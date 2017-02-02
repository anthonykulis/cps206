# Methods to Solve Problems
Let us first introduce a problem you have been asked to code. 

	* The client want code to emulate a morning wakeup routine.
	
So what is in a morning routine? This may differ person to person, yet some things are common.

	* Brush Teeth
	* Drink Coffee
	* Shower
	* Put on dedorant
	* ...
	* ...

Using this information, let us build a terribly naive use case.

```java
public class MorningRoutine {
	public static void main(String... args){
		
		for(int i = 0; i < 100; i++){
			// move tooth brush up and down 
		}
		
		while(notFull){
			// pour coffee
		}
		
		// take off clothes		
		// turn on water		
		// step in shower		
		// wash face
		// wash chest
		// wash arms
		// wash hands
		// wash legs
		// wash feet
		// wash hair		
		// turn off water		
		// grab towel		
		// dry your body		
		// step out of shower
		
		
		// open lid
		// wipe armpits
		// put on lid
	}
}
```

Ok. That was bad. I have no idea even to write a lot of that code. Point is, now I need a routine for someone with 
kids. We need to add to that list `wake kids`, `make breakfast`, `dress kids`, `put on bus`. Hopefully you see this 
is not going to end well. 

## Break the logical steps into methods
You can hopefully see I segmented some of that so it is easier to convey my ideas. So let us expand on that fully.

```java
public class MorningRoutine {
	
	public void brushTeeth(){
		for(int i = 0; i < 100; i++){
			// move tooth brush up and down 
		}
	}
	
	public void pourCoffee(){
		while(notFull){
			// pour coffee
		}
	}
	
	public void takeShower(){
		// take off clothes		
		// turn on water		
		// step in shower		
		// wash face
		// wash chest
		// wash arms
		// wash hands
		// wash legs
		// wash feet
		// wash hair	
		// turn off water		
		// grab towel		
		// dry your body		
		// step out of shower	
	}
	
	public void putOnDeodorant(){
		// open lid
		// wipe armpits
		// put on lid
	}
	
	public static void main(String... args){
		MorningRoutine morningRoutine = new MorningRoutine();
		morningRoutine.brushTeeth();
		morningRoutine.brushTeeth();
		morningRoutine.takeShower();
		morningRoutine.putOnDeodorant();
	}
}
```

Wow. That is much more simple. But it still is not good enough. Notice how we are `wash`ing repeatedly? So lets break
 that into a method for reusabilty. I also expand on the steps to make it more defined.


```java
public void wash(Bodypart part){
	// apply soap
	// rinse
}
```

Really simply now, we can apply this to the `takeShower` method.

```java
public void takeShower(){
 	// take off clothes		
 	// turn on water		
 	// step in shower		
 	// wash(face)
 	// wash(chest)
 	// wash(arms)
 	// wash(hands)
 	// wash(legs)
 	// wash(feet)
 	// wash(hair)	
 	// turn off water		
 	// grab towel		
 	// dry your body		
 	// step out of shower	
 }
``` 

Still gawdy, so let us break it down more. We can create a method called `washBody`

```java
public void washBody(){
 	wash(face);
 	wash(chest);
 	wash(arms);
 	wash(hands);
 	wash(legs);
 	wash(feet);
 	wash(hair)	;
}
```

And then change our `takeShower` method to something a bit more readable.

```java
public void takeShower(){
 	// take off clothes		
 	// turn on water		
 	// step in shower		
 	washBody();	
 	// turn off water		
 	// grab towel		
 	// dry your body		
 	// step out of shower	
 }
``` 

## Re-usabilty

Imagine I have to take out the trash as well. It's steps may be:

	1. Lift lid
	2. Remove bag
	3. Walk bag outside
	4. Put in can
	5. Return to inside can
	6. Put new bag in
	7. Close lid
	8. Wash hands.
	
Oops! Number 8! Wash hands. Didn't we wash in `takeShower()`? So now what, we write a method that does the same steps
 twice? Let's look at that bad approach.
 
```java
public void takeOutTrash(){
	// Lift lid
	// Remove bag
	// Walk bag outside
	// Put in can
	// Return to inside can
	// Put new bag in
	// Close lid
	// Wash hands.
}
```

Since we already wrote the method `wash(Bodypart part)`, and it has the imperative steps on how to wash, there is no 
need to repeat ourselves, just simply use that logic again.

```java
public void takeOutTrash(){
	// Lift lid
	// Remove bag
	// Walk bag outside
	// Put in can
	// Return to inside can
	// Put new bag in
	// Close lid
	wash(hands);
}
```

So now, if we look at our `MorningRoutine` in its entirety, we have

```java
public class MorningRoutine {
	
	public void brushTeeth(){
		for(int i = 0; i < 100; i++){
			// move tooth brush up and down 
		}
	}
	
	public void pourCoffee(){
		while(notFull){
			// pour coffee
		}
	}
	
	public void takeShower(){
     	// take off clothes		
     	// turn on water		
     	// step in shower		
     	washBody();	
     	// turn off water		
     	// grab towel		
     	// dry your body		
     	// step out of shower	
     }
     
     public void washBody(){
      	wash(face);
      	wash(chest);
      	wash(arms);
      	wash(hands);
      	wash(legs);
      	wash(feet);
      	wash(hair);
     }
     
    public void putOnDeodorant(){
		// open lid
		// wipe armpits
		// put on lid
	}
	
	public void takeOutTrash(){
    	// Lift lid
    	// Remove bag
    	// Walk bag outside
    	// Put in can
    	// Return to inside can
    	// Put new bag in
    	// Close lid
    	wash(hands);
    }
    
    public static void main(String... args){
		MorningRoutine morningRoutine = new MorningRoutine();
		morningRoutine.brushTeeth();
		morningRoutine.brushTeeth();
		morningRoutine.takeShower();
		morningRoutine.putOnDeodorant();
		morningRoutine.takeOutTrash();
	}
}
```

## Continuing

Hopefully you get the idea now that we can continue this onwards. Eventually we will get to the *atom unit* of instruction and from that, scale upwards into a logical sequence of steps that completes our problem. While it stands, that is not obvious how far we should go. But later, it may come to pass that we need to revisit this and add features to it. Those features may repeat what we are doing in other steps. As we then extrapolate those steps into a method, we are doing what is called *refactoring*. Refactoring is a normal fact of life. Because we will refactor frequently, you might have noticed that we may have steps dependent on what we are changing and that if we change too much, we now need to worry about breaking other methods, and you would be smart to see this. Fortunately, we have this covered as well. It will continue into unit testing.
	