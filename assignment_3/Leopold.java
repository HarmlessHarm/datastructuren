import java.io.*;
import java.util.*;

public class Leopold {

	//public static Agent[] board = new Agent[25];
	//public static Lion[] lions = new Lion[4];
	//public static Lambs[] lambs;
	
	public static String[] leopoldsMove = new String[2];
	public static int[] neighbours = {-1, 1,-4, 4, -5, 5, -6, 6};

    /* AI chooses move */
	public static String[] yourTurnSir(Agent[] board) {
		ArrayList<String[]> possibleMoves= new ArrayList<String[]>();
	    for (int i=0; i<board.length; i++) {
	        if (board[i] != null && board[i].getClass().equals(Lion.class)) {
	            leopoldsMove = checkNeighbours(board, i); // i = position on board
	            if (leopoldsMove[0] != null) {
	                possibleMoves.add(leopoldsMove);
	                // return leopoldsMove;
	            }
	        }
	    }
	    if (possibleMoves.size() != 0) {
	    	int randMove = new Random().nextInt(possibleMoves.size());
	    	String moveStr= Arrays.toString(possibleMoves.get(randMove));
	    	System.out.println(moveStr);
	    	return possibleMoves.get(randMove);
	    } 
	    for (int i = 0;i<board.length ;i++ ) {
			if(board[i] != null && board[i].getClass().equals(Lion.class) ) {
            	leopoldsMove = randomMove(i);
        		return leopoldsMove;
    		}
        }
        String[] noStr = {null, null};
        return noStr;
	}
	
	/* Neighbours of the lion are being checked for being lamb */
	private static String[] checkNeighbours(Agent[] board, int boardPos) {
	    int checkNeigh;
	    int pos1, pos2;
	    for (int i=0; i<neighbours.length; i++) {
	        checkNeigh = boardPos + neighbours[i];
        	pos2 = checkNeigh + neighbours[i];
	        if ((checkNeigh >= 0 && checkNeigh <= 24) && board[checkNeigh] != null && 
	        	board[checkNeigh].getClass().equals(Lamb.class) && 
	        	board[boardPos].validateAI(boardPos, pos2)) {
	        	

	            leopoldsMove[0] = Integer.toString(boardPos);
	            leopoldsMove[1] = Integer.toString(pos2);
	            System.out.println("From "+boardPos+" via "+checkNeigh+" to "+pos2);
	            System.out.print("nom nom");
	            return leopoldsMove; 
	        }	        
	    }
	    String[] noStr = {null,null};
	    return noStr;
	}	
	
	/* Chooses a random move for the lion */
	private static String[] randomMove(int boardPos) {
	    int randomNeigh = new Random().nextInt(neighbours.length);
        int randomMove = boardPos + neighbours[randomNeigh];
        leopoldsMove[0] = Integer.toString(boardPos);
        leopoldsMove[1] = Integer.toString(randomMove);
        return leopoldsMove;
    }	
}
