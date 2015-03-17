public class Leopold {

    /* AI chooses move */
	public static int[] yourTurnSir(Agent[] board) {
		return StateTree.getBestMove(board);
    }	
}
