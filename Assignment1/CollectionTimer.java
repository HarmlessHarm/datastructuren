/*
 * File: Assignment1.java
 * Collaborators: Maartje ter Hoeve, Harm Manders
 * Course: Datastructuren KI 2015
 */
 

import java.util.*;
import java.lang.*;
 

public abstract class CollectionTimer extends java.lang.Object {

    public static final int[] DEFEAULT_MUTATIONS = {3,4};
    private Random elemGen;
	
	public CollectionTimer() {
        /* Default constructor. Creates a CollectionTimer instance 
        in which the random object generator is instantiated with seed 0. */	
    }
    
    public CollectionTimer(long elemGenSeed) {
        /* Constructor that createsa CollectioTimer instance with a random
        object generator with the specified seed. */
    }
    
    public abstract void addElement(Integer elem);
        /* Adds the given object to the data structure */
    
    
    public abstract void removeElement();
        /* Removes some object from the data structure */
        
        /* Throws: java.lang.RuntimeException if no element can be removed from
        the underlying data structure */
    
    
    public abstract int getSize();
        /* Determines the size of the data structure that is being timed */
        
        /* Returns: the size of the data structure */
    
    
    public abstract boolean isEmpty();
        /* Tests whether the data structure that is being timed is empty. */
        
        /* Returns: true if the data structure is empty, false otherwise */
    
    
    public void insert(int amount) {
        /* Inserts a specified number of Integer objects into the data structure.
        This method assumes that the underlying data structure supports the
        insertion of the required number of objects. If such is not the case then
        (depending on the implementation), an exception may be thrown. */
    }
    
    public boolean extract(int amount) {
        /* Removes a specified number of objcts from the data structure */
        
        /* Returns: true if sufficient elements were present, false otheriwse */
        return true;
    }
    
    public long time() {
        /* Times a sequence of operations on the underlying data structure. This
        method performs mutations defined by DEFAULT_MUTATIONS. Timing takes
        place subtracting the number of milisecondssince the UNIX epoch before
        and after the required operations have taken place. Note that the actual
        accuracy is platform dependent and may be influenced by other processes
        running on the host machine. */
        
        /* Returns: elapsed time in milliseconds */
        return 3;
    }
    
    public long time(int[] mutations) {
        /* Times a specified sequence of operations on the underlying data 
        structure. This method performs the given operations in successive order,
        as they occur in the given array. Insertions are specified by a positive 
        number, removal of ojects are denoted by a negative value. If mutations 
        equalls null, then the default mutations as defined by DEFAULT_MUTATIONS
        are performed. Rest: see description above. */
        
        /* Returns: elapsed time in milliseconds */
        return 3;
    }
}
