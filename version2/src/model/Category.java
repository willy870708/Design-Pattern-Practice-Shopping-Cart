package model;

import java.util.ArrayList;

import Composite.Component;

public class Category extends Component{
	public Product p;
	public ArrayList<Product> product;
	public ArrayList<Component> components = new ArrayList<Component>();
	
	public void add(Component p){
		components.add(p);
	}
	public void remove(Product p){
		components.remove(p);
	}
	public Component getChild(int index){
		for(Component c : components){
			if(c.getid()==index){
				return c;
			}
		}
		return null;
	}
}
