package com.mgrobelak.view;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GameSettings {

	public GameSettings() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(null);

		JLabel widthLabel = new JLabel("Width (px):");
		widthLabel.setBounds(5, 5, 80, 14);
		contentPane.add(widthLabel);
		JTextField widthEdit = new JTextField();
		widthEdit.setBounds(128, 3, 90, 20);
		contentPane.add(widthEdit);

		JLabel heightLabel = new JLabel("Height (px):");
		heightLabel.setBounds(5, 40, 80, 14);
		contentPane.add(heightLabel);
		JTextField heightEdit = new JTextField();
		heightEdit.setBounds(128, 38, 90, 20);
		contentPane.add(heightEdit);

		JLabel rowsLabel = new JLabel("Rows:");
		rowsLabel.setBounds(5, 75, 80, 14);
		contentPane.add(rowsLabel);
		JTextField rowsEdit = new JTextField();
		rowsEdit.setBounds(128, 73, 90, 20);
		contentPane.add(rowsEdit);

		JLabel columnsLabel = new JLabel("Columns:");
		columnsLabel.setBounds(5, 110, 80, 14);
		contentPane.add(columnsLabel);
		JTextField columnsEdit = new JTextField();
		columnsEdit.setBounds(128, 108, 90, 20);
		contentPane.add(columnsEdit);

		JButton okButton = new JButton("ok");
		okButton.setBounds(30, 150, 80, 23);
		contentPane.add(okButton);
		JButton cancelButton = new JButton("cancel");
		cancelButton.setBounds(120, 150, 80, 23);
		contentPane.add(cancelButton);
		frame.pack();
		frame.setVisible(true);
	}
}
