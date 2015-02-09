/*
 * File: Assignment1.java
 * Collaborators: Maartje ter Hoeve, Harm Manders
 * Course: Datastructuren KI 2015
 */
 

import java.util.*;
import java.lang.*;
 

public abstract class CollectionTimer extends java.lang.Object {

    public static final int[] DEFAULT_MUTATIONS = {10000, -10000};
    private Random elemGen;
    private long elemGenSeed = 0;
	
	public CollectionTimer() {
        /* Default constructor. Creates a CollectionTimer instance 
        in which the random object generator is instantiated with seed 0. */	
    }
    
    public CollectionTimer(long elemGenSeed) {
        // this.elemGenSeed = elemGenSeed;
        // System.out.println(elemGenSeed);
        elemGen = new Random(elemGenSeed);
        
        /* Constructor that creates a CollectioTimer instance with a random
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
        // elemGen = new Random(seed);
        for (int i=0; i < amount; i++) {
            addElement(elemGen.nextInt());
            // System.out.println(elemGen.nextInt());
        }
        /* Inserts a specified number of Integer objects into the data structure.
        This method assumes that the underlying data structure supports the
        insertion of the required number of objects. If such is not the case then
        (depending on the implementation), an exception may be thrown. */
    }
    
    public boolean extract(int amount) {

        amount = amount * -1; // Makes the negative a mount to 

        for (int i=0; i < amount ;  i++) {
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
        }
        return true;


        /* Removes a specified number of objcts from the data structure */
        
        /* Returns: true if sufficient elements were present, false otheriwse */
        // return true;
    }
    
    public long time() {

        return time(DEFAULT_MUTATIONS);

        /* Times a sequence of operations on the underlying data structure. This
        method performs mutations defined by DEFAULT_MUTATIONS. Timing takes
        place subtracting the number of milisecondssince the UNIX epoch before
        and after the required operations have taken place. Note that the actual
        accuracy is platform dependent and may be influenced by other processes
        running on the host machine. */
        
        /* Returns: elapsed time in milliseconds */
        // return 3;
    }
    
    public long time(int[] mutations) {
        /* Times a specified sequence of operations on the underlying data 
        structure. This method performs the given operations in successive order,
        as they occur in the given array. Insertions are specified by a positive 
        number, removal of ojects are denoted by a negative value. If mutations 
        equalls null, then the default mutations as defined by DEFAULT_MUTATIONS
        are performed. Rest: see description above. */
        
        /* Returns: elapsed time in milliseconds */
        
        long start = System.currentTimeMillis();
        
        for (int i=0; i<mutations.length; i++) {

            // System.out.println(mutations[i]); // Mutations
            
            if (mutations[i]<0) {
                extract(mutations[i]);
            }
            else if (mutations[i]>0) {
                insert(mutations[i]);
            }
        }
        
        long stop = System.currentTimeMillis();
        long diff = stop - start;
        System.out.println("Took "+diff+" milliseconds");
        return diff;

    }
}
