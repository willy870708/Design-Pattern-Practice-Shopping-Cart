package controller;

import Observer.Observableasus1;
import Observer.Observableasus2;
import Observer.Observablei7;
import Observer.Observablei8;
import model.*;

public class ProductCtl {
	private static ProductCtl productctl;
	private ProductManager productmanager= ProductManager.getProductManager();
	Product i7=ProductManager.getI7();
	Product i8=ProductManager.getI8();
	Product asus1=ProductManager.getAsus1();
	Product asus2=ProductManager.getAsus2();
	Product addtoproducti7;
	Product addtoproducti8;
	Product addtoproductasus1;
	Product addtoproductasus2;
	Cart cart = Cart.getcart();
	Observableasus1 obasus1 = new Observableasus1();
	Observablei7 obi7 = new Observablei7();
	Observableasus2 obasus2 = new Observableasus2();
	Observablei8 obi8 = new Observablei8();
	public static ProductCtl getproductctl() {
		if (productctl == null) {
			productctl = new ProductCtl();
		}
		return productctl;
	}
	public String geti7message() {		
		return productmanager.getmessage(i7);
	}
	public int geti7quantity() {
		return productmanager.getQuantity(i7);
	}
	
	public String geti8message() {		
		return productmanager.getmessage(i8);
	}
	public int geti8quantity() {
		return productmanager.getQuantity(i8);
	}
	
	public String getasus1message() {		
		return productmanager.getmessage(asus1);
	}
	public int getasus1quantity() {
		return productmanager.getQuantity(asus1);
	}
	
	public String getasus2message() {		
		return productmanager.getmessage(asus2);
	}
	public int getasus2quantity() {
		return productmanager.getQuantity(asus2);
	}
	
	public Product productaddtocart(Product product,int quantity){
		return productmanager.productaddtocart(product,quantity);
	}
	public Product getaddtocarti7(){
		return addtoproducti7;
	}
	public Product getaddtocarti8(){
		return addtoproducti8;
	}
	public Product getaddtocartasus1(){
		return addtoproductasus1;
	}
	public Product getaddtocartasus2(){
		return addtoproductasus2;
	}
	public String geti7addtocartmessage(int quantity){
		addtoproducti7 = productaddtocart(i7,quantity);
		return productmanager.getmessage(productaddtocart(i7,quantity));
	}
	
	public String geti8addtocartmessage(int quantity){
		addtoproducti8 = productaddtocart(i8,quantity);
		return productmanager.getmessage(productaddtocart(i8,quantity));
	}
	
	public String getasus1addtocartmessage(int quantity){
		addtoproductasus1 = productaddtocart(asus1,quantity);
		return productmanager.getmessage(productaddtocart(asus1,quantity));
	}
	public String getasus2addtocartmessage(int quantity){
		addtoproductasus2 = productaddtocart(asus2,quantity);
		return productmanager.getmessage(productaddtocart(asus2,quantity));
	}
	public void seti7quantity(int quantity) {
		productmanager.seti7Quantity(i7,quantity);
	}
	
	public void seti8quantity(int quantity) {
		productmanager.seti8Quantity(i8,quantity);
	}
	
	public void setasus1quantity(int quantity) {
		productmanager.setasus1Quantity(asus1,quantity);
	}
	
	public void setasus2quantity(int quantity) {
		productmanager.setasus2Quantity(asus2,quantity);
	}
//	public String modifyasus2quantity(int quantity) {
//		return productmanager.modifymessage(asus2,quantity);
//	}
	public Product geti7(){
		return productmanager.getI7();
	}
	
	public Product geti8(){
		return productmanager.getI8();
	}
	
	public Product getasus1(){
		return productmanager.getAsus1();
	}
	
	public Product getasus2(){
		return productmanager.getAsus2();
	}
	public Product getaddtocarti7(int quantity) {
		return productmanager.cartproduct(i7,quantity);
	}
	public Product getaddtocarti8(int quantity) {
		return productmanager.cartproduct(i8,quantity);
	}
	public Product getaddtocartasus1(int quantity) {
		return productmanager.cartproduct(asus1,quantity);
	}
	public Product getaddtocartasus2(int quantity) {
		return productmanager.cartproduct(asus2,quantity);
	}
	public void setallstate() {
		productmanager.setallstate();
	}
	public boolean i7notify(){
		if(i7.getQuantity()>0){
			obi7.noftfyObsevers();
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean i8notify(){
		if(i8.getQuantity()>0){
			obi8.noftfyObsevers();
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean asus1notify(){
		if(asus1.getQuantity()>0){
			obasus1.noftfyObsevers();
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean asus2notify(){
		if(asus2.getQuantity()>0){
			obasus2.noftfyObsevers();
			return true;
		}
		else{
			return false;
		}
	}
}