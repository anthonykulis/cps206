package classes.basic;

public class Divide {
	private int num;
	private int denom;

	public Divide(){
		this.setNum(0);
		this.setDenom(0);
	}

	public Divide(int num, int denom){
		this.setNum(num);
		this.setDenom(denom);
	}


	public int getNum(){ return num; }
	public int getDenom(){ return denom; }

	public Divide setNum(int num){
		this.num = num;
		return this;
	}


	public Divide setDenom(int denom){
		this.denom = denom;
		return this;
	}

	public double divide(){
		return (this.num * 1.0)/this.denom;
	}
}