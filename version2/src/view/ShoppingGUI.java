package view;

import view.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.omg.CORBA.PUBLIC_MEMBER;
import Command.*;
import controller.AccountCtl;
import model.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShoppingGUI extends JFrame {

	private JPanel contentPane;
	private AccountCtl accountctl;
	Invoker invoker = new Invoker();
	Order order = new Order();
	Command clearOrder = new ClearOrder(order);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingGUI frame = new ShoppingGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShoppingGUI() {
		accountctl = AccountCtl.getAccountCtl();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 631, 412);
		contentPane = new JPanel();
		final JLabel lblLogState = new JLabel("Account state");
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (accountctl.getstate() == true) {
					lblLogState.setText("Hello!! "
							+ accountctl.getaccount().getId());
				} else {
					lblLogState.setText("Log out!");
				}
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblLogState.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {

			}
		});
		lblLogState.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblLogState.setBounds(334, 97, 158, 19);
		contentPane.add(lblLogState);
		JLabel lblWelcomeToShop = new JLabel("Welcome To Shop");
		lblWelcomeToShop.setFont(new Font("新細明體", Font.PLAIN, 38));
		lblWelcomeToShop.setBounds(132, 0, 315, 92);
		contentPane.add(lblWelcomeToShop);

		JButton btnLogin = new JButton("Log in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (accountctl.getstate() == true) {
					JOptionPane.showMessageDialog(null, "Already log in !!!");
				} else {
					LoginGUI window = new LoginGUI();
					window.show();
					if (accountctl.getstate() == true) {
						lblLogState.setText("Hello!! "
								+ accountctl.getaccount().getId());
					} else {
						lblLogState.setText("Log out!");
					}
				}

			}
		});
		btnLogin.setBounds(105, 94, 99, 27);
		contentPane.add(btnLogin);
		final JComboBox choosebrand = new JComboBox();
		choosebrand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (choosebrand.getSelectedIndex() == 0) {
					APPLEGUI window = new APPLEGUI();
					window.show();
				} else if (choosebrand.getSelectedIndex() == 1) {
					ASUSGUI window = new ASUSGUI();
					window.show();
				}
			}
		});
		choosebrand.setModel(new DefaultComboBoxModel(new String[] { "APPLE",
				"ASUS" }));
		contentPane.add(choosebrand);
		choosebrand.setBounds(211, 179, 79, 25);
		choosebrand.setSelectedIndex(-1);

		JLabel lblNewLabel = new JLabel("Choose brand");
		lblNewLabel.setBounds(122, 182, 99, 19);
		contentPane.add(lblNewLabel);

		final JLabel lblNewLabel_1 = new JLabel("HELP");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1
						.setToolTipText("This is home page of shopping GUI."
								+ "\n"
								+ "You can log in or choose your favorite brand to view");
			}
		});
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(463, 235, 57, 19);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("My Cart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (accountctl.getstate() == false) {
					JOptionPane.showMessageDialog(null, "Please log in!!");
				} else {
					CartGUI.show();
				}

			}
		});
		btnNewButton.setBounds(298, 178, 99, 27);
		contentPane.add(btnNewButton);

		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accountctl.logout();
				lblLogState.setText("Log out!");
			}
		});
		btnLogOut.setBounds(218, 94, 99, 27);
		contentPane.add(btnLogOut);

		JLabel lblPromotionIfYou = new JLabel(
				"Promotion: If you buy 10,000 dollars, you'll get 20%discount!");
		lblPromotionIfYou.setForeground(Color.RED);
		lblPromotionIfYou.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblPromotionIfYou.setBounds(76, 274, 464, 19);
		contentPane.add(lblPromotionIfYou);

		JButton btnNewButton_1 = new JButton("Clear Order");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (accountctl.getstate() == false) {
					JOptionPane.showMessageDialog(null, "Please log in!!");
				} else {
					invoker.setCommand(clearOrder);
					invoker.doClear();
				}
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		btnNewButton_1.setBounds(458, 87, 141, 40);
		contentPane.add(btnNewButton_1);
	}
}
