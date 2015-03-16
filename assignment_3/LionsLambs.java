import java.applet.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class LionsLambs {
	
	public static Agent[] board = new Agent[25];
	public static ArrayList<Agent[]> boardHistory = new ArrayList<Agent[]>();
	public static ArrayList<Integer> scoreHistory = new ArrayList<Integer>();
	//public static Lion[] lions = new Lion[4];
	//public static List<Lamb> lambs = new ArrayList<Lamb>();
	public static int WIN_STATE = 0;
	public static int TURN = 1;
	public static int LAMB_COUNT = 20;
	public static int LAMB_KILLED = 0;
	public static int LIONS_ENCLOSED = 0;
	public static int[] input;

	public static void init() {
		// Lions without names are not OK
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
		int pos1, pos2;
		// setUpGame(); -- the basic board should be drawn here

		while (WIN_STATE == 0) {
		    // updateBoard(); -- the board should be updated according to the positions filled
			Board.drawBoard(board);
			
			for (int i=0; i<board.length; i++) {
			    if (board[i] != null && board[i].getClass().equals(Lion.class)) {
			        if (StateTree.getPossibleLionMoves(board, i).get(0) == null) {
			            LIONS_ENCLOSED++;
			        }
			    }
			}
			
			if (LAMB_KILLED == 2) {
			    WIN_STATE = -1;
			}
			
			
			if (LIONS_ENCLOSED == 4) {
			    WIN_STATE = 1;
			}
			
			while (true) {
				if (TURN == 1) {
					System.out.print("Lambs player's turn: ");
					input = readInput();
					pos1 = input[0];
					pos2 = input[1];

					if(board[pos1].validate(board, pos1, pos2, TURN)) {
						setMove(pos1, pos2);
						TURN = TURN * -1;
						break;
					}
				
				} 
				else if (TURN == -1) {
					System.out.print("Lions player's turn: ");
					// input = readInput();
					input = Leopold.yourTurnSir(board);
					//System.out.println("input: " + input[0] + "  " + input[1]);
					setMove(input[0], input[1]);
					TURN = TURN * -1;

					// setMove(input[0], input[1])
					System.out.println("Leo says: "+input[0]+" "+input[1]);
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
	public static int[] readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		int[] intIn = new int[2];
		int pos1, pos2;
		try {
			input = br.readLine().split("\\s");
			pos1 = Integer.parseInt(input[0]);
			if (input.length > 1) {
				pos2 = Integer.parseInt(input[1]);
				intIn[0] = pos1;
				intIn[1] = pos2;
				return intIn;
			}
			intIn[0] = pos1;
			intIn[1] = 9001;
			return intIn;
		} 
		catch (IOException ioe) {
			System.out.println("When does this error show!?");
			return null;
      	}
	}

    public static void setMove(int pos1, int pos2) {
    	int[] jumps = {-2, 2,-8, 8, -10, 10, -12, 12};
    	int[] neighbours = {-6, -5, -4, -1, 1, 4, 5, 6};
    	int neighbourLambs = 0;
    	int posDiff = pos2 - pos1;
    	System.out.println("setMove: "+pos1+" -> "+pos2+" pd: "+posDiff);

    	boardHistory.add(board);
    	scoreHistory.add(getBoardScore(board));
    	// Changing board
    	if (pos2 > 9000) {
			board[pos1] =  new Lamb("name", pos1);
			LAMB_COUNT--;
    	} else {
    	    System.out.println(pos1 +" is emptied now");
	    	board[pos2] = board[pos1];
	    	board[pos1] = null;
    	} 
    	// checks of the move that was done was a kill move and removes the lamb
    	for (int i=0;i < jumps.length ; i++) {
    		if (posDiff == jumps[i]) {
    		    System.out.println("In check killing move");
	    		int target = pos1 + (pos2 - pos1)/2;
	    		board[target] = null;
	    		LAMB_KILLED++;
	    		System.out.println(LAMB_KILLED);
    		}
    	}    	
    }

    private static int getBoardScore(Agent[] board) {
    	int totalScore = 1;


    	for (int i=0;i<board.length ;i++ ) {
    		if (board[i]!= null && board[i].getClass().equals(Lamb.class)) {
    			totalScore = totalScore * 3 * i;
    		}
    		if (board[i] != null && board[i].getClass().equals(Lion.class)) {
    			totalScore = totalScore * 7 * i;
    		}
    		if (board[i] == null) {
    			totalScore = totalScore * 1 * i;
    		}
    	}
    }
	    	

	    
	    
}
