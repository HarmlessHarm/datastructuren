import java.util.*;
import java.io.*;
import java.lang.*;

public class StateTree {

    private static final int DEPTH = 1;
    private int currentBranch;
    private int[] bestMove;
    private Agent[] bestBoard;

    private static ArrayList<ArrayList<int[]>> moveTree = new ArrayList<ArrayList<int[]>>();

    // private static int[] bestMove;

    /* Recursive method to build a tree and choose the best path while doing so */
    public int[] buildTree(Agent[] board, int turn, int currentDepth) {
    
        //int[] moves;
        ArrayList<int[]> moves = new ArrayList<int[]>();
        // ArrayList<ArrayList<Integer>> allMoves = new ArrayList<ArrayList<Integer>>();
        Map<Integer, ArrayList<ArrayList<Integer>>> movesHashmap = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        ArrayList<Integer> move = new ArrayList<Integer>();
        Agent[] newBoard;
        int[] bestMove = {0,1};
        
        /* Lion's turn */
        // if (turn == -1) {
            for (int i=0; i<board.length; i++) {
                if (board[i] != null &&
                    ((turn == -1 && board[i].getClass().equals(Lion.class)) ||
                     (turn == 1 && board[i].getClass().equals(Lamb.class)))) {
                    moves = getPossibleMoves(board, i); //moves will be overwritten, so you need to store the instances in an arrayList
                    for (int j=0; j < moves.size(); j++) {
                        moveTree.get(currentDepth).add(moves.get(j)); // Adds all possible moves from current branch to the corresponding depth in the tree 
                    }
                }
                if (currentDepth == 0) {
                    currentBranch = i;
                }
            }
            
            // movesHashmap.put(currentDepth, allMoves); // store all moves at a certain depth in a hashmap, so that you won't loose them
        
            /* Real recursive part */
            for (int k=0; k < allMoves.size(); k++) {
                movesAtDepth = moveTree.get(currentDepth);
                move = allMoves.get(k);
                newBoard = simulateMove(board, move);
                if (currentDepth != DEPTH) {
                    turn = -1;
                    currentDepth++;
                    buildTree(newBoard, turn, currentDepth);
                    currentDepth--;
                }
                Agent[] newBestBoard = compareBoards(newBoard, board);
                board = newBestBoard;
            }
        // }  
        
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
