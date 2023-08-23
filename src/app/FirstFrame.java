package app;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

public class FirstFrame extends JFrame{
	private JLabel mainl;
	private JButton userb, employeeb;
	private JPanel p;
	public FirstFrame(Statement statement) {
		p = new JPanel(new GridLayout(3,1));
		
		mainl = new JLabel("Choose your category", SwingConstants.CENTER);
		
		userb = new JButton("I am a User");
		userb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new UserPage(statement).setVisible(true);
            	dispose();
            }
            });
		
		employeeb = new JButton("I am an Employee");
		employeeb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new EmployeeSignIn(statement).setVisible(true);
            	dispose();
            }
            });
		
		
		p.add(mainl);
		p.add(userb);
		p.add(employeeb);
		
		add(p);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
