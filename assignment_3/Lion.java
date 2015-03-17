/**
 * Lion object class. Defines special moves which only lions can make.
 * Lion can use all methods defined in Agent
 */
public class Lion extends Agent {

    public static Agent target;
    /**
     * Constructor
     * @param   name    each lion need a nice name
     */
    public Lion(String name) {
        this.name = name;
    }
    
    /**
     * Checks if the requested move is valid jump. Checks if the position between pos1 and pos2
     * contains a lamb
     *
     * @param   pos1    starting position of piece
     * @param   pos2    final position of piece
     * @param   board   the board array
     * @return          if the move is a valid special move or not
     */
    public boolean specialMove(int pos1, int pos2, Agent[] board) {
        int posDif = pos2 - pos1;
        int posTar = posDif/2 + pos1;
        target = board[posTar];

        /* Check whether move is valid and whether lion jumps over lamb */
        if (target != null && valid(pos1, pos2, posDif) && target.getClass().equals(Lamb.class)) {        
             return true;
        }
        else {
            return false;
        }        
    }

    /**
     * Validates if a given move is a valid jump. Uses the posDif to check if
     * it is either a horizontal, vertical or diagonal move
     *
     * @param   pos1    starting position of piece
     * @param   pos2    final position of piece
     * @param   posDif  the difference between pos1 and pos2
     * @return          if the move is a valid jump or not
     */
    private boolean valid(int pos1, int pos2, int posDif) {
        boolean status = false;
        if (posDif == 2 || posDif == -2) {
            status = checkJumpHor(pos1, posDif);
            return status;
        }
        
        else if (posDif == 10 || posDif == -10) {
            status = checkJumpVer(pos2);
            return status;
        }
        
        else if (posDif == 12 || posDif == -12 || posDif == 8 || posDif == -8) {
            status = checkJumpDiag(pos1, pos2, posDif);
            return status;
        }
        
        return status;
    }

    /**
     * Checks whether horizontal jumps are valid.
     * Uses modulus to check where the piece is able to jump horizontallly
     * 
     * @param   pos1    starting position of piece
     * @param   posDif  the difference between pos1 and pos2
     * @return          if its a valid horizontal jump or not
     */
    private boolean checkJumpHor(int pos1, int posDif) {
    	if ((posDif == 2 && pos1 % 5 < 3) || 
    		(posDif == -2 && pos1 % 5 > 1) ) {
    		return true;
    	} else {
    		return false;
    	}
    }

    /**
     * Checks whether vertical jumps are valid.
     * Checks if pos2 is within the boundries of the board array
     * 
     * @param   pos2    starting final of piece
     * @return          if its a valid vertical jump or not
     */
    private boolean checkJumpVer(int pos2) {
    	if (pos2 > 24 || pos2 < 0) {
    		return false;
    	} else {
    		return true;
    	}
    }

    /**
     * Checks whether diagonal jumps are valid.
     * Uses both horizontal and vertical validators to check if the 
     * move is diagonally valid
     * 
     * @param   pos1    starting position of piece
     * @param   pos2    starting final of piece
     * @param   posDif  the difference between pos1 and pos2
     * @return          if its a valid diagonal jump or not
     */
    private boolean checkJumpDiag(int pos1, int pos2, int posDif) {
    	if (pos1 % 2 == 0) {
    	    if (posDif<0 && checkJumpHor(pos1, posDif+10) && checkJumpVer(pos2)) {
    		    return true;
    		}
    		else if (posDif>0 && checkJumpHor(pos1, posDif-10) && checkJumpVer(pos2)) {
    		    return true;
    		}
    		return false;
    	} else {
    		return false;
    	}
    }
}
