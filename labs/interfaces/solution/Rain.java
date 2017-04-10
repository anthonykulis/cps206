package labs.interfaces.solution;

import java.util.ArrayList;
import java.util.Iterator;

public class Rain implements Pourable {

	private Rain(){}

	public Liquid pour(double amount){
		return new Liquid(amount);
	}

	public static void main(String... args){
		ArrayList<Pourable> list = new ArrayList<>();
		list.add(new Rain());
		list.add(new SodaBottle(3.0, 1.0, null, null));

		Iterator it = list.iterator();
		while(it.hasNext()){
			Liquid liquid = ((Pourable) it.next()).pour(5.0);
			System.out.println("poured: " + liquid.getAmount());
		}
	}
}