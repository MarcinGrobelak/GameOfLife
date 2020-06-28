package com.mgrobelak.board;

/**
 * @author Marcin Grobelak
 */

import java.util.Random;

/**
 * @author Marcin Grobelak
 */

import com.mgrobelak.cell.Cell;

public class Board {
	private int rows;
	private int columns;
	private Cell[][] cells;

	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		cells = new Cell[rows][columns];
	}

	private void scan() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (cells[i][j].getState() == true) {
					increaseNeighbors(i, j);
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

			if (column < this.columns) {
				cells[row - 1][column + 1].addNeighbor();
			}
		}

		// current row
		if (column > 0) {
			cells[row][column - 1].addNeighbor();
		}
		if (column < this.columns) {
			cells[row][column + 1].addNeighbor();
		}

		// next row
		if (row < this.rows) {
			if (column > 0) {
				cells[row + 1][column - 1].addNeighbor();
			}

			cells[row + 1][column].addNeighbor();

			if (column < this.columns) {
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
