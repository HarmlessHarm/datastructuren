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
        /* Constructor that creates a ListTimer instace for the given list that
        will populate it with data generated using the specified seed. */
    }
    
    public ListTimer(List<Integer> list, java.lang.Long elemGenSee) {
        /* Constructor that creates a ListTimer instance for the given list that
        will populate it with data generated usig the specfied seed. */
        
        /* DIFFERENCE?? */
    }
    
    public void addElement(Integer elem) {
        // System.out.println(elem);
        // System.out.println(list);
        list.add(elem);
        /* Adds an Integer to the object list */
    }
    
    public void removeElement() {
        /* Remoevs an object from the list */
        
        /* Throws: java.lang.IndexOutOfBoundsException if the list is empty
        java.lang.UnsupportedOperationException if the list does not support 
        removal of elements */
    }
    
    public int getSize() {
        /* Returns the size of the list */
        
        /* Returns: the size of the list */
        return 3;
   } 
   
   public boolean isEmpty() {
        /* Tells whether the list is empty */
        
        /* Returns: true if the list is empty, false otherwise */
        return true;
   }
}
