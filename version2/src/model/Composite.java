package model;

import java.util.ArrayList;
import java.util.TreeMap;

import Composite.Component;

public class Composite extends Component{
	public Category c;
	public ArrayList<Category> list = new ArrayList<Category>();
	public TreeMap<Integer, Component> components = new TreeMap<Integer,Component>();
	public void add(Component c){
		components.put(c.getid(),c);
	}
	public void remove(Product p){
		components.remove(p);
	}
	public Component getChild(int index){
		return components.get(index);
	}
}
