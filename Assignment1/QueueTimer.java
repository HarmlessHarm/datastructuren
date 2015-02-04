
import java.util.*;

/*
 * Queue timer class
 */
public class QueueTimer extends CollectionTimer {
    
    private Queue<Integer> queue;

    private QueueTimer(Queue<Integer> queue) {
    	/*
    	 * Constructor that creates a QueueTimer instance for the given queue.
    	 */
    }

    public QueueTimer(Queue<Integer> queue, long elemGenSeed) {
    	/*
    	 * Constructor that creates a QueueTimer instance for the given queue that
    	 * will populate it with data generated using the specified seed.
    	 */
    }

    public QueueTimer(Queue<Integer> queue, Long elemGenSeed) {
    	/*
    	 * Constructor that creates a QueueTimer instance for the
    	 * given queue that will populate it with data generated using the specified seed.
    	 */
    }

    /*
     * Methods
     */

    public void addElement(Integer elem) {
    	/*
    	 * Adds an Integer object to the queue.
    	 */
    }

    public void removeElement() {
    	/*
    	 * Removes an object from the queue.
    	 */
    }

    public int getSize() {
    	/*
    	 * Returns the size of the queue.
    	 */
    }

    public boolean isEmpty() {
    	/*
    	 * Tells whether the queue is empty.
    	 */
    }

}