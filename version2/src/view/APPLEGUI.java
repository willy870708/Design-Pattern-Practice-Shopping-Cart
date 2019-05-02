package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.SpinnerModel;

import model.Account;
import model.Product;

import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

import controller.AccountCtl;
import controller.CartCtl;
import controller.ProductCtl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class APPLEGUI {

	private JFrame frmApplegui;
	CartCtl cartCtl;
	AccountCtl accountctl;
	ProductCtl productctl;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public APPLEGUI() {
		initialize();
	}

	public static void show() {
		APPLEGUI window = new APPLEGUI();
		window.frmApplegui.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmApplegui = new JFrame();
		frmApplegui.setTitle("AppleGUI");
		frmApplegui.setBounds(100, 100, 725, 300);
		frmApplegui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmApplegui.getContentPane().setLayout(null);
		accountctl = AccountCtl.getAccountCtl();
		cartCtl = CartCtl.getcartctl();
		productctl = ProductCtl.getproductctl();
		final JCheckBox product1 = new JCheckBox(productctl.geti7message());
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		spinner_1.setBounds(363, 88, 53, 26);
		frmApplegui.getContentPane().add(spinner_1);
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("新細明體", Font.PLAIN, 20));
		spinner.setBounds(363, 49, 53, 26);
		final SpinnerModel model1 = new SpinnerNumberModel(0, 0,
				productctl.geti7quantity(), 1);
		spinner.setModel(model1);
		final SpinnerModel model2 = new SpinnerNumberModel(0, 0,
				productctl.geti8quantity(), 1);
		spinner_1.setModel(model2);
		frmApplegui.getContentPane().add(spinner);
		product1.setFont(new Font("新細明體", Font.PLAIN, 20));
		product1.setBounds(61, 45, 277, 27);
		frmApplegui.getContentPane().add(product1);
		product1.setText(productctl.geti7message());
		final JCheckBox product2 = new JCheckBox(productctl.geti8message());
		product2.setText(productctl.geti8message());
		product2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (productctl.geti8().getQuantity() == 0) {
					JOptionPane
							.showMessageDialog(null,
									"I8 is already empty,please choose another products!!");
					product2.setSelected(false);
				} else if (accountctl.getstate() == false) {
					JOptionPane.showMessageDialog(null, "please log in!!");
					frmApplegui.dispose();
				} else {
					product2.setText(productctl.geti8addtocartmessage(Integer
							.parseInt(String.valueOf(model2.getValue()))));
				}

			}
		});
		product1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (productctl.geti7().getQuantity() == 0) {
					JOptionPane
							.showMessageDialog(null,
									"I7 is already empty,please choose another products!!");
					product1.setSelected(false);
				} 
				else if (accountctl.getstate() == false) {
					JOptionPane.showMessageDialog(null, "please log in!!");
					frmApplegui.dispose();
				}
				else {
					product1.setText(productctl.geti7addtocartmessage(Integer
							.parseInt(String.valueOf(model1.getValue()))));

				}

			}
		});
		product2.setFont(new Font("新細明體", Font.PLAIN, 20));
		product2.setBounds(61, 87, 277, 27);
		frmApplegui.getContentPane().add(product2);

		JButton btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (accountctl.getstate() != false) {
					if (product1.isSelected()) {
						cartCtl.addtocart(productctl.getaddtocarti7(),
								Integer.parseInt(String.valueOf(model1
										.getValue())));
					}
					if (product2.isSelected()) {
						cartCtl.addtocart(productctl.getaddtocarti8(),
								Integer.parseInt(String.valueOf(model2
										.getValue())));
					}
					JOptionPane.showMessageDialog(null, "Add sucessful!!");
					frmApplegui.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "please log in!!");
					frmApplegui.dispose();
				}
			}
		});
		btnAddToCart.setBounds(209, 161, 99, 27);
		frmApplegui.getContentPane().add(btnAddToCart);

		final JLabel label = new JLabel("HELP");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setToolTipText("This is AppleGUI, you need to select quantity and check the item, you can choose you want to add to Cart.");
			}
		});
		label.setForeground(Color.RED);
		label.setBounds(463, 191, 57, 19);
		frmApplegui.getContentPane().add(label);

		JLabel lblPromotionIfYou = new JLabel(
				"Promotion: If you buy i7 and i8 at the same time, you'll get 5%discount!");
		lblPromotionIfYou.setForeground(Color.RED);
		lblPromotionIfYou.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblPromotionIfYou.setBounds(31, 123, 544, 19);
		frmApplegui.getContentPane().add(lblPromotionIfYou);

		JLabel lblNewLabel = new JLabel("Name     Brand   Price Quantity");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel.setBounds(81, 17, 317, 19);
		frmApplegui.getContentPane().add(lblNewLabel);

		JButton btnSubsribe = new JButton("Subsribe");
		btnSubsribe.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnSubsribe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (accountctl.getstate() != false) {
					accountctl.subscribei7();
				} else {
					JOptionPane.showMessageDialog(null, "please log in!!");
				}
			}
		});
		btnSubsribe.setBounds(439, 50, 99, 27);
		frmApplegui.getContentPane().add(btnSubsribe);

		JButton button = new JButton("Subsribe");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (accountctl.getstate() != false) {
					accountctl.subscribei8();
				} else {
					JOptionPane.showMessageDialog(null, "please log in!!");
				}
			}
		});
		button.setFont(new Font("新細明體", Font.PLAIN, 18));
		button.setBounds(439, 88, 99, 27);
		frmApplegui.getContentPane().add(button);

		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accountctl.desubscribei7();
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnNewButton.setBounds(562, 50, 99, 27);
		frmApplegui.getContentPane().add(btnNewButton);

		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accountctl.desubscribei8();
			}
		});
		button_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		button_1.setBounds(562, 89, 99, 27);
		frmApplegui.getContentPane().add(button_1);
	}
}
