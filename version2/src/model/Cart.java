package model;

import java.util.*;


public class Cart {
	private static Cart cart ;
	Product momento;
	ArrayList<Product> productlist = new ArrayList<Product>();

	public ArrayList<Product> getProductlist() {
		return productlist;
	}
	public void setProductlist(ArrayList<Product> productlist) {
		this.productlist = productlist;
	}
	public void addcart(Product product) {
		productlist.add(product);
	}
	public static Cart getcart() {
		if(cart == null) {
			cart = new Cart();
		}
		return cart;
	}
	public void delproduct(int index) {
		momento = productlist.get(index);
		productlist.remove(index);
	}
}
