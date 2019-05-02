package ChainofResponsibility;
import controller.ProductCtl;

public class Get20Discount extends Helper {
	ProductCtl productCtl = ProductCtl.getproductctl();
	double discountprice = 0;

	public Get20Discount(Helper next) {
		super(next);
		// TODO Auto-generated constructor stub
	}

	public String help(int price) {
		int after = price;
		if (price > 100000) {
			discountprice = Math.floor(price * 0.2);
			after = (int) discountprice;
			after = price-after;
			message +=  "you buy more than 10,000 dollars, so you get 20% discount,"+"\n"+ "get 20% discount, after discount:" + after+"\n";
			payCtl.setprice(message);
		}
		doNext(after);
		return message;
	}
}
