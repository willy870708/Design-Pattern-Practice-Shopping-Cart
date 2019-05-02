package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextArea;

import Strategy.Strategy;
import model.Product;
import controller.AccountCtl;
import controller.CartCtl;
import controller.PayCtl;

import java.awt.Color;

public class ReceiptGUICreditcard implements Strategy {

	private JFrame frame;
	PayCtl payCtl = PayCtl.getPayCtl();
	JLabel label_3 = new JLabel(" ");

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ReceiptGUICreditcard() {
		wayofpay();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 706, 703);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		AccountCtl accountctl = AccountCtl.getAccountCtl();
		CartCtl cartCtl = CartCtl.getcartctl();
		String total = "";
		for (Product a : accountctl.getcart().getProductlist()) {
			String text = a.getName() + "    " + a.getBrand() + "      "
					+ a.getPrice() + "   " + a.getQuantity() + "\n";
			total += text;
		}
		JLabel label = new JLabel(accountctl.getid() + "'s" + " Receipt");
		label.setFont(new Font("新細明體", Font.BOLD, 25));
		label.setBounds(260, 13, 230, 48);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel(
				"Brand        Name              Price   Quantity");
		label_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_1.setBounds(37, 74, 403, 19);
		frame.getContentPane().add(label_1);

		JTextArea textArea = new JTextArea();
		textArea.setText(total
				+ "Total price: "
				+ String.valueOf(cartCtl.getprice(accountctl.getcart()
						.getProductlist())) + "  dollars\n" + payCtl.getprice());
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBounds(14, 101, 660, 406);
		frame.getContentPane().add(textArea);

		JLabel label_2 = new JLabel("Way Of Payment");
		label_2.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_2.setBounds(324, 560, 145, 48);
		frame.getContentPane().add(label_2);

		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_3.setBounds(483, 560, 145, 48);
		frame.getContentPane().add(label_3);
	}

	public void wayofpay() {
		label_3.setText("Pay In Credit Card");
	}

	static public void show() {
		ReceiptGUICreditcard window = new ReceiptGUICreditcard();
		window.frame.setVisible(true);
	}
}
