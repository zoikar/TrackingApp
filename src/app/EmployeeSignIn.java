package app;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

public class EmployeeSignIn extends JFrame{
	
	private JLabel mainl, username, password;
	private JTextField usernametf, passwordtf;
	private JButton signin, back;
	private JPanel p, p1;
	ResultSet resultUser, resultPass;

	public EmployeeSignIn(Statement statement) {
		p = new JPanel(new GridLayout(2,2));
		mainl = new JLabel("Type your info to signin", SwingConstants.CENTER);
		
		username = new JLabel("Username: ");
		usernametf = new JTextField();
		password = new JLabel("Password: ");
		passwordtf = new JTextField();
		
		p.add(username);
		p.add(usernametf);
		p.add(password);
		p.add(passwordtf);
		
		signin = new JButton("Sign In");
		signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                if (usernametf.getText().isEmpty() || passwordtf.getText().isEmpty()) {
                	JOptionPane.showMessageDialog(null, "Type your username and password to sign in");
                } else {
                	try {
    					resultUser = statement.executeQuery("SELECT employeeuser FROM EmployeeInfo WHERE employeeuser = " + usernametf.getText() + ";");
    					resultPass = statement.executeQuery("SELECT employeepass FROM EmployeeInfo WHERE employeepass = " + passwordtf.getText() + ";");
        				if(usernametf.getText() != resultUser.toString() || passwordtf.getText() != resultPass.toString()) {
        					JOptionPane.showMessageDialog(null, "Username or Password are not correct. Try again");
        				}else {
        					new EmployeePage(statement).setVisible(true);
                        	dispose();
        				}
    				} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
                	
                }
            	
            }
            });
		
		back = new JButton("Go Back");
		back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	new FirstFrame(statement).setVisible(true);
            }
            });
		
		p1 = new JPanel(new GridLayout(1,2));
		p1.add(back);
		p1.add(signin);
		
		add(mainl, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		add(p1, BorderLayout.SOUTH);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
