package collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entities.BackOrder;

public class BackOrderList implements Iterable<BackOrder>, Serializable {
	private static final long serialVersionUID = 1L;
	private List<BackOrder> backOrders =  new ArrayList<>();
	public static BackOrderList backOrderList;
	
	public BackOrderList() {
	}
	
	public static BackOrderList getInstance() {
		if(backOrderList == null) {
			backOrderList = new BackOrderList() ;
		}
		return backOrderList;
	}
	
	public boolean insertBackOrder(BackOrder backOrder) {
		backOrders.add(backOrder);
		return true;
	}
	

	@Override
	public Iterator<BackOrder> iterator() {
		return backOrders.iterator();
	}

}
