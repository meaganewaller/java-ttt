package com.ttt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ValidationsTest {
	Validations validations;
	
	@Before
	public void setUp() {
		validations = new Validations();
	}

	@Test
	public void returnsTrueIfNotCOrH(){
		assertTrue(validations.isPlayerOptionInvalid("g"));
	}
	
	@Test
	public void returnsFalseForH() {
		assertFalse(validations.isPlayerOptionInvalid("h"));
	}
	
	@Test
	public void returnsFalseForC() {
		assertFalse(validations.isPlayerOptionInvalid("c"));
	}
	
	@Test
	public void returnsIntForBoardSize() {
		assertEquals(3, validations.boardSize("3"));
	}
	
	@Test
	public void notInvalidForSize3() {
		assertFalse(validations.isBoardSizeInvalid(3));
	}
	
	@Test
	public void notInvalidForSize4() {
		assertFalse(validations.isBoardSizeInvalid(4));
	}
	
	@Test
	public void invalidForOtherSizes() {
		assertTrue(validations.isBoardSizeInvalid(5));
	}
	
	@Test
	public void parsePlayerMove() {
		assertEquals(5, validations.parsePlayerMove("5"));
	}
	
	@Test
	public void returnsFalseIfPlayerMoveValid() {
		assertFalse(validations.isPlayerMoveInvalid(5));
	}
	
	@Test
	public void returnsTrueIfPlayerMoveInvalid() {
		assertTrue(validations.isPlayerMoveInvalid(20));
	}
	
	@Test
	public void returnsTrueIfPlayingAgain() {
		assertTrue(validations.isUserPlayingAgain("y"));
	}
	
	@Test
	public void returnsFalseIfNotPlayingAgain() {
		assertFalse(validations.isUserPlayingAgain("n"));
	}
	

}
