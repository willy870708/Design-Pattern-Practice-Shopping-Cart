package controller;
import model.Product;
import ChainofResponsibility.*;
public class PayCtl {
	static PayCtl payCtl;
	ProductCtl productctl = ProductCtl.getproductctl();
	AccountCtl accountctl = AccountCtl.getAccountCtl();
	CartCtl cartCtl = CartCtl.getcartctl();
	int quantity;
	int price = cartCtl.getprice(accountctl.getcart().getProductlist());
	String totalmessage="";
	public void miniusquantity() {
		for (Product a : accountctl.getcart().getProductlist()) {
			if (a.getName().equals(productctl.geti7().getName())) {
				quantity = productctl.geti7().getQuantity();
				quantity = productctl.geti7().getQuantity() - a.getQuantity();
				productctl.geti7().setQuantity(quantity);
			} else if (a.getName().equals(productctl.geti8().getName())) {
				quantity = productctl.geti8().getQuantity();
				quantity = productctl.geti8().getQuantity() - a.getQuantity();
				productctl.geti8().setQuantity(quantity);
			} else if (a.getName().equals(productctl.getasus1().getName())) {
				quantity = productctl.getasus1().getQuantity();
				quantity = productctl.getasus1().getQuantity() - a.getQuantity();
				productctl.getasus1().setQuantity(quantity);
			} else if (a.getName().equals(productctl.getasus2().getName())) {
				quantity = productctl.getasus2().getQuantity();
				quantity = productctl.getasus2().getQuantity() - a.getQuantity();
				productctl.getasus2().setQuantity(quantity);
			}
		}
	}
	public static PayCtl getPayCtl() {
		if (payCtl == null) {
			payCtl = new PayCtl();
		}
		return payCtl;
	}
	public void setprice(String message) {
		totalmessage += message;
	}
	public String getprice() {
		return totalmessage;
	}
	public void discount(Helper help) {
		help.doNext(price);
	}
	public void clearmessage() {
		totalmessage="";
	}
}
