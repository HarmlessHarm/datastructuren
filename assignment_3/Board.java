import java.util.*;
import java.io.*;

public class Board {

	private static String[] stringBoard = new String[25];
	private static int CONNECTION_ROW = 0;

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
				System.out.print('-');
			}
		}
	}

	private static void setStringBoard(Agent[] board) {
		// String lion = 'L';
		// String nul = '0';
		// String lamb = 'l';
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
			// System.out.println(board[i].getClass());
		}
	}

	private static void printConnections() {
		if (CONNECTION_ROW == 0) {
			System.out.println("|\\|/|\\|/|");
			CONNECTION_ROW = 1;
		}
		else if(CONNECTION_ROW == 1){
			System.out.println("|/|\\|/|\\|");
			CONNECTION_ROW = 0;
		}
	}
}