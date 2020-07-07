package com.mgrobelak.board;

/**
 * @author Marcin Grobelak
 */

import java.util.Random;

import com.mgrobelak.cell.Cell;

public class Board {
	private int rows;
	private int columns;
	private Cell[][] cells;

	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		cells = new Cell[rows][columns];
		fillWithDeadCells();
	}

	public Board(Board board) {
		board.updateNeighborsCount();
		rows = board.getRows();
		columns = board.getColumns();
		this.cells = new Cell[rows][columns];
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				this.cells[row][column] = new Cell(board.getCells()[row][column]);
			}
		}
	}

	public void updateNeighborsCount() {
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (cells[row][column].getState() == true) {
					increaseNeighbors(row, column);
				}
			}
		}
	}

	private void increaseNeighbors(int row, int column) {
		// prior row
		if (row > 0) {
			if (column > 0) {
				cells[row - 1][column - 1].addNeighbor();
			}

			cells[row - 1][column].addNeighbor();

			if (column < this.columns - 1) {
				cells[row - 1][column + 1].addNeighbor();
			}
		}

		// current row
		if (column > 0) {
			cells[row][column - 1].addNeighbor();
		}
		if (column < this.columns - 1) {
			cells[row][column + 1].addNeighbor();
		}

		// next row
		if (row < this.rows - 1) {
			if (column > 0) {
				cells[row + 1][column - 1].addNeighbor();
			}

			cells[row + 1][column].addNeighbor();

			if (column < this.columns - 1) {
				cells[row + 1][column + 1].addNeighbor();
			}
		}
	}

	public void fillWithDeadCells() {
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				this.cells[i][j] = new Cell();
			}
		}
	}

	public void fillWithRandomCells() {
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				Random random = new Random();
				Cell cell = new Cell();
				cell.setState(random.nextBoolean());
				this.cells[i][j] = cell;
			}
		}
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Cell[][] getCells() {
		return cells;
	}
}
