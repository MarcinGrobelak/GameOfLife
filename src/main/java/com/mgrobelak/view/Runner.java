package com.mgrobelak.view;

/**
 * @author Marcin Grobelak
 */

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Runner {

	public Runner() {
		JFrame mainWindow = new JFrame("John Conway's Gamme of Life");
		JPanel gamePanel = new GamePanel(mainWindow);
		mainWindow.setSize(500, 500);
		mainWindow.setLayout(new BorderLayout());
		mainWindow.add(gamePanel, BorderLayout.CENTER);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
	}

	public static void main(String[] args) {
		new Runner();
	}

}
