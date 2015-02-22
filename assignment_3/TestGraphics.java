import javax.swing.*;
import java.awt.*;

public class TestGraphics extends JPanel {

    private int a;
    private int b;
    private int c;
    private int d;

    public TestGraphics(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    /* Bit like main method; is automatically called. Graphics object is automatically
     * made and deliverese the graphical context This object allows youto use colours
     * and lines. Need to import tha awt library     
     */
    public void paintComponent(Graphics g) { 
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.fillRect(a, b, c, d);
        //g.setColor(Color.YELLOW);
        //g.setBackground(Color.YELLOW);
    }

}
