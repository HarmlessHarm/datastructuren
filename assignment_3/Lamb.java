public class Lamb extends Agent {

    private String name;

    // public boolean specialMove(int pos1, int pos2, Agent[] board) {
    // 	return false;
    // }
    public boolean specialMove(int pos1, int pos2) {
    	return false;
    }

    public Lamb(String name) {
        this.name = name;
    }
    
    /* public boolean placeInGame(int position) {
        // Actually you only need to check whether a position is not empty,
        // and if this is not the case; add to array. But it's not very practical
        // to do that in a new class, so rather in main   
    } */
    
}
