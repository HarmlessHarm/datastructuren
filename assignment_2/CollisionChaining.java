import java.util.*;
import java.io.*;

public class CollisionChaining {
    
    private String key;
    private String value;
    private CollisionChaining next;
    
    /* Constructor; new nodes are added at the end, so they shouldn't be able to refer to a next node */
    CollisionChaining(String key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
    
    /* Set method: A single linked list needs a reference to the next node in the list */
    public void setNext(CollisionChaining nextNode) {
        next = nextNode;
    }
    
    /* Get the next node in the single linked list (null if node is last node) */
    public CollisionChaining getNext() {
        return next;
    }
    
    public void setKey(String newKey) {
        key = newKey;
    }
    
    public String getKey() {
        return key;
    }
}
