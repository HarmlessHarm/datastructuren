import java.util.*;
import java.io.*;

/**
 * Creates a graphic representation of the board
 */
public class Board {
	/**
	 * stringBoard contains the board converted to a string representation
	 * CONNECTION_ROW used to determine what connection between rows must be used
	 * lion,null,lamb string representation of certain pieces
	 */
	private static String[] stringBoard = new String[25];
	private static int CONNECTION_ROW = 0;
	private static String lion = "L";
	private static String nul = "0";
	private static String lamb = "l";

	/**
	 * draws board in terminal. connecting dashes are drawn between board positions
	 *
	 * @param	board 	board which needs representation
	 */
	public static void drawBoard(Agent[] board) {
		setStringBoard(board);
		for (int i=0; i<stringBoard.length;i++ ) {
			System.out.print(stringBoard[i]);
			if ((i+1)%5==0) {
				System.out.println();
				if (i != 24) {
					printConnections();
				}
			}
			else {
				System.out.print("--");
			}
		}
	}

	/** 
	 * Converts board to a string representation
	 *
	 * @param	board 	board which needs representation
	 */
	private static void setStringBoard(Agent[] board) {
		for (int i=0;i<board.length ;i++ ) {
			if (board[i] == null) {
				stringBoard[i]="0";
			}
			else if (board[i].getClass().equals(Lion.class)) {
				stringBoard[i]="L";
			}
			else if (board[i].getClass().equals(Lamb.class)) {
				stringBoard[i]="l";
			}
		}
	}

    /**
     * Draws vertical and diagonal connection lines between board position,
     * uses CONNECTION_ROW to determine which row must be printed
     */
	private static void printConnections() {
		if (CONNECTION_ROW == 0) {
			System.out.println("|\\ | /|\\ | /|");
			System.out.println("| \\|/ | \\|/ |");
			CONNECTION_ROW = 1;
		}
		else if(CONNECTION_ROW == 1) {
			System.out.println("| /|\\ | /|\\ |");
			System.out.println("|/ | \\|/ | \\|");
			CONNECTION_ROW = 0;
		}
	}
}
