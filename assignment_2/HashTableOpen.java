import java.util.*;
import java.io.*;

public class HashTableOpen {

    private CollisionChaining[] table;
    private Compressable function;
    private CollisionChaining currentListNode;

    /* Constructor */
    HashTableOpen(int hash_size, Compressable function) {
        this.function = function;
        // standard value of new array is null?
        table = new CollisionChaining[hash_size]; //if you don't want table load factor to be 0, this should be different
    }
    
    /* Puts new node to existing or new single linked list (represented as collisionChaining object) */
    public void put (String key, String value) {
        System.out.println(key);
        int index = function.calcIndex(key);
        currentListNode = table[index];
        if (currentListNode == null) {
            currentListNode = new CollisionChaining(key, value);
            System.out.println("In hashtabe: " + currentListNode.getKey());
        }
        else {
            /* Loop over single linked list until you've reached the last node */
            while (currentListNode.getNext() != null) {
                if (!currentListNode.getKey().equals(key)) {
                    currentListNode = table[index].getNext();
                }
                else {
                    currentListNode.setKey(key);
                } //really needed? perhaps the methods just doesn't do anything otherwise, which would be sufficient as well
            }
            
            /* Once you've reached the end of the list, construct a new node at the end of the linked list */
            if (currentListNode.getNext() == null) {
                currentListNode.setNext(new CollisionChaining(key, value));
            }
        }
    }
    
    /* Loop through all list nodes, until the correct key has been found; return this one */
    public String get(String key) {
        int index = function.calcIndex(key);
        currentListNode = table[index];
        
        if (currentListNode.getNext() == null) { //null pointer exception
            if (currentListNode.getKey().equals(key)) {
                return currentListNode.getKey();
            }
        }
        
        while (currentListNode.getNext() != null) {
            if (currentListNode.getKey().equals(key)) {
                return currentListNode.getKey();
            }
        }
        
        return null; // something that says the key hasn't been found?            
    }

	/* // private int hash_size;
	private Compressable function;
	private String[][] table;

	HashTableOpen(int hash_size, Compressable function) {
		// this.hash_size = hash_size;
		this.function = function;
		table = new String[hash_size][2];
	}
	
	public void put(String key, String value) {
		int index = function.calcIndex(key);
		table[index][0] = key; //put key in first column array
		table[index][1] = value; //put value in second column array (value will be the placeholder a)
	}
	
	

	public String get(String key) {
		int index = function.calcIndex(key);
		//System.out.println(table[index][1]);
		//System.out.println("check");
		return table[index][0];
	} */

	public int size() {
		return table.length;
	}

}
