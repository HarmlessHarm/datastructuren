//Program using the w/o acm library

import javax.swing.*;
import java.awt.*;

 
public class FrameNPanel{
   
    private Frame frame;
    private Panel panel;
    
    private static final int FRAME_SIZE_X = 800;
    private static final int FRAME_SIZE_Y = 600;
    private static final int PANEL_SIZE_X = 800;
    private static final int PANEL_SIZE_Y = 600;  
    
    private static final String TITLE = "Lambs and Lions";  
    
    public FrameNPanel(){
        frame = new Frame(TITLE);
        panel = new Panel();
    }    

    public void launchMyFrame(){
        frame.setSize(FRAME_SIZE_X, FRAME_SIZE_Y);
        //f.setLayout(null); //Override the default layout manager       

        panel.setSize(PANEL_SIZE_X, PANEL_SIZE_Y);
        panel.setBackground(Color.WHITE);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String args[]){
        FrameNPanel fe = new FrameNPanel();
        fe.launchMyFrame();
    }
}
