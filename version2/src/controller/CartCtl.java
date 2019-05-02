package controller;

import java.util.ArrayList;
import model.*;

public class CartCtl {
	Cart cart = Cart.getcart();
	CartManager cartManager = CartManager.getcartmanager();
	AccountCtl accountCtl = AccountCtl.getAccountCtl();
	static CartCtl cartctl;
	ProductCtl productCtl = ProductCtl.getproductctl();

	public CartCtl() {
		super();
	}

	public static CartCtl getcartctl() {
		if (cartctl == null) {
			cartctl = new CartCtl();
		}
		return cartctl;
	}

	public ArrayList<Product> getproductlist() {
		return cart.getProductlist();
	}

	public void addtocart(Product product,int quantity) {
		if(product.isState()==true) {
			for(Product a : accountCtl.getcart().getProductlist()) {
				if(product.getName().equalsIgnoreCase(a.getName())) {
					a.setQuantity(quantity);
				}
			}
		}else {
			accountCtl.getcart().addcart(cartManager.cartproduct(product, quantity));
		}
		
	}

	public void delproduct(int index) {
		accountCtl.getcart().getProductlist().get(index).setState(false);
		cart.delproduct(index);
	}

	public int getprice(ArrayList<Product> productlist) {
		int totalprice = 0;
		for (Product a : productlist) {
			totalprice += a.totalprice();
		}
		return totalprice;
	}
	public Product getProduct(int index) {
		return cartctl.getproductlist().get(index);
	}
}
