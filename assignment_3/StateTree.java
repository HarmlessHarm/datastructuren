import java.util.*;
import java.io.*;
import java.lang.*;

public class StateTree {

    private static final int DEPTH = 4; // Gets depth
    public static int[] neighbours = {-1, 1,-4, 4, -5, 5, -6, 6};
    public static int weightNearLamb = 5;
    public static int weightLamb = 400;


    // private static int[] bestMove;

    /* Recursive method to build a tree and choose the best path while doing so */
    private static MoveScore buildLionTree(Agent[] board, int currentDepth) {
    
       
        // System.out.println("BUILD LION TREE");
        //init vars;
        ArrayList<int[]> moves = new ArrayList<int[]>();
        ArrayList<int[]> tempMoves = new ArrayList<int[]>();
        int[] testMove = {24,23};
        MoveScore bestMoveScoreLion = new MoveScore(testMove, 10000000);
        
        
        /* Lion's turn */
        // if (turn == -1) {
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
            // int score = evaluate(newBoard);
            MoveScore lambMoveScore = new MoveScore();
            

            if (currentDepth != 0 || (currentDepth == 0 && !knownBoard(newBoard))) {
                // System.out.println(k+" found board?: "+knownBoard(newBoard));
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
                    // System.out.println("score: "+score+" move: "+move[0]+","+move[1]);
                }
                if (lambMoveScore.getScore() < bestMoveScoreLion.getScore()) {
                    // System.out.println("");
                    bestMoveScoreLion.setScore(lambMoveScore.getScore());
                    bestMoveScoreLion.setMove(move);
                }
            }
            
            /* If the max depth has been reached, you want to compare the scores at one level and send back the lowest score
             * as the lions will certainly do the best move, which results in the lowest score for them.
             */                
                        
            /* This will return the lowest score at the lions level. */    
        }
        
        /* The lowest score will be returned after the entire for loop has been finished. This will be the lamb score for that level. */    
        return bestMoveScoreLion;
            
            
            
                /*
                int[] move = moves.get(k);
                Agent[] newBoard = new Agent[25];
                newBoard = newBoard(board, move);
                int score = evaluate(newBoard);
                MoveScore moveScore = new MoveScore(move, score);
                MoveScore lambMoveScore = new MoveScore();
                //System.out.println(lambMoveScore.getScore());
                if (currentDepth != DEPTH) {
                    //MoveScore lambMoveScore = new MoveScore(); //added
                    currentDepth++;
                    lambMoveScore = buildLambTree(newBoard, currentDepth);
                    // System.out.println("OUT OF LAMB TREE");
                    currentDepth--;
                }
                if (lambMoveScore.getScore() > moveScore.getScore()) {
                    moveScore.setScore(lambMoveScore.getScore());
                    
                    if (currentDepth == 0) {
                       // System.out.println("BM: " +bestMoveScore.getScore());
                    }
                    //System.out.println("in if 1");
                }
                if (moveScore.getScore() < bestMoveScore.getScore()) {
                    bestMoveScore = moveScore;
                    //System.out.println("in if 2");
                   
                    // System.out.println("Score: "+moveScore.getScore());
                    //System.out.println("BM: "+bestMoveScore.getMove()[0]+" -> "+bestMoveScore.getMove()[1]);
                } */
                
                /*
                
                Op het niveau van de leeuwen moeten we 
                
                
            } 
            
            
        //System.out.println("BS: "+bestMoveScore.getScore() + " BM: "+bestMoveScore.getMove()[0]+" -> "+bestMoveScore.getMove()[1]);    
        return bestMoveScore; */
    }

    private static MoveScore buildLambTree(Agent[] board, int currentDepth) {

        // System.out.println("BUILD LAMB TREE");
        // init vars;
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
            // MoveScore moveScore = new MoveScore(move, score);
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
                    // System.out.println("BEST SCORE: "+ );
                    bestMoveScoreLamb.setScore(lionMoveScore.getScore());
                    bestMoveScoreLamb.setMove(move);
                }
            }
        }
        
        /* The move with the highest score will be returned */
        return bestMoveScoreLamb;
        
        
        

        /* for (int k=0; k < moves.size(); k++) {
            int[] move = moves.get(k);
            Agent[] newBoard = new Agent[25];
            newBoard = newBoard(board, move);
            int score = evaluate(newBoard);
            MoveScore moveScore = new MoveScore(move, score);
            MoveScore lionMoveScore = new MoveScore();
            if (currentDepth != DEPTH) {
                //MoveScore lionMoveScore = new MoveScore(); //added
                currentDepth++;
                lionMoveScore = buildLionTree(newBoard, currentDepth); // here it starts the recursion
                currentDepth--;
            }
            if (lionMoveScore.getScore() > moveScore.getScore()) {
                moveScore.setScore(lionMoveScore.getScore());
            }
            if (moveScore.getScore() > bestMoveScore.getScore()) {
                bestMoveScore = moveScore;
            }
        }
        return bestMoveScore; */
    }
    
    /* Checks all possible moves for a player -- STILL TO BE WRITTEN */
    public static ArrayList<int[]> getPossibleLionMoves(Agent[] board, int i) {
        ArrayList<int[]> possibleMoves = new ArrayList<int[]>();
        // newMove = new int[2];
        for (int j=0; j<board.length; j++) {            
            if (Agent.validate(board, i, j, -1)) {
           
                int[] newMove = {i, j};
               // System.out.println("valid: "+i+" -> "+j);
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
                    // System.out.println("place lamb@ "+j);
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
        // System.out.println("newBoard: "+pos1+" -> "+pos2);
        if (pos2 > 9000) {
            newBoard[pos1] =  new Lamb("name", pos1);
        } else {
            newBoard[pos2] = newBoard[pos1];
            newBoard[pos1] = null;
        } 
        // checks of the move that was done was a kill move and removes the lamb
        for (int i=0;i < jumps.length ; i++) {
            if (posDiff == jumps[i]) {
                // System.out.println("Jumpi");
                int target = pos1 + (pos2 - pos1)/2;
                newBoard[target] = null;
            }
        }
        // Board.drawBoard(board);
        return newBoard;
    }
    
    /* Compares to boards and returns the best */
    private static int evaluate(Agent[] board) {
        // int[] neighbours = {-6, -5, -4, -1, 1, 4, 5, 6};
        // int numberNearLambs = 0;
        double numberValidMoves = 0;
        ArrayList<int[]> possibleMoves;
        int totalLambs = 0;
        
        int g = 3;
        
        
        /* Compute total number of Lambs */ /*Compute total score of the board. null=1, Lamb=3, Lion=7*/
        for (int i=0; i<board.length; i++) {
            if (board[i] != null && board[i].getClass().equals(Lamb.class)) {
                totalLambs++;
            }
            if (board[i] != null && board[i].getClass().equals(Lion.class)) {
                possibleMoves = getPossibleLionMoves(board, i);
                numberValidMoves += Math.pow(g, (8-possibleMoves.size()));
                // System.out.println(numberValidMoves);
            }
        }

        
        /* Compute and count number of valid moves */
  //       for (int i=0; i<board.length; i++) {
        //     if (board[i] != null && board[i].getClass().equals(Lion.class)) {
        //         possibleMoves = getPossibleLionMoves(board, i);
        //         numberValidMoves += possibleMoves.size();
        //     }
        // }
		// double scoreValidMoves = Math.pow(g, (8-numberValidMoves));
        double lambScore = totalLambs * weightLamb;
		int score = (int)numberValidMoves + (int)lambScore;
		// System.out.println("mvsScore: "+numberValidMoves+" lambScore: "+lambScore+" totScore: "+score);
		/* Formula to compute score */
		return score;

        // if (knownBoard(totalScore, board)) {
        //     score = 999999;
        // }
		
        
        
        
        // /* Compute number of neighbouring lambs */
        // for (int i=0; i<board.length; i++) {
        //     if (board[i] != null && board[i].getClass().equals(Lion.class)) {
        //         for (int j=0; j<neighbours.length; j++) {
        //             if (i+j>0 && i+j<24 && board[i+j] != null && board[i+j].getClass().equals(Lamb.class)) {
        //                 numberNearLambs++;
        //             }
        //         }
        //     }            
        // }        
        
        // score = /*numberNearLambs*weightNearLamb + */totalLambs*weightLamb;
        

       
    }

    private static boolean knownBoard(Agent[] newBoard) {
        System.out.print(".");
        // ArrayList<Agent[]> boardHistory = LionsLambs.boardHistory;
        //ArrayList<Integer> scoreHistory = LionsLambs.scoreHistory;
        ArrayList<String> scoreHistory = LionsLambs.scoreHistory;

//        System.out.println("BH size: "+boardHistory.size());
//        System.out.println("SH size: "+boardHistory.size());

//        int totalScore = 0;

//        /* Compute the score of the board */
//        for (int k=0; k<newBoard.length; k++) {
//            if (newBoard[k] != null && newBoard[k].getClass().equals(Lamb.class)) {
//                totalScore += 3 * (k + 1);
//            }
//            if (newBoard[k] != null && newBoard[k].getClass().equals(Lion.class)) {
//                totalScore += 7 * (k + 1);
//            }
//            if(newBoard[k] == null ) {
//                totalScore += 1 * (k + 1);
//            }
//        }

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
                // System.out.println("TotalScore: "+totalScore+" i: "+i);
                return true;
            }
        }
        // System.out.println(status);
        return false;

//        for (int i=0; i<scoreHistory.size(); i++) {
//            if (totalScore == scoreHistory.get(i)) {
//                System.out.println("TotalScore: "+totalScore+" i: "+i);
//                
//                Agent[] oldBoard = new Agent[25];                
//                for (int l=0; l<25; l++) {
//                    oldBoard[l] = LionsLambs.boardHistory.get(i)[l]; //changed this
//                }
//                
//                System.out.println("Draw boards to check whether they're the same:");
//                Board.drawBoard(newBoard);
//                Board.drawBoard(oldBoard);
////                
//                for (int j=0; j<oldBoard.length; j++) {
//                    //System.out.println("oldBoard: "+oldBoard[j]+" newBoard: "+newBoard[j]);
//                    if (newBoard[j] != null && oldBoard[j] != null &&
//                        !newBoard[i].getClass().equals(oldBoard[j].getClass())) {
//                        System.out.println("lalala");
//                        // return false;
//                        break;
//                    }
//                    if (newBoard[j] == null && oldBoard[j] != null) {
//                        System.out.println("liiliili");
//                        // return false;
//                        break;
//                    }
//                    if (oldBoard[j] == null && newBoard[j] != null) {
//                        System.out.println("lululul  "+newBoard[j]);
//                        // return false;
//                        break;
//                    }
//                    System.out.println("return true;");
//                    return true;
//                }            

//                //return true;
//            }

//            return false;
//        }
//        return false;
    }

    public static int[] getBestMove(Agent[] board, String player) {
        // System.out.println("BS: "+buildLionTree(board, 0).getScore() + " BM: "+buildLionTree(board, 0).getMove()[0]+" -> "+buildLionTree(board, 0).getMove()[1]); 
        if (player.equals("lambs")) {
            return buildLionTree(board, 0).getMove();
        }
        else {
            return buildLambTree(board, 0).getMove();
        }
    }
}
