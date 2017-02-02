# Leveraging Methods to Solve Problems
So far, you have pretty much thought to yourself to put everything into main. Maybe you called a method to help solve a problem here or there, but you haven't used methods to call methods to solve bigger and bigger problems. It is time to change that.

## Our difficult problem.
Let us imagine I have some crazy math problem to solve:

	((6+5+4+3+2+1 - 2+1) + (10+9+8+7+6+5+4+3+2+1 - 9+8+7+6+5+4+3+2+1))!
	
If this was a one-off problem it would be easy enough to reduce it to 

	(6+5+4+3 + 10+9)!
	
But you dont know what the ranges will be, and need to accommodate for that. This leaves us with:

	(((m + m - 1 + m - 2 + ... + m - m + 1) + (n + n - 1 + n - 2 + ... n - n + 1)) + ...)!
	
We obviously have a patter here, so let us code for it.

## One method solution
We could just write one method to solve this

```java
public long solution(long m, long n, long o, long p){
	return factorial( (m * m + m)/2) - (n * n + n)/2 + (o * o + o)/2 - (p * p + p)/2);
}
```
	
While that would suffice, there are two major problems. First, it is nearly impossible to read. Second, what if later I just wanted to solve the sum of two ranges? I would have to write all that code again without calling `factorial`. We do not want that. 

## The better solution
First, let look at the patterns. `m`, `n`, `o`, and `p`, all do the same thing. The only thing different are the variables. So let us write a method to solve that.

```java
public int sumOneTo(int n){
	return (n * n + n)/2;
}
```
				
Now we can replace our long method with something a bit more usable, but while we are at it, lets also make it more readable.

```java
public long solution(long fromRangeOne, long toRangeOne, long fromRangeTwo, long toRangeTwo){
	return factorial(sumOneTo(toRangeone) - sumOneTo(fromRangeOne) + sumOneTo(toRangeTwo) - sumOneTo(fromRangeTwo));
}
```
				
Still, this is a bit much. We are repeating a behavior here. We are subtracting `from` and `to`, let us leverage a method so we do not need to repeat ourselves, and use our `sumOneTo` method there.

```java
public int sumRange(int from, int to){
	return sumOneTo(to) - sumOneTo(from);
}
```
				
But there is an inclusive problem here. I want to sum `from` to `to`. As it stands, it will give us `sumOneto(to) - sumOneTo(from) - from`. To fix this, let's modify our method.
 
```java
public int sumRange(int from, int to){
	return sumOneTo(to) - sumOneTo(from - 1);
}
```
	
Ok, let us rewrite our original method.

```java
public long solution(long fromRangeOne, long toRangeOne, long fromRangeTwo, long toRangeTwo){
	return factorial(sumRange(fromRangeOne, toRangeTo) + sumRange(fromRangeTwo, toRangeTwo));
}
```
				
Now we could just stop there. The code isn't repeating anymore. But let us think about this. Remember when I asked what if I wanted the sum of two ranges? Well, we would repeat the code. So let bring this down into its smallest form and create another method.

```java
public sumTwoRanges(long fromRangeOne, long toRangeOne, long fromRangeTwo, long toRangeTwo){
	return sumRange(fromRangeOne, toRangeTo) + sumRange(fromRangeTwo, toRangeTwo));
}
```
	
Now we can simply update our initial method once more.

```java
public long solution(long fromRangeOne, long toRangeOne, long fromRangeTwo, long toRangeTwo){
	return factorial(sumTwoRanges(fromRangeOne, toRangeTo, sumRange(fromRangeTwo, toRangeTwo));
}
```
		
## Re-usability
See how nice this is? Now I can call on *any* of those methods as I see fit without having to write any extra code. This is re-usability and it facilitates scaling. See my [example](LeverageMethod.java) and how I can call on each of those methods to show a mathematical step-through of solving the initial problem.