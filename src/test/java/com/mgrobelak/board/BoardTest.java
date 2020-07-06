package com.mgrobelak.board;

/**
 * @author Marcin Grobelak
 */

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class BoardTest {

	private Board board;
	private int rows = 10;
	private int columns = 10;

	@BeforeEach
	void initializeBoard() {
		board = new Board(rows, columns);
	}

	@Test
	void boardShouldBefilledWithEmptyCellsAfterCreation() {
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				assertThat(board.getCells()[row][column].getState(), is(false));
			}
		}
	}

}
