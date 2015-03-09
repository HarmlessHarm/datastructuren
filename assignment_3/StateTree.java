import java.util.*;
import java.io.*;
import java.lang.*;

public class StateTree {

    private int depth = 3;

    /* Recursive method to build a tree and choose the best path while doing so */
    public int[] buildTree(Agent[] board, int turn, int depth) {
    
        //int[] moves;
        ArrayList<ArrayList<Integer>> moves = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> allMoves = new ArrayList<ArrayList<Integer>>();
        Map<Integer, ArrayList<ArrayList<Integer>>> movesHashmap = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        ArrayList<Integer> move = new ArrayList<Integer>();
        Agent[] newBoard;
        int[] bestMove = {0,1};
        
        /* Lion's turn */
        if (turn == -1) {
            for (int i=0; i<board.length; i++) {
                if (board[i].getClass().equals(Lion.class)) {
                    moves = getPossibleMoves(board, i); //moves will be overwritten, so you need to store the instances in an arrayList
                    for (int j=0; i<moves.size(); j++) {
                        allMoves.add(moves.get(i));
                    }
                }
            }
            
            movesHashmap.put(depth, allMoves); // store all moves at a certain depth in a hashmap, so that you won't loose them
        
            /* Real recursive part */
            for (int k=0; k<allMoves.size(); k++) {
                move = allMoves.get(k);
                newBoard = simulateMove(board, move);
                if (depth != 0) {
                    turn = -1;
                    depth--;
                    buildTree(newBoard, turn, depth);
                }
                Agent[] newBestBoard = compareBoards(newBoard, board);
                board = newBestBoard;
            }
        
        }  
        
        return bestMove;  
        
    }
    
    /* Checks all possible moves for a player -- STILL TO BE WRITTEN */
    public ArrayList<ArrayList<Integer>> getPossibleMoves(Agent[] board, int boardPos) {
        ArrayList<Integer> move1 = new ArrayList<Integer>(); // so this is an arrayList which is not particularly handy
        move1.add(0);
        move1.add(1);
        ArrayList<ArrayList<Integer>> possibleMoves = new ArrayList<ArrayList<Integer>>();
        possibleMoves.add(move1);
        return possibleMoves;
    }
    
    /* Simulates a move and returns the board after doing the move */
    public Agent[] simulateMove(Agent[] board, List<Integer> move) {
        return board;
    }
    
    /* Compares to boards and returns the best */
    public Agent[] compareBoards(Agent[] newBoard, Agent[] board) {
        return newBoard;
    }

    public static void main(String[] args) {
    
    
    }

}
