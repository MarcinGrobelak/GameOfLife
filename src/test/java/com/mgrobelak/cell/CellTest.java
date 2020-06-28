package com.mgrobelak.cell;

/**
 * @author Marcin Grobelak
 */

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * @author Marcin Grobelak
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

public class CellTest {
	private Cell cell;

	@BeforeEach
	void initializeFrame() {
		cell = new Cell();
	}

	@Test
	void neighborsShouldBeZeroWhenCellIsCreated() {
		assertThat(cell.getNeighbors(), is(equalTo(0)));
	}

	@Test
	void deadCellWithExactThreeNeighboursWillAliveInNextGeneration() {
		// given
		cell.setState(false);
		// when
		for (int i = 0; i < 3; i++) {
			cell.addNeighbor();
		}
		Cell newCell = new Cell(cell);
		// then
		assertThat(newCell.getState(), is(true));
	}

	@RepeatedTest(8)
	void deadCellWithNumberOfNeighborsDifferentThanThreeWillBeDeadInNextGeneration(RepetitionInfo repetition) {
		if (repetition.getCurrentRepetition() != 3) {
			// given
			cell.setState(false);
			// when
			for (int i = 0; i < repetition.getCurrentRepetition(); i++) {
				cell.addNeighbor();
			}
			Cell newCell = new Cell(cell);
			// then
			assertThat(newCell.getState(), is(false));
		}
	}

	@Test
	void aliveCellWithExactTwoNeighboursWillStayAliveInNextGeneration() {
		// given
		cell.setState(true);
		// when
		for (int i = 0; i < 2; i++) {
			cell.addNeighbor();
		}
		Cell newCell = new Cell(cell);
		// then
		assertThat(newCell.getState(), is(true));
	}

	@Test
	void aliveCellWithExactThreeNeighboursWillStayAliveInNextGeneration() {
		// given
		cell.setState(true);
		// when
		for (int i = 0; i < 3; i++) {
			cell.addNeighbor();
		}
		Cell newCell = new Cell(cell);
		// then
		assertThat(newCell.getState(), is(true));
	}

	@RepeatedTest(8)
	void aliveCellWithNumberOfNeighborsDifferentThanTwoOrThreeWillDieInNextGeneration(RepetitionInfo repetition) {
		if (repetition.getCurrentRepetition() != 2 && repetition.getCurrentRepetition() != 3) {
			// given
			cell.setState(true);
			// when
			for (int i = 0; i < repetition.getCurrentRepetition(); i++) {
				cell.addNeighbor();
			}
			Cell newCell = new Cell(cell);
			// then
			assertThat(newCell.getState(), is(false));
		}
	}

}
