import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class LionsLambs extends GraphicsProgram {
	
	
	/* Before you call lion.move(positionOne, positionTwo) (e.g) check whether positionTwo is not null.
	   I can't check that in Agent.java as there I can only check for integers and not for array indeces.
	   If not null, then unable to move.
	 */
	
	public static void main() {
		GCanvas canvas = new GCanvas();
		GRect rect = new GRect(10, 10);
		canvas.add(rect);
	}
}
