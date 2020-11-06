package refactoring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Arrays.*;

public class Rover {

    private Peripheral peripheral;

    public Rover(Peripheral peripheral){
        this.peripheral = peripheral;
    }

    public Peripheral peripheral() {
    	return peripheral;
	}

	public void go(String instructions){
    	go(Arrays.stream(instructions.split("")).map(Order::of));
	}

	public  void  go(Order... orders){
    	go(stream(orders));
	}

	private void go(Stream<Order> orders){
    	orders.filter(Objects::nonNull).forEach(this::execute);
	}

	private void execute(Order order){
		actions.get(order).execute();
	}

	@FunctionalInterface
	public interface Action {
		void execute();
	}

	private Map<Order, Action> actions = new HashMap<>();
	{
		actions.put(Order.Left, () -> peripheral = peripheral.turnLeft());
		actions.put(Order.Right, () -> peripheral = peripheral.turnRight());
		actions.put(Order.Backward, () -> peripheral = peripheral.backward());
		actions.put(Order.Forward, () -> peripheral = peripheral.forward());
	}
}

