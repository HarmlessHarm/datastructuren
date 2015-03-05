public abstract class Agent {

    public String name;
    public int position;
    
    public Agent(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public abstract boolean specialMove(int pos1, int pos2) ;

  
    /*  */
    public boolean move(int pos1, int pos2) {        
        if (valid(pos1, pos2)) {
            position = pos2;
            return true;
        }
        else {
            return false;
        } 
    }
    
    /* Check whether asked moves are valid */
    private boolean valid(int pos1, int pos2) {        
        boolean status = false;
        int posDif = pos2 - pos1;
        // int[] jumpInts = {-12, -10, -8, -2, 2, 8, 10, 12};

        // if ( Arrays.asList(jumpInts).contains(posDif) ) {
        //     jump(pos );

        // }
               
        /* Move Horizontal */
        if (posDif == 1 || posDif == -1) {
            status = checkMoveHor(posDif, pos1); 
            return status;   
        }
        
        /* Move Vertical */
        if (posDif == 5 || posDif == -5) {
            status = checkMoveVer(pos1, pos2);
            return status;
        }
        
        /* Move Diagonal */
        if (posDif == -6 ||  posDif == 4 || posDif == 6 || posDif == -4) {
            status = checkMoveDiag(posDif, pos1);
            return status;
        } 
        return false;  
    }
    
    /* Checks whether move to the left is valid */
    private boolean checkMoveHor(int posDif, int pos1) {
        if ((posDif == 1 && pos1 + 1 % 5 == 0)||
            (posDif == -1 && pos1 % 5 == 0)) {
            return false;
        }
        else { 
            return true; 
        }
        
    }

    /* Checks whether a move down or upwards is valid */
    private boolean checkMoveVer(int pos1, int pos2) {
        if (pos2 > 24 || pos2 < 0) {
            return false;
        }
        else {
            return true;
        }
    }
    
    /* Checks whether a move upwards and to the left via the diagonal is valid */
    private boolean checkMoveDiag(int posDif, int pos1) {
        if (pos1 % 2 == 0 && 
            checkMoveHor(posDif, pos1) && checkMoveVer(posDif, pos1) ) {
            return true;
        }
        else {
            return false;
        }
    }
}
