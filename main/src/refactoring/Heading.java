package refactoring;

public enum Heading {
    North, East, South, West;

    public static Heading of(String label) {
        return of(label.charAt(0));
    }

    public static Heading of(char label) {
        if (label == 'N') return North;
        if (label == 'S') return South;
        if (label == 'W') return West;
        if (label == 'E') return East;
        return null;
    }

    public Heading turnRight() {
        return values()[add(+1)];
    }

    public Heading turnLeft() {
        return values()[add(-1)];
    }

    private int add(int offset) {
        return (this.ordinal() + offset + values().length) % values().length;
    }

}