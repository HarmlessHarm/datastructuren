/*
 * File: HashTableOpen.java
 * Collaborators: Maartje ter Hoeve (10190015), Harm Manders (10677186)
 * Course: Datastructuren KI 2015
 *
 * Class to construct hash tables. Either of two hash strategies can be used, depending
 * on the user's command; collision chaining or linear probing.
 *
 */

import java.util.*;
import java.io.*;

/* Class to construct hashtables; either one with collision chaining or one with linear probing */
public class HashTableOpen {

    private CollisionChaining[] hashTableCollision;
    private Compressable function;
    private CollisionChaining currentListNode;
    private String[][] hashTableLinProb;
    private String returnKey;

    /* Constructor */
    HashTableOpen(int hash_size, Compressable function) {
        this.function = function;
        
        /* For the collision chaining */
        hashTableCollision = new CollisionChaining[hash_size]; 
        for (int i=0; i<hash_size; i++) {
            hashTableCollision[i] = null;
        }
        
        /* For the linear probing */
        hashTableLinProb = new String[hash_size][2];
    }
    
    /* Depending on the hash strategy the correct put method is selected */
    public void put(String key, String value, int hashStrategy) {    
        if (hashStrategy == 1) {
            putCollisionChaining(key, value);
        }
        else if (hashStrategy == 2) {
            putLinearProbing(key, value);
        }           
    }
    
    /* Puy key value pairs in hash table with collision chaining */
    public void putCollisionChaining(String key, String value) {        
        int index = function.calcIndex(key);             
        currentListNode = hashTableCollision[index];  
      
        if (currentListNode == null) {
            hashTableCollision[index] = new CollisionChaining(key, value);           
        }        
        else {            
            /* Loop over single linked list until you've reached the last node */
            while (currentListNode.getNext() != null) {
                if (!currentListNode.getKey().equals(key)) { // as then the key is already present, so no need to add anything
                    currentListNode = currentListNode.getNext();
                }
                else {
                    currentListNode.setKey(key);
                    break;
                } 
            }
            
            /* Once you've reached the end of the list, construct a new node at the end of the linked list */
            if (currentListNode.getNext() == null) {
                currentListNode.setNext(new CollisionChaining(key, value));
            }
        }
    }
    
    /* Put key value pairs in hash table (reprented as int[]), using linear probing */
    public void putLinearProbing(String key, String value) {
        int index = function.calcIndex(key);

        if (hashTableLinProb[index][0] == null ){
            hashTableLinProb[index][0] = key;
            hashTableLinProb[index][1] = value;
        }
        else {
            int tempI = index;
            while (hashTableLinProb[tempI][1] != null) {
                tempI++;
                if(tempI == hashTableLinProb.length) {
                    tempI = 0;
                }
                if(tempI == index) {
                    System.out.println("The array is full, use a larger hash_size");
                    System.exit(1);
                }
            }
            
            hashTableLinProb[tempI][0] = key;
            hashTableLinProb[tempI][1] = value;
        }
    }
    
    /* Choose the correct get method, depending on the hash strategy */
    public String get(String key, int hashStrategy) {       
        if (hashStrategy == 1) {
            returnKey = getCollisionChaining(key);
        }
        else if (hashStrategy == 2) {
            returnKey = getLinearProbing(key);
        }
        
        return returnKey;       
    }
    
    /* Search for key in hash table with collision chaining implementation */
    public String getCollisionChaining(String key) {    
        int index = function.calcIndex(key);        
        currentListNode = hashTableCollision[index];
        
        if (currentListNode == null) {
            return null;
        }        
 
        while (currentListNode.getNext() != null) {
            if (currentListNode.getKey().equals(key)) {
                return currentListNode.getKey();
            }
            else {
                currentListNode = currentListNode.getNext();
            }            
        }
        
        if (currentListNode.getNext() == null) {
            if (currentListNode.getKey().equals(key)) {
                return currentListNode.getKey();
            }
        }        
        
        return null;      
    }
    
    /* Search for key in hash table with linear probing implementation */
    public String getLinearProbing(String key) {
        int index = function.calcIndex(key);
        
        if (hashTableLinProb[index][0] == null) {
            return null;
        }
        
        if (!hashTableLinProb[index][0].equals(key)) {
            int tempI = index;
            while (!hashTableLinProb[tempI][0].equals(key)) {
                tempI++;
                if (hashTableLinProb[tempI][0] == null) {
                    return null;
                }
                if (tempI == hashTableLinProb.length) {
                    tempI = 0;
                }
                if (tempI == index) {
                    return null;
                }
            }
        }
        
        return "found";
    }
	
	/* Get size of hashtable (both used hashtables have same length) */
	public int size(int hashStrategy) {
        if( hashStrategy == 1) {
            return sizeCollisionChaining();
        }
        else if( hashStrategy ==2 ) {
            return sizeLinearProbing();
        }
        return 0;
	}

    private int sizeCollisionChaining() {
        int counter=0;
        for (int i=0;i<hashTableCollision.length ;i++ ) {
            if(hashTableCollision[i] != null) {
                CollisionChaining curNode = hashTableCollision[i];
                while(curNode.getNext() != null) {
                    curNode = curNode.getNext();
                    counter++;
                }
                counter++; //Last element correction
            }
        }
        return counter;
    }

    private int sizeLinearProbing() {
        int counter=0;
        for (int i=0;i<hashTableLinProb.length ;i++ ) {
            if(hashTableLinProb[i][0] == null) {
                counter++;
            }
        }
        return hashTableLinProb.length - counter;
    }

}
