package com.codemanship.marsrover;

import org.junit.Test;
import refactoring.Position;
import refactoring.Proprio;

import static org.junit.Assert.assertEquals;
import static refactoring.Heading.*;

public class Position_ {

	@Test
	public void should_calculate_forward_position() {
		assertEquals(new Position(-1,0), new Position(0,0).forward(North).forward(West).forward(South));
		assertEquals(new Position(0,3), new Position(0,0).forward(North).forward(North).forward(North));
		assertEquals(new Position(3,0), new Position(0,0).forward(East).forward(East).forward(East));
		assertEquals(new Position(0,0), new Position(0,0).forward(North).forward(West).forward(South).forward(East));
	}

	@Test
	public void should_calculate_backward_position() {
		assertEquals(new Position(1,0), new Position(0,0).backward(North).backward(West).backward(South));
		assertEquals(new Position(0,-3), new Position(0,0).backward(North).backward(North).backward(North));
		assertEquals(new Position(-3,0), new Position(0,0).backward(East).backward(East).backward(East));
		assertEquals(new Position(0,0), new Position(0,0).backward(North).backward(West).backward(South).backward(East));
	}

}
