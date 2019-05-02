package model;

import javax.swing.JOptionPane;

public class Order {
	public Order() {
	};

	public void clearOrder() {
		JOptionPane.showMessageDialog(null, "Order has been clear!!!");
	}

	public void clearPayMent() {
		JOptionPane.showMessageDialog(null, "PayMent has been clear!!!");
	}

	public void clearReceipt() {
		JOptionPane.showMessageDialog(null, "Receipt has been clear!!!");
	}
}
