# Lab 3 - Interfaces
This lab will revisit your POJO lab, supplying the *action* methods via interfaces. To complete this lab, you will need to have completed lab 2 (POJO).

## Topic
To introduce you to the usage of interfaces and their implementations, reinforcing the Interface Segregation Principle and to use Interfaces in polymorphism. You will also need to update your POJO classes as needed to leverage proper interfacing. Besides the course topics of interfaces and polymorphism, this lab will demonstrate your capabilities to improve on your previous work.


## Rules
* Have a completed POJO lab prior to starting this lab. You will need to discuss with me the design change of the POJO lab to complete this lab, hence the requirement. Also, **before** implementing the design the design must be approved. This can be done via github using issues as *improvements*, via email if you are not using github, or in person as required.  
* Revisit your POJO, adding action methods via the interface mechanism.
	* Caveat - I understand some actions may be just impossible to implement in a reasonable time. If you feel this
    	is the case, confer with me on how far, if at all, you need to take the action.

* Use your existing POJO lab repository!

* Your main class, which may not be the same as the main class in your POJO lab, will require at least 2 action based methods, meaning your class will implement two interfaces. Because of the variations among POJO labs, this may vary as well. Your design very well may simply have the requirements of implementation inherited.

* You will be required to implement at least 4 other action methods throughout your source. These action methods must be accompanied by interfaces and design approved.

* Any refactoring of the original POJO assignment determined in the design phase will also need to be completed. This will vary from student to student. Because of so, if you have already turned in a working POJO lab, you are free to design a new set of POJOs that may be of better use. If you do so, just re-implement the requirements for the POJO lab and tag me in the commits to get the ok to use that new repository instead.

* You may not use another students POJO lab unless you previously worked on teams. This means if you have not written the POJO lab, you cannot get away with forking their work and completing this lab. In the real world that makes sense, but this is for class, you need to be able to demonstrate you are capable of refactoring your own work, iteratively improving it. If you worked on the POJO lab individually and decide to team up with someone on this lab, that other person must have also completed a working POJO lab by the time this lab is started (the day after lab 3 is due). This requirement goes for all team members, irregardless of the the team size. If you wish to construct a new set of POJOs to work off of as a team, all members must have contributed via pull requests to the main repository.

### Example of Expectations

```java
public interface Pourable {
	public Liquid pour(double amount);
}

public interface Fillable {
	public Liquid fill(double amount);
}

public interface Attachable {
	public void attach();
}

public interface Removable {
	public void remove();
}

public class SodaBottle implements Pourable, Fillable {
	...
	...
	...

	public Liquid pour(double amount){
		// implementation
	}

	public Liquid fill(double amount){
		// implementation
	}

}

public class SodaBottleLid implements Attachable, Detachable {
	...
	...
	...

	public void attach(){
		//implementation
	}

	public vlid detach(){
		//implementation
	}
}
```

* You are required to implement all the actions pertaining to your submitted lab as discussed in the design review.

* Furthermore, you are required to design another POJO that uses at least one of your interfaces. With this second class that implements your interface, you are to show polymorphism via the interface and perform your action on those two non-related classes. You may do so in a `Driver.java` or where ever suitable. Just make sure on submission you
 point out where this occurs in your code so I may review it.


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

* Of course, when demonstrating polymorphism, you may not use my example, but you are free to reimplement it using list streams to perform the same action if `Pourable` is a logical interface to your work.


* As in above, if you are required to make additional classes to support your methods, make them.


## Grading
* If your POJO lab is not correct, this lab is not correct. You must have a working POJO lab to be graded for this lab.
* You will be graded on having proper interfaces to describe your actions
* You will be graded on Interface Segregation Principle.
* You will be graded on your demonstration of polymorphism via interfaces.
* You will be graded on meeting your design expectations as discussed and approved.

## Tips
* Re-use your POJO lab and its tests! Do not modify your tests unless you plan on modifying the existing methods (which may happen)

## Extra Credit
To receive the extra credit for this lab, you must write unit tests for each method! You are required to have 100% method coverage. This means one unit test to *set*, *get*, and *assert* is acceptable.


## Run By Date
While this, and all labs, are due at the end of the semester, if you wish to be eligible for the extra credit, this assignment must be submitted in running order by Friday at midnight, [TBD]. You may either submit via D2L or by Github commit (make sure I am following you on Github and that you tag me in the commit).
