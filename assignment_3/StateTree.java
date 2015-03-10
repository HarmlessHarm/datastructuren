import java.util.*;
import java.io.*;
import java.lang.*;

public class StateTree {

    private static final int DEPTH = 1; // Gets depth   


    // private static int[] bestMove;

    /* Recursive method to build a tree and choose the best path while doing so */
    private MoveScore buildLionTree(Agent[] board, int currentDepth) {
    
        //init vars;
        ArrayList<int[]> moves = new ArrayList<int[]>();
        ArrayList<int[]> tempMoves = new ArrayList<int[]>();
        MoveScore bestMoveScore = new MoveScore();
        Agent[] newBoard;
        
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
                move = moves.get(k);
                newBoard = newBoard(board, move);
                score = evaluate(newBoard);
                MoveScore moveScore = new MoveScore(move, score);

                if (currentDepth != DEPTH) {
                    currentDepth++;
                    lambMoveScore = buildLambTree(newBoard, currentDepth);
                    currentDepth--;
                }
                if (lambMoveScore.getScore() > moveScore.getScore()) {
                    moveScore.setScore(lambMoveScore.getScore());
                }
                if (moveScore.getScore() < bestMoveScore.getScore()) {
                    bestMoveScore.setScore(moveScore.getScore());
                }
            }
        
        return bestMoveScore;  
        
    }

    private MoveScore buildLambTree(Agent[] board, int currentDepth) {
    
        //init vars;
        ArrayList<int[]> moves = new ArrayList<int[]>();
        ArrayList<int[]> tempMoves = new ArrayList<int[]>();
        MoveScore bestMoveScore = new MoveScore();
        Agent[] newBoard;
        
        for (int i=0; i<board.length; i++) {
            if ( board[i] != null && board[i].getClass().equals(Lamb.class) ) {
                tempMoves = getPossibleLambMoves(board, i);                     // returns ArrayList with all possible moves a Lamb on board[i]
                for (int j=0; j < tempMoves.size(); j++) {
                    moves.add(tempMoves.get(j));                            // Adds all possible moves for Lamb to moves ArrayList moves
                }
            }
        }

        for (int k=0; k < moves.size(); k++) {
            move = moves.get(k);
            newBoard = newBoard(board, move);
            score = evaluate(newBoard);
            MoveScore moveScore = new MoveScore(move, score);

            if (currentDepth != DEPTH) {
                currentDepth++;
                lionMoveScore = buildLionTree(newBoard, currentDepth);
                currentDepth--;
            }
            if (lionMoveScore.getScore() > moveScore.getScore()) {
                moveScore.setScore(lionMoveScore.getScore());
            }
            if (moveScore.getScore() > bestMoveScore.getScore()) {
                bestMoveScore.setScore(moveScore.getScore());
            }
        }
    
        return bestMoveScore;
    }
    
    /* Checks all possible moves for a player -- STILL TO BE WRITTEN */
    private ArrayList<int[]> getPossibleLionMoves(Agent[] board, int boardPos) {
        ArrayList<int[]> possibleMoves = new ArrayList<int[]>();
        int[] move1 = {0,1};
        possibleMoves.add(move1);
        return possibleMoves;
    }

    private ArrayList<int[]> getPossibleLambMoves(Agent[] board, int boardPos) {
        ArrayList<int[]> possibleMoves = new ArrayList<int[]>();
        int[] move1 = {12,9001};
        possibleMoves.add(move1);
        return possibleMoves;
    }
    
    /* Simulates a move and returns the board after doing the move */
    private Agent[] newBoard(Agent[] board, int[] move) {
        return board;
    }
    
    /* Compares to boards and returns the best */
    private int evaluate(Agent[] board) {
        return 20;
    }

    public int[] getBestMove(Agent[] board) {
        return buildLionTree(board, 0);
    }
}
