package com.mgrobelak.view;

/**
 * @author Marcin Grobelak
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mgrobelak.board.Board;

public class GamePanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = -7775299104049319502L;

	private JFrame frame;
	private Board board;
	int rowHeight;
	int columnWidth;

	public GamePanel(JFrame frame) {
		this.frame = frame;
		this.addMouseListener(this);
		board = new Board(10, 10);
		board.fillWithDeadCells();
	}

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		rowHeight = this.getHeight() / board.getRows();
		columnWidth = this.getWidth() / board.getColumns();
		drawCells(graphics);
		drawColumnLines(graphics);
		drawRowLines(graphics);
		frame.repaint();

	}

	private void drawCells(Graphics graphics) {
		graphics.setColor(new Color(52, 100, 235));
		for (int row = 0; row < board.getRows(); row++) {
			for (int column = 0; column < board.getColumns(); column++) {
				if (board.getCells()[row][column].getState()) {
					graphics.fillRect(column * columnWidth, row * rowHeight, columnWidth, rowHeight);
				}
			}
		}
	}

	private void drawColumnLines(Graphics graphics) {
		graphics.setColor(Color.BLACK);
		for (int i = 0; i < board.getColumns(); i++) {
			graphics.drawLine(i * columnWidth, 0, i * columnWidth, this.getHeight());
		}
	}

	private void drawRowLines(Graphics graphics) {
		graphics.setColor(Color.BLACK);
		for (int i = 0; i < board.getRows(); i++) {
			graphics.drawLine(0, i * rowHeight, this.getWidth(), i * rowHeight);
		}
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		int column = event.getX() / columnWidth;
		int row = event.getY() / rowHeight;
		System.out.println("Column: " + column + " ,row: " + row);
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

}
