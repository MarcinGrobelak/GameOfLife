package com.mgrobelak.view;

/**
 * @author Marcin Grobelak
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import com.mgrobelak.board.Board;

public class GamePanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = -7775299104049319502L;

	private Board board;
	double rowHeight;
	double columnWidth;

	public GamePanel(int rows, int columns) {
		this.addMouseListener(this);
		board = new Board(rows, columns);
	}

	public void createNextGeneration() {
		Board nextGen = new Board(board);
		board = nextGen;
	}

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		rowHeight = (double) this.getHeight() / board.getRows();
		columnWidth = (double) this.getWidth() / board.getColumns();
		drawCells(graphics);
		drawColumnLines(graphics);
		drawRowLines(graphics);
		this.repaint();
	}

	private void drawCells(Graphics graphics) {
		graphics.setColor(new Color(52, 100, 235));
		for (int row = 0; row < board.getRows(); row++) {
			for (int column = 0; column < board.getColumns(); column++) {
				if (board.getCells()[row][column].getState()) {
					graphics.fillRect(round(column * columnWidth), round(row * rowHeight), round(columnWidth) + 1,
							round(rowHeight) + 1);
				}
			}
		}
	}

	private void drawColumnLines(Graphics graphics) {
		graphics.setColor(Color.BLACK);
		for (int i = 0; i < board.getColumns(); i++) {
			graphics.drawLine(round(i * columnWidth), 0, round(i * columnWidth), this.getHeight());
		}
	}

	private void drawRowLines(Graphics graphics) {
		graphics.setColor(Color.BLACK);
		for (int i = 0; i < board.getRows(); i++) {
			graphics.drawLine(0, round(i * rowHeight), this.getWidth(), round(i * rowHeight));
		}
	}

	private int round(double i) {
		return (int) Math.round(i);
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		int column = (int) Math.floor(event.getX() / columnWidth);
		int row = (int) Math.floor(event.getY() / rowHeight);
		boolean oldState = board.getCells()[row][column].getState();
		board.getCells()[row][column].setState(!oldState);
	}

	@Override
	public void mouseClicked(MouseEvent event) {
	}

	@Override
	public void mousePressed(MouseEvent event) {
	}

	@Override
	public void mouseEntered(MouseEvent event) {
	}

	@Override
	public void mouseExited(MouseEvent event) {
	}

	public Board getBoard() {
		return board;
	}

}
