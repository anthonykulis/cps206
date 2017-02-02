package exercises.methods;

import exercises.factorial.RecursionExample;

public class LeverageMethod {

	/*
		This example is to demonstrate how to use
		methods to solve bigger and bigger problems (scaling)
	 */

	public int sumOneTo(int n){
		return (n * n + n)/2;
	}

	public int sumRange(int from, int to){

		/*
			note, if we sum 5 to 10 and use sumOneTo 2x, subtracting the difference, we
			will be off by the from value (eg answer - from). to solve this issue,
			redunce from by 1
		 */
		return sumOneTo(to) - sumOneTo(from - 1);
	}

	public int sumTwoRanges(int fromOne, int toOne, int fromTwo, int toTwo){
		return sumRange(fromOne, toOne) + sumRange(fromTwo, toTwo);
	}

	/*
		A gawdy method you will never do. hopefuly
	 */
	public long doFactorialOfTheSumOfTwoRanges(int fromOne, int toOne, int fromTwo, int toTwo){
		RecursionExample recursionExample = new RecursionExample();
		return recursionExample.doFactorial(sumTwoRanges(fromOne, toOne, fromTwo, toTwo));
	}

	public static void main(String... args){
		LeverageMethod leverageMethod = new LeverageMethod();

		/*
			 lets do a big problem,
			 (((6*6+6)/2 - (3*3+3)/2) + ((10*10+10)/2 - (9*9+2)/2)))!
		 */


		/* Lets first look at our methods solving the first multirange */
		System.out.println("Sum one to 3 is: " + leverageMethod.sumOneTo(3));
		System.out.println("Sum one to 6 is: " + leverageMethod.sumOneTo(6));
		System.out.println("Sum of range 3 to 6 is: " + leverageMethod.sumRange(3, 6));

		/* now second */
		System.out.println("Sum one to 9 is: " + leverageMethod.sumOneTo(9));
		System.out.println("Sum one to 10 is: " + leverageMethod.sumOneTo(10));
		System.out.println("Sum of range 9 to 10 is: " + leverageMethod.sumRange(9, 10));

		/* now add those two ranges together */
		System.out.println("Sum of two ranges: " + leverageMethod.sumTwoRanges(3,6,9,10));

		/* Finally, factorial that sum */
		System.out.println("Factorial of those two ranges is: " + leverageMethod.doFactorialOfTheSumOfTwoRanges(3, 6, 9, 10));

		/* Just to prove its kosher */
		RecursionExample recursionExample = new RecursionExample();
		System.out.println("Factorial of 37 is " + recursionExample.doFactorial(37));
	}


}
