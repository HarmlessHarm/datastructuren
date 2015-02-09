/*
 * File: Assignment1.java
 * Collaborators: Maartje ter Hoeve, Harm Manders
 * Course: Datastructuren KI 2015
 */

import java.util.*;
import java.lang.*;


/*
 * Queue timer class
 */
public class QueueTimer extends CollectionTimer {
    
    private Queue<Integer> queue;

    private QueueTimer(Queue<Integer> queue) {
        super();
        this.queue = queue;
    	/*
    	 * Constructor that creates a QueueTimer instance for the given queue.
    	 */
    }

    public QueueTimer(Queue<Integer> queue, long elemGenSeed) {
        super(elemGenSeed);
        this.queue = queue;
    	/*
    	 * Constructor that creates a QueueTimer instance for the given queue that
    	 * will populate it with data generated using the specified seed.
    	 */
    }

    public QueueTimer(Queue<Integer> queue, Long elemGenSeed) {
        super(elemGenSeed);
        this.queue = queue;
        /*
    	 * Constructor that creates a QueueTimer instance for the
    	 * given queue that will populate it with data generated using the specified seed.
    	 */
    }

    /*
     * Methods
     */

    public void addElement(Integer elem) {

        queue.add(elem);
    	/*
    	 * Adds an Integer object to the queue.
    	 */
    }

    public void removeElement() {

        queue.remove();
    	/*
    	 * Removes an object from the queue.
    	 */
    }   

    public int getSize() {

        return queue.size();
    	/*
    	 * Returns the size of the queue.
    	 */
    }

    public boolean isEmpty() {

        if( getSize() == 0) {
            return true;
        }
        else {
            return false;
        }
    	/*
    	 * Tells whether the queue is empty.
    	 */
    }

}
