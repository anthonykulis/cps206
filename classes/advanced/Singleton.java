package classes.advanced;

public class Singleton {
	private static Singleton instance = null;
	private int num = 0;

	private Singleton() {}

	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	public int getNum(){ return this.num; }
	public void incrementNum(){ this.num++; }

	public static void main(String[] args){
		Singleton a = Singleton.getInstance();
		Singleton b = Singleton.getInstance();
		a.incrementNum();
		System.out.println(b.getNum());
	}
}