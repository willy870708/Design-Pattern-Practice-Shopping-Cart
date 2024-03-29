package model;

import Composite.Component;

public class Product extends Component implements Cloneable {
	private int price;
	private String name;
	private String brand;
	private int quantity;
	private boolean state=false;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product(String name, String brand, int price, int quantity,boolean state) {
		this.price = price;
		this.name = name;
		this.brand = brand;
		this.quantity = quantity;
		this.state=state;
	}

	public int totalprice() {
		return getPrice() * getQuantity();
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	@Override
	public Object clone(){
		try {
			return super.clone();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
