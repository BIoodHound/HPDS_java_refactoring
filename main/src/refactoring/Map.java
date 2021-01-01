package refactoring;

import java.util.Arrays;

public class Map {
    Integer[][] mapMatrix = new Integer[24][24];
    private Boolean goalSet = false;

    public Map() {
        generateObstacles();
    }

    private void setGoal(Integer[] goalRow){
        Integer randomPosition = (int) Math.round(Math.random() * (mapMatrix.length-1));
        goalRow[randomPosition] = 2;
        goalSet = true;
    }

    private void generateObstacles(){
        for (int i = 0; i < mapMatrix.length; i++) {
            Arrays.fill(mapMatrix[i],0);
            for (int j = 0; j < 7; j++) {
                Integer randomPosition = (int) Math.round(Math.random() * (mapMatrix.length-1));
                mapMatrix[i][randomPosition] = 1;
            }
            if(goalSet.equals(false)){
                setGoal(mapMatrix[i]);
            }
        }
    }

    public Integer[][] getMapMatrix() {
        return mapMatrix;
    }
}
