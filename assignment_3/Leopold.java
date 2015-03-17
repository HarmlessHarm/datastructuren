/* Class to return the best move for the AI. 
 * Class was used in previous version of the AI,
 * however, now it's slightly redundant. */

public class Leopold {

    /* AI chooses move */
	public static int[] yourTurnSir(Agent[] board) {
		return StateTree.getBestMove(board);
    }	
}
