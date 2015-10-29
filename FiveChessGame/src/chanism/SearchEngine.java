package chanism;
import java.util.*;

class ChessPos
{
	int x = 0;
	int y = 0;
}

/**
 * 
 * 为搜索引擎提供接口
 *
 */
abstract class SearchEngine  
{
	//棋盘情况
	String CurPosition[][];
	//记录最佳落子位置
	ChessPos bestMove;
	//生成可能的落子位置
	MoveGenerator moveGen;
	//评估棋盘
	ManVsMachine eval;
	//当前搜索深度
	int searchDepth;
	//最大搜索深度
	int maxDepth;
	//棋盘行列数
	int gridNum;
	//计算机落子颜色
	String myChess;
	
	abstract void searchAGoodMove(String position[][], String c);
	
	/**
	 * 
	 * @param n			
	 * 				棋盘的行列数
	 * @param depth		
	 * 				搜索深度
	 */
	SearchEngine(int n, int depth)
	{
//System.out.println("3 ");
		gridNum = n;
		maxDepth = depth;
		//评估棋盘
		eval = new ManVsMachine(gridNum);
		//生成可能的落子位置
		moveGen = new MoveGenerator(gridNum);
		CurPosition = new String[n][n];
	}
	
	/**
	 * 
	 * 下一步棋
	 * 
	 * @param move		
	 * 				即将下的棋子的坐标
	 * @param c			
	 * 				棋子的颜色
	 */
	void makeMove(ChessPos move, String c)
	{
//		System.out.println("16");
		CurPosition[move.x][move.y] = c;
	}
	
	/**
	 * 
	 * 回溯到之前的棋局
	 * 
	 * @param move
	 * 				上一个棋子的坐标
	 */
	void unMakeMove(ChessPos move)
	{
//		System.out.println("17");
		CurPosition[move.x][move.y] = Chessman.EMPTY.getChessman();		
	}
	
}

/**
 * 
 * 该类用以生成可行的下棋坐标
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
	 * 				棋盘的行列数
	 */
	MoveGenerator(int n)
	{
//System.out.println("5 ");
		size = n;		
		moveList = new ChessPos[5][n * n];
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < n * n; j++)
				moveList[i][j] = new ChessPos();
	}

	/**
	 * 生成可行的下棋坐标
	 * 
	 * @param board		
	 * 					棋盘情况
	 * @param depth		
	 * 					当前搜索深度
	 * @return			
	 * 					可行的下棋坐标数量
	 */
	int createPossibleMove(String[][] board, int depth)
	{
//		System.out.println("15 ");
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
 * 使用了alpha-beta剪枝算法的搜索引擎
 *
 */
class AlphaBetaEngine extends SearchEngine
{
	AlphaBetaEngine(int n, int depth)
	{
		super(n, depth);
	}
	
	/**
	 * 搜索出一个较好的走法
	 * 
	 * @param board		
	 * 				棋盘情况
	 * @param c	  the chessman hold by computer
	 * 
	 */
	void searchAGoodMove(String board[][], String c)
	{
//System.out.println("9 ");
		//记录当前棋盘情况
		for(int i = 0; i < gridNum; i++)
			for(int j = 0; j < gridNum; j++)
			{
				CurPosition[i][j] = board[i][j];
			}
		boolean isWhiteTurn = (c == Chessman.WHITE.getChessman())?true:false;
		
		//使用alpha-beta剪枝算法搜索出较好的走法
		AB(maxDepth, -20000, 20000, isWhiteTurn);
		
		//System.out.println("x:" + bestMove.y + " y:" + bestMove.x);
		//makeMove(bestMove, c);
	}
	
	/**
	 * alpha-beta剪枝算法
	 * 
	 * @param depth			
	 * 				当前搜索深度
	 * @param alpha			
	 * 				alpha值
	 * @param beta			
	 * 				beta值
	 * @param isWhiteTurn	
	 * 				是否轮到白子下棋
	 * @return 分数
	 */
	int AB(int depth, int alpha, int beta, boolean isWhiteTurn)
	{
//System.out.println(" 10");
		int Count,i;
		int score;
		String chessMan;
		int current = -20000;
		
		chessMan = (isWhiteTurn)?Chessman.WHITE.getChessman():Chessman.BLACK.getChessman();
		
		//如果是叶子节点则返回分数
		if (depth <= 0)	
		{
			score = eval.evaluate(CurPosition, isWhiteTurn);
			score = (isWhiteTurn)?-score:score;
			return score;
		}
		
		//生成可能的走法
		Count = moveGen.createPossibleMove(CurPosition, depth);
		
		//在可能的走法中搜索
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
			
			//递归搜索
			score = -AB(depth - 1 , -beta, -alpha, !isWhiteTurn);
			
/*			if(depth == maxDepth)
				System.out.println("x:" + t.x + " " + "y:" + t.y + "score:" + score);
*/			
			unMakeMove(t);
			
			//判断是否得到了更好的结果
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
	    //返回最好的结果
		return current;

	}
}
