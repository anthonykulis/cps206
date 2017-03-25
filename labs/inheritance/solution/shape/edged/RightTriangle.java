package labs.inheritance.solution.shape.edged;

public final class RightTriangle extends Triangle {

	public RightTriangle(double height, double base){
		super(height, base);
	}

	public final double perimeter(){
		double height = this.getHeight();
		double width = this.getWidth();
		double hypotenuse = Math.sqrt(height * height + width * width);
		return height + width + hypotenuse;
	}

}