import javax.swing.*;

public class TestPanel extends JPanel {

    private JTextField field1;
    private JTextField field2;
    private JButton actionButton;
    
    public TestPanel() {
        actionButton = new JButton("Copy");
        field1 = new JTextField(30);
        field2 = new JTextField(30);
        
        this.add(field1);
        this.add(actionButton);
        this.add(field2);        
    }

}
