package exercises.orderlab;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Order {

	private ArrayList<Item> items;
	private double subTotal;
	private double tax;
	private double total;
	private Item discount;

	private final double TAX_RATE = .05;

	public Order(){
		this.items = null;
		this.subTotal = 0;
		this.tax = 0;
		this.total =0;
		this.discount = null;
	}

	public void computeSubTotal(){
		for(Item item : this.items){
			double cost = item.getPrice() * item.getQuantity();

			if(item.getName().equalsIgnoreCase("discount")) {
				this.discount = item;
				continue;
			}

			this.subTotal += cost;
		}

		this.applyDiscount();
	}

	public void computeTax(){
		this.tax = this.subTotal * this.TAX_RATE;
	}

	public void computeTotal(){
		this.total = this.subTotal + this.tax;
	}

	public String toString(){
		String receipt = "Item\tPrice\tQuantity\tCharged\n";
		for(Item item : this.items){
			receipt += item.getName() + "\t" + item.getPrice() + "\t" + item.getQuantity() + "\t\t" + item.getPrice() * item.getQuantity() + "\n";
		}

		receipt += "\n\nSub Total: " + this.subTotal;
		receipt += "\nTax: " + this.tax;
		receipt += "\nTotal: " + this.total + "\n";

		return receipt;
	}

	private void applyDiscount(){
		if(this.discount == null) return;
		this.subTotal -= this.subTotal * (this.discount.getQuantity() * this.discount.getPrice());
	}


	public static void main(String... args){

		if(args.length < 1){
			System.err.println("Usage: java Order <order> [order] ...");
			System.exit(1);
		}

		for(String orderFile : args) {

			try {

				Order order = new Order();
				order.items = OrderReader.readItems(orderFile);
				order.computeSubTotal();
				order.computeTax();
				order.computeTotal();
				System.out.println(order);

			} catch (FileNotFoundException e) {
				System.err.println("Could not find file: " + orderFile);
				e.printStackTrace();
			} catch (Exception e) {
				System.err.println("Improper order formatting: " + orderFile);
				e.printStackTrace();
			}
		}
	}
}
