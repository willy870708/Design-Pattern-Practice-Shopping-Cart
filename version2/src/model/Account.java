package model;


import javax.swing.JOptionPane;

public class Account {
	private String id;
	private char[] psw;
	boolean rootstate = false;
	boolean logstate = false;
	boolean describestate = false;
	Cart cart;

	public Account(String id, char[] psw, boolean rootstate, boolean logstate,
			boolean describestate) {
		this.id = id;
		this.psw = psw;
		rootstate = false;
		logstate = false;
		describestate = false;
		cart = new Cart();
	}

	public boolean getrootstate() {
		return rootstate;
	}

	public void isrootstate(boolean state) {
		rootstate = state;
	}

	public void islogstate(boolean state) {
		logstate = state;
	}

	public boolean getlogstate() {
		return logstate;
	}

	public boolean getdescribestate() {
		return describestate;
	}

	public void isdescribestate(boolean state) {
		describestate = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public char[] getPsw() {
		return psw;
	}

	public void setPsw(char[] psw) {
		this.psw = psw;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void update() {
		JOptionPane.showMessageDialog(null,
					"The products that you subscribe have stored!!");
	}

	public Account getAccount() {
		return this;
	}
}
