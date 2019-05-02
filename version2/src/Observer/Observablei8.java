package Observer;


import javax.swing.JOptionPane;

import Iterator.AccountAggregate;
import Iterator.ITerator;
import model.Account;

public class Observablei8 implements Observableinterface {
	AccountAggregate aa = new AccountAggregate(100);
	ITerator iterator = aa.iterator();

	public void addtoobservable(Account account) {
		aa.appendAccount(account);
	}

	public void remove(Account account) {
		if (aa.getLength() != 0) {
			aa.remove(account);
			JOptionPane.showMessageDialog(null, "Already cancel subscribe!!");
		} else {
			JOptionPane.showMessageDialog(null,
					"you have not subscribed this product!!");
		}
	}

	public void noftfyObsevers() {
		while(iterator.hasNext()){
			Account a = (Account)iterator.next();
			a.update();
		}
	}
}
