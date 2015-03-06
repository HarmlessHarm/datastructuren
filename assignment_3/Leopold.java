import java.io.*;
import java.util.*;

public class Leopold {

	//public static Agent[] board = new Agent[25];
	//public static Lion[] lions = new Lion[4];
	//public static Lambs[] lambs;
	
	public static String[] leopoldsMove = new String[2];
	public static int[] neighbours = {-1, 1, -5, 5, -6, 6, -8, 8};

    /* AI chooses move */
	public static String[] yourTurnSir(Agent[] board) {	
	    for (int i=0; i<board.length; i++) {
	        if (board[i] == null) {
	            System.out.println("check");
	        }
	        else if (board[i].getClass().equals(Lion.class)) {
	            leopoldsMove = checkNeighbours(board, i); // i = position on board
	            if (!leopoldsMove[0].equals("no")) {
	                return leopoldsMove;
	            }
	            else {
	                leopoldsMove = randomMove(i);
	                return leopoldsMove;
	            }
	        }
	    }
	    leopoldsMove[0].equals("no");
	    leopoldsMove[1].equals("neighbours");
	    return leopoldsMove;
	
		//this.board = board;
		//this.lions = lions; 	
		//this.lambs = lambs.toArray(new Lambs[lambs.size()]);
		//System.out.println(this.lambs.length);
	}
	
	/* Neighbours of the lion are being checked for being lamb */
	private static String[] checkNeighbours(Agent[] board, int boardPos) {
	    int checkNeigh;
	    String pos1, pos2;
	    for (int i=0; i<neighbours.length; i++) {
	        checkNeigh = boardPos + i;
	        if (board[checkNeigh] == null) {
	            System.out.println("check2");
	        } 
	        else if (board[checkNeigh].getClass().equals(Lamb.class)) {
	            leopoldsMove[0] = Integer.toString(boardPos);
	            leopoldsMove[1] = Integer.toString(checkNeigh+i);
	            return leopoldsMove; 
	        }
	        /* else {
	            leopoldsMove[0].equals("no");
	            leopoldsMove[1].equals("neighbours");
	            return leopoldsMove;
	        } */	        
	    }
	    leopoldsMove[0].equals("no");
	    leopoldsMove[1].equals("neighbours");
	    return leopoldsMove;
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
