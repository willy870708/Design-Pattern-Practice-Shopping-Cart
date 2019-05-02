package ChainofResponsibility;

import controller.*;

public abstract class Helper {
	Helper next;
	AccountCtl accountCtl = AccountCtl.getAccountCtl();
	CartCtl cartCtl = CartCtl.getcartctl();
	PayCtl payCtl = PayCtl.getPayCtl();
	String message = "";
	Helper(Helper next){
		this.next=next;
	}
	public abstract String help(int price);
	public void doNext(int price) {
		if(next != null) {
			next.help(price);
		}
	}
}
