package Memento;

import model.Product;

public class Orignator {
	public Product product;

	public void set(Product product) {
		this.product = product;
	}

	public Memento saveToMemento() {
		return new Memento(product);
	}

	public void restoreFromeMemento(Memento memento) {
		product = memento.getProduct();
	}
}
