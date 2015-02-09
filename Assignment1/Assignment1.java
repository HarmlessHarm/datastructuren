/*
 * File: Assignment1.java
 * Collaborators: Maartje ter Hoeve, Harm Manders
 * Course: Datastructuren KI 2015
 *
 * Class to benchmark data structures with interface List or Queue.
 *
 * How will the implementation of removeElement() affect the performance of the different ADTs?
 *
 * When we let the program add and remove a lot of elements the queues tend to get
 * slower than lists the more elements there are removed, we think this is due to the
 * fact that all elements have in the queue have move forward with each element removed.
 */
 
import java.util.*;
import java.lang.*;
 
/* Main class */
public class Assignment1 extends java.lang.Object {

	/* Global variables */
	private ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
	private ArrayList<Queue<Integer>> queues = new ArrayList<Queue<Integer>>();


    /* Constructor that creates an empty instance of each of the data structures 
     * to be benchmarked */
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
	}

    /* Performs benchmark with random seed 0 and default mutations */
	public void benchmark() {
		benchmark(0, CollectionTimer.DEFAULT_MUTATIONS);
	}

    /* Performs benchmark with given seed and default mutations */
	public void benchmark(long elemGenSeed) {
		benchmark(elemGenSeed, CollectionTimer.DEFAULT_MUTATIONS);
	}

    /* Performs benchmark with given seed and given mutations */
	public void benchmark(long elemGenSeed, int[] mutations) {
		ListTimer listTimer;
		QueueTimer queueTimer;

		System.out.println("Lists: ");
		for (List<Integer> l : lists ) {
			listTimer = new ListTimer(l, elemGenSeed);
			System.out.print(l.getClass().getSimpleName());
			listTimer.time(mutations);
		}

		System.out.println("Queues: ");
		for (Queue<Integer> q : queues) {
			queueTimer = new QueueTimer(q, elemGenSeed);
			System.out.print(q.getClass().getSimpleName());
			queueTimer.time(mutations);
		}
	}
	
	/* Checks whether given String is integer */
	private static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		}
		catch (NumberFormatException e) {
			System.out.println("You've used an invalid input; the result may not be adequate.");
			return false;
		}
		return true;
	}

    /* Parses the command line options and initiates the benchmarking
     * process according to the provided arguments */
	public static void main(String[] args) {
        long elemGenSeed = 0;
        int mutation;        
        Assignment1 assignment = new Assignment1();

        if (args.length == 0) {
            assignment.benchmark();
        }        
        else if (args[0].equals("-s")) {
            if (args.length < 2) {
                System.out.println("Error: Please enter a seed.");
                return;
            }
            else if (args.length == 2 && isInteger(args[1])) {
        		elemGenSeed = Integer.parseInt(args[1]);
            	assignment.benchmark(elemGenSeed);
        	}
            else if (args.length > 2) {
            	int[] mutations = new int[args.length - 2];
            	for (int i = 2; i<args.length; i++ ) {
            		if (isInteger(args[i])) {
	            		mutation = Integer.parseInt(args[i]);
	            		mutations[i - 2] = mutation;
            		}
            	}
                assignment.benchmark(elemGenSeed, mutations);                
            }
        }        
        else {
        	int[] mutations = new int[args.length];
        	for (int i = 0; i<args.length; i++ ) {
        		if (isInteger(args[i])) {
	        		mutation = Integer.parseInt(args[i]);
	        		mutations[i] = mutation;
        		}
        	}
            assignment.benchmark(0, mutations);
        }
    }
}
