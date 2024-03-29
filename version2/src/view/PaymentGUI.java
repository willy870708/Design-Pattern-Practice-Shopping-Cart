package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import ChainofResponsibility.Get15Discount;
import ChainofResponsibility.Get20Discount;
import ChainofResponsibility.Get5Dicount;
import ChainofResponsibility.GetoneFree;
import ChainofResponsibility.Helper;
import controller.AccountCtl;
import controller.CartCtl;
import controller.PayCtl;
import controller.ProductCtl;
import model.Product;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Color;

public class PaymentGUI {

	private JFrame frmPaymentgui;
	CartCtl cartCtl;
	AccountCtl accountctl;
	ProductCtl productctl;
	PayCtl payCtl = PayCtl.getPayCtl();
	String text = "";
	int quantity;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public PaymentGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPaymentgui = new JFrame();
		frmPaymentgui.setTitle("Check List");
		frmPaymentgui.setBounds(100, 100, 450, 462);
		frmPaymentgui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPaymentgui.getContentPane().setLayout(null);
		accountctl = AccountCtl.getAccountCtl();
		cartCtl = CartCtl.getcartctl();
		productctl = ProductCtl.getproductctl();
		int position = 25;
		int y = 20;
		for (Product a : accountctl.getcart().getProductlist()) {

			JLabel lblNewLabel = new JLabel(a.getName() + "   " + a.getBrand()
					+ "    " + a.getPrice() + "    " + a.getQuantity());
			lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
			y += 20;
			lblNewLabel.setBounds(80, position + y, 300, 19);
			frmPaymentgui.getContentPane().add(lblNewLabel);
		}
		JButton btnNewButton = new JButton("In Cash");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payCtl.miniusquantity();
				Helper help = new GetoneFree(new Get15Discount(
						new Get20Discount(new Get5Dicount(null))));
				payCtl.discount(help);
				productctl.setallstate();
				JOptionPane.showMessageDialog(null, "Pay successfully!!!");
				frmPaymentgui.dispose();
				ReceiptGUICASH.show();
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnNewButton.setBounds(166, 290, 145, 27);
		frmPaymentgui.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Name      Brand     Price  Quantity");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(58, 39, 300, 19);
		frmPaymentgui.getContentPane().add(lblNewLabel_1);

		JLabel label = new JLabel("HELP");
		label.setForeground(Color.RED);
		label.setBounds(361, 380, 57, 19);
		frmPaymentgui.getContentPane().add(label);

		JLabel lblNewLabel_2 = new JLabel("Check List");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 24));
		lblNewLabel_2.setBounds(141, 13, 145, 19);
		frmPaymentgui.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("choose way to pay");
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(14, 334, 152, 19);
		frmPaymentgui.getContentPane().add(lblNewLabel_3);

		JButton btnCreditCard = new JButton("Credit Card");
		btnCreditCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				payCtl.miniusquantity();
				Helper help = new GetoneFree(new Get15Discount(
						new Get20Discount(new Get5Dicount(null))));
				payCtl.discount(help);
				productctl.setallstate();
				JOptionPane.showMessageDialog(null, "Pay successfully!!!");
				frmPaymentgui.dispose();
				frmPaymentgui.dispose();
				ReceiptGUICreditcard.show();
			}
		});
		btnCreditCard.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnCreditCard.setBounds(166, 330, 145, 27);
		frmPaymentgui.getContentPane().add(btnCreditCard);

		JButton Online = new JButton("Online");
		Online.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				payCtl.miniusquantity();
				Helper help = new GetoneFree(new Get15Discount(
						new Get20Discount(new Get5Dicount(null))));
				payCtl.discount(help);
				productctl.setallstate();
				JOptionPane.showMessageDialog(null, "Pay successfully!!!");
				frmPaymentgui.dispose();
				frmPaymentgui.dispose();
				ReceiptGUIOnline.show();
			}
		});
		Online.setFont(new Font("新細明體", Font.PLAIN, 20));
		Online.setBounds(166, 375, 145, 27);
		frmPaymentgui.getContentPane().add(Online);

	}

	public void show() {
		PaymentGUI window = new PaymentGUI();
		window.frmPaymentgui.setVisible(true);
	}
}
