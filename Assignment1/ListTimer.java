/*
 * File: Assignment1.java
 * Collaborators: Maartje ter Hoeve, Harm Manders
 * Course: Datastructuren KI 2015
 */
 

import java.util.*;
import java.lang.*;


public class ListTimer extends CollectionTimer {

    private List<Integer> list;
    
    public ListTimer(List<Integer> list) {
        this.list = list;
        /* Constructor that creates a ListTimer instance for the given list */
    }
    
    public ListTimer (List<Integer> list, long elemGenSeed) {
        this.list = list;
        super(elemGenSeed);
        /* Constructor that creates a ListTimer instance for the given list that
        will populate it with data generated using the specified seed. */
    }
    
    public ListTimer(List<Integer> list, java.lang.Long elemGenSeed) {
        /* Constructor that creates a ListTimer instance for the given list that
        will populate it with data generated usig the specfied seed. */
        
        /* DIFFERENCE?? */
    }
    
    public void addElement(Integer elem) {
 
        list.add(elem);
        /* Adds an Integer to the object list */
    }
    
    public void removeElement() throws IndexOutOfBoundsException, 
                                        UnsupportedOperationException {
        int size = getSize();
     
                int index = list.size() - 1; // Not so nice code to remove last element in list.
                list.remove(index);
            


        /* Removes an object from the list */
        
        /* Throws: java.lang.IndexOutOfBoundsException if the list is empty
        java.lang.UnsupportedOperationException if the list does not support 
        removal of elements */
    }
    
    public int getSize() {
        
        int size = list.size();
        
        /* Returns: the size of the list */
        return size;
   } 
   
   public boolean isEmpty() {
        /* Tells whether the list is empty */
        
        /* Returns: true if the list is empty, false otherwise */
        return true;
   }
}
