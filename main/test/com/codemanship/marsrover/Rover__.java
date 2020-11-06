package com.codemanship.marsrover;

import org.junit.Test;
import refactoring.Peripheral;
import refactoring.Proprio;
import refactoring.Rover;
import refactoring.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static refactoring.Heading.*;
import static refactoring.Order.*;

public class Rover__ {
    @Test
    public void could_be_initialized_with_legacy_constructor() {
        assertThat(new Rover(new Proprio("N", 5, 5)).peripheral().heading()).isEqualTo(North);
        assertThat(new Rover(new Proprio("North", 5, 5)).peripheral().heading()).isEqualTo(North);
        assertThat(new Rover(new Proprio("North", 5, 5)).peripheral().position()).isEqualTo(new Position(5,5));
    }

    @Test
    public void could_be_initialized_using_new_constructors() {
        assertThat(new Rover(new Proprio(North, new Position(4,4))).peripheral().position()).isEqualTo(new Position(4,4));
        assertThat(new Rover(new Proprio(North, 4, 4)).peripheral().position()).isEqualTo(new Position(4,4));
    }

    @Test
    public void could_turn_left() {
        Rover rover = new Rover(new Proprio(North, new Position(3, 3)));
        rover.go(Left);
        assertThat(rover.peripheral().heading()).isEqualTo(West);
        assertThat(cast(rover.peripheral()).position()).isEqualTo(new Position(3,3));
    }

    @Test
    public void could_turn_right() {
        Rover rover = new Rover(new Proprio(East, new Position(5, 1)));
        rover.go(Right);
        assertThat(cast(rover.peripheral()).heading()).isEqualTo(South);
        assertThat(cast(rover.peripheral()).position()).isEqualTo(new Position(5,1));
    }

    @Test
    public void could_go_forward() {
        Rover rover = new Rover(new Proprio(South, new Position(-1, 1)));
        rover.go(Forward);
        assertThat(cast(rover.peripheral()).heading()).isEqualTo(South);
        assertThat(cast(rover.peripheral()).position()).isEqualTo(new Position(-1,0));
        assertThat(cast(rover.peripheral()).position()).isEqualTo( new Position(-1,0));
    }

    @Test
    public void could_go_backward() {
        Rover rover = new Rover(new Proprio(West, new Position(-4, 4)));
        rover.go(Backward);
        assertThat(cast(rover.peripheral()).heading()).isEqualTo(West);
        assertThat(cast(rover.peripheral()).position()).isEqualTo(new Position(-3,4));
    }

    @Test
    public void could_execute_many_orders() {
        Rover rover = new Rover(new Proprio(West, new Position(3, 1)));
        rover.go(Backward, Left, Forward, Right, Forward);
        assertThat(cast(rover.peripheral()).heading()).isEqualTo(West);
        assertThat(cast(rover.peripheral()).position()).isEqualTo(new Position(3,0));
    }

    @Test
    public void could_execute_legacy_instructions() {
        Rover rover = new Rover(new Proprio(West, new Position(3, 1)));
        rover.go("BLFRFR");
        assertThat(cast(rover.peripheral()).heading()).isEqualTo(North);
        assertThat(cast(rover.peripheral()).position()).isEqualTo(new Position(3,0));
    }

    @Test
    public void could_ignore_legacy_instructions() {
        Rover rover = new Rover(new Proprio(West, new Position(3, 1)));
        rover.go("BLFRF");
        assertThat(cast(rover.peripheral()).heading()).isEqualTo(West);
        assertThat(cast(rover.peripheral()).position()).isEqualTo(new Position(3,0));
    }

    private Proprio cast(Peripheral peripheral){
        return (Proprio) peripheral;
    }
}
