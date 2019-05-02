package model;



public class ProductManager {
	static Product i7;
	static Product i8;
	static Product asus1;
	static Product asus2;
	static int i7quantity = 0;
	static int i8quantity = 200;
	static int asus1quantity = 300;
	static int asus2quantity = 250;
	static ProductManager productmanager;
	String message = "";

	static public Product getI7() {
		if(i7==null){
			i7 = new Product("iphone 7", "Apple", 28000, i7quantity ,false);
		}
		return i7;
	}

	static public Product getI8() {
		if(i8==null){
			i8 = new Product("iphone 8", "Apple", 32000, i8quantity,false);
		}
		return i8;
	}

	static public Product getAsus1() {
		if(asus1==null){
			asus1 = new Product("zenfone5 ", "ASUS", 9800, asus1quantity,false);
		}
		return asus1;
	}

	static public Product getAsus2() {
		if(asus2==null){
			asus2 = new Product("zenfone5z", "ASUS", 500, asus2quantity,false);
		}
		return asus2;
	}

	public static ProductManager getProductManager() {
		if (productmanager == null) {
			productmanager = new ProductManager();
		}
		return productmanager;
	}

	public String getmessage(Product product) {
		message = product.getName() + "   " + product.getBrand() + "   " + product.getPrice() + "    " + product.getQuantity();
		return message;

	}

	public Product productaddtocart(Product product,int quantity) {
		Product productclone = (Product)product.clone();
		productclone.setQuantity(quantity);
		return productclone;
	}

	public Product cartproduct(Product product,int quantity) {
		product.setState(true);
		Product buyproduct = new Product(product.getName(),product.getBrand(),product.getPrice(),quantity,product.isState());
		return buyproduct;
	}
	
	public void setallstate() {
		i7.setState(false);
		i8.setState(false);
		asus1.setState(false);
		asus2.setState(false);
	}
	
	public String getName(Product product){
		return product.getName();
	}
	
	public String getBrand(Product product){
		return product.getBrand();
	}
	
	public int getQuantity(Product product){
		return product.getQuantity();
	}
	
	public int getPrice(Product product){
		return product.getPrice();
	}
	
	public boolean getState(Product product){
		return product.isState();
	}
	
	public void seti7Quantity(Product product,int quantity){
		i7quantity = quantity;
		product.setQuantity(quantity);
	}
	public void seti8Quantity(Product product,int quantity){
		i8quantity = quantity;
		product.setQuantity(quantity);
	}
	public void setasus1Quantity(Product product,int quantity){
		asus1quantity = quantity;
		product.setQuantity(quantity);
	}
	public void setasus2Quantity(Product product,int quantity){
		asus2quantity = quantity;
		product.setQuantity(quantity);
	}
}
