// import acm.graphics.*;
// import acm.program.*;
// import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

public class LionsLambs {
	
	public static Agent[] board = new Agent[25];

	public static int WIN_STATE = 0;

	public static void init() {
		board[0] = new Lion("Leo");
		board[4] = new Lion("Leu");
		board[20] = new Lion("Love");
		board[24] = new Lion("Lejon");
	}

	public static void main(String[] args) {
	    init();
	    playGame();
	}

	// public static void main() {
	// 	drawCanvas();
	// }
	
	// call: java LionsLambs <Agent> <Move> <PositionOne> (<PositionTwo>)
	

	public static void playGame(){
		String[] input;
		// StringTokenizer st;
		// String agent, move;
		// int pos1, pos2;

		while( WIN_STATE == 0 ) {
			Board.drawBoard(board);
			input = readInput();
			// st = new StringTokenizer(input);
			// agent = st[0];
			// move = st[1];
			// pos1 = Integer.parseInt(st[2]);
			// pos2 = Integer.parseInt(st[3]);
			setMove(input);
		}
		if( WIN_STATE == 1) {
			System.out.println("Lambs win!");
			System.exit(1);
		}
		if (WIN_STATE == -1) {
			System.out.println("Lions win!");
			System.exit(1);
		}
	}

	public static String[] readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		try {
			input = br.readLine().split("\\s");
			return input;
		} catch (IOException ioe) {
			System.out.println("IO error trying to read your name!");
			return null;
      	}
	}



	public static void setMove(String[] st) {
	    String agent = st[0];
		String move = st[1];
		int positionOne = Integer.parseInt(st[2]);
		int positionTwo = Integer.parseInt(st[3]);
	    
	    /* LIONS */
	    if (agent.equals("lion")) {
	        if (move.equals("move")) {
	            if (board[positionTwo] == null) {
	                if (board[positionOne].move(positionOne, positionTwo)) {
	                    board[positionTwo] = board[positionOne];
	                    board[positionOne] = null;
	                }
	                else {
	                    System.out.println("Invalid move");
	                }
	            }
	            else {
	                System.out.println("The position you want to move to is already taken!");
	            }
	        }
	        
	        else if (move.equals("jump")) {
	            if (board[positionTwo] == null) {
	                if (board[positionOne].jump(positionOne, positionTwo, board)) {
	                    board[positionTwo] = board[positionOne];
	                    board[positionOne] = null;
	                }
	                else {
	                    System.out.println("Invalid jump");
	                }
	            }
	            else {
	                System.out.println("The position you want to jump to is already taken!");
	            }
	        }
	        
	        else {
	            System.out.println("We don't know that move. Either choose 'move' or 'jump'");
	        }
	    }
	    
	    
	    /* LAMBS -- Still need to check whether object is lamb */
	    if (agent.equals("lamb")) {
	        int countLambs = 0;
	        
	        // repetition of code, ugly
	        if (move.equals("move")) {
	            if (board[positionTwo] == null) {
	                if (board[positionOne].move(positionOne, positionTwo)) {
	                    board[positionTwo] = board[positionOne];
	                    board[positionOne] = null;
	                }
	                else {
	                    System.out.println("Invalid move");
	                }
	            }
	            else {
	                System.out.println("The position you want to move to is already taken!");
	            }
	        }
	        
	       
	        else if (move.equals("placeInGame")) {
	            if (board[positionOne] == null && countLambs < 20) {
	                board[positionOne] = new Lamb("name"); // name?
	                countLambs++;
	            }
	            else {
	                System.out.println("Impossible to place new lamb on that position");
	            }
	        }
	    }
	}
	
	
	

}