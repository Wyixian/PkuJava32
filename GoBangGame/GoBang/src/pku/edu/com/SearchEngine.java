package pku.edu.com;

import java.util.*;

class ChessPos
{
	int x = 0;
	int y = 0;
}

/**
 * 
 * Ϊ���������ṩ�ӿ�
 *
 */
abstract class SearchEngine  
{
	//�������
	String CurPosition[][];
	//��¼�������λ��
	ChessPos bestMove;
	//���ɿ��ܵ�����λ��
	MoveGenerator moveGen;
	//��������
	Evaluation eval;
	//��ǰ�������
	int searchDepth;
	//����������
	int maxDepth;
	//����������
	int gridNum;
	//�����������ɫ
	String myChess;
	
	abstract void searchAGoodMove(String position[][], String c);
	
	/**
	 * 
	 * @param n			
	 * 				���̵�������
	 * @param depth		
	 * 				�������
	 */
	SearchEngine(int n, int depth)
	{
		gridNum = n;
		maxDepth = depth;
		//��������
		eval = new Evaluation(gridNum);
		//���ɿ��ܵ�����λ��
		moveGen = new MoveGenerator(gridNum);
		CurPosition = new String[n][n];
	}
	
	/**
	 * 
	 * ��һ����
	 * 
	 * @param move		
	 * 				�����µ����ӵ�����
	 * @param c			
	 * 				���ӵ���ɫ
	 */
	void makeMove(ChessPos move, String c)
	{
		CurPosition[move.x][move.y] = c;
	}
	
	/**
	 * 
	 * ���ݵ�֮ǰ�����
	 * 
	 * @param move
	 * 				��һ�����ӵ�����
	 */
	void unMakeMove(ChessPos move)
	{
		CurPosition[move.x][move.y] = Chessman.EMPTY.getChessman();		
	}
	
}

/**
 * 
 * �����������ɿ��е���������
 *
 */
class MoveGenerator
{
	public int moveCount;	
	public ChessPos[][] moveList = new ChessPos[10][225];
	int size;
	
	/**
	 * 
	 * @param n		
	 * 				���̵�������
	 */
	MoveGenerator(int n)
	{
		size = n;		
		moveList = new ChessPos[5][n * n];
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < n * n; j++)
				moveList[i][j] = new ChessPos();
	}

	/**
	 * ���ɿ��е���������
	 * 
	 * @param board		
	 * 					�������
	 * @param depth		
	 * 					��ǰ�������
	 * @return			
	 * 					���е�������������
	 */
	int createPossibleMove(String[][] board, int depth)
	{
		int	i,j;
		moveCount = 0;
		for (i = 0; i < size; i++)
			for (j = 0; j < size; j++)
			{
				if (board[i][j] == Chessman.EMPTY.getChessman())
				{
					moveList[depth][moveCount].x = i;
					moveList[depth][moveCount++].y = j;
				}
			}

		return moveCount;		
	}

}

/**
 * 
 * ʹ����alpha-beta��֦�㷨����������
 *
 */
class AlphaBetaEngine extends SearchEngine
{
	AlphaBetaEngine(int n, int depth)
	{
		super(n, depth);
	}
	
	/**
	 * ������һ���Ϻõ��߷�
	 * 
	 * @param board		
	 * 				�������
	 * @param c	  the chessman hold by computer
	 * 
	 */
	void searchAGoodMove(String board[][], String c)
	{
		//��¼��ǰ�������
		for(int i = 0; i < gridNum; i++)
			for(int j = 0; j < gridNum; j++)
			{
				CurPosition[i][j] = board[i][j];
			}
		boolean isWhiteTurn = (c == Chessman.WHITE.getChessman())?true:false;
		
		//ʹ��alpha-beta��֦�㷨�������Ϻõ��߷�
		AB(maxDepth, -20000, 20000, isWhiteTurn);
		
		//System.out.println("x:" + bestMove.y + " y:" + bestMove.x);
		//makeMove(bestMove, c);
	}
	
	/**
	 * alpha-beta��֦�㷨
	 * 
	 * @param depth			
	 * 				��ǰ�������
	 * @param alpha			
	 * 				alphaֵ
	 * @param beta			
	 * 				betaֵ
	 * @param isWhiteTurn	
	 * 				�Ƿ��ֵ���������
	 * @return ����
	 */
	int AB(int depth, int alpha, int beta, boolean isWhiteTurn)
	{
		int Count,i;
		int score;
		String chessMan;
		int current = -20000;
		
		chessMan = (isWhiteTurn)?Chessman.WHITE.getChessman():Chessman.BLACK.getChessman();
		
		//�����Ҷ�ӽڵ��򷵻ط���
		if (depth <= 0)	
		{
			score = eval.evaluate(CurPosition, isWhiteTurn);
			score = (isWhiteTurn)?-score:score;
			return score;
		}
		
		//���ɿ��ܵ��߷�
		Count = moveGen.createPossibleMove(CurPosition, depth);
		
		//�ڿ��ܵ��߷�������
	    for ( i = 0; i < Count; i++ ) 
		{
	    	ChessPos t = moveGen.moveList[depth][i];
			makeMove(t, chessMan);
			if(GobangGame.isWon(t.x, t.y, CurPosition))
			{	
				if(depth == maxDepth)
					bestMove = moveGen.moveList[depth][i];				
				return 10000;
			}
			
			//�ݹ�����
			score = -AB(depth - 1 , -beta, -alpha, !isWhiteTurn);
			
/*			if(depth == maxDepth)
				System.out.println("x:" + t.x + " " + "y:" + t.y + "score:" + score);
*/			
			unMakeMove(t);
			
			//�ж��Ƿ�õ��˸��õĽ��
			if(score > current)
			{	
				current = score;
				if(score > alpha)
					alpha = score;
				if(score >= beta)
					break;
				if(depth == maxDepth)
					bestMove = moveGen.moveList[depth][i];
			}

		}
	    //������õĽ��
		return current;

	}
}
