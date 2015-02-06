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
public class Assignment1 {

	/*
	 * Global variables 
	 */
	private ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>;
	private ArrayList<Queues<Integer>> queues = new ArrayList<Queues<Integer>>;

	public Assignment1() {

		lists[0] = new ArrayList<Integer>;
		lists[1] = new LinkedList<Integer>;
		lists[2] = new Stack<Integer>;
		lists[3] = new Vector<Integer>;

		queues[0] = new LinkedList<Integer>;
		queues[1] = new PriorityQueue<Integer>;
		/*
		 * Default constructor. Creates an empty instance of each of the data structures that are 
		 * to be benchmarked.
		 */
	}

	public void benchmark() {
		ListTimer listTimer;

		for (List<Integer> i : lists ) {
			System.out.println(i);
			listTimer = new ListTimer(i);
		}
		/*
		 * Performs benchmark with random seed 0 to populate the data structures and with mutations as in 
		 * CollectionTimer.DEFAULT_MUTATIONS. The result is printed to stdout.
		 */
	}

	public void benchmark(long elemGenSeed) {
		/*
		 * Performs benchmark with given seed to populate the data structures and with mutations as in 
		 * CollectionTimer.DEFAULT_MUTATIONS. The result is printed to stdout.
		 */
	}

	public void benchmark(long elemGenSeed, int[] mutations) {
		/*
		 * Performs benchmark by applying the specified mutations and using the given seed to
		 * populate the data structures. The result is printed to stdout.
		 */
	}

	main(String[] args) {

		benchmark();



		/*
		 * Main method of the program. Parses the command line options and initiates the benchmarking
		 * process according to the provided arguments. See the class description for an overview of
		 * the accepted paramers.
		 */
	}
}
