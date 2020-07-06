package com.mgrobelak.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public class GameSettings {

	private JSpinner widthSpinner;
	private JSpinner heightSpinner;
	private JSpinner rowsSpinner;
	private JSpinner columnsSpinner;
	private JSpinner intervalSpinner;

	public GameSettings(Runner runner) {
		JDialog settingsDialog = new JDialog(runner.getMainWindow(), "Game settings", true);
		settingsDialog.setResizable(false);
		settingsDialog.setLocationRelativeTo(runner.getMainWindow());
		Container contentPane = settingsDialog.getContentPane();
		contentPane.setPreferredSize(new Dimension(225, 210));
		contentPane.setLayout(null);

		JLabel widthLabel = new JLabel("Width (px):");
		widthLabel.setBounds(5, 5, 80, 14);
		contentPane.add(widthLabel);
		widthSpinner = new JSpinner();
		widthSpinner.setBounds(128, 3, 90, 20);
		widthSpinner.setValue(runner.getWidthPx());
		contentPane.add(widthSpinner);

		JLabel heightLabel = new JLabel("Height (px):");
		heightLabel.setBounds(5, 40, 80, 14);
		contentPane.add(heightLabel);
		heightSpinner = new JSpinner();
		heightSpinner.setBounds(128, 38, 90, 20);
		heightSpinner.setValue(runner.getHeightPx());
		contentPane.add(heightSpinner);

		JLabel rowsLabel = new JLabel("Rows:");
		rowsLabel.setBounds(5, 75, 80, 14);
		contentPane.add(rowsLabel);
		rowsSpinner = new JSpinner();
		rowsSpinner.setBounds(128, 73, 90, 20);
		rowsSpinner.setValue(runner.getRows());
		contentPane.add(rowsSpinner);

		JLabel columnsLabel = new JLabel("Columns:");
		columnsLabel.setBounds(5, 110, 80, 14);
		contentPane.add(columnsLabel);
		columnsSpinner = new JSpinner();
		columnsSpinner.setBounds(128, 108, 90, 20);
		columnsSpinner.setValue(runner.getColumns());
		contentPane.add(columnsSpinner);

		JLabel intervalLabel = new JLabel("Interval:");
		intervalLabel.setBounds(5, 145, 80, 14);
		contentPane.add(intervalLabel);
		intervalSpinner = new JSpinner();
		intervalSpinner.setBounds(128, 143, 90, 20);
		intervalSpinner.setValue(runner.getInterval());
		contentPane.add(intervalSpinner);

		JButton okButton = new JButton("ok");
		okButton.setBounds(30, 177, 80, 23);

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				runner.setGameSettings((int) widthSpinner.getValue(), (int) heightSpinner.getValue(),
						(int) rowsSpinner.getValue(), (int) columnsSpinner.getValue(),
						(int) intervalSpinner.getValue());
				settingsDialog.dispose();
			}
		});

		contentPane.add(okButton);

		JButton cancelButton = new JButton("cancel");
		cancelButton.setBounds(120, 177, 80, 23);

		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				settingsDialog.dispose();
			}
		});

		contentPane.add(cancelButton);
		settingsDialog.pack();
		settingsDialog.setVisible(true);
	}
}
