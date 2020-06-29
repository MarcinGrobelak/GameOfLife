package com.mgrobelak.view;

/**
 * @author Marcin Grobelak
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Runner implements ActionListener, Runnable {

	private boolean launched;
	private GamePanel gamePanel;
	private int interval;

	public Runner() {
		JFrame mainWindow = new JFrame("John Conway's Gamme of Life");
		mainWindow.setJMenuBar(createMenu());
		gamePanel = new GamePanel();
		mainWindow.setSize(1800, 1200);
		interval = 500;
		mainWindow.setLayout(new BorderLayout());
		mainWindow.add(gamePanel, BorderLayout.CENTER);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
	}

	private JMenuBar createMenu() {
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Game");
		menubar.add(menu);
		JMenuItem startItem = new JMenuItem("Start", KeyEvent.VK_1);
		startItem.addActionListener(this);
		JMenuItem stopItem = new JMenuItem("Stop", KeyEvent.VK_0);
		stopItem.addActionListener(this);
		menu.add(startItem);
		menu.add(stopItem);
		return menubar;
	}

	public static void main(String[] args) {
		new Runner();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Start")) {
			if (!launched) {
				launched = true;
				Thread thread = new Thread(this);
				thread.start();
			}
			return;
		}
		launched = false;
	}

	@Override
	public void run() {
		while (launched) {
			gamePanel.createNextGeneration();
			try {
				Thread.sleep(interval);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
