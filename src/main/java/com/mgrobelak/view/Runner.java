package com.mgrobelak.view;

/**
 * @author Marcin Grobelak
 */

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.mgrobelak.view.listeners.ClearBoardListener;
import com.mgrobelak.view.listeners.GameSettingsListener;
import com.mgrobelak.view.listeners.GenerateRandomBoardListener;
import com.mgrobelak.view.listeners.StartGameListener;
import com.mgrobelak.view.listeners.StopGameListener;

public class Runner implements Runnable {

	private boolean launched;
	private GamePanel gamePanel;
	private int interval;

	public Runner() {
		launched = false;
		JFrame mainWindow = new JFrame("John Conway's Gamme of Life");
		mainWindow.setJMenuBar(createMenu());
		gamePanel = new GamePanel();
		mainWindow.setSize(1200, 800);
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
		menu.add(createMenuItem("Start", KeyEvent.VK_1, new StartGameListener(this)));
		menu.add(createMenuItem("Stop", KeyEvent.VK_2, new StopGameListener(this)));
		menu.add(createMenuItem("Generate random board", KeyEvent.VK_3, new GenerateRandomBoardListener(this)));
		menu.add(createMenuItem("Clear the board", KeyEvent.VK_4, new ClearBoardListener(this)));
		menu.add(createMenuItem("Game settings", KeyEvent.VK_5, new GameSettingsListener(this)));
		return menubar;
	}

	private JMenuItem createMenuItem(String name, int key, ActionListener listener) {
		JMenuItem item = new JMenuItem(name, key);
		item.addActionListener(listener);
		return item;
	}

	public static void main(String[] args) {
		new Runner();
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

	public boolean getLaunched() {
		return launched;
	}

	public void setLaunched(boolean launched) {
		this.launched = launched;
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

}
