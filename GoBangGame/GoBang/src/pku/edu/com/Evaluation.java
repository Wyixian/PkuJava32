package pku.edu.com;

/**
 * 
 * 该类用于评估当前棋盘的情况
 *
 */
class Evaluation
{
	int size;
	//眠二
	static final int sTwo = 0;
	//眠三
	static final int sThree = 1;
	//冲四
	static final int sFour = 2;
	
	static final int two = 3;
	static final int three= 4;
	static final int four = 5;
	//五连子
	static final int five = 6;
	
	//记录相应棋子的数量
	int[] blackTypeCount = new int[8];
	int[] whiteTypeCount = new int[8];
	//二维数组记录棋盘每个位置的权重
	public static int[][] posValue;
	
	/**
	 * 
	 * @param mapSize	
	 * 棋盘的行列数
	 */
	Evaluation(int mapSize)
	{
		size = mapSize;
		posValue = new int[mapSize][mapSize];
		int edge = size - 1;
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
			{
				int a = (i > edge - i)?(edge - i):i;
				int b = (j > edge - j)?(edge - j):j;
				posValue[i][j] = (a > b)?b:a;
			}
		
		return;
	}
	
	/**
	 *评估期盼情况并返回一个得分, 轮到白方则返回负值，否则返回正值
	 *分数越高对黑方越有利，反之对白方越有利
	 *
	 * 
	 * @param board				棋盘情况
	 * @param isWhiteTurn		是否轮到白方
	 * @return 					棋盘估值
	 */
	int evaluate(String[][] board, boolean isWhiteTurn)
	{
		for(int i = 0; i < 8; i++)
		{	
			blackTypeCount[i] = 0;
			whiteTypeCount[i] = 0;
		}
		this.analysisBoard(board);
		int score = 0;
		
		//多个冲四相当与一个活四
		if (whiteTypeCount[sFour] > 1)
			whiteTypeCount[four]++;

		if (blackTypeCount[sFour] > 1)
			blackTypeCount[four]++;

		//计算白方和黑方的分数
		int WValue = 0, BValue = 0;
		//白子
		if (isWhiteTurn)
		{
			if (blackTypeCount[five] > 0)
			{	
				BValue = 9999;
			}
			else if (whiteTypeCount[five] > 0)
			{	
				WValue = 9999;
			}
			//白方胜
			else if (whiteTypeCount[four] > 0 || whiteTypeCount[sFour] > 0)
			{
				WValue = 9990;
			}
			//黑方胜
			else if (blackTypeCount[four] > 0)
			{
				BValue = 9970;
			}
			//黑方胜
			else if (blackTypeCount[sFour] > 0 && blackTypeCount[three] > 0)
			{
				BValue = 9960;
			}
			//白方胜
			else if (whiteTypeCount[three] > 0 && blackTypeCount[sFour] == 0)
			{
				WValue = 9950;
			}
			//黑方胜
			else if (blackTypeCount[three] > 1 && 
				whiteTypeCount[three] == 0 &&
				whiteTypeCount[sThree] == 0)
			{
				BValue = 9940;
			}
			else {
			//分别计算白方和黑方的权值
			if (whiteTypeCount[three] > 1)
				WValue += 2000;
			else
			{
				if (whiteTypeCount[three] > 0)
					WValue += 200;
			}

			if (blackTypeCount[three] > 1)
				BValue += 1000;
			else
			{
				if (blackTypeCount[three] > 0)
					BValue += 100;
			}

			if (whiteTypeCount[sThree] > 0)
				WValue += whiteTypeCount[sThree]*10;

			if (blackTypeCount[sThree] > 0)
				BValue += blackTypeCount[sThree]*10;

			if (whiteTypeCount[two] > 0)
				WValue += whiteTypeCount[two]*4;

			if (blackTypeCount[two] > 0)
				BValue += blackTypeCount[two]*4;

			if (whiteTypeCount[sTwo] > 0)
				WValue += whiteTypeCount[sTwo];

			if (blackTypeCount[sTwo] > 0)
				BValue += blackTypeCount[sTwo];
			}
		}
		//黑子
		else
		{
			if (whiteTypeCount[five] > 0)
			{	
				WValue = 9999;
			}
			else if(blackTypeCount[five] > 0)
			{	
				BValue = 9999;
			}
			else if (blackTypeCount[four] > 0 || blackTypeCount[sFour] > 0)
			{
				BValue = 9990;
			}

			else if (whiteTypeCount[four] > 0)
			{
				WValue = 9970;
			}
			else if (whiteTypeCount[sFour] > 0 && whiteTypeCount[three] > 0)
			{
				WValue = 9960;
			}
			else if (blackTypeCount[three] > 0 && whiteTypeCount[sFour] == 0)
			{
				BValue = 9950;
			}
			else if (whiteTypeCount[three] > 1 && 
				blackTypeCount[three] == 0 &&
				blackTypeCount[sThree] == 0)
			{
				WValue = 9940;
			}
			else {

			if (blackTypeCount[three] > 1)
				BValue += 2000;
			else{
				if (blackTypeCount[three] > 0)
					BValue += 200;
			}

			if (whiteTypeCount[three] > 1)
				WValue += 1000;
			else{
				if (whiteTypeCount[three] > 0)
					WValue += 100;
			}

			if (whiteTypeCount[sThree] > 0)
				WValue += whiteTypeCount[sThree]*10;

			if (blackTypeCount[sThree] > 0)
				BValue += blackTypeCount[sThree]*10;

			if (whiteTypeCount[two] > 0)
				WValue += whiteTypeCount[two]*4;

			if (blackTypeCount[two] > 0)
				BValue += blackTypeCount[two]*4;

			if (whiteTypeCount[sTwo] > 0)
				WValue += whiteTypeCount[sTwo];

			if (blackTypeCount[sTwo] > 0)
				BValue += blackTypeCount[sTwo];
			}
		}
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
			{
				String tmp = board[i][j];
				if (tmp != Chessman.EMPTY.getChessman())
				{
					if (tmp == Chessman.BLACK.getChessman())
						 BValue += posValue[i][j];
					else
						 WValue += posValue[i][j];
				}
			}			
		score = BValue - WValue;
		
		return score;
	}
	
	/**
	 * 分析棋盘情况，
	 * 
	 * @param board		
	 * 				棋盘当前情况
	 */
	void analysisBoard(String[][] board)
	{
		String[] line = new String[size];
		
		//水平方向分析
		for(int i = 0; i < size; i++)
			analysisLine(board[i], size);
		
		//竖直方向分析
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
				line[j] = board[j][i];
			analysisLine(line, size);
		}	
		//右上左下方分析
		for(int k = 0; k <= 2 * size - 2; k++)
		{
			int n = 0;
			for(int i = 0; i <= k; i++)
			{
				int j = k - i;
				if(j >= size || i >= size)
					continue;
				line[n++] = board[i][j];
			}
			analysisLine(line, size);
		}	
		//左上右下方分析
		for(int k = 0; k < size; k++)
		{
			int n = 0;
			for(int i = 0; i < size - k; i++)
			{	
				line[n++] = board[i][i + k];
			}
			analysisLine(line, n);
		}
		
		for(int k = 1; k < size; k++)
		{
			int n = 0;
			for(int i = k; i < size; i++)
			{	
				line[n++] = board[i][i - k];
			}
			
			analysisLine(line, n);
		}		
	}
	
	/**
	 * 分析一行, 找出是五连、四连、三连等的情况
	 * 
	 * @param line		
	 * 				棋盘某一行或列的情况
	 * @param end		
	 * 				数组长度
	 */
	void analysisLine(String[] line, int end)
	{
		int i = 0;
		int j = 0;
		int k = 0;
		int bitLine = 0;
		//上一个棋子颜色
		String oldChess = Chessman.EMPTY.getChessman();
		String lastChess = Chessman.EMPTY.getChessman();
		
		//将一行按不同棋子颜色分成几段
		//分别分析 
		while(i < end)
		{
			//当前棋子位颜色
			String curChess = line[i];
			//判断上一个棋子位是否为空
			boolean isOldEmpty = (oldChess == Chessman.EMPTY.getChessman());
			//判断当前棋子位是否为空
			boolean isCurEmpty = (curChess == Chessman.EMPTY.getChessman());
			//判断当前棋子和上一个棋子位颜色是否相同
			boolean isCurEqOld = (oldChess == curChess);
			
			//找出棋子最近一次变化的位置
			if(!isOldEmpty && curChess != lastChess && lastChess == oldChess)
			{
				k = i;
				//System.out.println("k:" + k);
			}
			//当前棋子位不为空
			if(!isCurEmpty)
				//将i的二进制表示左移一位（乘2），与bitLine按位或运算，将一行棋子情况用2进制表示
				bitLine |=  1<<i;
			//上一个棋子位为空
			if(isOldEmpty)
			{
				if(!isCurEmpty)
					oldChess = curChess;
			}
			else if(!isCurEqOld && !isCurEmpty)
			{
				analysisChess(bitLine, j, i, oldChess);
				oldChess = curChess;
				j = k;
			}
			lastChess = curChess;
			i++;
		}
		//分析最后一段
		analysisChess(bitLine, j, size, oldChess);		
		
	}
	
	/**
	 * 按位比较分析每一段中五连、四连、三连等的情况
	 * 
	 * @param bitLine	
	 * 				整型数表示一段中每一位的情况
	 * @param start		
	 * 				位开始的位置
	 * @param end		
	 * 				位结束的位置
	 * @param c			
	 * 				棋子颜色
	 */
	void analysisChess(int bitLine, int start, int end, String c)
	{
		int length = end - start;		
		if(length < 5)
			return;
		//移到某一段开始的位置
		int line = bitLine >> start;
		int[] typeCount;
		
		if(c == Chessman.BLACK.getChessman())
			typeCount = blackTypeCount;
		else
			typeCount = whiteTypeCount;
		
		int tmpLine = line;
		for(int i = 0; i <= length - 5; i++)
		{
			//0x    十六进制   
			//16进制一位表示4位2进制数，0、1、2、3、4、5、6、7、8、9、A、B、C、D、E、F
			//（5）16 = （0101) 2，（F）16 = (1111) 2
			int tmp = tmpLine & 0x1f;
			//System.out.println("tmp:" + tmp);

			switch(tmp)
			{
			//五连11111b
			case 0x1f: typeCount[five]++; return;
			//冲四11011b
			case 0x1b: typeCount[sFour]++; break;
			//眠三10011b, 10101b, 11001b
			case 0x13: case 0x15: case 0x19: typeCount[sThree]++; break;
			//眠二10001
			case 0x11: typeCount[sTwo]++; break;
			default: break;
			}
			
			tmpLine >>= 1;
		}
		
		tmpLine = line;
		for(int i = 0; i <= length - 6; i++)
		{
			int tmp = tmpLine & 0x3f;
			//System.out.println("tmp:" + tmp);

			switch(tmp)
			{
			//活四011110b
			case 0x1e: typeCount[four]++; break;
			//活三011010b, 010110b
			case 0x1a: case 0x16: typeCount[three]++; break;
			//活二010010b, 001100b
			case 0x12: case 0xc: typeCount[two]++; break;
			default: break;
			}
			
			tmpLine >>= 1;
		}
		
		tmpLine = line;
		for(int i = 0; i <= length - 7; i++)
		{
			//掩码:0111110
			int tmp = tmpLine & 0x3e;
			//System.out.println("tmp:" + tmp);

			//活三：X01110Y
			if(tmp == 0x1c)
			{
				//活三：X 或 Y 等于 0
				if(((tmpLine & 0x1) == 0) || ((tmpLine & 0x40) == 0))
					typeCount[three]++;
			}
			
			//活二：X01010Y
			if(tmp == 0x14)
			{
				//活二：X 或 Y 等于 0
				if(((tmpLine & 0x1) == 0) || ((tmpLine & 0x40) == 0))
					typeCount[two]++;
			}
			
			//掩码:0011100
			tmp = tmpLine & 0x1c;
			//冲四：XY101ZW
			if(tmp == 0x14)
			{
				//冲四：XY 等于 11 且 Z 等于 0 或 ZW 等于 11 且 Y 等于 0
				if(((tmpLine & 0x62) == 0x60) || ((tmpLine & 0x23) == 0x3))
					typeCount[sFour]++;
			}
			
			tmpLine >>= 1;
		}
		
		tmpLine = line;
		for(int i = 0; i <= length - 8; i++)
		{
			//掩码:00111100
			int tmp = tmpLine & 0x3c;

			//活二：XY0110ZW
			if(tmp == 0x18)
			{
				//活二：XY 等于 0 且 ZW 不等于 0 或 ZW 等于 0 且 XY 不等于 0
				int XY = tmpLine & 0xc0;
				int ZW = tmpLine & 0x3;
				if(((XY == 0) && (ZW != 0)) || ((ZW == 0) && (XY != 0)))
					typeCount[two]++;
			}
			
			tmpLine >>= 1;
		}
		
		//取尾部五位
		int suffix = line & 0x1f;
		//System.out.println("suffix:" + suffix);
		
		switch(suffix)
		{
		//冲四01111, 11101
		case 0xf: case 0x1d: typeCount[sFour]++; break;
		//眠三01011,眠三01101,眠三00111
		case 0xb: case 0xd: case 0x7: typeCount[sThree]++; break;
		//眠二00011,00101,01001
		case 0x3: case 0x5: case 01001: typeCount[sTwo]++; break;
		default: break;
		}
		
		int prefix = (line >> (length - 5)) & 0x1f;
		//System.out.println("prefix:" + prefix);
		
		switch(prefix)
		{
		//冲四11110, 10111
		case 0x1e: case 0x17: typeCount[sFour]++; break;
		//眠三11010,眠三10110,眠三11100
		case 0x1a: case 0x16: case 0x1c: typeCount[sThree]++; break;
		//眠二11000,10100,10010
		case 0x18: case 0x14: case 0x12: typeCount[sTwo]++; break;
		default: break;
		}
		
		if(length >= 6)
		{
			//取尾部六位111111
			suffix = line & 0x3f;
			//System.out.println("suffix:" + suffix);
			
			switch(suffix)
			{
			//活三001110
			case 0xe: typeCount[three]++; break;
			//活二001010, 000110
			case 0xa: case 0x6: typeCount[two]++; break;
			default: break;
			}
			
			prefix = (line >> (length - 6)) & 0x3f;
			
			switch(prefix)
			{
			//活三011100
			case 0x1c: typeCount[three]++; break;
			//活二010100, 011000
			case 0x14: case 0x18: typeCount[two]++; break;
			default: break;
			}
		}
	}
}
