package refactoring;


public class Proprio implements Peripheral{
    private Heading heading;
    private Position position;

    public Proprio(Heading heading, Position position) {
        this.heading = heading;
        this.position = position;
    }

    public Proprio(String facing, int x, int y){
        this.heading = heading.of(facing);
        this.position = new Position(x,y);
    }

    public Proprio(Heading heading, int x, int y){
        this.heading = heading;
        this.position = new Position(x,y);
    }

    public Heading heading(){
        return heading;
    }
    public Position position(){
        return position;
    }

    @Override
    public Peripheral turnLeft() {
        heading = heading.turnLeft();
        return this;
    }

    @Override
    public Peripheral turnRight() {
        heading = heading.turnRight();
        return this;
    }

    @Override
    public Peripheral forward() {
        position = position.forward(heading);
        return this;
    }

    @Override
    public Peripheral backward() {
        position = position.backward(heading);
        return this;
    }
}
