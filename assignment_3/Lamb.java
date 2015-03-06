public class Lamb extends Agent {

    private String name;
    private int pos1;

    // public boolean specialMove(int pos1, int pos2, Agent[] board) {
    // 	return false;
    // }
    
    public Lamb(String name, int pos1) {
        this.name = name;
        this.pos1 = pos1;
    }
    
    public boolean specialMove(int pos1, int pos2) {
    	return false;
    }


    /* Set position of lambs, needed to make them able to move around */
    public void setPosition(int pos1) {
        this.pos1 = pos1;
    }
    
    /* Get position of lambs */
    public int getPosition() {
        return pos1;
    }
    
    /* public boolean placeInGame(int position) {
        // Actually you only need to check whether a position is not empty,
        // and if this is not the case; add to array. But it's not very practical
        // to do that in a new class, so rather in main   
    } */
    
}
