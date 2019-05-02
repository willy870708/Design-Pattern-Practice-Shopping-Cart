package Command;

import model.Order;

public class ClearOrder implements Command {
	Order order;

	public void execute() {
		order.clearOrder();
		order.clearPayMent();
		order.clearReceipt();
	}

	public ClearOrder(Order order) {
		super();
		this.order = order;
		// TODO Auto-generated constructor stub
	}
}
