package labs.interfaces.solution;

public class SodaBottle implements Pourable, Fillable{

	private double volume;
	private final double capacity;
	private final Lid lid;
	private final Label label;

	private SodaBottle(){
		this.volume = this.capacity = 0;
		this.lid = null;
		this.label = null;
	}

	public SodaBottle(double capacity, double volume, Lid lid, Label label){
		this.capacity = capacity;
		this.setVolume(volume);
		this.lid = lid;
		this.label = label;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume){ this.volume = volume; }

	public double getCapacity() {
		return capacity;
	}

	public Lid getLid() {
		return lid;
	}

	public Label getLabel() {
		return label;
	}

	public Liquid pour(double amount){
		this.volume -= amount;
		return new Liquid(amount);
	}

	public void fill(Liquid liquid){
		this.volume += liquid.getAmount();
	}


	/* Tests */

	public static void main(String... args){
		Color color = new Color(1,1,1);
		Lid lid = new Lid(1,1,color,true);
		Label label = new Label(color, "label", new Image(400,500));

		SodaBottle bottle = new SodaBottle(3.0, 1.0, lid, label);

		assert(bottle.getCapacity() == 3.0);
		assert(bottle.getVolume() == 1.0);
		assert(bottle.getLabel() == label);
		assert(bottle.getLid() == lid);

		bottle.setVolume(10.0);
		assert(bottle.getVolume() == 10.0);

		Liquid liq = bottle.pour(5);
		assert(liq != null);
		assert(liq.getAmount() == 5.0);

		bottle.fill(liq);
		assert(bottle.getVolume() == 10.0);

	}
}