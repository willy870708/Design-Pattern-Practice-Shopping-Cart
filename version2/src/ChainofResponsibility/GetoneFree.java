package ChainofResponsibility;
import java.util.Date;
import controller.ProductCtl;

public class GetoneFree extends Helper {
	ProductCtl productCtl = ProductCtl.getproductctl();
	Date date = new Date();
	double discountprice = 0;

	public GetoneFree(Helper next) {
		super(next);
		// TODO Auto-generated constructor stub
	}

	public String help(int price) {
		int after = price;
		if (date.getMonth() == 10) {
			if (date.getDate() == 10) {
				if (productCtl.getasus1quantity() >= 2) {
					cartCtl.addtocart(productCtl.getasus2(), 1);
					after = price - after;
					message += "you buy zenfone5 on holidaay,"+"\n"+" get a zenfone5z free, after discount:" + after + "\n";
					payCtl.setprice(message);
				}
			}
		}
		doNext(after);
		return message;
	}
}
