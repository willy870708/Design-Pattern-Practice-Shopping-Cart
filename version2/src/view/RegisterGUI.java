package view;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controller.*;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RegisterGUI {

	private JFrame frmRegistergui;
	private JTextField textid;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldagain;
	private AccountCtl accountctl;
	/**
	 * Launch the application.
	 */
	
	public void show() {
		RegisterGUI window = new RegisterGUI();
		window.frmRegistergui.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public RegisterGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 accountctl = AccountCtl.getAccountCtl();
		
		frmRegistergui = new JFrame();
		frmRegistergui.setTitle("RegisterGUI");
		frmRegistergui.setBounds(100, 100, 450, 300);
		frmRegistergui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegistergui.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Input ID");
		label.setFont(new Font("新細明體", Font.PLAIN, 20));
		label.setBounds(43, 29, 87, 47);
		frmRegistergui.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Input PSW");
		label_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_1.setBounds(43, 89, 87, 47);
		frmRegistergui.getContentPane().add(label_1);
		
		textid = new JTextField();
		textid.setColumns(10);
		textid.setBounds(188, 42, 116, 25);
		frmRegistergui.getContentPane().add(textid);
		passwordField = new JPasswordField();
		passwordField.setBounds(188, 102, 116, 25);
		frmRegistergui.getContentPane().add(passwordField);
		
		JLabel lblInputPswAgain = new JLabel("Input PSW again");
		lblInputPswAgain.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblInputPswAgain.setBounds(43, 149, 144, 47);
		frmRegistergui.getContentPane().add(lblInputPswAgain);
		
		passwordFieldagain = new JPasswordField();
		passwordFieldagain.setBounds(188, 161, 116, 25);
		frmRegistergui.getContentPane().add(passwordFieldagain);
		
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Arrays.equals(passwordField.getPassword(),passwordFieldagain.getPassword())) {
					accountctl.register(textid.getText(),passwordField.getPassword());
					
				}
				else {
					JOptionPane.showMessageDialog(null, "password inconsistent!! Please input again");
				}
				
				frmRegistergui.dispose();
			}
			
		});
		confirm.setBounds(319, 161, 99, 27);
		frmRegistergui.getContentPane().add(confirm);
		
		JLabel lblNewLabel = new JLabel("Passward please more than 5 characters!!");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel.setBounds(43, 209, 365, 19);
		frmRegistergui.getContentPane().add(lblNewLabel);
	}

	public String getTextid() {
		return textid.getText();
	}

	public char[] getPasswordField() {
		return passwordField.getPassword();
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JPasswordField getPasswordFieldagain() {
		return passwordFieldagain;
	}

	public void setPasswordFieldagain(JPasswordField passwordFieldagain) {
		this.passwordFieldagain = passwordFieldagain;
	}
}
