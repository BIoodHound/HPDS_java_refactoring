package refactoring;

public interface Peripheral {
    Peripheral turnLeft();
    Peripheral turnRight();
    Peripheral forward();
    Peripheral backward();

    public Position position();
    public Heading heading();
}
