/*
 * File: Assignment1.java
 * Collaborators: Maartje ter Hoeve, Harm Manders
 * Course: Datastructuren KI 2015
 *
 * Class for all Queue mutations.
 */

import java.util.*;
import java.lang.*;


/* Queue timer class */
public class QueueTimer extends CollectionTimer {
    
    private Queue<Integer> queue;

    /* Constructor that creates a QueueTimer instance for the given queue. */
    private QueueTimer(Queue<Integer> queue) {
        super();
        this.queue = queue;
    }

    /* Constructor that creates a QueueTimer instance for the given queue and 
     * specified seed */
    public QueueTimer(Queue<Integer> queue, long elemGenSeed) {
        super(elemGenSeed);
        this.queue = queue;
    }

    /* Constructor that creates a QueueTimer instance for the given queue and 
     * specified seed */
    public QueueTimer(Queue<Integer> queue, Long elemGenSeed) {
        super(elemGenSeed);
        this.queue = queue;
    }

    /* Adds an Integer object to the queue */
    public void addElement(Integer elem) {
        queue.add(elem);
    }

    /* Removes an object from the queue */
    public void removeElement() throws NoSuchElementException {
        queue.remove();
    }   

    /* Returns the size of the queue */
    public int getSize() {
        return queue.size();
    }

    /* Tells whether the queue is empty */
    public boolean isEmpty() {
        if (getSize() == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
