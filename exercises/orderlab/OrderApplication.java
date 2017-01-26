package exercises.orderlab;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class OrderApplication {
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
