/**
通过查阅参考资料，了解到，实现较好的计算机自动下棋的AI算法可以将实现步骤大体分为：
1、计算棋盘各点的估值，涉及到棋型（长连、活四、冲四等）打分；
2、将估值存入预期未来五步的多叉树中；
3、利用α-β剪枝算法找出攻防最适宜的点落子。
该算法的完整实现对我来说有很大难度，在至今有限的课余时间内，还未能完成。
以下是我写的一个比较low的方法，作为初步的作业提交，后续我会慢慢努力完成计算机自动下棋的AI算法。

该low方法基本思想：
1、遍历棋盘，判计算每个无子位置白子在四个方向（竖直、水平、左上右下、右上左下）上的连子数；
2、将最大连子数存入二维数组中；
3、找出整个棋盘中最大连子数最大的位置，落子。
*/

	/**
	 * 计算机随机下棋
	 */
	public int[] computerDo() {
		String[][] board = chessboard.getBoard();
		//存储棋盘中空位的权值
		int[][] temp = new int[board.length][];
		//遍历棋盘，对棋盘的空位置进行判断是否适合落子   
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				if(board[i][j] == "十"){
				//System.out.println("countV="+countVertical(i,j));
					temp[i][j] = countVertical(i,j);
					if(countHorizontal(i,j) > temp[i][j])
						temp[i][j] = countHorizontal(i,j);
					if(countLeftSlope(i,j) > temp[i][j])
						temp[i][j] = countLeftSlope(i,j);
					if(countRightSlope(i,j) >temp[i][j])
						temp[i][j] = countRightSlope(i,j);
					
				}
			}
			
		}
		//权值最大处落子
		int max = -1;
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				if(temp[i][j] > max){
					max = temp[i][j];
				}
			}
		}
		int posX = -1;
		int posY = -1;
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				if(max == temp[i][j]){
					posX = i;
					posY = j;
					break;
				}	
			}
			if(posX !=-1){
				break;
			}
			
		}
		
//		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		String[][] board = chessboard.getBoard();
//		while (board[posX][posY] != "十") {
//			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		}
		int[] result = { posX, posY };
		return result;
	}
	
	/**
	 * 计算竖直方向连子数目
	 *
	 * @param posX 
	 *           棋子的X坐标
	 * @param posY
	 *            棋子的Y坐标
	 * @return 返回竖直方向连子数目。
	 * 
	 * @author wangyixian
	 *
	 */
	public int countVertical(int posX, int posY){
		String[][] board = chessboard.getBoard();
		int count = 0;
		//循环向上数4个，看看有几个同色的
		for(int i = 1; i < 5; i++){
			//如果超过了棋盘范围则跳出循环                     
			if(posX - i < 0)         
				break;
			//如果同色则count加一
			if(board[posX-i][posY] == Chessman.WHITE.getChessman())    
				count++;
			else
				break;
		}
		//循环向下数4个，看看有几个同色的
		for(int i = 1; i < 5; i++){
			//如果超过了棋盘范围则跳出循环 
			if(posX + i >  Chessboard.BOARD_SIZE-1)
				break;
			//如果同色则count加一
			if(board[posX+i][posY] == Chessman.WHITE.getChessman())
				count++;
			else
				break;
		}
		return count;
	}
	
	/**
	 * 计算水平方向连子数目
	 *
	 * @param posX 
	 *           棋子的X坐标
	 * @param posY
	 *            棋子的Y坐标
	 * @return 返回水平方向连子数目。
	 * 
	 * @author wangyixian
	 *
	 */
	public int countHorizontal(int posX, int posY){
		String[][] board = chessboard.getBoard();
		int count = 0;
		//循环向右数4个，看看有几个同色的
		for(int i = 1; i < 5; i++){
			//如果超过了棋盘范围则跳出循环                     
			if(posY + i > Chessboard.BOARD_SIZE-1)         
				break;
			//如果同色则count加一
			if(board[posX][posY+i] == Chessman.WHITE.getChessman())      
				count++;
			else
				break;
		}
		//循环向左数4个，看看有几个同色的
		for(int i = 1; i < 5; i++){
			//如果超过了棋盘范围则跳出循环 
			if(posY - i < 0)
				break;
			//如果同色则count加一
			if(board[posX][posY-i] == Chessman.WHITE.getChessman())
				count++;
			else
				break;
		}
		return count;
	}

	/**
	 * 计算左上右下方向连子数目
	 *
	 * @param posX 
	 *           棋子的X坐标
	 * @param posY
	 *            棋子的Y坐标
	 * @return 返回左上右下方向连子数目。
	 * 
	 * @author wangyixian
	 *
	 */
	public int countLeftSlope(int posX, int posY){
		String[][] board = chessboard.getBoard();
		int count = 0;
		//循环向右下数4个，看看有几个同色的
		for(int i = 1; i < 5; i++){
			//如果超过了棋盘范围则跳出循环                     
			if(posX + i > Chessboard.BOARD_SIZE-1||posY+i > Chessboard.BOARD_SIZE-1)         
				break;
			//如果同色则count加一
			if(board[posX+i][posY+i] == Chessman.WHITE.getChessman())      
				count++;
			else
				break;
		}
		//循环向左上数4个，看看有几个同色的
		for(int i = 1; i < 5; i++){
			//如果超过了棋盘范围则跳出循环 
			if(posX - i < 0||posY - i < 0)
				break;
			//如果同色则count加一
			if(board[posX-i][posY-i] == Chessman.WHITE.getChessman())
				count++;
			else
				break;
		}
		return count;
	}

	/**
	 * 计算左下右上方向连子数目
	 *
	 * @param posX 
	 *           棋子的X坐标
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 返回左下右上方向连子数目。
	 * 
	 * @author wangyixian
	 *
	 */
	public int countRightSlope(int posX, int posY){
		String[][] board = chessboard.getBoard();
		int count = 0;
		//循环向左下数4个，看看有几个同色的
		for(int i = 1; i < 5; i++){
			//如果超过了棋盘范围则跳出循环                     
			if(posX + i > Chessboard.BOARD_SIZE-1||posY - i < 0)         
				break;
			//如果同色则count加一
			if(board[posX+i][posY-i] == Chessman.WHITE.getChessman())      
				count++;
			else
				break;
		}
		//循环向右上数4个，看看有几个同色的
		for(int i = 1; i < 5; i++){
			//如果超过了棋盘范围则跳出循环 
			if(posX - i < 0||posY + i > Chessboard.BOARD_SIZE-1)
				break;
			//如果同色则count加一
			if(board[posX-i][posY+i] == Chessman.WHITE.getChessman())
				count++;
			else
				break;
		}
		return count;
	}