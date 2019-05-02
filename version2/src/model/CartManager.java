package model;

public class CartManager {
	private static CartManager cartManager = null;
	public static CartManager getcartmanager() {
		if(cartManager == null) {
			cartManager = new CartManager();
		}
		return cartManager;
	}
public Product cartproduct(Product product,int quantity) {
	product.setState(true);
	Product buyproduct = new Product(product.getName(),product.getBrand(),product.getPrice(),quantity,product.isState());
	return buyproduct;
}

}
