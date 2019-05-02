package view;

import java.awt.EventQueue;
import Strategy.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.AccountCtl;
import controller.CartCtl;
import controller.PayCtl;
import model.Cart;
import model.Product;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ReceiptGUICASH implements Strategy {

	private JFrame frmReceipt;
	PayCtl payCtl = PayCtl.getPayCtl();
	JLabel payway = new JLabel(" ");

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ReceiptGUICASH() {
		wayofpay();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReceipt = new JFrame();
		frmReceipt.setTitle("Receipt");
		frmReceipt.setBounds(100, 100, 706, 703);
		frmReceipt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmReceipt.getContentPane().setLayout(null);
		AccountCtl accountctl = AccountCtl.getAccountCtl();
		CartCtl cartCtl = CartCtl.getcartctl();
		String total = "";
		for (Product a : accountctl.getcart().getProductlist()) {
			String text = a.getName() + "    " + a.getBrand() + "      "
					+ a.getPrice() + "   " + a.getQuantity() + "\n";
			total += text;
		}
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setText(total
				+ "Total price: "
				+ String.valueOf(cartCtl.getprice(accountctl.getcart()
						.getProductlist())) + "  dollars\n" + payCtl.getprice());
		textArea.setBounds(14, 116, 660, 406);
		frmReceipt.getContentPane().add(textArea);

		JLabel lblNewLabel = new JLabel(accountctl.getid() + "'s" + " Receipt");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 25));
		lblNewLabel.setBounds(260, 28, 230, 48);
		frmReceipt.getContentPane().add(lblNewLabel);

		JLabel lblIphoneApple = new JLabel(
				"Brand        Name              Price   Quantity");
		lblIphoneApple.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblIphoneApple.setBounds(37, 89, 403, 19);
		frmReceipt.getContentPane().add(lblIphoneApple);

		JLabel lblWayOfPayment = new JLabel("Way Of Payment");
		lblWayOfPayment.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblWayOfPayment.setBounds(267, 558, 145, 48);
		frmReceipt.getContentPane().add(lblWayOfPayment);

		payway.setForeground(Color.RED);
		payway.setFont(new Font("新細明體", Font.PLAIN, 20));
		payway.setBounds(426, 558, 145, 48);
		frmReceipt.getContentPane().add(payway);
	}

	public void wayofpay() {
		payway.setText("Pay In Cash");
	}

	static public void show() {
		ReceiptGUICASH window = new ReceiptGUICASH();
		window.frmReceipt.setVisible(true);
	}

}
