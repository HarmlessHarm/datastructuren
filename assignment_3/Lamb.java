/**
 * Lamb object class. 
 * Lamb can use all methods defined in Agent
 */
    
public class Lamb extends Agent {

    /* Lamb constructor */
    public Lamb(String name) {
        this.name = name;
    }
    
    /* Lambs cannot do special moves, so return false if asked */
    public boolean specialMove(int pos1, int pos2, Agent[] board) {
    	return false;
    }    
}
