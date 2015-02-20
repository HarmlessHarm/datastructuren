import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class LionsLambs extends GraphicsProgram {
	
	// call: java LionsLambs <Agent> <Move> <PositionOne> <PositionTwo>
	
	Agent[] board;
	
	private void setUpGame() {
	    board = new Agent[25];
	    board[0] = new Lion;
	    board[4] = new Lion;
	    board[20] = new Lion;
	    board[24] = new Lion;        
	}
	
	private void playGame(String[] args) {
	    String agent = args[0];
	    String move = args[1];
	    int positionOne = Integer.parseInt(args[2]);
	    int positionTwo = Integer.parseInt(args[3]);
	    
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
	    
	    if (args[0].equals("lamb")) {
	    
	    }
	}
	
	
	/* Before you call lion.move(positionOne, positionTwo) (e.g) check whether positionTwo is not null.
	   I can't check that in Agent.java as there I can only check for integers and not for array indeces.
	   If not null, then unable to move.
	 */
	
	public static void main(String[] args) {
	    setUpGame();
	    playGame(args);
		
		
		GCanvas canvas = new GCanvas();
		
		
		//GRect rect = new GRect(10, 10);
		//canvas.add(rect);
	}
}
