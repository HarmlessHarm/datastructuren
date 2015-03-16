import java.util.*;
import java.io.*;

public class MoveScore {    
      
    int[] move;
    int score; 
       
    public MoveScore() {
        //constructor
    }
    
    public MoveScore(int[] move, int score) {
        // second constructor
        this.move = move;
        this.score = score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;   
    }
    
    public void setMove(int[] move) {
        this.move = move;        
    }
    
    public int[] getMove() {
        return move;
    }

}
