package Memento;

import model.*;

public class Memento {
	Product product;

	public Memento(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}
}
