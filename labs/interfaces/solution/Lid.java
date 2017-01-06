package labs.interfaces.solution;

class Lid implements Attachable, Removable {

	private final double height;
	private final double diameter;
	private final Color color;
	boolean isAttached;

	private Lid(){
		this.height = this.diameter = 0;
		this.color = null;
		this.isAttached = false;
	}

	public Lid(double height, double diameter, Color color, boolean isAttached){
		this.height = height;
		this.diameter = diameter;
		this.color = color;
		this.isAttached = isAttached;
	}

	public double getHeight() {
		return height;
	}

	public double getDiameter() {
		return diameter;
	}

	public Color getColor() {
		return color;
	}

	public void attach(){ this.isAttached = true; }

	public void remove(){ this.isAttached = false; }

	public boolean isAttached(){ return this.isAttached; }

	/* Tests */
	void test(){
		testHeight();
		testDiameter();
		testColor();
		testAttach();
		testRemove();
	}

	private void testHeight(){
		assert(this.getHeight() == 5.0);
	}

	private void testDiameter(){
		assert(this.getDiameter() == 3.0);
	}

	private void testColor(){
		Color color = this.getColor();
		assert(color != null);
	}

	private void testAttach(){
		this.attach();
		assert(this.isAttached());
	}

	private void testRemove(){
		this.remove();
		assert(!this.isAttached());
	}

	public static void main(String... args){

		double height = 5.0;
		double diameter = 3.0;
		Color color = new Color(1,1,1);
		boolean isAttached = false;

		Lid lid = new Lid(height, diameter, color, isAttached);
		lid.test();
	}
}