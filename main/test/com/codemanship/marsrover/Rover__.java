package com.codemanship.marsrover;

import org.junit.Test;
import refactoring.Rover;
import refactoring.Rover.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static refactoring.Heading.*;
import static refactoring.Order.*;

public class Rover__ {
    @Test
    public void could_be_initialized_with_legacy_constructor() {
        assertThat(new Rover("N", 5, 5).heading()).isEqualTo(North);
        assertThat(new Rover("North", 5, 5).heading()).isEqualTo(North);
        assertThat(new Rover("North", 5, 5).position()).isEqualTo(new Position(5,5));
    }

    @Test
    public void could_be_initialized_using_new_constructors() {
        assertThat(new Rover(North, new Position(4,4)).position()).isEqualTo(new Position(4,4));
        assertThat(new Rover(North, 4, 4).position()).isEqualTo(new Position(4,4));
    }
    @Test
    public void could_turn_left() {
        Rover rover = new Rover(North, new Position(3, 3));
        rover.go(Left);
        assertThat(rover.heading()).isEqualTo(West);
        assertThat(rover.position()).isEqualTo(new Position(3,3));
    }
}
