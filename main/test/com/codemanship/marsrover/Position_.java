package com.codemanship.marsrover;

import org.junit.Test;
import refactoring.Rover;
import refactoring.Rover.Position;

import static org.junit.Assert.assertEquals;
import static refactoring.Rover.Heading.*;

public class Position_ {

	@Test
	public void should_calculate_forward_position() {
		assertEquals(new Position(-1,0), new Position(0,0).forward(North).forward(West).forward(South));
		assertEquals(new Position(0,3), new Position(0,0).forward(North).forward(North).forward(North));
		assertEquals(new Position(3,0), new Position(0,0).forward(East).forward(East).forward(East));
		assertEquals(new Position(0,0), new Position(0,0).forward(North).forward(West).forward(South).forward(East));
	}

}
