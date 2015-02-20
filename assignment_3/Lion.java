public class Lion extends Agent {

    private String name;

    public Lion(String name) {
        this.name = name;
    }
    
    public boolean jump(int positionOne, int positionTwo, Agent[] board) {
        if (valid(positionOne, positionTwo, Agent[] board)) {
            return true;
        }
        else {
            return false;
        }        
    }
    
    private boolean valid(int positionOne, int positionTwo, Agent[] board) {
        boolean status = false;
        if (positionTwo - positionOne == 2) {
            status = checkJumpRight(positionOne, positionTwo, board);
            return status;
        }
        
        else if (positionOne - positionTwo == 2) {
            status = checkJumpLeft(positionOne, positionTwo, board);
            return status;
        }
        
        else if (positionTwo - positionOne == 10) {
            status = checkJumDown(positionOne, positionTwo, board);
            return status;
        }
        
        else if (positionOne - positionTwo == 10) {
            status = checkJumpUp(positionOne, positionTwo, board);
            return status;
        }
        
        else if (positionTwo - positionOne == 13) {
            status = checkJumpRightDown(positionOne, positionTwo, board);
            return status;
        }
        
        else if (positionOne - positionTwo == 13) {
            status = checkJumpLeftUp(positionOne, positionTwo, board);
            return status;
        }   
        
        else if (positionTwo - positionOne == 8) {
            status = checkJumpLeftDown(positionOne, positionTwo, board);
            return status;
        }
        
        else if (positionOne - positionTwo == 8) {
            status = checkJumpRightUp(positionOne, positionTwo, board);
            return status;
        }
        
        return false;
    }

    private boolean checkJumpRight(int positionOne, int positionTwo, Agent[] board) {
        if (board[positionOne + 1] != null) {
            
        }
        else {
            return false;
        }
    }
    

}
