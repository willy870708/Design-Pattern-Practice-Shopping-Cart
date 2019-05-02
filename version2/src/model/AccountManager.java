package model;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class AccountManager {
	private static AccountManager instance;
	private static boolean state = false;
	char[] rootpsw = { 'r', 'o', 'o', 't' };
	String rootacc = "root";
	boolean rootstate = true;
	boolean logstate = true;
	boolean describestate = false;
	private ArrayList<Account> accountlist = new ArrayList<Account>();

	private AccountManager() {
	}

	public static AccountManager getAccountManager() {
		if (instance == null) {
			instance = new AccountManager();
		}
		return instance;
	}

	public ArrayList<Account> getAccountlist() {
		return accountlist;
	}

	public void setAccountlist(ArrayList<Account> accountlist) {

		this.accountlist = accountlist;
	}

	public void registeraccount(Account account) {
		if (account.getPsw().length < 5) {
			JOptionPane.showMessageDialog(null,
					"Passward please more than 5 characters");
		} else {
			accountlist.add(account);
			JOptionPane.showMessageDialog(null, "Register Success");
		}
	}

	public Account loggin(String id, char[] psw) {
		for (Account a : accountlist) {
			if (a.getId().equals(id)) {
				if (Arrays.equals(a.getPsw(), psw)) {
					state = true;
					a.islogstate(true);
					return a;
				}

			}
		}
		state = false;
		return null;
	}

	public boolean accountstate() {
		return state;
	}

	public void setState() {
		state = false;
	}

}
