import java.util.*;
import java.io.*;

/* Class to store moves and scores that belong to this move */

public class MoveScore {    
      
    int[] move;
    int score; 
    
    /* Standard constructor */   
    public MoveScore() {
        this.score = -1;
    }
    
    /* Constructor if move and score are given */
    public MoveScore(int[] move, int score) {
        this.move = move;
        this.score = score;
    }

    /* Sets score */
    public void setScore(int score) {
        this.score = score;
    }

    /* Gets score */
    public int getScore() {
        return score;   
    }
    
    /* Sets move */
    public void setMove(int[] move) {
        this.move = move;        
    }
    
    /* Gets score */
    public int[] getMove() {
        return move;
    }
}
