package exercises.orderlab;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Order {

	private final ArrayList<Item> items;
	private final double subTotal;
	private final double tax;
	private final double total;
	private final Item discount;

	// dont want used
	private Order(){
		this.items = null;
		this.subTotal = this.tax = this.total = 0;
		this.discount = null;
	}

	public Order(ArrayList<Item> items, double subTotal, Item discount, double tax, double total){
		this.items = items;
		this.subTotal = subTotal;
		this.tax = tax;
		this.total = total;
		this.discount = discount;
	}


	// override toString so we print a receipt
	public String toString(){

		// header
		String receipt = "Item\tPrice\tQuantity\tCharged\n";

		// each item
		for(Item item : this.items){
			receipt += item.toString();
		}

		// footer
		receipt += "\n\nSub Total: " + this.subTotal;
		receipt += "\nTax: " + this.tax;
		receipt += "\nTotal: " + this.total + "\n";

		return receipt;
	}




	public static void main(String... args){

		// requires at least one order to process
		if(args.length < 1){
			System.err.println("Usage: java Order <order> [order] ...");
			System.exit(1);
		}

		for(String orderFile : args) {

			try {

				BasicOrderBuilder builder = new BasicOrderBuilder();
				ArrayList<Item> items = OrderReader.readItems(orderFile);

				for(Item item : items){
					if(item.getName().equalsIgnoreCase("discount")) builder.setDiscount(item);
					else builder.setItem(item);
				}

				Order order = builder.build();

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
