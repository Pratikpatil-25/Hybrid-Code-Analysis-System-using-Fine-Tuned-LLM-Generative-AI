import java.util.ArrayList;
import javax.swing.*;

public class AI implements Runnable {
	private static final int TIME_LIMIT_MILLIS = 5000;
	private static final int EVALS_PER_SECOND = 100;
	private static final int emptyPosition = 0;
	private static final int aiPosition = 1;
	private static final int humanPosition = 2;
	private static final int winCutoff = 500000;
	
	private static boolean searchCutoff = false;
	
	public AI() {

	}
	
				public void run() {
		AIGameState state = new AIGameState();
		
		AIGameMove move = chooseMove(state);
		
		AIGame.buttons[move.getRow()][move.getColumn()].setText(AIGame.aiButtonText);
	}
	
				private AIGameMove chooseMove(AIGameState state) {
		long startTime = System.currentTimeMillis();
		boolean aiMove = state.aiMove();
		int maxScore = Integer.MIN_VALUE;
		AIGameMove bestMove = null;
		
		ArrayList<AIGameMove> moves = state.validMoves();
		
		for (AIGameMove move : moves) {
												AIGameState newState = state.clone();
			
			newState.makeMove(move);
			
												long searchTimeLimit = ((TIME_LIMIT_MILLIS - 1000) / (moves.size()));
			
			int score = iterativeDeepeningSearch(newState, searchTimeLimit);
			
												if (score >= winCutoff) {
				return move;
			}
			
			if (score > maxScore) {
				maxScore = score;
				bestMove = move;
			}
		}
				
		return bestMove;
	}
	
				private int iterativeDeepeningSearch(AIGameState state, long timeLimit) {
		long startTime = System.currentTimeMillis();
		long endTime = startTime + timeLimit;
		int depth = 1;
		int score = 0;
		searchCutoff = false;
		
		while (true) {
			long currentTime = System.currentTimeMillis();
			
			if (currentTime >= endTime) {
				break;
			}
			
			int searchResult = search(state, depth, Integer.MIN_VALUE, Integer.MAX_VALUE, currentTime, endTime - currentTime);
			
												if (searchResult >= winCutoff) {
				return searchResult;
			}
			
			if (!searchCutoff) {
				score = searchResult;
			}
			
			depth++;
		}
		
		return score;
	}
	
					private int search(AIGameState state, int depth, int alpha, int beta, long startTime, long timeLimit) {
		ArrayList<AIGameMove> moves = state.validMoves();
		boolean myMove = state.aiMove();
		int savedScore = (myMove) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		int score = Evaluator.eval(state);
		long currentTime = System.currentTimeMillis();
		long elapsedTime = (currentTime - startTime);
		
		if (elapsedTime >= timeLimit) {
			searchCutoff = true;
		}
		
								if (searchCutoff || (depth == 0) || (moves.size() == 0) || (score >= winCutoff) || (score <= -winCutoff)) {
			return score;
		}
		
		if (state.aiMove) {
			for (AIGameMove move : moves) {
				AIGameState childState = state.clone();
				childState.makeMove(move);

				alpha = Math.max(alpha, search(childState, depth - 1, alpha, beta, startTime, timeLimit));
				
				if (beta <= alpha) {
					break;
				}
			}
			
			return alpha;
		} else {
			for (AIGameMove move : moves) {
				AIGameState childState = state.clone();
				childState.makeMove(move);
				
				beta = Math.min(beta, search(childState, depth - 1, alpha, beta, startTime, timeLimit));
					
				if (beta <= alpha) {
					break;
				}
			}
			
			return beta;
		}
	}
	
	public void Reset() {
			}
}