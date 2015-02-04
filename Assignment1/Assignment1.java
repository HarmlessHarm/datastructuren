/*
 * File: Assignment1.java
 * Collaborators: Maartje ter Hoeve, Harm Manders
 * Course: Datastructuren KI 2015
 */
 
import java.util.*;
 
/*
 * Main class
 */
public class Assignment1 {

	/*
	 * Global variables 
	 */
	private ArrayList<List<Integer>> lists;
	private ArrayList<List<Integer>> queues;

	public Assignment1() {
		/*
		 * Default constructor. Creates an empty instance of each of the data structures that are 
		 * to be benchmarked.
		 */
	}

	public void benchmark() {
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
		/*
		 * Main method of the program. Parses the command line options and initiates the benchmarking
		 * process according to the provided arguments. See the class description for an overview of
		 * the accepted paramers.
		 */
	}
}
