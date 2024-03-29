package controller;


import javax.swing.JOptionPane;
import Observer.*;
import model.*;

public class AccountCtl {
	private AccountManager accountManager = AccountManager.getAccountManager();
	private static AccountCtl accountctl;
	public Account account;
	ProductCtl productCtl = ProductCtl.getproductctl();
	Observableasus1 asus1 = new Observableasus1();
	Observablei7 obi7 = new Observablei7();
	Observableasus2 asus2 = new Observableasus2();
	Observablei8 obi8 = new Observablei8();

	private AccountCtl() {
	}

	public static AccountCtl getAccountCtl() {
		if (accountctl == null) {
			accountctl = new AccountCtl();
		}
		return accountctl;
	}

	public void register(String id, char[] psw) {
		Account account = new Account(id, psw, false, false, false);
		accountManager.registeraccount(account);

	}

	public void login(String id, char[] psw) {
		if (accountManager.getAccountlist().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"fisrt log in, please register!!");
		} else if (accountManager.loggin(id, psw) != null) {
			JOptionPane.showMessageDialog(null, "log in successful!!");
			account = accountManager.loggin(id, psw);
			if (account.getdescribestate() == true
					&& (productCtl.i7notify() == true || productCtl.i8notify() == true
					|| productCtl.asus1notify() == true
					|| productCtl.asus2notify() == true)) {
				account.update();
			}
		} else {
			JOptionPane.showMessageDialog(null, "log in fail!!");
		}
	}

	public String getid() {
		return account.getId();
	}

	public void logout() {
		accountManager.setState();
	}

	public Account getaccount() {
		return account;
	}

	public boolean getstate() {
		return accountManager.accountstate();
	}

	public Cart getcart() {
		return account.getCart();
	}

	public void subscribei7() {
		obi7.addtoobservable(account.getAccount());
		account.isdescribestate(true);
		JOptionPane.showMessageDialog(null, "Subscribe sucessful!!");
	}

	public void subscribei8() {
		obi8.addtoobservable(account.getAccount());
		account.isdescribestate(true);
		JOptionPane.showMessageDialog(null, "Subscribe sucessful!!");
	}

	public void subscribeasus1() {
		asus1.addtoobservable(account.getAccount());
		account.isdescribestate(true);
		JOptionPane.showMessageDialog(null, "Subscribe sucessful!!");
	}

	public void subscribeasus2() {
		asus2.addtoobservable(account.getAccount());
		account.isdescribestate(true);
		JOptionPane.showMessageDialog(null, "Subscribe sucessful!!");
	}

	public void desubscribei7() {
		obi7.remove(account);
		account.isdescribestate(false);
	}

	public void desubscribei8() {
		obi8.remove(account);
		account.isdescribestate(false);
	}

	public void desubscribeasus1() {
		asus1.remove(account);
		account.isdescribestate(false);
	}

	public void desubscribeasus2() {
		asus2.remove(account);
		account.isdescribestate(false);
	}
}
