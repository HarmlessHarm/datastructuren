import java.applet.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

public class LionsLambs {
	
	public static Agent[] board = new Agent[25];
	public static Lion[] lions = new Lion[4];
	public static List<Lamb> lambs = new ArrayList<Lamb>();
	public static int WIN_STATE = 0;
	public static int TURN = 1;
	public static int LAMB_COUNT = 20;
	public static int LAMB_KILLED = 0;

	public static void init() {
		board[0] = new Lion("Leo", 0);
		board[4] = new Lion("Leu", 4);
		board[20] = new Lion("Love", 20);
		board[24] = new Lion("Lejon", 24);
	}

	public static void main(String[] args) {
	    init();
	    playGame();
	}

	// call: java LionsLambs <pos1> (<pos2>)	

    /* This method describes the game loop */
	public static void playGame(){
		String[] input;
		
		// setUpGame(); -- the basic board should be drawn here

		while (WIN_STATE == 0) {
		    // updateBoard(); -- the board should be updated according to the positions filled
			Board.drawBoard(board);
			while(true) {
				if(TURN == 1) {
					System.out.print("Lambs player's turn: "); // M: what if move is invalid; give player another chance?
					input = readInput();
				} else if(TURN == -1) {
					System.out.print("Lions player's turn: ");
					input = Leopold.yourTurnSir(board);
				}
				if(setMove(input)) {
					TURN = TURN * -1;
					break;
				}
			}
		}
		
		if (WIN_STATE == 1) {
			System.out.println("Lambs win!");
			System.exit(1);
		}
		
		else if (WIN_STATE == -1) {
			System.out.println("Lions win!");
			System.exit(1);
		}
	}

    /* Reads the users input - moves */
	public static String[] readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		try {
			input = br.readLine().split("\\s");
			return input;
		} 
		catch (IOException ioe) {
			System.out.println("When does this error show!?");
			return null;
      	}
	}

    /* Determines kind of move and moves if legitimate */
	public static boolean setMove(String[] input) {
		int pos1 = Integer.parseInt(input[0]);
		int pos2 = 0; // M: Why do you need this?
		if (input.length == 2) {
			pos2 = Integer.parseInt(input[1]);
		}

		// hiermee kan je de class opvragen zie ook Board.java
		// Class agent = board[pos1].getClass();
		
		/* Place lamb in game */
		if (input.length == 1 && LAMB_COUNT != 0 && board[pos1] == null && TURN == 1) {
			board[pos1] =  new Lamb("name");
			LAMB_COUNT--;
			return true;
		}
		
	    /* Move lions and lambs */
	    else if (board[pos1] != null && board[pos2] == null) {
	    	if ((TURN == 1 && board[pos1].getClass().equals(Lamb.class) && LAMB_COUNT == 0) ||
	    		(TURN == -1 && board[pos1].getClass().equals(Lion.class))) {

		    	if(board[pos1].move(pos1, pos2) || board[pos1].specialMove(pos1, pos2)) {
		    		board[pos2] = board[pos1];
		    		board[pos1] = null;
		    		return true;
		    	} else {
		    		System.out.println("Invalid move");
		    		return false;
		    	}
	    	}
	    } else {
    		System.out.println("No piece found at " + pos1 + " or no room at " + pos2);
    		return false;
    	}
    	return false;
    }
	    	

	    
	    
}
