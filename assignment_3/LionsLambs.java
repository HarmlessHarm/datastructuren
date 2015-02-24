import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class LionsLambs extends GraphicsProgram {
	
	public static Agent[] board = new Agent[25];

	public static void init() {
		board[0] = new Lion("Leo");
		board[4] = new Lion("Leu");
		board[20] = new Lion("Love");
		board[24] = new Lion("Lejon");
	}

	public static void main() {
		drawCanvas();
	// call: java LionsLambs <Agent> <Move> <PositionOne> (<PositionTwo>)

	
	public void playGame(String[] args) {
	    String agent = args[0];
	    String move = args[1];
	    int positionOne = Integer.parseInt(args[2]);
	    int positionTwo = Integer.parseInt(args[3]);
	    
	    
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
	    if (args[0].equals("lamb")) {
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
	            if (board[positionOne] == null || countLambs < 20) {
	                board[positionOne] = new Lamb("name"); // name?
	                countLambs++;
	            }
	            else {
	                System.out.println("Impossible to place new lamb on that position");
	            }
	        }
	    }
	}
	
	
	
	public static void main(String[] args) {
	    setUpGame();
	    playGame(args);
		
		
		GCanvas canvas = new GCanvas();
		
		
		//GRect rect = new GRect(10, 10);
		//canvas.add(rect);
	}
}
