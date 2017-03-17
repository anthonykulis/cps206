package interfaces.advanced;

public class Bottle implements Fillable {

	Fillable fillable;

	public Bottle(){
		this.fillable = null;
	}

	public Bottle(Fillable fillable){
		this.fillable = fillable;
	}

	public void fill(double amount){
		if(this.fillable != null){
			fillable.fill(20);
		}
		else {
			System.out.println("Filled up!");
		}
	}

	public static void main(String... args){
		System.out.println("Using standard built in fill method");
		(new Bottle()).fill(20);

		System.out.println("Using anonymous fillable");
		new Bottle(new Fillable() {
			@Override
			public void fill(double amount) {
				System.out.println("Dripping sink fills a bucket");
			}
		}).fill(20);

		System.out.println("Using lambda");
		new Bottle((amount) -> System.out.println("It filled with lambdas? #crazy")).fill(20);
	}
}
