package classes.basic;

public class POJO {
	private int num;
	private int denom;

	public POJO(){
		this.setNum(0);
		this.setDenom(0);
	}

	public POJO(int num, int denom){
		this.setNum(num);
		this.setDenom(denom);
	}


	public int getNum(){ return num; }
	public int getDenom(){ return denom; }

	public POJO setNum(int num){
		this.num = num;
		return this;
	}


	public POJO setDenom(int denom){
		this.denom = denom;
		return this;
	}
}