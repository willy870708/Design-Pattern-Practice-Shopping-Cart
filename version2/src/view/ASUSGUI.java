package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.AccountCtl;
import controller.CartCtl;
import controller.ProductCtl;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ASUSGUI {

	private JFrame frmAsusgui;
	CartCtl cartCtl;
	AccountCtl accountctl;
	ProductCtl productctl;

	/**
	 * Launch the application.
	 */

	public void show() {
		ASUSGUI window = new ASUSGUI();
		window.frmAsusgui.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public ASUSGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAsusgui = new JFrame();
		frmAsusgui.setTitle("ASUSGUI");
		frmAsusgui.setBounds(100, 100, 725, 300);
		frmAsusgui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAsusgui.getContentPane().setLayout(null);
		accountctl = AccountCtl.getAccountCtl();
		cartCtl = CartCtl.getcartctl();
		productctl = ProductCtl.getproductctl();

		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("新細明體", Font.PLAIN, 20));
		spinner.setBounds(377, 63, 53, 26);
		final SpinnerModel model = new SpinnerNumberModel(0, 0, productctl.getasus1quantity(), 1);
		spinner.setModel(model);
		frmAsusgui.getContentPane().add(spinner);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		spinner_1.setBounds(377, 102, 53, 26);
		final SpinnerModel model1 = new SpinnerNumberModel(0, 0, productctl.getasus2quantity(), 1);
		spinner_1.setModel(model1);
		frmAsusgui.getContentPane().add(spinner_1);
		final ProductCtl productctl = ProductCtl.getproductctl();
		final JCheckBox product1 = new JCheckBox(productctl.getasus1message());
		product1.setFont(new Font("新細明體", Font.PLAIN, 20));
		product1.setBounds(74, 59, 272, 27);
		frmAsusgui.getContentPane().add(product1);
		product1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (productctl.getasus1().getQuantity() == 0) {
					JOptionPane.showMessageDialog(null, "zenfone5 is already empty,please choose another products!!");
					product1.setSelected(false);
				} else {
					product1.setText(
							productctl.getasus1addtocartmessage(Integer.parseInt(String.valueOf(model.getValue()))));
				}

			}
		});
		final JCheckBox product2 = new JCheckBox(productctl.getasus2message());
		product2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (productctl.getasus2().getQuantity() == 0) {
					JOptionPane.showMessageDialog(null, "zenfone5z is already empty,please choose another products!!");
					product2.setSelected(false);
				} else {
					product2.setText(
							productctl.getasus2addtocartmessage(Integer.parseInt(String.valueOf(model1.getValue()))));
				}

			}

		});
		product2.setFont(new Font("新細明體", Font.PLAIN, 20));
		product2.setBounds(74, 101, 262, 27);
		frmAsusgui.getContentPane().add(product2);

		JButton addtocart = new JButton("Add to Cart");
		addtocart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (accountctl.getstate() != false) {
					if (product1.isSelected()) {
						cartCtl.addtocart(productctl.getaddtocartasus1(), Integer.parseInt(String.valueOf(model.getValue())));
					}
					if (product2.isSelected()) {
						cartCtl.addtocart(productctl.getaddtocartasus2(), Integer.parseInt(String.valueOf(model1.getValue())));
					}
					JOptionPane.showMessageDialog(null, "Add sucessful!!");
					frmAsusgui.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "please log in!!");
					frmAsusgui.dispose();
				}
				frmAsusgui.dispose();
			}
		});
		addtocart.setBounds(206, 199, 99, 27);
		frmAsusgui.getContentPane().add(addtocart);

		final JLabel label = new JLabel("HELP");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setToolTipText(
						"This is AsusGUI, you need to select quantity and check the item, you can choose you want to add to Cart.");
			}
		});
		label.setForeground(Color.RED);
		label.setBounds(451, 203, 57, 19);
		frmAsusgui.getContentPane().add(label);

		JLabel lblNewLabel = new JLabel("Promotion: If you buy 100 zenfone5z, you'll get 15%discount!");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel.setBounds(51, 159, 457, 19);
		frmAsusgui.getContentPane().add(lblNewLabel);

		JLabel lblNameBrandPrice = new JLabel("Name    Brand  Price  Quantity");
		lblNameBrandPrice.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNameBrandPrice.setBounds(102, 29, 317, 19);
		frmAsusgui.getContentPane().add(lblNameBrandPrice);
		
		JButton button = new JButton("Subsribe");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(accountctl.getstate() != false){
					accountctl.subscribeasus1();
				}else{
					JOptionPane.showMessageDialog(null, "please log in!!");
				}
			}
		});
		button.setFont(new Font("新細明體", Font.PLAIN, 18));
		button.setBounds(453, 64, 99, 27);
		frmAsusgui.getContentPane().add(button);
		
		JButton button_1 = new JButton("Subsribe");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(accountctl.getstate() != false){
					accountctl.subscribeasus2();
				}else{
					JOptionPane.showMessageDialog(null, "please log in!!");
				}
			}
		});
		button_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		button_1.setBounds(453, 103, 99, 27);
		frmAsusgui.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Cancel");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accountctl.desubscribeasus1();
			}
		});
		button_2.setFont(new Font("新細明體", Font.PLAIN, 18));
		button_2.setBounds(566, 64, 99, 27);
		frmAsusgui.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Cancel");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accountctl.desubscribeasus2();
			}
		});
		button_3.setFont(new Font("新細明體", Font.PLAIN, 18));
		button_3.setBounds(566, 103, 99, 27);
		frmAsusgui.getContentPane().add(button_3);

	}
}
