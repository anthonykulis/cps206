# Exceptions
We use exceptions when the program runs into an issue that cannot be solved with simple `if/then` logic, or `if/then` is not succinct enough to handle the problem.

Example:

```java
public String makeUppercase(String lowercase) throws NullPointerException{
	if(lowercase == null) throw new NullPointerException();
	return lowercase.toUpperCase();
}
```

In the above example, while we could do an `if/else` to check for `null`, and if it was `null`, return null, but throwing the exception allows the user of our class to handle this exception with a `try/catch/finally` statement. In some cases, this makes more sense than requiring the user of our class to check for null by using `if/then` statement. 

As you can see by my ambiguity on what to use, this is a design decision. Since this class is about designing classes and interfaces, we will learn quickly that other people will use our classes and that the decision on what to do varies wildly. Being said, we will always throw an exception when our method doesn't meet the criteria required by the method.

## As a user of this method
Since we are throwing a `NullPointerException`, the user of our class will be required to `catch` that exception. Imagine our class name is `StringHelper` and we have an instance of it named `stringHelper`, the following is an example of how we would use that method.

```java
String someString = null;
try {
	stringHelper.makeUppercase(someString);
} catch (NullPointerException npe){
	System.err.println("Whoops, someString is null");
}
```

If the previous example we used `try` and `catch` to *try* a method, and when it failed *catch* the exception. Let's look at `try` and `catch` now.

## Try
`try` is a java keyword that *attempts* to perform its scope. The scope of `try` is everything inside `{` and the trailing `}`. If any of that code in scope encounters a thrown exception, it will immediately break scope and find the appropriate catch.

## Catch
`catch` is the pairing keyword to `try`. You cannot have a `try` without a following `catch`, and you cannot have a `catch` without a preceding `try`. You can however, have multiple `catch` statements for one `try`.

Let's revisit our original example and make it do more than it should.

```java
public String makeUppercaseAndDivideTwoNumbers(String lowercase, int num, int denom) throws NullPointerException, 
ArithimeticException{
	if(lowercase == null) throw new NullPointerException();
	if(denom == 0) throw new ArithimeticException()
	return lowercase.toUpperCase();
}
```

You will notice here I separated what the method throws by a comma. Also, I do two different checks. If it passes the `null` check for the `String` but fails the denom equal to 0 one, it will only throw the `ArithimeticException`. Conversely, if the string passed in `null`, it will throw that one, *irregardless* if denom is 0 or not. In fact, it will not even check. 

Catching both while using the method looks as the following:

```java
String someString = null;
int denom = 0;
int num = 1;
try {
	stringHelper.makeUppercase(someString, num, denom);
} catch (NullPointerException npe){
	System.err.println("Whoops, someString is null");
} catch (ArithimeticException ae){
	System.err.println("Cannot divide by zero");
}
```

### Using the catches variable
You will notice that for each catch it has a variable with the type of the exception, eg `NullPointerException npe`. This means you can use the `npe` variable in the scope of the `catch` statement in the same way you could use a parameter in a method. 

## Finally
Finally, we have `finally`. `finally` is the third exception keyword that goes with the `try/catch/finally` concept. To use it, you must have a `try`, which means you also have at least one `catch`. You can use `finally` for any code you wish to *always* execute when a `catch` occurs.

```java
String someString = null;
int denom = 0;
int num = 1;
try {
	stringHelper.makeUppercase(someString, num, denom);
} catch (NullPointerException npe){
	System.err.println("Whoops, someString is null");
} catch (DivideByZeroException dbze){
	System.err.println("Cannot divide by zero");
} finally {
	System.exit(1);
}
```

## Custom Exceptions
Custom exceptions are allowed. An exception is simply an object, and if an object is not final, it can be extended. 
Creating custom exceptions is beyond the scope of this class.

