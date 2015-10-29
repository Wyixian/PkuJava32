package chanism;
import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// 定义达到赢条件的棋子数目
	private static final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的Y坐标
	private int posY = 0;
	// 定义棋盘
	private static Chessboard chessboard;
	// 定义搜索深度
	private static int DEPTH = 2;
	// 定义一个搜索引擎
	SearchEngine engine = new AlphaBetaEngine(Chessboard.BOARD_SIZE, DEPTH);
	
	
	
	
	
	
	
	/**
	 * 空构造器
	 */
	public GobangGame() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame(Chessboard chessboard) {
//System.out.println("5.1 ");
		this.chessboard = chessboard;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "+") {
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	public void start() throws Exception {
//		System.out.println("7 ");
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessboard.getBoard())) {
				isOver = true;

			} else {
				// 计算机选择位置坐标
				chessman = Chessman.WHITE.getChessman();
				int[] computerPosArr = computerDo(chessboard.getBoard(),chessman);
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessboard.getBoard())) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			//System.out.println("2222请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}

	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机随机下棋
	 * 
	 * @param board
	 * 				棋盘当前情况
	 * @param chessman
	 * 				计算机落子的颜色
	 */
	public int[] computerDo(String[][] board,String chessman) {
//System.out.println(" 8");
		//搜索最佳落子位置
		engine.searchAGoodMove(board, chessman);
		//取出最佳落子位置
		ChessPos pos = engine.bestMove;
		//play chess
		int[] result = { pos.x, pos.y};
		return result;
		/*
		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "+") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] result = { posX, posY };
		return result;
		*/
	}


	/**
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param board
	 *            当前棋盘情况
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	public static boolean isWon(int posX, int posY, String[][] board) {
		if(isWonVertical(posX,posY,board)||isWonHorizontal(posX,posY,board)||isWonLeftSlope(posX,posY,board)||isWonRightSlope(posX,posY,board))
			return true;
		else
			return false;
	}

	/**
	 * 判断竖直方向是否有超过五个棋子
	 *
	 * @param posX 
	 *            棋子的X坐标
	 * @param posY
	 *            棋子的Y坐标
	 * @param board
	 *            当前棋盘情况
	 * @return 如果竖直方向有五颗相邻棋子连成一条直接，返回真，否则相反。
	 *
	 */
	public static boolean isWonVertical(int posX, int posY, String[][] board){  
		int count = 1;
		//String[][] board = chessboard.getBoard();
		//循环向右数4个，看看有几个同色的
		for(int i = 1; i < 5; i++)
		{
			//如果超过了棋盘范围则跳出循环                     
			if(posX + i > Chessboard.BOARD_SIZE-1)         
				break;
			//如果同色则count加一
			if(board[posX+i][posY] == board[posX][posY])      
				count++;
			else
				break;
		}
		//循环向左数4个，看看有几个同色的
		for(int i = 1; i < 5; i++){
			//如果超过了棋盘范围则跳出循环 
			if(posX - i < 0)
				break;
			//如果同色则count加一
			if(board[posX-i][posY] == board[posX][posY])
				count++;
			else
				break;
		}
		if(count >= WIN_COUNT)
			return true;
		else 
			return false;
	}

	/**
	 * 判断水平方向是否有超过五个棋子
	 *
	 * @param posX 
	 *            棋子的X坐标
	 * @param posY
	 *            棋子的Y坐标
	 * @param board
	 *            当前棋盘情况
	 * @return 如果水平方向有五颗相邻棋子连成一条直接，返回真，否则相反。
	 *
	 */
	public static boolean isWonHorizontal(int posX, int posY, String[][] board){  
		int count = 1;
		//String[][] board = chessboard.getBoard();
		//循环向上数4个，看看有几个同色的
		for(int i = 1; i < 5; i++){
			//如果超过了棋盘范围则跳出循环                     
			if(posY + i > Chessboard.BOARD_SIZE-1)         
				break;
			//如果同色则count加一
			if(board[posX][posY+i] == board[posX][posY])      
				count++;
			else
				break;
		}
		//循环向下数4个，看看有几个同色的
		for(int i = 1; i < 5; i++){
			//如果超过了棋盘范围则跳出循环 
			if(posY - i < 0)
				break;
			//如果同色则count加一
			if(board[posX][posY-i] == board[posX][posY])
				count++;
			else
				break;
		}
		if(count >= WIN_COUNT)
			return true;
		else 
			return false;
		
	}

	/**
	 * 判断左上右下方向是否有超过五个棋子
	 *
	 * @param posX 
	 *           棋子的X坐标
	 * @param posY
	 *            棋子的Y坐标
	 * @param board
	 *            当前棋盘情况
	 * @return 如果左上右下方向有五颗相邻棋子连成一条直接，返回真，否则相反。
	 *
	 */
	public static boolean isWonLeftSlope(int posX, int posY, String[][] board){  
		int count = 1;
		//String[][] board = chessboard.getBoard();
		//循环向右下数4个，看看有几个同色的
		for(int i = 1; i < 5; i++){
			//如果超过了棋盘范围则跳出循环                     
			if(posX + i > Chessboard.BOARD_SIZE-1 || posY + i > Chessboard.BOARD_SIZE-1)         
				break;
			//如果同色则count加一
			if(board[posX+i][posY+i] == board[posX][posY])      
				count++;
			else
				break;
		}
		//循环向左上数4个，看看有几个同色的
		for(int i = 1; i < 5; i++){
			//如果超过了棋盘范围则跳出循环 
			if(posX - i < 0 || posY - i < 0)
				break;
			//如果同色则count加一
			if(board[posX-i][posY-i] == board[posX][posY])
				count++;
			else
				break;
		}
		if(count >= WIN_COUNT)
			return true;
		else 
			return false;
	}

	/**
	 * 判断左下右上方向是否有超过五个棋子
	 *
	 * @param posX 
	 *           棋子的X坐标
	 * @param posY
	 *            棋子的Y坐标
	 * @param board
	 *            当前棋盘情况
	 * @return 如果左下右上方向有五颗相邻棋子连成一条直接，返回真，否则相反。
	 *
	 */
	public static boolean isWonRightSlope(int posX, int posY, String[][] board){  
		int count = 1;
		//String[][] board = chessboard.getBoard();
		//循环向左下数4个，看看有几个同色的
		for(int i = 1; i < 5; i++){
			//如果超过了棋盘范围则跳出循环                     
			if(posX + i > Chessboard.BOARD_SIZE-1 || posY - i < 0)         
				break;
			//如果同色则count加一
			if(board[posX+i][posY-i] == board[posX][posY])
				count++;
			else
				break;
		}
		//循环向右上数4个，看看有几个同色的
		for(int i = 1; i < 5; i++){
			//如果超过了棋盘范围则跳出循环 
			if(posX - i < 0 || posY + i > Chessboard.BOARD_SIZE-1)
				break;
			//如果同色则count加一
			//System.out.println("posX:"+posX+" posY:"+posY);
			if(board[posX-i][posY+i] == board[posX][posY])
				count++;
			else
				break;
		}
		if(count >= WIN_COUNT)
			return true;
		else 
			return false;
	}

	public static void main(String[] args) throws Exception {
//System.out.println("1 ");
		GobangGame gb = new GobangGame(new Chessboard());
//System.out.println(" 6");
		gb.start();
		
	}
}
