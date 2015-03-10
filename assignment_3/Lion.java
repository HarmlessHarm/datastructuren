public class Lion extends Agent {

    public static Agent target;

    public Lion(String name, int position) {

        this.name = name;
        this.position = position;

    }
    
    /* Method for the special moves: place lamb in game and lion jump */
    public boolean specialMove(int pos1, int pos2) {
        int posDif = pos2 - pos1;
        int posTar = posDif/2 + pos1;
        target = LionsLambs.board[posTar];
        // System.out.println("specMove tar@ "+posTar);
        //System.out.println(posDif);

        /* Check whether move is valid and whether lion jumps over lamb */
        if (target != null && valid(pos1, pos2, posDif) && target.getClass().equals(Lamb.class)) {
            LionsLambs.board[posTar] = null;
        	LionsLambs.LAMB_KILLED++;
        	//LionsLambs.lambs
            return true;
        }
        else {
            return false;
        }        
    }
    
    // public boolean validateAI(int pos1, int pos2) {
    //     int posDif = pos2 - pos1;

    //     if(pos2 >= 0 && pos2 < 25 && LionsLambs.board[pos2] == null && 
    //         valid(pos1, pos2, posDif)) {
    //         return true;
    //     }
    //     return false;
    // }

    /* Validates jumps */
    private boolean valid(int pos1, int pos2, int posDif) {
        boolean status = false;
        //System.out.println("validation");
        if (posDif == 2 || posDif == -2) {
            status = checkJumpHor(pos1, posDif);
            return status;
        }
        
        else if (posDif == 10 || posDif == -10) {
            status = checkJumpVer(pos2);
            return status;
        }
        
        else if (posDif == 12 || posDif == -12 || posDif == 8 || posDif == -8) {
            //System.out.println("checkDiag");
            status = checkJumpDiag(pos1, pos2, posDif);
            return status;
        }
        
        return status;
    }

    /* Checks whether horizontal jumps are valid */
    private boolean checkJumpHor(int pos1, int posDif) {
    	if ((posDif == 2 && pos1 % 5 < 3) || 
    		(posDif == -2 && pos1 % 5 > 1) ) {
    		//System.out.println("Horizontal move seen as valid");
    		return true;
    	} else {
    	    //System.out.println("Horizontal move seen as invalid");
    		return false;
    	}
    }

    /* Checks whether vertical moves are valid */
    private boolean checkJumpVer(int pos2) {
    	if (pos2 > 24 || pos2 < 0) {
    	    //System.out.println("Vertical move seen as invalid");
    		return false;
    	} else {
    	    //System.out.println("Vertical move seen as valid");
    		return true;
    	}
    }

    /* Checks whether diagonal moves are valid */
    private boolean checkJumpDiag(int pos1, int pos2, int posDif) {
    	if (pos1 % 2 == 0) {
    	    if (posDif<0 && checkJumpHor(pos1, posDif+10) && checkJumpVer(pos2)) {
    	        //System.out.println(" Diagonal seen as valid move");
    		    return true;
    		}
    		else if (posDif>0 && checkJumpHor(pos1, posDif-10) && checkJumpVer(pos2)) {
    	        //System.out.println(" Diagonal seen as valid move");
    		    return true;
    		}
    		return false;
    	} else {
    	    //System.out.println("Diagonal seen as invalid move");
    		return false;
    	}
    }
}
