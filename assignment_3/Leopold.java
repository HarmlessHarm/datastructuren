import java.io.*;
import java.util.*;

public class Leopold {

	
	public static int[] leopoldsMove = new int[2];
	public static int[] neighbours = {-1, 1,-4, 4, -5, 5, -6, 6};
	public static final int TURN = -1; // Lions turn always -1

    /* AI chooses move */
	public static int[] yourTurnSir(Agent[] board) {
		// System.out.println(StateTree.getBestMove(board));
		return StateTree.getBestMove(board);

		// ArrayList<int[]> possibleMoves= new ArrayList<int[]>();
	 //    for (int i=0; i<board.length; i++) {
	 //        if (board[i] != null && board[i].getClass().equals(Lion.class)) {
	 //            leopoldsMove = checkNeighbours(board, i); // i = position on board
	 //            if (leopoldsMove[0] != -999) {
	 //                possibleMoves.add(leopoldsMove);
	 //                // return leopoldsMove;
	 //            }
	 //        }
	 //    }
	 //    if (possibleMoves.size() != 0) {
	 //    	int randMove = new Random().nextInt(possibleMoves.size());
	 //    	String moveStr= Arrays.toString(possibleMoves.get(randMove));
	 //    	System.out.println(moveStr);
	 //    	return possibleMoves.get(randMove);
	 //    } 
	 //    for (int i = 0;i<board.length ;i++ ) {
	 //    	// Gets all lions on board
		// 	if(board[i] != null && board[i].getClass().equals(Lion.class) ) {
            	
  //           	leopoldsMove = randomMove(i);
  //           	while(board[i].validate(board, leopoldsMove[0], leopoldsMove[1], TURN) == false) {
  //           		leopoldsMove = randomMove(i);
  //           	}
  //       		return leopoldsMove;
  //   		}
  //       }
  //       int[] noStr = {-999, -999}; // Will never be accessed
  //       return noStr;
	}
	
	/* Neighbours of the lion are being checked for being lamb */
	private static int[] checkNeighbours(Agent[] board, int pos1) {
	    int neighPos;
	    int pos2;
	    for (int i=0; i<neighbours.length; i++) {
	        neighPos = pos1 + neighbours[i]; // position of neighbour
        	pos2 = neighPos + neighbours[i]; // target move position
        	// System.out.println("try: "+pos1+" -> "+pos2);
	        if (board[pos1].validate(board, pos1, pos2, TURN)) {
	        	

	            leopoldsMove[0] = pos1;
	            leopoldsMove[1] = pos2;
	            System.out.println("From "+pos1+" via "+neighPos+" to "+pos2);
	            System.out.println("nom nom nom");
	            return leopoldsMove; 
	        }	        
	    }
	    // System.out.println("really!?");
	    int[] noStr = {-999,-999}; // never happens but needs return statement
	    return noStr;
	}	
	
	/* Chooses a random move for the lion */
	private static int[] randomMove(int pos1) {
		// System.out.println("random move");
	    int randomNeigh = new Random().nextInt(neighbours.length);
	    // System.out.println("randTar:"+randomNeigh);
        int randomMove = pos1 + neighbours[randomNeigh];
        leopoldsMove[0] = pos1;
        leopoldsMove[1] = randomMove;
        return leopoldsMove;
    }	
}
