package com.mgrobelak.cell;

/**
 * @author Marcin Grobelak
 */

public class Cell {

	private boolean state;
	private int neighbors;

	public Cell() {
		neighbors = 0;
	}

	public Cell(Cell cell) {
		state = initState(cell);
		neighbors = 0;
	}

	private boolean initState(Cell cell) {
		if (cell.getState() == false) {
			if (cell.getNeighbors() == 3) {
				return true;
			}
			return false;
		}
		if (cell.getNeighbors() == 2 || cell.getNeighbors() == 3) {
			return true;
		}
		return false;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public int getNeighbors() {
		return neighbors;
	}

	public void addNeighbor() {
		this.neighbors++;
	}
}
