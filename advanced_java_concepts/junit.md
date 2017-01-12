# JUNIT and Unit Testing

Unit testing allows us to write code we know that works. 
This class will not go beyond testing simple units of structure. The purpose of unit testing is to promise us that each unit of functionality (methods) work as designed. This allows us to iteratively work on code and know that our modifications do not change the promised behaviors at a later date. 

Nearly 100% of your extra credit will be derived from unit testing.

## JUNIT
JUnit is a test suite that allows for the simplification of unit testing. I will not be teaching how to use JUnit, but suggest this is the test suite you use. 

Feel free to read the documentation on JUnit4. Integrating JUnit4 into your application is best done with Maven or Gradle.

## Unit Testing
Unit testing can be down with out any test suite, and for this class, that is completely acceptable. This can be done with the `assert` method and must be run with `java -ea <MyApp>`. The `-ea` flag tells the JVM to enable assertions.

A quick example:

```java
class MyClass {
	
	public boolean alwaysTrue(){ return true; }
	
	// purposely broken
	public boolean flipTruthy(boolean truthy){ return truthy; }
	
	public static void main(String... args){
		MyClass myClass = new MyClass();
		
		// assert passes!
		assert(myClass.alwaysTrue());
		
		// assert fails - notified in shell
		assert(myClass.flipTruthy(false) == true);
	}
}

```

You can see how a simple logical test allows you to catch a simple logic flaw. It will also allow you to return to code later (once tested and working), allowing you to modify the method. As long as the test remains, you know all the code using your method will continue to work.