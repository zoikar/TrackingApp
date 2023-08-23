package app;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test extends JFrame{

    private JFrame frame;
    private JTextField textField;
    private JButton button;

    public Test() {
        frame = new JFrame("TextField and Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField();

        button = new JButton("Click");
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text = textField.getText();
                if (text.isEmpty()) {
                	JOptionPane.showMessageDialog(null, "You didn't give a tracking number");
                } else {
                    
                }
            }
        });

        frame.add(textField, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        frame.pack();
        
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Test();
    }
}
