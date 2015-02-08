/*
 * File: Assignment1.java
 * Collaborators: Maartje ter Hoeve, Harm Manders
 * Course: Datastructuren KI 2015
 */
 
import java.util.*;
import java.lang.*;

 
/*
 * Main class
 */
public class Assignment1 extends java.lang.Object {

	/*
	 * Global variables 
	 */
	private ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
	private ArrayList<Queue<Integer>> queues = new ArrayList<Queue<Integer>>();


	public Assignment1() {
    
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedListList = new LinkedList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        Vector<Integer> vector = new Vector<Integer>();
        
        lists.add(arrayList);
        lists.add(linkedListList);
        lists.add(stack);
        lists.add(vector);
        
        LinkedList<Integer> linkedListQueue = new LinkedList<Integer>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        
        queues.add(linkedListQueue);
        queues.add(priorityQueue);

		
		/*
		 * Default constructor. Creates an empty instance of each of the data structures that are 
		 * to be benchmarked.
		 */
	}

	public void benchmark() {
		benchmark(0, CollectionTimer.DEFAULT_MUTATIONS);

		/*
		 * Performs benchmark with random seed 0 to populate the data structures and with mutations as in 
		 * CollectionTimer.DEFAULT_MUTATIONS. The result is printed to stdout.
		 */
	}

	public void benchmark(long elemGenSeed) {
		benchmark(elemGenSeed, CollectionTimer.DEFAULT_MUTATIONS);

		/*
		 * Performs benchmark with given seed to populate the data structures and with mutations as in 
		 * CollectionTimer.DEFAULT_MUTATIONS. The result is printed to stdout.
		 */
	}

	public void benchmark(long elemGenSeed, int[] mutations) {
		ListTimer listTimer;
		QueueTimer queueTimer;

		for (List<Integer> l : lists ) {
			listTimer = new ListTimer(l);
			listTimer.time();
			// System.out.println(l);
		}

		/*
		 * Performs benchmark by applying the specified mutations and using the given seed to
		 * populate the data structures. The result is printed to stdout.
		 */
	}

    /* Too much double code, still to be deleted */
	public static void main(String[] args) {
        
        long elemGenSeed = 0;
        int mutation;
        ArrayList<Integer> mutations = new ArrayList<Integer>();
        
        Assignment1 assignment = new Assignment1();

        if (args.length == 0) {
            assignment.benchmark();
        }
        
        else if (args[0].equals("-s")) {
            if (args.length < 2) {
                System.out.println("Error: Please enter a seed.");
            }
            else {
                try {
                    elemGenSeed = Integer.parseInt(args[1]);                    
                }
                catch (NumberFormatException e) {
                    System.out.println("Error: Seed has to be of type integer.");
                }
            }
            
            elemGenSeed = Integer.parseInt(args[1]); 
            
            if (args.length == 2) {
                //elemGenSeed = Integer.parseInt(args[1]); //not very neat; twice this line
                assignment.benchmark(elemGenSeed);
            }
            else if (args.length > 2) {
                //int mutation;
                for (int i = 2; i<args.length; i++) {
                    mutation = Integer.parseInt(args[i]);
                    mutations.add(mutation);
                }
                
                int[] mutationsArray = new int[mutations.size()];
                for (int j=0; j<mutations.size(); j++) {
                    mutationsArray[j] = j;
                }
                
                assignment.benchmark(elemGenSeed, mutationsArray);
            }
        }
        
        else {
            //int mutation;
            for (int i=0; i < args.length; i++) {                
                mutation = Integer.parseInt(args[i]);
                mutations.add(mutation);
            }
            
            int[] mutationsArray = new int[mutations.size()];
            for (int j=0; j<mutations.size(); j++) {
                mutationsArray[j] = j;
            }
                
            assignment.benchmark(elemGenSeed, mutationsArray);
        }
        
        
        




		/*
		 * Main method of the program. Parses the command line options and initiates the benchmarking
		 * process according to the provided arguments. See the class description for an overview of
		 * the accepted paramers.
		 */
	}
}
