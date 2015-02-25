public class Lion extends Agent {

    private String name;

    public static Agent target;

    public Lion(String name) {
        this.name = name;
    }
    
    public boolean specialMove(int pos1, int pos2) {
        int posDif = pos2 - pos1;
        int posTar = posDif/2 + pos1;
        target = LionsLambs.board[posTar];
        System.out.println(posDif);

        if (valid(pos1, pos2, posDif) && target.getClass().equals(Lamb.class)) {
            LionsLambs.board[posTar] = null;
        	LionsLambs.LAMB_COUNT--;
            return true;
        }
        else {
            return false;
        }        
    }
    
    private boolean valid(int pos1, int pos2,int posDif) {
        boolean status = false;
        System.out.println("validation");
        if (posDif == 2 || posDif == -2) {
            status = checkJumpHor(pos1, posDif);
            return status;
        }
        
        else if (posDif == 10 || posDif == -10) {
            status = checkJumpVer(pos2);
            return status;
        }
        
        else if (posDif == 12 || posDif == -12 || posDif == 8 || posDif == -8) {
            System.out.println("checkDiag");
            status = checkJumpDiag(pos1, pos2, posDif);
            return status;
        }
        
        return status;
    }

    private boolean checkJumpHor(int pos1, int posDif) {
    	if ((posDif == 2 && pos1 % 5 < 3) || 
    		(posDif == -2 && pos1 % 5 > 1) ) {
    		return true;
    	} else {
    		return false;
    	}
    }

    private boolean checkJumpVer(int pos2) {
    	if (pos2 > 24 || pos2 < 0) {
    		return false;
    	} else {
    		return true;
    	}
    }

    private boolean checkJumpDiag(int pos1, int pos2, int posDif) {
    	if (pos1 % 2 == 0 && checkJumpHor(pos1, posDif) && checkJumpVer(pos2)) {
    		return true;
    	} else {
    		return false;
    	}
    }
}
