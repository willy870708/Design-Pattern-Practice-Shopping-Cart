package ChainofResponsibility;

import controller.AccountCtl;
import controller.ProductCtl;

public class Get5Dicount extends Helper {
	double discountprice = 0;
	ProductCtl productCtl = ProductCtl.getproductctl();
	AccountCtl accountCtl = AccountCtl.getAccountCtl();

	public Get5Dicount(Helper next) {
		super(next);
		// TODO Auto-generated constructor stub
	}

	public String help(int price) {
		int after = price;
		if (productCtl.geti7().isState() == true && productCtl.geti8().isState() == true) {
			discountprice = Math.floor(price * 0.05);
			after = (int) discountprice;
			after = price-after;
			message += "you buy i7 and i8, get 5% discount,"+"\n"+"after discount:" + after + "\n";
			payCtl.setprice(message);
		}
		doNext(after);
		return message;
	}
}
