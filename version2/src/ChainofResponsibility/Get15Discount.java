package ChainofResponsibility;

import controller.ProductCtl;
import model.Product;

public class Get15Discount extends Helper {
	ProductCtl productCtl = ProductCtl.getproductctl();
	double discountprice=0;
	public Get15Discount(Helper next) {
		super(next);
		// TODO Auto-generated constructor stub
	}

	public String help(int price) {
		int after = price;
		int quantity=0;
		for(Product a :accountCtl.getcart().getProductlist()) {
			if(a.getName().equalsIgnoreCase("zenfone5z")) {
				quantity = a.getQuantity();
			}
		}
		if(quantity>=100) {
			discountprice = Math.floor(price*0.15);
			after = (int) discountprice;
			after = price-after;
			message = "you buy 100 zenfone5z,"+"\n"+"get 15% discount, after discount:" + after+"\n";
			payCtl.setprice(message);
		}
			doNext(after);
			return message;
	}
	public String getdiscount() {
		return message;
	}
}
