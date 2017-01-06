# Lab 3 - Interfaces
This lab will revisit your POJO lab, supplying the *action* methods via interfaces.

## Topic
To introduce you to the usage of interfaces and their implementations, reinforcing the Interface Segregation 
Principle and to use Interfaces in polymorphism.


## Rules
* Revisit your POJO, adding action methods via the interface mechanism.
	* Caveat - I understand some actions may be just impossible to implement in a reasonable time. If you feel this 
    	is the case, confer with me on how far, if at all, you need to take the action.
    	
### Example

```java
public interface Pourable {
	public Liquid pour(double amount);
}

public interface Attachable {
	public void attach();
}

public interface Removable {
	public void remove();
} 

public class SodaBottle implements Pourable, Attachable, Removalable {
	...
	...
	...
	
	public Liquid pour(double amount){
		// implementation
	}
	
	public void attach(){
		// implementation
	}
	
	public void remove(){
		//implementation
	}
	
}
```

* You are required to implement all the actions pertaining to your submitted lab. 

* Furthermore, you are required to design another POJO that uses at least one of your interfaces. With this second 
class that implements your interface, you are to show polymorphism via the interface and perform your action on those
 two non-related classes. You may do so in a `Driver.java` or where ever suitable. Just make sure on submission you 
 point 
 out where this occurs in your code so I may review it.
	
	
### Example

```java
public class Rain implements Pourable {
	public Liquid pour(double amount){
		return new Liquid(amount);
	}
}
```

#### Polymorphism Example

	ArrayList<Pourable> pourableItems = new ArrayList<>();
	pourableItems.add(new Rain());
	pourableItems.add(new SodaBottle());
	
	Iterator iterator = pourableItems.iterator();
	while(iterator.hasNext()){
		((Pourable)iterator.next()).pour(1.0);
	}
	
* Of course, when demonstrating polymorphism, you may not use my example, but you are free to use list streams to 
perform the same action.


* As in above, if you are required to make additional classes to support your methods, make them. 

* Lastly, refactor all your POJOs that should be immutable into immutable objects. 

### Example

A color will not change!

```java
class Color {
	private final int red;
	private final int blue;
	private final int green;
	
	private Color(){ 
		this.red = this.green = this.blue = 0;
	}
	
	public Color(int red, int green, int blue){
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public getRed(){ return this.red; }
	public getGreen(){ return this.green; }
	public getBlue(){ return this.blue; }
}
```


## Grading
* You will be graded on having proper immutable features, even if its the entire class. 
* You will be graded on having proper interfaces to describe your actions
* You will be graded on Interface Segregation Principle.
* You will be graded on your demonstration of polymorphism via interfaces.

## Tips 
* Re-use your POJO lab and its tests! Do not modify your tests unless you plan on modifying the accessors (which you 
may need to while you make features immutable)

## Extra Credit
To receive the extra credit for this lab, you must write unit tests for each method! You are required to have 100% method coverage. This means one unit test to *set*, *get*, and *assert* is acceptable. 

If you are not using maven to import jUnit, you may write your tests as private methods called by the main method. If you are using jUnit, be sure to submit your tests with proper naming conventions. If you are using maven to manage the project, be sure to submit the *pom.xml* file as well. 

## Run By Date
While this, and all labs, are due at the end of the semester, if you wish to be eligible for the extra credit, this assignment must be submitted in running order by Friday at midnight, Feb 17, 2017. You may either submit via D2L or by Github commit (make sure I am following you on Github and that you tag me in the commit).