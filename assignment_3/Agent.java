import java.util.*;
/**
 * Agent object class. Defines the moves each piece can make.
 * Lion and Lamb can use all methods defined in this class.
 */
public abstract class Agent {
    // animals need names
    public String name;
    
    // Constructor
    public Agent() {}
    /**
     * Abstract class so Lion can define its unique jump move
     */
    public abstract boolean specialMove(int pos1, int pos2, Agent[] board);

    /**
     * Checks if the requested move is valid move. Checks who's turn it is and if a lamb
     * is placed on the board. Lamb is placed on board when pos2 is over 9000
     *
     * @param   board   the board array
     * @param   pos1    starting position of piece
     * @param   pos2    final position of piece
     * @param   turn    tells who's turn it is
     * @return          if the move is a valid move or not
     */
    public static boolean validate(Agent[] board, int pos1, int pos2, int turn) {
    
        if (((pos2 < 0 || pos2 > 24) && pos2 < 9000) ||
             (pos1 < 0 || pos1 > 24 )) {
            return false;
        }
        
        if (pos2 > 9000 && LionsLambs.LAMB_COUNT != 0 && turn == 1) {
            if (board[pos1] == null) {
                return true;
            } else{
                return false;
            }
        }
        else if (board[pos1] != null && board[pos2] == null) {
            if((turn == 1 && board[pos1].getClass().equals(Lamb.class) && LionsLambs.LAMB_COUNT == 0) ||
                turn == -1 && board[pos1].getClass().equals(Lion.class)) {
                if (move(pos1, pos2) || board[pos1].specialMove(pos1, pos2, board)) {
                    return true;
                }
            }
        }
        if (LionsLambs.LAMB_COUNT == 0) {
            return false;
        }
        return false;
    }
    
    /**
     * Validates if a given move is a valid move. Uses the posDif to check if
     * it is either a horizontal, vertical or diagonal move
     *
     * @param   pos1    starting position of piece
     * @param   pos2    final position of piece
     * @return          if the move is a valid move or not
     */
    private static boolean move(int pos1, int pos2) {

        boolean status = false;
        int posDif = pos2 - pos1;

        if (posDif == 1 || posDif == -1) {
            status = checkMoveHor(posDif, pos1); 
            return status;   
        }

        if (posDif == 5 || posDif == -5) {
            status = checkMoveVer(pos2);
            return status;
        }
        
        if (posDif == -6 ||  posDif == 4 || posDif == 6 || posDif == -4) {
            status = checkMoveDiag(posDif, pos1);
            return status;
        } 
        return false;  
    }
    
    /**
     * Checks whether horizontal moves are valid.
     * Uses modulus to check where the piece is able to move horizontally
     * 
     * @param   posDif  the difference between pos1 and pos2
     * @param   pos1    starting position of piece
     * @return          if its a valid horizontal move or not
     */
    private static boolean checkMoveHor(int posDif, int pos1) {
        if ((posDif == 1 && (pos1 + 1) % 5 == 0)||
            (posDif == -1 && pos1 % 5 == 0)) {
            return false;
        }
        else { 
            return true; 
        }
        
    }

    /**
     * Checks whether vertical moves are valid.
     * Checks if pos2 is within the boundries of the board array
     * 
     * @param   pos2    starting final of piece
     * @return          if its a valid vertical move or not
     */
    private static boolean checkMoveVer(int pos2) {
        if (pos2 > 24 || pos2 < 0) {
            return false;
        }
        else {
            return true;
        }
    }
    
    /**
     * Checks whether diagonal moves are valid.
     * Uses both horizontal and vertical validators to check if the 
     * move is diagonally valid
     * 
     * @param   pos1    starting position of piece
     * @param   pos2    starting final of piece
     * @param   posDif  the difference between pos1 and pos2
     * @return          if its a valid diagonal move or not
     */
    private static boolean checkMoveDiag(int posDif, int pos1) {
        if (pos1 % 2 == 0 && posDif > 0 &&
            checkMoveHor(posDif - 5, pos1) && checkMoveVer(posDif + pos1) ) {
            return true;
        }
        if (pos1 % 2 == 0 && posDif < 0 &&
            checkMoveHor(posDif + 5, pos1) && checkMoveVer(posDif + pos1) ) {
            return true;
        }
        else {
            return false;
        }
    }
}
