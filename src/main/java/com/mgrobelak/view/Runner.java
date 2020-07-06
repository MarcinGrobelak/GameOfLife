package com.mgrobelak.view;

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
	private JFrame mainWindow;

	private int widthPx;
	private int heightPx;
	private int rows;
	private int columns;
	private int interval;

	public Runner() {
		launched = false;
		mainWindow = new JFrame("John Conway's Game of Life");
		mainWindow.setJMenuBar(createMenu());
		setDefaultSettings();
		mainWindow.setSize(widthPx, heightPx);
		gamePanel = new GamePanel(rows, columns);
		mainWindow.add(gamePanel);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
	}

	private void setDefaultSettings() {
		heightPx = 800;
		widthPx = 1200;
		rows = 60;
		columns = 70;
		interval = 500;
	}

	public void setGameSettings(int widthPx, int heightPx, int rows, int columns, int interval) {
		launched = false;
		this.widthPx = widthPx;
		this.heightPx = heightPx;
		this.rows = rows;
		this.columns = columns;
		this.interval = interval;
		createBoard();
		mainWindow.repaint();
	}

	private void createBoard() {
		mainWindow.getContentPane().removeAll();
		mainWindow.setSize(widthPx, heightPx);
		gamePanel = new GamePanel(rows, columns);
		mainWindow.add(gamePanel);
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

	public JFrame getMainWindow() {
		return mainWindow;
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

	public int getHeightPx() {
		return heightPx;
	}

	public int getWidthPx() {
		return widthPx;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public int getInterval() {
		return interval;
	}
}
