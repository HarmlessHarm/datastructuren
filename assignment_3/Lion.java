public class Lion extends Agent {

    private String name;

    public Lion(String name) {
        this.name = name;
    }
    
    // public boolean specialMove(int pos1, int pos2, Agent[] board) {
    //     if (valid(pos1, pos2, board)) {
    //         return true;
    //     }
    //     else {
    //         return false;
    //     }        
    // }
    
    private boolean valid(int pos1, int pos2, Agent[] board) {
        boolean status = false;
        if (pos2 - pos1 == 2) {
            status = checkJumpRight(pos1, pos2, board);
            return status;
        }
        
        else if (pos1 - pos2 == 2) {
            status = checkJumpLeft(pos1, pos2, board);
            return status;
        }
        
        else if (pos2 - pos1 == 10) {
            status = checkJumpDown(pos1, pos2, board);
            return status;
        }
        
        else if (pos1 - pos2 == 10) {
            status = checkJumpUp(pos1, pos2, board);
            return status;
        }
        
        else if (pos2 - pos1 == 13) {
            status = checkJumpRightDown(pos1, pos2, board);
            return status;
        }
        
        else if (pos1 - pos2 == 13) {
            status = checkJumpLeftUp(pos1, pos2, board);
            return status;
        }   
        
        else if (pos2 - pos1 == 8) {
            status = checkJumpLeftDown(pos1, pos2, board);
            return status;
        }
        
        else if (pos1 - pos2 == 8) {
            status = checkJumpRightUp(pos1, pos2, board);
            return status;
        }
        
        return false;
    }

    private boolean checkJumpRight(int pos1, int pos2, Agent[] board) {
        if (board[pos1 + 1] != null) { // check whether there's a lamb to jump over
            for (int i=3; i<24; i+=5) {
                if (pos1 == i) {
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
    
    private boolean checkJumpLeft(int pos1, int pos2, Agent[] board) {
        if (board[pos1 - 1] != null) {
            for (int i=1; i<24; i+=5) {
                if (pos1 == i) {
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
    
    private boolean checkJumpDown(int pos1, int pos2, Agent[] board) {
        if (board[pos1 + 5] != null) {
            if (pos2 > 24) {
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

    private boolean checkJumpUp(int pos1, int pos2, Agent[] board) {
        if (board[pos1 - 5] != null) {
            if (pos2 < 0) {
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
    
    private boolean checkJumpLeftUp(int pos1, int pos2, Agent[] board) {
        if (board[pos1 - 4] != null || pos1 % 2 == 0) {
            if (pos2 < 0 || pos1 == 13 || pos1 == 18 || pos1 ==  21) {
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

    private boolean checkJumpLeftDown(int pos1, int pos2, Agent[] board) {
        if (board[pos2 - 6] != null || pos1 % 2 == 0) {
            if (pos2 > 24 || pos1 == 1 || pos1 == 6 || pos1 == 11) {
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

    private boolean checkJumpRightUp(int pos1, int pos2, Agent[] board) {
        if (board[pos2 - 4] != null || pos1 % 2 == 0) {
            if (pos2 < 0 || pos1 == 23 || pos1 == 18 || pos1 == 13) {
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

    private boolean checkJumpRightDown(int pos1, int pos2, Agent[] board) {
        if (board[pos2 - 4] != null || pos1 % 2 == 0) {
            if (pos2 > 24 || pos1 == 3 || pos1 == 8 || pos1 == 13) {
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
