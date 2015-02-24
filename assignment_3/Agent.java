public class Agent {

    public Agent() {
        // Construstuctor
    }
    
    /*  */
    public boolean move(int positionOne, int positionTwo) {        
        if (valid(positionOne, positionTwo)) {
            return true;
        }
        else {
            return false;
        } 
    }
    
    /* Check whether asked moves are valid */
    private boolean valid(int positionOne, int positionTwo) {        
        boolean status = false;
        
        /* New position empty? CHECK THIS BEFORE MOVE IS CALLED
        if (positionTwo != null) {
            return false;
        } */
        
        /* Move left */
        if (positionTwo - positionOne == 1) {
            status = checkMoveLeft(positionOne, positionTwo); 
            return status;   
        }
        
        /* Move right */
        else if (positionOne - positionTwo == 1) {
            status = checkMoveRight(positionOne, positionTwo);
            return status;
        } 
        
        /* Move up or down */
        else if (positionTwo - positionOne == 5 || positionOne - positionTwo == 5) {
            status = checkMoveUpDown(positionOne, positionTwo);
            return status;
        }
        
        /* Move left up; via diagonal */
        else if (positionOne - positionTwo == 6 ||  positionTwo - positionOne == 4) {
            status = checkMoveLeftUpDown(positionOne, positionTwo);
            return status;
        } 
        
        /* Move right up; via diagonal */
        else if (positionTwo - positionOne == 6 || positionOne - positionTwo == 4) {
            status = checkMoveRightUpDown(positionOne, positionTwo);
            return status;
        }
        
        return false;  
    }
    
    /* Checks whether move to the left is valid */
    private boolean checkMoveLeft(int positionOne, int positionTwo) { 
        if (20 % positionOne == 0) {
            return false;
        }
        else {
            return true;
        } 
    }

    /* Checks whether move to the right is valid */
    private boolean checkMoveRight(int positionOne, int positionTwo) {
        if (25 % (positionOne + 1) == 0) {
            return false; 
        }
        else {
            return true;
        }
    }        

    /* Checks whether a move down or upwards is valid */
    private boolean checkMoveUpDown(int positionOne, int positionTwo) {
        if (positionTwo > 24 || positionTwo < 0) {
            return false;
        }
        else {
            return true;
        }
    }
    
    /* Checks whether a move upwards and to the left via the diagonal is valid */
    private boolean checkMoveLeftUpDown(int positionOne, int positionTwo) {
        if (positionOne % 2 == 0) {
            if (checkMoveLeft(positionOne, positionTwo)) {
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
    private boolean checkMoveRightUpDown(int positionOne, int positionTwo) {
        if (positionOne % 2 == 0) {
            if (checkMoveRight(positionOne, positionTwo)) {
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
    private boolean checkMoveLeftDown(int positionOne, int positionTwo) {
         if (positionOne % 2 == 0) {
            if (checkMoveRight(positionOne, positionTwo)) {
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
