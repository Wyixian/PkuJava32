/**
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
         * 
	 * @author wangyixian
	 */
	public boolean isWon(int posX, int posY, String ico) {
		if(isWonVertical(posX,posY,ico)||isWonHorizontal(posX,posY,ico)||isWonLeftSlope(posX,posY,ico)||isWonRightSlope(posX,posY,ico))
			return true;
		else
			return false;
	}

	/**
	 * 判断竖直方向是否有超过五个棋子
	 *
	 * @param posX 
	 *           棋子的X坐标
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果竖直方向有五颗相邻棋子连成一条直接，返回真，否则相反。
         * 
	 * @author wangyixian
	 *
	 */
	public boolean isWonVertical(int posX, int posY, String ico){
		String[][] board = chessboard.getBoard();
		int count = 1;
		//循环向上数4个，看看有几个同色的
		for(int i = 1; i < 5; i++){
			//如果超过了棋盘范围则跳出循环                     
			if(posX - i < 0)         
				break;
			//如果同色则count加一
			if(board[posX-i][posY] == ico)      
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
			if(board[posX+i][posY] == ico)
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
	 *           棋子的X坐标
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果水平方向有五颗相邻棋子连成一条直接，返回真，否则相反。
         * 
	 * @author wangyixian
	 *
	 */
	public boolean isWonHorizontal(int posX, int posY, String ico){
		String[][] board = chessboard.getBoard();
		int count = 1;
		//循环向右数4个，看看有几个同色的
		for(int i = 1; i < 5; i++){
			//如果超过了棋盘范围则跳出循环                     
			if(posY + i > Chessboard.BOARD_SIZE-1)         
				break;
			//如果同色则count加一
			if(board[posX][posY+i] == ico)      
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
			if(board[posX][posY-i] == ico)
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
	 * @param ico
	 *            棋子类型
	 * @return 如果左上右下方向有五颗相邻棋子连成一条直接，返回真，否则相反。
         * 
	 * @author wangyixian
	 *
	 */
	public boolean isWonLeftSlope(int posX, int posY, String ico){
		String[][] board = chessboard.getBoard();
		int count = 1;
		//循环向右下数4个，看看有几个同色的
		for(int i = 1; i < 5; i++){
			//如果超过了棋盘范围则跳出循环                     
			if(posX + i > Chessboard.BOARD_SIZE-1||posY+i > Chessboard.BOARD_SIZE-1)         
				break;
			//如果同色则count加一
			if(board[posX+i][posY+i] == ico)      
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
			if(board[posX-i][posY-i] == ico)
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
	 * @param ico
	 *            棋子类型
	 * @return 如果左下右上方向有五颗相邻棋子连成一条直接，返回真，否则相反。
         * 
	 * @author wangyixian
	 *
	 */
	public boolean isWonRightSlope(int posX, int posY, String ico){
		String[][] board = chessboard.getBoard();
		int count = 1;
		//循环向左下数4个，看看有几个同色的
		for(int i = 1; i < 5; i++){
			//如果超过了棋盘范围则跳出循环                     
			if(posX + i > Chessboard.BOARD_SIZE-1||posY - i < 0)         
				break;
			//如果同色则count加一
			if(board[posX+i][posY-i] == ico)      
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
			if(board[posX-i][posY+i] == ico)
				count++;
			else
				break;
		}
		if(count >= WIN_COUNT)
			return true;
		else 
			return false;
	}