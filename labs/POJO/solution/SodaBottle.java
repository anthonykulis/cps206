package labs.POJO.solution;

public class SodaBottle {

	private double volume;
	private double capacity;
	private Lid lid;
	private Label label;

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public Lid getLid() {
		return lid;
	}

	public void setLid(Lid lid) {
		this.lid = lid;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	/* Tests */
	void test(){
		testVolume();
		testCapacity();
		testLid();
		testLabel();
	}

	private void testVolume(){
		this.setVolume(1.0);
		assert(this.getVolume() == 1.0);
	}

	private void testCapacity(){
		this.setCapacity(1.0);
		assert(this.getCapacity() == 1.0);
	}

	private void testLid(){
		Lid lid = new Lid();
		this.setLid(lid);
		assert(this.getLid() == lid);
	}

	private void testLabel(){
		Label label = new Label();
		this.setLabel(label);
		assert(this.getLabel() == label);
	}

	public static void main(String... args){
		SodaBottle bottle = new SodaBottle();
		bottle.test();
	}
}