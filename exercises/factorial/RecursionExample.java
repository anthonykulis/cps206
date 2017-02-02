package exercises.factorial;

public class RecursionExample {

	public int doFactorial(int n){
		if(n == 1) return n;
		return n * this.doFactorial(n - 1);
	}

	public static void main(String... args){
		RecursionExample recursionExample = new RecursionExample();
		System.out.println(recursionExample.doFactorial(5));
	}
}
