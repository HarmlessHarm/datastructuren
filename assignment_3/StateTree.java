import java.util.*;
import java.io.*;
import java.lang.*;

public class StateTree {

    private static final int DEPTH = 1; // Gets depth
    public static int[] neighbours = {-1, 1,-4, 4, -5, 5, -6, 6};


    // private static int[] bestMove;

    /* Recursive method to build a tree and choose the best path while doing so */
    private static MoveScore buildLionTree(Agent[] board, int currentDepth) {
    
        //init vars;
        ArrayList<int[]> moves = new ArrayList<int[]>();
        ArrayList<int[]> tempMoves = new ArrayList<int[]>();
        int[] testMove = {0,5};
        MoveScore bestMoveScore = new MoveScore(testMove, 100);
        Agent[] newLionBoard;
        
        /* Lion's turn */
        // if (turn == -1) {
            for (int i=0; i<board.length; i++) {
                if ( board[i] != null && board[i].getClass().equals(Lion.class) ) {
                    tempMoves = getPossibleLionMoves(board, i);                     // returns ArrayList with all possible moves a Lion on board[i]
                    for (int j=0; j < tempMoves.size(); j++) {
                        moves.add(tempMoves.get(j));                            // Adds all possible moves for Lion to moves ArrayList moves
                    }
                }
            }
            for (int k=0; k < moves.size(); k++) {
                int[] move = moves.get(k);
                Agent[] newBoard = newBoard(board, move);
                int score = evaluate(newBoard);
                MoveScore moveScore = new MoveScore(move, score);
                MoveScore lambMoveScore = new MoveScore();
                if (currentDepth != DEPTH) {
                    currentDepth++;
                    lambMoveScore = buildLambTree(newBoard, currentDepth);
                    currentDepth--;
                }
                if (lambMoveScore.getScore() > moveScore.getScore()) {
                    moveScore = lambMoveScore;
                }
                if (moveScore.getScore() < bestMoveScore.getScore()) {
                    System.out.println(moveScore.getScore());
                    bestMoveScore = moveScore;
                    System.out.println(bestMoveScore.getMove()[1]);
                }
            }
        return bestMoveScore;
    }

    private static MoveScore buildLambTree(Agent[] board, int currentDepth) {
    
        //init vars;
        ArrayList<int[]> moves = new ArrayList<int[]>();
        ArrayList<int[]> tempMoves = new ArrayList<int[]>();
        MoveScore bestMoveScore = new MoveScore();
        Agent[] newLambBoard;


        if (LionsLambs.LAMB_COUNT != 0) {
            System.out.println("lambcount != 0");
            tempMoves = getPossibleLambMoves(board, 0);
            for (int k=0;k < tempMoves.size() ;k++ ) {
                moves.add(tempMoves.get(k));
            }
        }
        if (LionsLambs.LAMB_COUNT == 0) {
            for (int i=0; i<board.length; i++) {
                if ( board[i] != null && board[i].getClass().equals(Lamb.class) ) {
                    tempMoves = getPossibleLambMoves(board, i);                     // returns ArrayList with all possible moves a Lamb on board[i]
                    for (int j=0; j < tempMoves.size(); j++) {
                        moves.add(tempMoves.get(j));                            // Adds all possible moves for Lamb to moves ArrayList moves
                    }
                }
            }
        }

        for (int k=0; k < moves.size(); k++) {
            int[] move = moves.get(k);
            Agent[] newBoard = newBoard(board, move);
            int score = evaluate(newBoard);
            MoveScore moveScore = new MoveScore(move, score);
            MoveScore lionMoveScore = new MoveScore();
            if (currentDepth != DEPTH) {
                currentDepth++;
                lionMoveScore = buildLionTree(newBoard, currentDepth);
                currentDepth--;
            }
            if (lionMoveScore.getScore() > moveScore.getScore()) {
                moveScore = lionMoveScore;
            }
            if (moveScore.getScore() > bestMoveScore.getScore()) {
                bestMoveScore = moveScore;
            }
        }
        return bestMoveScore;
    }
    
    /* Checks all possible moves for a player -- STILL TO BE WRITTEN */
    private static ArrayList<int[]> getPossibleLionMoves(Agent[] board, int i) {
        ArrayList<int[]> possibleMoves = new ArrayList<int[]>();
        // newMove = new int[2];
        for (int j=0;j < board.length ;j++ ) {
            if (Agent.validate(board, i, j, -1)) {
                int[] newMove = {i, j};
                System.out.println("valid: "+i+" -> "+j);
                possibleMoves.add(newMove);
            }
        }
        return possibleMoves;
    }
    private static ArrayList<int[]> getPossibleLambMoves(Agent[] board, int i) {
        ArrayList<int[]> possibleMoves = new ArrayList<int[]>();
        // int[] newMove = new int[2];
        if (LionsLambs.LAMB_COUNT != 0) {
            for (int j=0;j < board.length ;j++ ) {
                if(Agent.validate(board,j,9001,1)){
                    System.out.println("place lamb@ "+j);
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
        return board;
    }
    
    /* Compares to boards and returns the best */
    private static int evaluate(Agent[] board) {
        return 20;
    }

    public static int[] getBestMove(Agent[] board) {
        return buildLionTree(board, 0).getMove();
    }
}
