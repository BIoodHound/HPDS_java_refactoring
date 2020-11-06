package refactoring;

public enum Order {
    Forward, Backward, Left, Right;

    static Order of(String s){
        return of(s.charAt(0));
    }

    public static Order of(char label) {
        if (label == 'F') return Forward;
        if (label == 'B') return Backward;
        if (label == 'L') return Left;
        if (label == 'R') return Right;
        return null;
    }

}
