public abstract class Agent {

    public Agent() {
        // Construstuctor
    }

    public abstract boolean jump(int pos1, int pos2, Agent[] board);
    
    /*  */
    public boolean move(int pos1, int pos2) {        
        if (valid(pos1, pos2)) {
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
               
        /* Move left */
        if (pos2 - pos1 == 1) {
            status = checkMoveRight(pos1, pos2); 
            return status;   
        }
        
        /* Move right */
        else if (pos1 - pos2 == 1) {
            status = checkMoveLeft(pos1, pos2);
            return status;
        } 
        
        /* Move up or down */
        else if (pos2 - pos1 == 5 || pos1 - pos2 == 5) {
            status = checkMoveUpDown(pos1, pos2);
            return status;
        }
        
        /* Move left up; via diagonal */
        else if (pos1 - pos2 == 6 ||  pos2 - pos1 == 4) {
            status = checkMoveLeftUpDown(pos1, pos2);
            return status;
        } 
        
        /* Move right up; via diagonal */
        else if (pos2 - pos1 == 6 || pos1 - pos2 == 4) {
            status = checkMoveRightUpDown(pos1, pos2);
            return status;
        }
        
        return false;  
    }
    
    /* Checks whether move to the left is valid */
    private boolean checkMoveLeft(int pos1, int pos2) { 
        if (pos1 == 0 || pos1 == 5 || pos1 == 10 || pos1 == 15 || pos1 == 20) {
            return false;
        }
        else {
            return true;
        } 
    }

    /* Checks whether move to the right is valid */
    private boolean checkMoveRight(int pos1, int pos2) {
        if (pos1 == 4 || pos1 == 9 || pos1 == 14 || pos1 == 19 || pos1 == 24) {
            return false; 
        }
        else {
            return true;
        }
    }        

    /* Checks whether a move down or upwards is valid */
    private boolean checkMoveUpDown(int pos1, int pos2) {
        if (pos2 > 24 || pos2 < 0) {
            return false;
        }
        else {
            return true;
        }
    }
    
    /* Checks whether a move upwards and to the left via the diagonal is valid */
    private boolean checkMoveLeftUpDown(int pos1, int pos2) {
        if (pos1 % 2 == 0) {
            if (checkMoveLeft(pos1, pos2)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    /* Checks whether a move upwards or downwards and to the right via the diagonal is valid */
    private boolean checkMoveRightUpDown(int pos1, int pos2) {
        if (pos1 % 2 == 0) {
            if (checkMoveRight(pos1, pos2)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    /* Checks whether a move upwards or downwards and to the left via the diagonal is valid */
    private boolean checkMoveLeftDown(int pos1, int pos2) {
         if (pos1 % 2 == 0) {
            if (checkMoveRight(pos1, pos2)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }    
    }    
}
