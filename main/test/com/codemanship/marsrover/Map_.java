package com.codemanship.marsrover;

import org.junit.Test;
import refactoring.Map;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class Map_ {
    @Test
    public void hasObstacles(){
        Map roverMap = new Map();
        assertThat(checkIfObstaclesExists(roverMap).equals(true));
    }

    @Test
    public void hasGoal() {
        Map roverMap = new Map();
        assertThat(checkIfGoalExists(roverMap).equals(true));

    }

    private Boolean checkIfGoalExists(Map map){
        for(int i : map.getMapMatrix()[0]){
            if (i == 2) return true;
        }
        return false;
    }
    private Boolean checkIfObstaclesExists(Map map){
        for(int i : map.getMapMatrix()[0]){
            if (i == 2) return true;
        }
        return false;
    }
}
