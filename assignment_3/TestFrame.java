import javax.swing.*;
import java.awt.*;

public class TestFrame extends JFrame {

    public TestFrame() {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Test frame");
        frame.setLocation(50, 50);
        
        //TestPanel testPanel = new TestPanel();
        //frame.add(testPanel);
        
        for (int i=1; i<4; i++) {
            TestGraphics testGraphics = new TestGraphics(i*110, i*30, i*30, i*30);
            frame.add(testGraphics);
            System.out.println(i);
            frame.setVisible(true);    
        }
        

        
    }
    
    public static void main (String[] args) {        
        new TestFrame();
    }

}
