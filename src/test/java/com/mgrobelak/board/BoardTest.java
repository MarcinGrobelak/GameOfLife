package com.mgrobelak.board;

/**
 * @author Marcin Grobelak
 */

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class BoardTest {

	private Board board;
	private static int rowsCount = 10;
	private static int columnsCount = 10;

	@BeforeEach
	void initializeBoard() {
		board = new Board(rowsCount, columnsCount);
	}

	@ParameterizedTest
	@MethodSource("rowColumnPairs")
	void boardShouldBefilledWithEmptyCellsAfterCreation(int row, int column) {
		assertThat(board.getCells()[row][column].getState(), is(false));
	}

	@ParameterizedTest
	@CsvSource({ "0,1", "1,0", "1,1" })
	void topRowLeftCornerCellNeighboursShouldBeIncresed(int row, int column) {
		// given
		board.getCells()[0][0].setState(true);
		// when
		board.updateNeighborsCount();
		// then
		assertThat(board.getCells()[row][column].getNeighbors(), is(equalTo(1)));
	}

	@ParameterizedTest
	@MethodSource("rowColumnPairs")
	void topRowLeftCornerCellNotNeighboursShouldNotBeIncresed(int row, int column) {
		// given
		board.getCells()[0][0].setState(true);
		// when
		board.updateNeighborsCount();
		// then
		if (!((row == 0 && column == 1) || (row == 1 && column == 0) || (row == 1 && column == 1))) {
			assertThat(board.getCells()[row][column].getNeighbors(), is(equalTo(0)));
		}
	}

	@ParameterizedTest
	@CsvSource({ "0,8", "1,8", "1,9" })
	void topRowRightCornerCellNeighboursShouldBeIncresed(int row, int column) {
		// given
		board.getCells()[0][columnsCount - 1].setState(true);
		// when
		board.updateNeighborsCount();
		// then
		assertThat(board.getCells()[row][column].getNeighbors(), is(equalTo(1)));
	}

	@ParameterizedTest
	@MethodSource("rowColumnPairs")
	void topRowRightCornerCellNotNeighboursShouldNotBeIncresed(int row, int column) {
		// given
		board.getCells()[0][columnsCount - 1].setState(true);
		// when
		board.updateNeighborsCount();
		// then
		if (!((row == 0 && column == 8) || (row == 1 && column == 8) || (row == 1 && column == 9))) {
			assertThat(board.getCells()[row][column].getNeighbors(), is(equalTo(0)));
		}
	}

	@ParameterizedTest
	@CsvSource({ "0,5", "0,7", "1,5", "1,6", "1,7" })
	void topRowMiddleCellNeighboursShouldBeIncresed(int row, int column) {
		// given
		board.getCells()[0][6].setState(true);
		// when
		board.updateNeighborsCount();
		// then
		assertThat(board.getCells()[row][column].getNeighbors(), is(equalTo(1)));
	}

	@ParameterizedTest
	@MethodSource("rowColumnPairs")
	void topRowMiddleCellNotNeighboursShouldNotBeIncresed(int row, int column) {
		// given
		board.getCells()[0][6].setState(true);
		// when
		board.updateNeighborsCount();
		// then
		if (!((row == 0 && column == 5) || (row == 0 && column == 7) || (row == 1 && column == 5)
				|| (row == 1 && column == 6) || (row == 1 && column == 7))) {
			assertThat(board.getCells()[row][column].getNeighbors(), is(equalTo(0)));
		}
	}

	@ParameterizedTest
	@CsvSource({ "8,0", "8,1", "9,1" })
	void bottomRowLeftCornerCellNeighboursShouldBeIncresed(int row, int column) {
		// given
		board.getCells()[rowsCount - 1][0].setState(true);
		// when
		board.updateNeighborsCount();
		// then
		assertThat(board.getCells()[row][column].getNeighbors(), is(equalTo(1)));
	}

	@ParameterizedTest
	@MethodSource("rowColumnPairs")
	void bottomRowLeftCornerCellNotNeighboursShouldNotBeIncresed(int row, int column) {
		// given
		board.getCells()[rowsCount - 1][0].setState(true);
		// when
		board.updateNeighborsCount();
		// then
		if (!((row == 8 && column == 0) || (row == 8 && column == 1) || (row == 9 && column == 1))) {
			assertThat(board.getCells()[row][column].getNeighbors(), is(equalTo(0)));
		}
	}

	@ParameterizedTest
	@CsvSource({ "8,8", "8,9", "9,8" })
	void bottomRowRightCornerCellNeighboursShouldBeIncresed(int row, int column) {
		// given
		board.getCells()[rowsCount - 1][columnsCount - 1].setState(true);
		// when
		board.updateNeighborsCount();
		// then
		assertThat(board.getCells()[row][column].getNeighbors(), is(equalTo(1)));
	}

	@ParameterizedTest
	@MethodSource("rowColumnPairs")
	void bottomRowRightCornerCellNotNeighboursShouldNotBeIncresed(int row, int column) {
		// given
		board.getCells()[rowsCount - 1][columnsCount - 1].setState(true);
		// when
		board.updateNeighborsCount();
		// then
		if (!((row == 8 && column == 8) || (row == 8 && column == 9) || (row == 9 && column == 8))) {
			assertThat(board.getCells()[row][column].getNeighbors(), is(equalTo(0)));
		}
	}

	@ParameterizedTest
	@CsvSource({ "8,5", "8,6", "8,7", "9,5", "9,7" })
	void bottomRowMiddleCellNeighboursShouldBeIncresed(int row, int column) {
		// given
		board.getCells()[rowsCount - 1][6].setState(true);
		// when
		board.updateNeighborsCount();
		// then
		assertThat(board.getCells()[row][column].getNeighbors(), is(equalTo(1)));
	}

	@ParameterizedTest
	@MethodSource("rowColumnPairs")
	void bottomRowMiddleCellNotNeighboursShouldNotBeIncresed(int row, int column) {
		// given
		board.getCells()[rowsCount - 1][6].setState(true);
		// when
		board.updateNeighborsCount();
		// then
		if (!((row == 8 && column == 5) || (row == 8 && column == 6) || (row == 8 && column == 7)
				|| (row == 9 && column == 5) || (row == 9 && column == 7))) {
			assertThat(board.getCells()[row][column].getNeighbors(), is(equalTo(0)));
		}
	}

	@ParameterizedTest
	@CsvSource({ "4,4", "4,5", "4,6", "5,4", "5,6", "6,4", "6,5", "6,6" })
	void cellOnTheMiddleOfTheBoardNeighboursShouldBeIncresed(int row, int column) {
		// given
		board.getCells()[5][5].setState(true);
		// when
		board.updateNeighborsCount();
		// then
		assertThat(board.getCells()[row][column].getNeighbors(), is(equalTo(1)));
	}

	@ParameterizedTest
	@MethodSource("rowColumnPairs")
	void cellOnTheMiddleOfTheBoardNotNeighboursShouldNotBeIncresed(int row, int column) {
		// given
		board.getCells()[5][5].setState(true);
		// when
		board.updateNeighborsCount();
		// then
		if (!((row == 4 && column == 4) || (row == 4 && column == 5) || (row == 4 && column == 6)
				|| (row == 5 && column == 4) || (row == 5 && column == 6) || (row == 6 && column == 4)
				|| (row == 6 && column == 5) || (row == 6 && column == 6))) {
			assertThat(board.getCells()[row][column].getNeighbors(), is(equalTo(0)));
		}
	}

	private static List<Arguments> rowColumnPairs() {
		List<Arguments> args = new ArrayList<>();
		for (int row = 0; row <= rowsCount - 1; row++) {
			for (int column = 0; column <= columnsCount - 1; column++) {
				args.add(Arguments.of(row, column));
			}
		}
		return args;
	}

}
