package refactoring;

public class Rover {

	public Rover(String facing, int x, int y) {
	}

	public Rover(Heading heading, int x, int y) {
	}

	public static class Position {
		private final int x;
		private final int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Position forward(Heading heading) {
			if(heading.equals(Heading.of("N"))){
				return new Position(this.x, this.y+1);
			}
			if(heading.equals(Heading.of("S"))){
				return new Position(this.x, this.y-1);
			}
			if(heading.equals(Heading.of("E"))){
				return new Position(this.x+1, this.y);
			}
			if(heading.equals(Heading.of("W"))){
				return new Position(this.x-1, this.y);
			}
			return null;
		}

		public Position backward(Heading heading) {
			if(heading.equals(Heading.of("N"))){
				return new Position(this.x, this.y-1);
			}
			if(heading.equals(Heading.of("S"))){
				return new Position(this.x, this.y+1);
			}
			if(heading.equals(Heading.of("E"))){
				return new Position(this.x-1, this.y);
			}
			if(heading.equals(Heading.of("W"))){
				return new Position(this.x+1, this.y);
			}
			return null;
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
}

