package pku.edu.com;

/**
 * 
 * ��������������ǰ���̵����
 *
 */
class Evaluation
{
	int size;
	//�߶�
	static final int sTwo = 0;
	//����
	static final int sThree = 1;
	//����
	static final int sFour = 2;
	
	static final int two = 3;
	static final int three= 4;
	static final int four = 5;
	//������
	static final int five = 6;
	
	//��¼��Ӧ���ӵ�����
	int[] blackTypeCount = new int[8];
	int[] whiteTypeCount = new int[8];
	//��ά�����¼����ÿ��λ�õ�Ȩ��
	public static int[][] posValue;
	
	/**
	 * 
	 * @param mapSize	
	 * ���̵�������
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
	 *�����������������һ���÷�, �ֵ��׷��򷵻ظ�ֵ�����򷵻���ֵ
	 *����Խ�߶Ժڷ�Խ��������֮�԰׷�Խ����
	 *
	 * 
	 * @param board				�������
	 * @param isWhiteTurn		�Ƿ��ֵ��׷�
	 * @return 					���̹�ֵ
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
		
		//��������൱��һ������
		if (whiteTypeCount[sFour] > 1)
			whiteTypeCount[four]++;

		if (blackTypeCount[sFour] > 1)
			blackTypeCount[four]++;

		//����׷��ͺڷ��ķ���
		int WValue = 0, BValue = 0;
		//����
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
			//�׷�ʤ
			else if (whiteTypeCount[four] > 0 || whiteTypeCount[sFour] > 0)
			{
				WValue = 9990;
			}
			//�ڷ�ʤ
			else if (blackTypeCount[four] > 0)
			{
				BValue = 9970;
			}
			//�ڷ�ʤ
			else if (blackTypeCount[sFour] > 0 && blackTypeCount[three] > 0)
			{
				BValue = 9960;
			}
			//�׷�ʤ
			else if (whiteTypeCount[three] > 0 && blackTypeCount[sFour] == 0)
			{
				WValue = 9950;
			}
			//�ڷ�ʤ
			else if (blackTypeCount[three] > 1 && 
				whiteTypeCount[three] == 0 &&
				whiteTypeCount[sThree] == 0)
			{
				BValue = 9940;
			}
			else {
			//�ֱ����׷��ͺڷ���Ȩֵ
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
		//����
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
	 * �������������
	 * 
	 * @param board		
	 * 				���̵�ǰ���
	 */
	void analysisBoard(String[][] board)
	{
		String[] line = new String[size];
		
		//ˮƽ�������
		for(int i = 0; i < size; i++)
			analysisLine(board[i], size);
		
		//��ֱ�������
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
				line[j] = board[j][i];
			analysisLine(line, size);
		}	
		//�������·�����
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
		//�������·�����
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
	 * ����һ��, �ҳ��������������������ȵ����
	 * 
	 * @param line		
	 * 				����ĳһ�л��е����
	 * @param end		
	 * 				���鳤��
	 */
	void analysisLine(String[] line, int end)
	{
		int i = 0;
		int j = 0;
		int k = 0;
		int bitLine = 0;
		//��һ��������ɫ
		String oldChess = Chessman.EMPTY.getChessman();
		String lastChess = Chessman.EMPTY.getChessman();
		
		//��һ�а���ͬ������ɫ�ֳɼ���
		//�ֱ���� 
		while(i < end)
		{
			//��ǰ����λ��ɫ
			String curChess = line[i];
			//�ж���һ������λ�Ƿ�Ϊ��
			boolean isOldEmpty = (oldChess == Chessman.EMPTY.getChessman());
			//�жϵ�ǰ����λ�Ƿ�Ϊ��
			boolean isCurEmpty = (curChess == Chessman.EMPTY.getChessman());
			//�жϵ�ǰ���Ӻ���һ������λ��ɫ�Ƿ���ͬ
			boolean isCurEqOld = (oldChess == curChess);
			
			//�ҳ��������һ�α仯��λ��
			if(!isOldEmpty && curChess != lastChess && lastChess == oldChess)
			{
				k = i;
				//System.out.println("k:" + k);
			}
			//��ǰ����λ��Ϊ��
			if(!isCurEmpty)
				//��i�Ķ����Ʊ�ʾ����һλ����2������bitLine��λ�����㣬��һ�����������2���Ʊ�ʾ
				bitLine |=  1<<i;
			//��һ������λΪ��
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
		//�������һ��
		analysisChess(bitLine, j, size, oldChess);		
		
	}
	
	/**
	 * ��λ�ȽϷ���ÿһ���������������������ȵ����
	 * 
	 * @param bitLine	
	 * 				��������ʾһ����ÿһλ�����
	 * @param start		
	 * 				λ��ʼ��λ��
	 * @param end		
	 * 				λ������λ��
	 * @param c			
	 * 				������ɫ
	 */
	void analysisChess(int bitLine, int start, int end, String c)
	{
		int length = end - start;		
		if(length < 5)
			return;
		//�Ƶ�ĳһ�ο�ʼ��λ��
		int line = bitLine >> start;
		int[] typeCount;
		
		if(c == Chessman.BLACK.getChessman())
			typeCount = blackTypeCount;
		else
			typeCount = whiteTypeCount;
		
		int tmpLine = line;
		for(int i = 0; i <= length - 5; i++)
		{
			//0x    ʮ������   
			//16����һλ��ʾ4λ2��������0��1��2��3��4��5��6��7��8��9��A��B��C��D��E��F
			//��5��16 = ��0101) 2����F��16 = (1111) 2
			int tmp = tmpLine & 0x1f;
			//System.out.println("tmp:" + tmp);

			switch(tmp)
			{
			//����11111b
			case 0x1f: typeCount[five]++; return;
			//����11011b
			case 0x1b: typeCount[sFour]++; break;
			//����10011b, 10101b, 11001b
			case 0x13: case 0x15: case 0x19: typeCount[sThree]++; break;
			//�߶�10001
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
			//����011110b
			case 0x1e: typeCount[four]++; break;
			//����011010b, 010110b
			case 0x1a: case 0x16: typeCount[three]++; break;
			//���010010b, 001100b
			case 0x12: case 0xc: typeCount[two]++; break;
			default: break;
			}
			
			tmpLine >>= 1;
		}
		
		tmpLine = line;
		for(int i = 0; i <= length - 7; i++)
		{
			//����:0111110
			int tmp = tmpLine & 0x3e;
			//System.out.println("tmp:" + tmp);

			//������X01110Y
			if(tmp == 0x1c)
			{
				//������X �� Y ���� 0
				if(((tmpLine & 0x1) == 0) || ((tmpLine & 0x40) == 0))
					typeCount[three]++;
			}
			
			//�����X01010Y
			if(tmp == 0x14)
			{
				//�����X �� Y ���� 0
				if(((tmpLine & 0x1) == 0) || ((tmpLine & 0x40) == 0))
					typeCount[two]++;
			}
			
			//����:0011100
			tmp = tmpLine & 0x1c;
			//���ģ�XY101ZW
			if(tmp == 0x14)
			{
				//���ģ�XY ���� 11 �� Z ���� 0 �� ZW ���� 11 �� Y ���� 0
				if(((tmpLine & 0x62) == 0x60) || ((tmpLine & 0x23) == 0x3))
					typeCount[sFour]++;
			}
			
			tmpLine >>= 1;
		}
		
		tmpLine = line;
		for(int i = 0; i <= length - 8; i++)
		{
			//����:00111100
			int tmp = tmpLine & 0x3c;

			//�����XY0110ZW
			if(tmp == 0x18)
			{
				//�����XY ���� 0 �� ZW ������ 0 �� ZW ���� 0 �� XY ������ 0
				int XY = tmpLine & 0xc0;
				int ZW = tmpLine & 0x3;
				if(((XY == 0) && (ZW != 0)) || ((ZW == 0) && (XY != 0)))
					typeCount[two]++;
			}
			
			tmpLine >>= 1;
		}
		
		//ȡβ����λ
		int suffix = line & 0x1f;
		//System.out.println("suffix:" + suffix);
		
		switch(suffix)
		{
		//����01111, 11101
		case 0xf: case 0x1d: typeCount[sFour]++; break;
		//����01011,����01101,����00111
		case 0xb: case 0xd: case 0x7: typeCount[sThree]++; break;
		//�߶�00011,00101,01001
		case 0x3: case 0x5: case 01001: typeCount[sTwo]++; break;
		default: break;
		}
		
		int prefix = (line >> (length - 5)) & 0x1f;
		//System.out.println("prefix:" + prefix);
		
		switch(prefix)
		{
		//����11110, 10111
		case 0x1e: case 0x17: typeCount[sFour]++; break;
		//����11010,����10110,����11100
		case 0x1a: case 0x16: case 0x1c: typeCount[sThree]++; break;
		//�߶�11000,10100,10010
		case 0x18: case 0x14: case 0x12: typeCount[sTwo]++; break;
		default: break;
		}
		
		if(length >= 6)
		{
			//ȡβ����λ111111
			suffix = line & 0x3f;
			//System.out.println("suffix:" + suffix);
			
			switch(suffix)
			{
			//����001110
			case 0xe: typeCount[three]++; break;
			//���001010, 000110
			case 0xa: case 0x6: typeCount[two]++; break;
			default: break;
			}
			
			prefix = (line >> (length - 6)) & 0x3f;
			
			switch(prefix)
			{
			//����011100
			case 0x1c: typeCount[three]++; break;
			//���010100, 011000
			case 0x14: case 0x18: typeCount[two]++; break;
			default: break;
			}
		}
	}
}
