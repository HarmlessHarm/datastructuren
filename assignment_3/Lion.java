public class Lion extends Agent {

    private String name;

    public Lion(String name) {
        this.name = name;
    }
    
    public boolean jump(int positionOne, int positionTwo, Agent[] board) {
        if (valid(positionOne, positionTwo, board)) {
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
            status = checkJumpDown(positionOne, positionTwo, board);
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
        if (board[positionOne + 1] != null) { // check whether there's a lamb to jump over
            for (int i=3; i<24; i+=5) {
                if (positionOne == i) {
                    return false;
                }
                else {
                    return true;
                }
            }
            return false; 
        }
        return false;
    }
    
    private boolean checkJumpLeft(int positionOne, int positionTwo, Agent[] board) {
        if (board[positionOne - 1] != null) {
            for (int i=1; i<24; i+=5) {
                if (positionOne == i) {
                    return false;
                }
                else {
                    return true;
                } 
            }
            return false;    
        }
        return false;
    }
    
    private boolean checkJumpDown(int positionOne, int positionTwo, Agent[] board) {
        if (board[positionOne + 5] != null) {
            if (positionTwo > 24) {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    private boolean checkJumpUp(int positionOne, int positionTwo, Agent[] board) {
        if (board[positionOne - 5] != null) {
            if (positionTwo < 0) {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }        
    }
    
    private boolean checkJumpLeftUp(int positionOne, int positionTwo, Agent[] board) {
        if (board[positionOne - 4] != null || positionOne % 2 == 0) {
            if (positionTwo < 0 || positionOne == 13 || positionOne == 18 || positionOne ==  21) {
                return false;
            }   
            else {
                return true;
            } 
        }
        else {
            return false;
        }
    }

    private boolean checkJumpLeftDown(int positionOne, int positionTwo, Agent[] board) {
        if (board[positionTwo - 6] != null || positionOne % 2 == 0) {
            if (positionTwo > 24 || positionOne == 1 || positionOne == 6 || positionOne == 11) {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    private boolean checkJumpRightUp(int positionOne, int positionTwo, Agent[] board) {
        if (board[positionTwo - 4] != null || positionOne % 2 == 0) {
            if (positionTwo < 0 || positionOne == 23 || positionOne == 18 || positionOne == 13) {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    private boolean checkJumpRightDown(int positionOne, int positionTwo, Agent[] board) {
        if (board[positionTwo - 4] != null || positionOne % 2 == 0) {
            if (positionTwo > 24 || positionOne == 3 || positionOne == 8 || positionOne == 13) {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    } 
}
