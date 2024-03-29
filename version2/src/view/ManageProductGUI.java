package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Font;

import javax.swing.JSpinner;
import javax.swing.JButton;

import controller.ProductCtl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageProductGUI {

	private JFrame frmManageproductgui;
	ProductCtl productctl;
	/**
	 * Launch the application.
	 */
	public static void show() {
		ManageProductGUI window = new ManageProductGUI();
		window.frmManageproductgui.setVisible(true);
	}


	/**
	 * Create the application.
	 */
	public ManageProductGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManageproductgui = new JFrame();
		frmManageproductgui.setTitle("ManageProductGUI");
		frmManageproductgui.setBounds(100, 100, 450, 357);
		frmManageproductgui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmManageproductgui.getContentPane().setLayout(null);
		productctl=ProductCtl.getproductctl();
		final JCheckBox i7text = new JCheckBox("iphone 7   Apple   28000    200");
		
		i7text.setFont(new Font("新細明體", Font.PLAIN, 20));
		i7text.setBounds(34, 44, 277, 27);
		i7text.setText(productctl.geti7message());
		frmManageproductgui.getContentPane().add(i7text);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("新細明體", Font.PLAIN, 20));
		spinner.setBounds(336, 48, 53, 26);
		frmManageproductgui.getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		spinner_1.setBounds(336, 87, 53, 26);
		frmManageproductgui.getContentPane().add(spinner_1);
		
		final JCheckBox i8text = new JCheckBox("iphone 8   Apple   32000    150");

		i8text.setFont(new Font("新細明體", Font.PLAIN, 20));
		i8text.setBounds(34, 86, 277, 27);
		i8text.setText(productctl.geti8message());
		frmManageproductgui.getContentPane().add(i8text);
		
		final JCheckBox asus1 = new JCheckBox("zenfone5    ASUS   9800    300");

		asus1.setFont(new Font("新細明體", Font.PLAIN, 20));
		asus1.setBounds(33, 133, 272, 27);
		frmManageproductgui.getContentPane().add(asus1);
		asus1.setText(productctl.getasus1message());
		final JCheckBox asus2 = new JCheckBox("zenfone5z   ASUS   500    250");

		asus2.setFont(new Font("新細明體", Font.PLAIN, 20));
		asus2.setBounds(33, 175, 262, 27);
		asus2.setText(productctl.getasus2message());
		frmManageproductgui.getContentPane().add(asus2);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setFont(new Font("新細明體", Font.PLAIN, 20));
		spinner_2.setBounds(336, 137, 53, 26);
		frmManageproductgui.getContentPane().add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setFont(new Font("新細明體", Font.PLAIN, 20));
		spinner_3.setBounds(336, 176, 53, 26);
		frmManageproductgui.getContentPane().add(spinner_3);
		
		final SpinnerModel model = new SpinnerNumberModel(0, 0, null, 1);
		spinner.setModel(model);
		final SpinnerModel model1 = new SpinnerNumberModel(0, 0, null, 1);
		spinner_1.setModel(model1);
		final SpinnerModel model2 = new SpinnerNumberModel(0, 0, null, 1);
		spinner_2.setModel(model2);
		final SpinnerModel model3 = new SpinnerNumberModel(0, 0, null, 1);
		spinner_3.setModel(model3);
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(288, 240, 99, 27);
		frmManageproductgui.getContentPane().add(btnConfirm);
		i7text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productctl.seti7quantity(Integer.parseInt(String.valueOf(model.getValue())));
				System.out.println(Integer.parseInt(String.valueOf(model.getValue())));
				i7text.setText(productctl.geti7addtocartmessage(Integer.parseInt(String.valueOf(model.getValue()))));
			}
		});
		
		i8text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				i8text.setText(productctl.geti8addtocartmessage(Integer.parseInt(String.valueOf(model1.getValue()))));
			}
		});
		
		asus1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				asus1.setText(productctl.getasus1addtocartmessage(Integer.parseInt(String.valueOf(model2.getValue()))));
			}
		});
		
		asus2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				asus2.setText(productctl.getasus2addtocartmessage(Integer.parseInt(String.valueOf(model3.getValue()))));
			}
		});
		
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productctl.seti7quantity(Integer.parseInt(String.valueOf(model.getValue())));
				productctl.seti8quantity(Integer.parseInt(String.valueOf(model1.getValue())));
				productctl.setasus1quantity(Integer.parseInt(String.valueOf(model2.getValue())));
				productctl.setasus2quantity(Integer.parseInt(String.valueOf(model3.getValue())));
				productctl.i7notify();
				frmManageproductgui.dispose();
			}
		});
	}
}
