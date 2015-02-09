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
	    // Guess you will have to write all the methods anyway, as the type of constructor depends on whether
	    // a seed or mutations are given.
		ListTimer listTimer;
		QueueTimer queueTimer;

		for (List<Integer> l : lists ) {
			listTimer = new ListTimer(l, elemGenSeed); // gives a random generator with seed 500 as well
			System.out.println(l.getClass().getSimpleName());
			listTimer.time(mutations);
			// System.out.println(l);
		}

		for (Queue<Integer> q: queues) {
			queueTimer = new QueueTimer(q, elemGenSeed);
			System.out.println(q.getClass().getSimpleName());
			queueTimer.time(mutations);
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
        // ArrayList<Integer> mutations = new ArrayList<Integer>();
        
        Assignment1 assignment = new Assignment1();

        if (args.length == 0) {
            assignment.benchmark();
        }
        
        else if (args[0].equals("-s")) {
            if (args.length < 2) {
                System.out.println("Error: Please enter a seed.");
                return;
            }
            else {
                try {
                    elemGenSeed = Integer.parseInt(args[1]);                    
                }
                catch (NumberFormatException e) {
                    System.out.println("Error: Seed has to be of type integer.");
                    return;
                }
            }

            if (args.length == 2) {
                //elemGenSeed = Integer.parseInt(args[1]); //not very neat; twice this line
                assignment.benchmark(elemGenSeed);
            }
            else if (args.length > 2) {
                //int mutation;
            	int[] mutations = new int[args.length - 2];
            	for (int i = 2; i<args.length; i++ ) {
            		mutation = Integer.parseInt(args[i]);
            		mutations[i - 2] = mutation;
            	}
                assignment.benchmark(elemGenSeed, mutations);                
            }
        }
        
        else {
        	// System.out.println("HOI");
            //int mutation;
        	int[] mutations = new int[args.length];
        	for (int i = 0; i<args.length; i++ ) {
        		mutation = Integer.parseInt(args[i]);
        		mutations[i] = mutation;
        		// System.out.println(mutation);
        	}
            assignment.benchmark(0, mutations);



            // for (int i=0; i < args.length; i++) {                
            //     mutation = Integer.parseInt(args[i]);
            //     mutations.add(mutation);
            // }
            
            // int[] mutationsArray = new int[mutations.size()];
            // for (int j=0; j<mutations.size(); j++) {
            //     mutationsArray[j] = j;
            // }
                
            // assignment.benchmark(elemGenSeed, mutationsArray);
        }
        
        
        




		/*
		 * Main method of the program. Parses the command line options and initiates the benchmarking
		 * process according to the provided arguments. See the class description for an overview of
		 * the accepted paramers.
		 */
	}
}
