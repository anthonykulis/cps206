package exercises.orderlab;

import java.util.ArrayList;

public class BasicOrderBuilder implements OrderBuilderInterface {

	private final ArrayList<Item> items;
	private Item discount;
	private final double TAX_RATE = .05;

	public BasicOrderBuilder(){ this.items = new ArrayList<>(); }

	public void setItem(Item item){ this.items.add(item); }

	public void setDiscount(Item discount){ this.discount = discount; }

	public Order build(){
		double subtotal = this.computeSubTotal();
		subtotal = this.applyDiscount(subtotal);
		double tax = this.computeTax(subtotal);
		double total = this.computeTotal(subtotal, tax);

		return new Order(items, subtotal, discount, tax, total);
	}

	private double applyDiscount(double subTotal){
		if(this.discount == null) return subTotal;
		subTotal -= subTotal * (this.discount.getQuantity() * this.discount.getPrice());
		return subTotal;
	}

	private double computeTax(double subTotal){
		return subTotal * this.TAX_RATE;
	}

	private double computeTotal(double subTotal, double tax){
		return subTotal + tax;
	}

	private double computeSubTotal(){
		double subTotal = 0;

		for(Item item : this.items){
			subTotal += item.getPrice() * item.getQuantity();
		}

		// now use discount
		return subTotal;
	}

}
