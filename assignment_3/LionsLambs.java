import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class LionsLambs extends GraphicsProgram {
	
	public static Agent[] board = new Agent[25];

	public static void init() {
		board[0] = new Lion("Leo");
		board[4] = new Lion("Leu");
		board[20] = new Lion("Love");
		board[24] = new Lion("Lejon");
	}

	public static void main() {
		drawCanvas();
	}
}
