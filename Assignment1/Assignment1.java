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

	public static void main(String[] args) {

        Assignment1 assignment = new Assignment1();
        assignment.benchmark();




		/*
		 * Main method of the program. Parses the command line options and initiates the benchmarking
		 * process according to the provided arguments. See the class description for an overview of
		 * the accepted paramers.
		 */
	}
}
