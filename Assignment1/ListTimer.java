/*
 * File: Assignment1.java
 * Collaborators: Maartje ter Hoeve, Harm Manders
 * Course: Datastructuren KI 2015
 *
 * Class for all List mutations.
 */
 

import java.util.*;
import java.lang.*;

public class ListTimer extends CollectionTimer {

    private List<Integer> list;
    
    /* Constructor that creates a ListTimer instance for the given list */
    public ListTimer(List<Integer> list) {
        super();
        this.list = list;        
    }
    
    /* Constructor that creates a ListTimer instance for the given list, with
     * a given seed */
    public ListTimer (List<Integer> list, long elemGenSeed) {
        super(elemGenSeed);
        this.list = list;
    }
    
    /* Constructor that creates a ListTimer instance for the given list, with
     * a given seed */
    public ListTimer(List<Integer> list, java.lang.Long elemGenSeed) {
        super(elemGenSeed);
        this.list = list;
    }
    
    /* Adds an Integer to the object list */
    public void addElement(Integer elem) { 
        list.add(elem);        
    }
    
    /* Removes an object from the list */
    public void removeElement() throws IndexOutOfBoundsException, UnsupportedOperationException {
        int index = list.size() - 1; 
        list.remove(index);
    }
    
    /* Returns: the size of the list */
    public int getSize() {        
        return list.size();
    } 
   
    /* Tells whether the list is empty */
    public boolean isEmpty() {
        if (getSize() == 0) {
            return true;
        }
        else {
            return false;
        }
   }
}
