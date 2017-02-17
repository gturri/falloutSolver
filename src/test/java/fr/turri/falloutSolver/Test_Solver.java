package fr.turri.falloutSolver;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_Solver {
	@Test
	public void shouldRetrievesTheCorrectViolations() throws Exception {
		Solver sut = new Solver();

		//Let's assume the solution is "tata"
		sut.addData("test", 1);
		assertEquals(1, sut.testCandidate("test").size());
		assertEquals(0, sut.testCandidate("toto").size());
		assertEquals(0, sut.testCandidate("tata").size());
		
		sut.addData("tota", 3);
		assertEquals(2, sut.testCandidate("test").size());
		assertEquals(0, sut.testCandidate("toto").size());
		assertEquals(0, sut.testCandidate("tata").size());
		
		sut.addData("baba", 2);
		assertEquals(3, sut.testCandidate("test").size());
		assertEquals(1, sut.testCandidate("toto").size());
		assertEquals(0, sut.testCandidate("tata").size());
	}
	
	@Test(expected=WordIncorrectSizeException.class)
	public void shouldThrowIfDataWithIncorrectSizeIsAdded() throws Exception {
		Solver sut = new Solver();
		sut.addData("test", 4);
		sut.addData("tests", 4);
	}

	@Test(expected=WordIncorrectSizeException.class)
	public void shouldThrowIfWordWithIncorrectSizeIsTested() throws Exception {
		Solver sut = new Solver();
		sut.addData("test", 4);
		sut.testCandidate("tests");
	}
}
