package Protype;
import model.*;
public class ProductClone{
	static Product product;
	private void setproduct(Product product) {
		this.product = product;
	}
	public static Product getproductclone() throws CloneNotSupportedException{
		return (Product)product.clone();
	}
}
