package refactoring;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position forward(Heading heading) {
        return new Position(x+dx(heading), y+dy(heading));
    }

    public Position backward(Heading heading) {
        return forward(heading.opposite());
    }

    private int dx(Heading heading){
        return heading == Heading.East ? 1 : heading == heading.West ? -1: 0;
    }

    private int dy(Heading heading){
        return heading == Heading.North ? 1 : heading == heading.South ? -1: 0;
    }

    @Override
    public boolean equals(Object object) {
        return isSameClass(object) && equals((Position) object);
    }

    private boolean equals(Position position) {
        return position == this || (x == position.x && y == position.y);
    }

    private boolean isSameClass(Object object) {
        return object != null && object.getClass() == Position.class;
    }

}