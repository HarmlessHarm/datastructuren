/*
 * File: Division.java
 * Collaborators: Maartje ter Hoeve (10190015), Harm Manders (10677186)
 * Course: Datastructuren KI 2015
 *
 * Class in which the index in a hash table is being defined based on the hash function.
 *
 */

public class Division implements Compressable {
    int table_length;
    int initial = 11;
    int multiplier = 31;
    
    Division(int length) {
        table_length = length;
    }

    public int calcIndex(String key) {
        int index;

        index = Math.abs(hashCode(key)) % table_length;
        return index;
    }

    int hashCode(String key) {
        int h = initial;
        char[] val = key.toCharArray();
        int len = key.length();
   
        for (int i = 0; i < len; i++) {
            h = multiplier * h + val[i];
        }
        return h;
    }

}
