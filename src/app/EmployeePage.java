package app;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;
import java.util.Random;

public class EmployeePage extends JFrame{
	private JPanel p;
	private JLabel mainl;
	private JButton newPackage, updatePackage, goBack;
	ResultSet rsl;
	Random random = new Random();
    int trackNum = random.nextInt(100000);

	public EmployeePage(Statement statement) {
		p = new JPanel(new GridLayout(2,1));
		
		mainl = new JLabel("Choose what you want to do", SwingConstants.CENTER);
		
		newPackage = new JButton("I want to add a new package");
		newPackage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Check if the track number already exists in the table
                String sql = "SELECT * FROM PackageInfo WHERE tracknum = " + trackNum;
                try {
					rsl = statement.executeQuery(sql);
					if (rsl.next()) {
	                    // Track number already exists, generate another one
	                    trackNum = random.nextInt(100000);
	                }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
            	new NewPackage(statement, trackNum).setVisible(true);
            	dispose();
            }
            });
		
		updatePackage = new JButton("I want to update a package");
		updatePackage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new UpdatePackage(statement).setVisible(true);
            	dispose();
            }
            });
		
		goBack = new JButton("Go Back");
		goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new EmployeeSignIn(statement).setVisible(true);
            	dispose();
            }
            });
		
		p.add(newPackage);
		p.add(updatePackage);
		
		add(mainl, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		add(goBack, BorderLayout.SOUTH);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}

}
