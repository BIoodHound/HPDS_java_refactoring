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


}
