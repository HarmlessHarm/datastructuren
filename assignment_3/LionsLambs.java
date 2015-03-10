import java.applet.*;
import java.io.*;
import java.util.*;

public class LionsLambs {
	
	public static Agent[] board = new Agent[25];
	public static ArrayList<Agent[]> boardHistory = new ArrayList<Agent[]>();
	//public static Lion[] lions = new Lion[4];
	//public static List<Lamb> lambs = new ArrayList<Lamb>();
	public static int WIN_STATE = 0;
	public static int TURN = 1;
	public static int LAMB_COUNT = 20;
	public static int LAMB_KILLED = 0;
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
					System.out.println("1: "+input[0]+"2: "+input[1]);
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
    	boardHistory.add(board);
    	if (pos2 > 9000) {
			board[pos1] =  new Lamb("name", pos1);
			LAMB_COUNT--;
    	} else {
	    	board[pos2] = board[pos1];
	    	board[pos1] = null;
    	}
    }
	    	

	    
	    
}
