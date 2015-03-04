import java.io.*;
import java.util.*;

public class Leopold {

	public static Agent[] board = new Agent[25];
	public static Lion[] lions = new Lion[4];
	public static Lambs[] lambs;

	public static String[] yourTurnSir(Agent[] board, Lion[] lions, ArrayList<Lambs> lambs) {
		this.board = board;
		this.lions = lions; 	
		this.lambs = lambs.toArray(new Lambs[lambs.size()]);
		System.out.println(this.lambs.length);
	}
}