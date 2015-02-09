/*
 * File: Assignment1.java
 * Collaborators: Maartje ter Hoeve, Harm Manders
 * Course: Datastructuren KI 2015
 *
 * Abstract class, that implements methods that are to be used by both
 * child classes; ListTimer.java and QueueTimer.java
 */
 

import java.util.*;
import java.lang.*;

public abstract class CollectionTimer extends java.lang.Object {

    public static final int[] DEFAULT_MUTATIONS = {10000, -10000};
    private Random elemGen;
	
	/* Creates a CollectionTimer instance in which the random object 
	 * generator is instantiated with seed 0. */
	public CollectionTimer() {
	    elemGen = new Random(0);
    }
    
    /* Creates a CollectioTimer instance with a random object generator 
     * with the specified seed. */
    public CollectionTimer(long elemGenSeed) {
        elemGen = new Random(elemGenSeed);
    }
    
    /* Adds the given object to the data structure */
    public abstract void addElement(Integer elem);        
    
    /* Removes some object from the data structure */    
    public abstract void removeElement();    
    
    /* Determines the size of the data structure that is being timed */
    public abstract int getSize();            
    
    /* Tests whether the data structure that is being timed is empty. */
    public abstract boolean isEmpty();        
    
    /* Inserts a specified number of Integer objects into the data structure. */
    public void insert(int amount) {
        for (int i=0; i<amount; i++) {
            addElement(elemGen.nextInt());
        }
    }
    
    /* Removes a specified number of objcts from the data structure */
    public boolean extract(int amount) {
        amount = amount * -1; 

        if (amount <= getSize()) {
            
            for (int i=0; i<amount;  i++) {
                    try {
                        removeElement();
                    }
                    catch (IndexOutOfBoundsException e) {
                        System.err.println("IndexOutOfBoundsException: " + e.getMessage());
                        return false;
                    }
                    catch (UnsupportedOperationException e) {
                        System.err.println("UnsupportedOperationException: " + e.getMessage());
                        return false;
                    }
                    catch (NoSuchElementException e) {
                        System.out.println("NoSuchElementException: "+ e.getMessage());
                        return false;
                    }
            }
            return true;
        }
        else {
            System.out.println("You tried to extract more elements then that there are present in your structure");
            return false;
        }
    }
    
    /* Times a sequence of operations on the underlying data structure, 
     * using the default mutations */
    public long time() {
        return time(DEFAULT_MUTATIONS);
    }
    
    /* Times a sequence of operations on the underlying data structure, 
     * using the given mutations */
    public long time(int[] mutations) {        
        long start = System.currentTimeMillis();
        
        for (int i=0; i<mutations.length; i++) {            
            if (mutations[i]<0) {
                extract(mutations[i]);
            }
            else if (mutations[i]>0) {
                insert(mutations[i]);
            }
        }
        
        long stop = System.currentTimeMillis();
        long diff = stop - start;
        System.out.println(" took "+diff+" milliseconds");
        return diff;

    }
}
