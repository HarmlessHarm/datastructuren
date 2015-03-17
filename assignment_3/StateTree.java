import java.util.*;
import java.io.*;

public class StateTree {

    private static int DEPTH = 4;
    public static int[] neighbours = {-1, 1,-4, 4, -5, 5, -6, 6};
    public static int weightNearLamb = 5;
    public static int weightLamb = 400;

    /* Recursive method to build a tree and choose the best path while doing so */
    private static MoveScore buildLionTree(Agent[] board, int currentDepth) {

        ArrayList<int[]> moves = new ArrayList<int[]>();
        ArrayList<int[]> tempMoves = new ArrayList<int[]>();
        int[] testMove = {24,23};
        MoveScore bestMoveScoreLion = new MoveScore(testMove, 10000000);
        
        
        /* Lion's turn */
        for (int i=0; i<board.length; i++) {
            if ( board[i] != null && board[i].getClass().equals(Lion.class) ) {
                tempMoves = getPossibleLionMoves(board, i);                     // returns ArrayList with all possible moves a Lion on board[i]
                for (int j=0; j < tempMoves.size(); j++) {
                    moves.add(tempMoves.get(j));                                // Adds all possible moves for Lion to moves ArrayList moves
                }
            }
        }
        for (int k=0; k < moves.size(); k++) {
            
            /* new insight minimax implementation */
            int[] move = moves.get(k);
            Agent[] newBoard = new Agent[25];
            newBoard = newBoard(board, move);
            MoveScore lambMoveScore = new MoveScore();
            

            if (currentDepth != 0 || (currentDepth == 0 && !knownBoard(newBoard))) {
                /* If max depth hasn't been reached yet, do another layer of recursion */
                if (currentDepth != DEPTH) {
                    currentDepth++;

                    lambMoveScore = buildLambTree(newBoard, currentDepth);
                    currentDepth--;

                }
                if (currentDepth == DEPTH) {
                    int score = evaluate(newBoard);
                    lambMoveScore.setScore(score);
                    lambMoveScore.setMove(move);
                }
                if (lambMoveScore.getScore() > 0 && lambMoveScore.getScore() < bestMoveScoreLion.getScore()) {
                    bestMoveScoreLion.setScore(lambMoveScore.getScore());
                    bestMoveScoreLion.setMove(move);
                }
                if (lambMoveScore.getScore() == bestMoveScoreLion.getScore()) {
                    if (randBool()) {
                        bestMoveScoreLion.setScore(lambMoveScore.getScore());
                        bestMoveScoreLion.setMove(move);
                    }
                }
            }
            
            /* If the max depth has been reached, you want to compare the scores at one level and send back the lowest score
             * as the lions will certainly do the best move, which results in the lowest score for them.
             */                
                        
            /* This will return the lowest score at the lions level. */    
        }
        /* The lowest score will be returned after the entire for loop has been finished. This will be the lamb score for that level. */    
        return bestMoveScoreLion;
    }

    private static MoveScore buildLambTree(Agent[] board, int currentDepth) {

        ArrayList<int[]> moves = new ArrayList<int[]>();
        ArrayList<int[]> tempMoves = new ArrayList<int[]>();
        MoveScore bestMoveScoreLamb = new MoveScore();


        Agent[] oldBoard = new Agent[25];

        if (LionsLambs.LAMB_COUNT != 0) {
            tempMoves = getPossibleLambMoves(board, 0);
            for (int k=0;k < tempMoves.size() ;k++ ) {
                moves.add(tempMoves.get(k));
            }
        }
        
        if (LionsLambs.LAMB_COUNT == 0) {
            for (int i=0; i<board.length; i++) {
                if (board[i] != null && board[i].getClass().equals(Lamb.class)) {
                    tempMoves = getPossibleLambMoves(board, i);        // returns ArrayList with all possible moves a Lamb on board[i]
                    for (int j=0; j < tempMoves.size(); j++) {
                        moves.add(tempMoves.get(j));                   // Adds all possible moves for Lamb to moves ArrayList moves
                    }
                }
            }
        }
        
        /* New minimax algorithm insight */
        for (int k=0; k < moves.size(); k++) {
            int[] move = moves.get(k);
            Agent[] newBoard = new Agent[25];
            newBoard = newBoard(board, move);
            MoveScore lionMoveScore = new MoveScore();
            if (currentDepth != 0 || (currentDepth == 0 && !knownBoard(newBoard))) {
                
                /* If the maximum layer of recursion hasn't been reached yet, do another layer of recursion */
                if (currentDepth != DEPTH) {
                    currentDepth++;
                    lionMoveScore = buildLionTree(newBoard, currentDepth); // here it starts the recursion
                    currentDepth--;
                }
                if (currentDepth == DEPTH) {
                    int score = evaluate(newBoard);
                    lionMoveScore.setScore(score);
                    lionMoveScore.setMove(move);
                }
                
                /* If the maximum layer has been reached, we want to return the highest score, as that is the best move for the lambs */
                if (lionMoveScore.getScore() > bestMoveScoreLamb.getScore()) {
                    bestMoveScoreLamb.setScore(lionMoveScore.getScore());
                    bestMoveScoreLamb.setMove(move);
                }
                if (lionMoveScore.getScore() == bestMoveScoreLamb.getScore()) {
                    if (randBool()) {
                        bestMoveScoreLamb.setScore(lionMoveScore.getScore());
                        bestMoveScoreLamb.setMove(move);
                    }
                }
            }
        }
        if (bestMoveScoreLamb.getScore() == -1 && currentDepth == 0) {
            System.out.println("");
            System.out.println("CHECKMATE, Lions win!");
            System.exit(0);
            // bestMoveScoreLamb.setMove(moves.get(0));
        }

        /* The move with the highest score will be returned */
        return bestMoveScoreLamb;
    }
    
    /* Checks all possible moves for a player -- STILL TO BE WRITTEN */
    public static ArrayList<int[]> getPossibleLionMoves(Agent[] board, int i) {
        ArrayList<int[]> possibleMoves = new ArrayList<int[]>();

        for (int j=0; j<board.length; j++) {

            if (Agent.validate(board, i, j, -1)) {
           
                int[] newMove = {i, j};
                possibleMoves.add(newMove);
            }
        }
        return possibleMoves;
    }
    
    private static ArrayList<int[]> getPossibleLambMoves(Agent[] board, int i) {
        ArrayList<int[]> possibleMoves = new ArrayList<int[]>();
        if (LionsLambs.LAMB_COUNT != 0) {
            for (int j=0;j < board.length ;j++ ) {
                if(Agent.validate(board,j,9001,1)){
                    int[] newMove = {j, 9001};
                    possibleMoves.add(newMove);
                }
            }
        }
        if(LionsLambs.LAMB_COUNT == 0) {
            for (int k=0;k < board.length ;k++ ) {
                if(Agent.validate(board,i, k, 1)){
                    int[] newMove = {i,k};
                    possibleMoves.add(newMove);
                }
            }
        }
        return possibleMoves;
    }
    
    /* Simulates a move and returns the board after doing the move */
    private static Agent[] newBoard(Agent[] board, int[] move) {
        int pos1 = move[0];
        int pos2 = move[1];
        Agent[] newBoard = new Agent[25];
        for (int i = 0; i < board.length; i++) {
            newBoard[i] = board[i];
        }
        int[] jumps = {-2, 2,-8, 8, -10, 10, -12, 12};
        int posDiff = pos2 - pos1;
        if (pos2 > 9000) {
            newBoard[pos1] =  new Lamb("name");
        } else {
            newBoard[pos2] = newBoard[pos1];
            newBoard[pos1] = null;
        } 
        // checks of the move that was done was a kill move and removes the lamb
        for (int i=0;i < jumps.length ; i++) {
            if (posDiff == jumps[i]) {
                int target = pos1 + (pos2 - pos1)/2;
                newBoard[target] = null;
            }
        }
        return newBoard;
    }
    
    /**
     * Computes a score for this board. Score gets lower the better the board
     * for the lions.
     *
     * Compares to boards and returns the best 
     * @param   board   board array
     * @return  score   board score
     *
     */
    private static int evaluate(Agent[] board) {

        double numberValidMoves = 0;
        ArrayList<int[]> possibleMoves;
        int totalLambs = 0;        
        int g = 3;
        
        
        /* Compute total number of Lambs 
         *Compute total score of the board. null=1, Lamb=3, Lion=7
         */
        for (int i=0; i<board.length; i++) {
            if (board[i] != null && board[i].getClass().equals(Lamb.class)) {
                totalLambs++;
            }
            if (board[i] != null && board[i].getClass().equals(Lion.class)) {
                possibleMoves = getPossibleLionMoves(board, i);
                numberValidMoves += Math.pow(g, (8-possibleMoves.size()));
            }
        }

        
        /* Compute and count number of valid moves */
        double lambScore = totalLambs * weightLamb;
		int score = (int)numberValidMoves + (int)lambScore;
		return score;       
    }

    /**
     * Gives a string array that is unique for every board state. 
     * Returns true if a scoreHistory array contains this score.
     *
     * @param   newBoard    board array
     * @return  boolean     whether board is known or not 
     *   
     */
    private static boolean knownBoard(Agent[] newBoard) {
        System.out.print(".");
        ArrayList<String> scoreHistory = LionsLambs.scoreHistory;

        String totalScore = "";

        /* Compute the score of the board */
        for (int k=0; k<newBoard.length; k++) {
            if (newBoard[k] != null && newBoard[k].getClass().equals(Lamb.class)) {
                totalScore = totalScore + "3";
                
            }
            if (newBoard[k] != null && newBoard[k].getClass().equals(Lion.class)) {
                totalScore = totalScore + "7";
            }
            if(newBoard[k] == null ) {
                totalScore = totalScore + "1";
            }
        }
        
        for (int i=0; i<scoreHistory.size(); i++) {
            if (totalScore.equals(scoreHistory.get(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns random int
     *
     * @return  Math.random()   random integer smaller than 5
    */
    private static boolean randBool() {
        return Math.random() < 0.5;
    }

    /**
     * Sets depth depending on what user enters. Gives warning is depth is very high.
     * @param   depth   depth chosen by player     
    */
    public static void setDepth(int depth) {
        DEPTH = depth;
        if (DEPTH > 4) {
            System.out.println("WARNING! it might take a while for each move to be calculated!");
        }
    }

    /**
    * Return best move for the AI. Starts lion tree of lamb tree depending on the turn.
    * 
    * @param    board   the board Array
    * @return           the best move score found in the tree
    */
    public static int[] getBestMove(Agent[] board) {
        if (LionsLambs.TURN == -1) {
            return buildLionTree(board, 0).getMove();
        }
        else {
            int[] move = buildLambTree(board, 0).getMove(); 
            return move;
        }
    }
}
