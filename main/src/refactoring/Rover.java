package refactoring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.*;

public class Rover {
	private Heading heading;
	private Position position;

	public Rover(String facing, int x, int y) {
		this.heading = Heading.of(facing);
		this.position = new Position(x,y);
	}

	public Rover(Heading heading, int x, int y) {
		this.heading = heading;
		this.position = new Position(x,y);
	}

	public Rover(Heading heading, Position position) {
		this.heading = heading;
		this.position = position;
	}

	public Heading heading(){
		return heading;
	}

	public Position position(){
		return position;
	}

	public void go(String instructions){
		stream(instructions.split("")).map(Order::of);
	}

	public void go(Order... order){
		for (Order o: order) execute(o);
	}

	private void execute(Order order){
		actions.get(order).execute();
	}

	@FunctionalInterface
	public interface Action {
		void execute();
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

	private final Map<Order, Action> actions = new HashMap<>();
	{
		actions.put(Order.Left, () -> heading = heading.turnLeft());
		actions.put(Order.Right, () -> heading = heading.turnRight());
		actions.put(Order.Backward, () -> position = position.backward(heading));
		actions.put(Order.Forward, () -> position = position.forward(heading));
	}
}

