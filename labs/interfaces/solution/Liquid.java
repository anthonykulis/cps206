package labs.interfaces.solution;

class Liquid {
	private final double amount;

	private Liquid(){ this.amount = 0; }

	public Liquid(double amount){ this.amount = amount; }

	public double getAmount(){ return this.amount; }

	/* Tests */
	public static void main(String... args){
		Liquid liquid = new Liquid(3.33);
		assert(liquid.getAmount() == 3.33);
	}
}