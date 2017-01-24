package exercises.orderlab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OrderReader {
	public static ArrayList<Item> readItems(String orderFile) throws Exception {

		// our collection of items
		ArrayList<Item> items = new ArrayList<>();

		try {

			//set up read
			String line;
			BufferedReader bufferedReader = new BufferedReader(new FileReader(orderFile));
			line = bufferedReader.readLine();

			// read
			while(line != null) {

				// skip page header
				if (line.charAt(0) == '#'){
					line = bufferedReader.readLine();
					continue;
				}

				// split on commas
				String[] split = line.split(",");

				// collect values
				String name = split[0];
				int quanity = Integer.valueOf(split[2]);
				double price = Double.valueOf(split[1]);

				// add item
				items.add(new Item(name, price, quanity));

				line = bufferedReader.readLine();
			}
		} catch(FileNotFoundException exception){
			throw exception;
		} catch(IOException exception){
			throw exception;
		} catch(NumberFormatException exception){
			throw exception;
		}

		return items;
	}

}
