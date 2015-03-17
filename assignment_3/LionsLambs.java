import java.io.*;
import java.util.*;

public class LionsLambs {
	
	/**
	 * board representation board stores Agent objects which can be either Lions or Lambs
	 * scoreHistory stores all the scores of the boards ever used
	 */
	public static Agent[] board = new Agent[25];
	public static ArrayList<String> scoreHistory = new ArrayList<String>();

	/**
	 * Global variables used to track the game state
	 */
	public static int WIN_STATE = 0;
	public static int TURN = 1;
	public static int LAMB_COUNT = 20;
	public static int LAMB_KILLED = 0;

	/**
	 * Initialises board, places a Lion object on each corner
	 */
	public static void init() {
		// Lions without names are not OK
		board[0] = new Lion("Leo");
		board[4] = new Lion("Leu");
		board[20] = new Lion("Love");
		board[24] = new Lion("Lejon");
	}

	/**
	 * @args if arguments are given in the form of integers, use this as target depth in the state tree
	 * 
	 */
	public static void main(String[] args) {

		if (args.length != 0) {
			try {
				int depth = Integer.parseInt(args[0]);
				StateTree.setDepth(depth);
			}
			catch (NumberFormatException e) {
				System.out.println("Set custom depth by adding an int in arguments");
			}
		}

	    boolean bool = false;
	    String input, player;

	    init();
	    System.out.println("WELCOME! My name is Leopold, I'm a superiour");
	    System.out.println("AI designed to play this game.");
	    System.out.println("Do you dare to play against me?");
	    while (bool == false) {
		    System.out.print("(yes/no): ");
		    input = stringRead();
		    if (input.equals("y") || input.equals("yes")) {
		    	System.out.println("Would you like to play as mighty lions?");
		    	System.out.println("Or wee little lambs?");
		    	while (bool == false) {
			    	System.out.print("(Lions/Lambs): ");
			    	input = stringRead();
			    	if (input.equals("lions") || input.equals("lion")) {
			    		System.out.println("Good luck! You'll need it...");
			    		player = "lions";
			    		bool = true;
			    	} else if (input.equals("lambs") || input.equals("lamb")) {
			    		System.out.println("Good luck! You'll need it...");
			    		player = "lambs";
			    		bool = true;
			    	} else {
			    		System.out.println("C'mon choose already!");
			    	}
		    	}
		    } else if (input.equals("n") || input.equals("no")) {
		    	player = "two";
		    	bool = true;
		    } else if (input.equals("ai")) {
		    	player = "ai";
		    	bool = true;
		    } 
		    else {
		    	System.out.println("C'mon choose already!");
		    }
	    }
	    playGame(player);
	}

    /* This method describes the game loop */
	public static void playGame(String player){	
		int pos1, pos2;
		int[] input;

		while (WIN_STATE == 0) {
			System.out.println("");
			Board.drawBoard(board);
			System.out.println("Lambs remaining: "+LAMB_COUNT);
			System.out.println("Lambs killed   : "+LAMB_KILLED);
			
			while (true) {

				if (TURN == 1) {
					System.out.print("Lambs player's turn: ");
					
					if (player.equals("lambs") || player.equals("two")) {					
					    input = readInput();
					    while (input == null) {
					    	input = readInput();
					    }
					    pos1 = input[0];
					    pos2 = input[1];

					    if (board[pos1].validate(board, pos1, pos2, TURN)) {
						    setMove(pos1, pos2);
						    TURN = TURN * -1;
						    break;
					    }					
					}
					if (player.equals("lions") || player.equals("ai")){
					    input = Leopold.yourTurnSir(board);
					    setMove(input[0], input[1]);
					    TURN = TURN * -1;
					    System.out.print(" Leopold says: "+input[0]+" ");
					    if (input[1] < 9000) {
					    	System.out.println(input[1]);
					    }else {
					    	System.out.println("");
					    }
					    break;
					}
				
				}

				if (TURN == -1) {
					System.out.print("Lions player's turn: ");
					if (player.equals("lions") || player.equals("two")) {
					    input = readInput();
					    while (input == null) {
					    	input = readInput();
					    }
					    pos1 = input[0];
					    pos2 = input[1];

					    if (board[pos1].validate(board, pos1, pos2, TURN)) {
						    setMove(pos1, pos2);
						    TURN = TURN * -1;
						    break;
					    }					
					} 
					if (player.equals("lambs") || player.equals("ai")) {
					    input = Leopold.yourTurnSir(board);
					    setMove(input[0], input[1]);
					    TURN = TURN * -1;

					    System.out.println(" Leopold says: "+input[0]+" "+input[1]);
					    break;
					}
				}
			}

			if (LAMB_KILLED == 20) {
			    WIN_STATE = -1;
			}
			
			ArrayList<int[]> tempMoves = new ArrayList<int[]>();
			ArrayList<int[]> moves = new ArrayList<int[]>();
			for (int i=0; i<board.length; i++) {
	            if ( board[i] != null && board[i].getClass().equals(Lion.class) ) {
	                tempMoves = StateTree.getPossibleLionMoves(board, i);
	                for (int j=0; j < tempMoves.size(); j++) {
	                    moves.add(tempMoves.get(j));
	                }
	            }
	        }
			
			if (moves.size() == 0) {
			    WIN_STATE = 1;
			}
			

		}
		Board.drawBoard(board);
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
			System.out.println(ioe);
			return null;
      	}
      	catch (NumberFormatException nfe) {
      		System.out.println("Please enter an input with only integers");
      		return null;
      	}
	}

	public static String stringRead() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		try {
			input = br.readLine().split("\\s");
			input[0] = input[0].toLowerCase();
			return input[0];
		} 
		catch (IOException ioe) {
			System.out.println(ioe);
			return null;
      	}
	}

    public static void setMove(int pos1, int pos2) {
    	int[] jumps = {-2, 2,-8, 8, -10, 10, -12, 12};
    	int[] neighbours = {-6, -5, -4, -1, 1, 4, 5, 6};
    	int neighbourLambs = 0;
    	int posDiff = pos2 - pos1;

    	scoreHistory.add(getBoardScore(board));

    	// Changing board
    	if (pos2 > 9000) {
			board[pos1] =  new Lamb("name", pos1);
			LAMB_COUNT--;
    	} else {
	    	board[pos2] = board[pos1];
	    	board[pos1] = null;
    	} 
    	// checks of the move that was done was a kill move and removes the lamb
    	for (int i=0;i < jumps.length ; i++) {
    		if (posDiff == jumps[i]) {
	    		int target = pos1 + (pos2 - pos1)/2;
	    		board[target] = null;
	    		LAMB_KILLED++;
    		}
    	}    	
    }

    /* Computes score for a certain board position that is used to check whether board positions haven't occurred before */
    private static String getBoardScore(Agent[] board) {
        String totalScore = "";

        /* Compute the score of the board */
        for (int k=0; k<board.length; k++) {
            if (board[k] != null && board[k].getClass().equals(Lamb.class)) {
                totalScore = totalScore + "3";
                
            }
            if (board[k] != null && board[k].getClass().equals(Lion.class)) {
                totalScore = totalScore + "7";
            }
            if(board[k] == null ) {
                totalScore = totalScore + "1";
            }
        }
        return totalScore;
    }
}
