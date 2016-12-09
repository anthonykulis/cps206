# Recursion
CPS215 will deal with recursion intensively. For this class I just want to introduce it as a topic since you will be 
writing many methods and may encounter it, accidentally.

Recursion is simply a method calling another method, which could be itself, repeatedly, until a stopping condition is
 met. 
 
We basically have two types of recursion, `tail`, and `indirect`. Of course, there is more advanced concepts behind 
this, but these two should suffice for your understanding.


## Tail Recursion

Its best to start with an example

```java

// assumes all numbers >= 0 (no negatives)
public long factorial(long num){
	if(num < 1) return 0;
	if(num == 1) return 1;
	return num * factorial(num - 1);
}
```

In the above `factorial` method, we simply will compute the factorial of a number. A factorial is just itself 
multiplied by the subsequent lesser number until we reach one. It is denoted by the `!` symbol. So 5! is 5 * 4 * 3 * 
2 * 1.

Our method will take any long and compute the factorial. So lets imagine we want 3! and go through the steps.

1. First we call the method with `num == 3`
2. Check. Is 3 < 1? It is not, so continue onwards.
3. Check. Is 3 == 1? It is not, so continue onwards.
4. Here is the tail recursion. We are telling it to return 3 * the methods next return value when passing it 2.
5. Check. Is 2 < 1? No, continue.
6. Check. Is 2 == 1? NO, continue.
7. Now, again, we know this method is taking 2 * the return result of the next call with 1.
8. Check. Is 1 < 1? No. Continue.
9. Check. Is 1 == 1? Yes, return 1.

Now that we are no longer calling the method, the computer will go back up the *stack frames*. Remember, with 2 we 
called the method again with 1, but it was 2 * `factorial(1)`. `factorial(1)` returned a 1, so it gets replaced. We 
now have 2 * 1. 

Next, dont forget, we called `factorial(2)` first. This was actually `3 * factorial(2)`. `factorial(2)` returned us 2
 * 1. So we can replace that factorial part again, getting 3 * 2 * 1. And since 3 * 2 * 1 == 3!, we used the code to 
 compute the math problem.
 
## Indirect Recursion. 

Again, indirect recursion is best said with an example.

```java
void a(){
	b();
}

void b(){
	a();
}
```

I think it is pretty obvious here that if I call either `a()` or `b()`, that they will call each other indefinitely.