import java.util.*;
import java.io.*;

public class HashTableOpen {

    private CollisionChaining[] hashTableCollision;
    private Compressable function;
    private CollisionChaining currentListNode;
    private String[][] hashTableLinProb;
    private String returnKey;

    /* Constructor */
    HashTableOpen(int hash_size, Compressable function) {
        this.function = function;
        // default value of new array is null?
        hashTableCollision = new CollisionChaining[hash_size]; //if you don't want table load factor to be 0, this should be different
        for (int i=0; i<hash_size; i++) {
            hashTableCollision[i] = null;
        }
        // System.out.println("table: " + hashTableCollision.length);
        
        /* For the linear probing */
        hashTableLinProb = new String[hash_size][2];
        // System.out.println("linProb size: "+hashTableLinProb.length);
        // for (int i = 0; i<hash_size; i++) {
        //     hashTableLinProb[i][1] = null;
        //     // // System.out.println(hashTableLinProb[i]);
        // }
        // default value is null again?
    }
    
    /* Puts new node to existing or new shouldingle linked list (represented as collisionChaining object) */
    public void put(String key, String value, int hashStrategy) {
    
        if (hashStrategy == 1) {
            putCollisionChaining(key, value);
        }
        else if (hashStrategy == 2) {
            putLinearProbing(key, value);
        }           
    }
    
    public void putCollisionChaining(String key, String value) {
        // System.out.println(key);
        int index = function.calcIndex(key);
        // System.out.println("Index: " + index);
       
        currentListNode = hashTableCollision[index];
        // System.out.println("Current listnode: " + currentListNode);
        if (currentListNode == null) {
            currentListNode = new CollisionChaining(key, value);
            // System.out.println("In hashtable: " + currentListNode.getKey());
        }
        
        else {
            // System.out.println(" in else");
            /* Loop over single linked list until you've reached the last node */
            while (currentListNode.getNext() != null) {
                if (!currentListNode.getKey().equals(key)) {
                    currentListNode = hashTableCollision[index].getNext();
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
        
        // System.out.println("In hashtable2: " + hashTableCollision[3].getKey());
        
        
        //// System.out.println("Everything in hashtable");
    }
    
    /* Put key value pairs in hash table (reprented as int[]), using linear probing */
    public void putLinearProbing(String key, String value) {
        int index = function.calcIndex(key);
        // // System.out.println(key+"->"+index);

        if (hashTableLinProb[index][0] == null ){
            // System.out.println(key+"--->"+index);
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
                    // System.out.println("Hash table is full, increase your table size and try again");
                    System.exit(1);
                }
            }
            // System.out.println("looped: "+key+"--->"+tempI);
            hashTableLinProb[tempI][0] = key;
            hashTableLinProb[tempI][1] = value;
        }
    }
    
    /* Loop through all list nodes, until the correct key has been found; return this one */
    public String get(String key, int hashStrategy) {
        
        
        if (hashStrategy == 1) {
            returnKey = getCollisionChaining(key);
        }
        else if (hashStrategy == 2) {
            returnKey = getLinearProbing(key);
        }
        
        return returnKey;       
    }
    
    public String getCollisionChaining(String key) {
    
        int index = function.calcIndex(key);
        // System.out.println("Get: " + key);
        currentListNode = hashTableCollision[index];
        // System.out.println("In get: " + currentListNode.getKey());
        
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
    
    public String getLinearProbing(String key) {
        int index = function.calcIndex(key);
        // System.out.println("key: "+key+" index: "+index);
        // System.out.println("key@index: "+hashTableLinProb[index][0]);
        if( hashTableLinProb[index][0] == null ) {
            return null;
        }
        if (!hashTableLinProb[index][0].equals(key) ) {
            int tempI = index;
            // System.out.println(tempI);
            while ( !hashTableLinProb[tempI][0].equals(key) ) {
                tempI++;
                if( hashTableLinProb[tempI][0] == null ) {
                    return null;
                }
                if( tempI == hashTableLinProb.length ) {
                    tempI = 0;
                }
                if( tempI == index ) {
                    return null;
                }
            }
        }
        return "found";
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
		//// System.out.println(table[index][1]);
		//// System.out.println("check");
		return table[index][0];
	} */

	public int size() {
		return hashTableCollision.length;
	}

}
