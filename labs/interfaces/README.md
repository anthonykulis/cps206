# Lab 3 - Interfaces
This lab will revisit your POJO lab, supplying the *action* methods via interfaces.

## Topic
To introduce you to the usage of interfaces and their implementations, reinforcing the Interface Segregation 
Principle and to use Interfaces in polymorphism.


## Rules
* Revisit your POJO, adding action methods via the interface mechanism.
 
### Example

```java
public interface Pour {
	public Liquid pour(double amount);
}

public interface Cap {
	public void attach();
	public void detach();
} 
```

* You are required to implement all the actions pertaining to your submitted lab. Furthermore, you are required to 
design another POJO that uses at least one of your interfaces.

### Example

```java
public class Bucket implements Pour {
	private double volume;
	private double capacity;
	
	public Liquid pour(double amount){
		Liquid liquid = new Liquid(amount);
		this.volume -= amount;
		return liquid;
	}
}
```

* As in above, if you are required to make additional classes to support your methods, make them. 

* Lastly, refactor all your POJOs that should be immutable into immutable objects. 

### Example

A color will not change!

```java
class Color {
	private final int red;
	private final int blue;
	private final int green;
	
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
