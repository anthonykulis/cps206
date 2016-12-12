# Introduction to Classes
We learned in cps176 that objects are instances of classes. We also learned that Java is Object Orientated 
Programming. This implies classes are *heavily* used in Java. 

## Concepts of Classes
The entire idea behind a class is to store heterogeneous content into a structure. This structure is called a *class*
 and that content can be any primitive or class, including instances of the class itself. We call this content 
 *properties* or *member variables*.
 
 A class also has methods to act upon those properties. Of course, we do not need methods, to create a class, nor do 
 we need properties. But without methods, the class is fairly pointless, and without properties, it is completely 
 useless.
 
 But taking that completely useless concept, the only thing we need to create a class is a the keyword `class` and a 
 name for the class. Let's create a totally legal, but completely useless class.
 
 ```java
class MyCompletelyUselessClass {}
```

That's it. But for this being an introduction, let's break it down.

* The keyword `class` signifies the following name and scope are to be a class. 
* The name, in this case `MyCompletelyUselessClass` is the name of the class. Of course, it needs to be saved in a 
file of the same name, including case. 
* The `{}` define the classes scope. Any code that occurs within those `{}` *belong* to that class.

### Visibility
You may notice we didn't put any modifiers onto the class. We could. You've seen `public` many times before. So let 
us update the class.

#### Public Visibilty

```java
public class MyCompletelyUselessClass {}
```

That `public` keyword sets the visibility so any class may now use this class. And in this case, *use* means 
instantiate, although later in the course, you will see we can do much more with the class.

    MyCompletelyUselessClass c = new MyCompletelyUselessClass();
    
#### Package-Private Visibility
So what happened when I omitted `public`? Well, the visibility is set to `package-private`. This means only the 
class itself can access the class and the classes in the package. Package you ask? Well, yes! We can even package 
classes into "like minded" groups. Lets do that really quick and explain it later.

```java
package classes.basic;

class MyCompletelyUselessClass {}
```

Now this useless class with `package-private` visibility belongs to the package `classes.basic`, or another way of 
thinking about it, the "group" `classes/basic`.

To package something, it must reside in a directory named as the package within the root directory of your java 
project. Once packaged, and with visibility of `package-private`, its access is limited to any class that resides in that 
directory. This allows you to create all kinds of *helper* classes that you do not want publicly consumed. In our 
case of `classes.basic`, this source code resides in the path of `classes/basic`.
 
#### Protected
Protected classes have slightly better visibility than package-protected and slightly worse visibility than public 
ones. Lets update our useless class to `protected`.

```java
package classes.basic;

protected class MyCompletelyUselessClass {}
```

This still allows itself to access it, any class in the directory to access it, and now any *subclass* of it to 
access it. When we get into inheritance, subclassing we be covered.

#### Private
A private class is them most limited class of all. Only itself can access it. Why would we do that? Believe it or not
 the occasion shows up. Lets update our example.
 
 ```java
 package classes.basic;
 
 private class MyCompletelyUselessClass {}
 ```

#### Selecting a visibility
Always choose the most restrictive visibility you can get away with. Its that simple. If you want to see a nice 
explanation with a table, visit [the java documentation](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html).

## Properties of a Class
As mentioned, properties of a class are simply it's variables. But from now on, we have to identify them as *class 
variables* or *instance variables*. I will explain this in a minute, but before I do, lets queue up an example. 

```java
package classes.basic;

public class POJO {
	int num = 3;
}
```


### Instance Variables

Now somewhere later, I can create the POJO. By the way, a POJO stands for Plain Old Java Object.

    POJO pojo = new POJO();
    
Since I instantiated the POJO, and with this property as a `package-private` member variable, and no methods, I can work
 on its *instance variable*.
 
    pojo.num++;
    
    
### Class Variables

Now let me show you the *class variable* version.

```java
package classes.basic;

public class POJO {
	static int num = 3;
}
```

If I later did the following, I would get a compile time error.

    POJO pojo = new POJO();
    pojo.num++;
    
Why? Well, because the variable `num` belongs to the class, not the instance! The instance is `pojo`, but since the 
variable is declared `static`, there is only one instance of it anywhere, and that is within the class. So to access 
it, my code needs to change to:

    POJO.num++;
    
### Variable Visibility
I hinted that this `num` variable was `package-private`. It follows class creation that since we never set a 
visibility modifier it will default. But typically we never want to expose a variable that can change. This can lead 
to unpredictable behavior in our code. You've seen this example as *some what* visible, now lets look at totally exposed.

#### Public 

```java
package classes.basic;

public class POJO {
	public static int num = 3;
}
```

Now anyone can change our variable at will. This violates one of our core principals of `encapsulation`, so we want 
to avoid this. But there is one exception, and that is using the keyword `final`. Lets change our code again.

```java
package classes.basic;

public class POJO {
	public final static int num = 3;
}
```

With the `final` keyword, once the instance exists (in this case with `static` there is only one instance, the class)
, the value of `num` can never change. It is okay to expose a variable (rather now a constant) to the public. A 
better example is this:

```java
public class Math {
	public final static double PI = 3.14;
}

```

And you have seen this when you call upon the math class

    Math.PI * radius * radius;
    
    
Now back to visibility, but we will revisit `final` later.

### Protected
We can also set a variable to `protected` visibility. Here is a sample. 

```java
package classes.basic;

public class POJO {
	protected int num = 3;
}
```

But again, we do not want outsiders affecting our variable. So this is probably never a good idea. Of course, if we 
set it to final, it becomes a constant, so that *may* be okay. Again, this is a design decision. Providing a constant
 makes sense to expose, providing an exposed variable does not.


#### Private
Private visibility, as in the class, means only the class can access this variable. And that is good! The only way 
the variable can change or be read is via a non-private method belonging to the class.  This enforces our 
`encapsulation` principle and is mandatory for in this class (and your future jobs).

Let us update our code once again.

```java
package classes.basic;

public class POJO {
	private int num = 3;
}
```

Ok. So not that is it updated, I can no longer do the following

    POJO pojo = new POJO();
    pojo.num++;
    
And this is because `num` is private. So to access it, I need to introduce `methods`.

## Methods
You are expected to know methods from cps176. You are also expected to know how to pass arguments and set parameters,
 so if you need a refresher, visit my [methods](https://github.com/anthonykulis/cps176/tree/master/methods) notes in the cps176 repo.
 
Here we will look at what methods to create and why to create them. But before I get too involved, I want only 
introduce accessors and mutators so we can close off that `private` access variable concept.


### Accessors
As the name implies, `accessors` allow a different class to access the private variable. A common nickname for them 
is `getters`. This is because they are typically named with the prefix `get`. They should only return the value of 
the variable and do nothing else.

Let us expand our class more now. 

```java
package classes.basic;

public class POJO {
	private int num = 3;
	
	public int getNum(){ return num; }
}
```

Pretty simple concept, right? Of course I can restrict visibility if I needed, but if I restrict all the way to `private` I 
become a useless class again. Besides `public`, you can set to `protected` for that limited package and subsclass access. Or just omit any visibility to give access to only the package.

### Mutators
Again, as the name implies, mutators allow me to modify the value of the variable. Again, also, they have a 
nickname. It is called `setters`. And yes, again, that is because their names are prefixed with `set`. Lets add some 
code.

```java
package classes.basic;

public class POJO {
	private int num = 3;
	
	public int getNum(){ return num; }
	public void setNum(int num){ this.num = num; }
}
```

#### `this` keyword

This? Did you see that in the mutator? What is `this`? This is the instance. Not the class. `this` would not work in 
static methods. `this` only works in instances. Think of `this` as the monk meditating on top of the mountain unaware 
of anything else but his consciousness. That is `this`. It is its internal reference to the instance itself. It 
allows me to access variables in scope. Notice how `num` has two scopes in the class? One in the method and on for the class? 
`this.num` tells the compiler to access the instances `num`, not the methods.

## Constructors
We gave our POJO a couple of methods and a `num` property that we defined to be 3. But we never created a constructor
. By default, java will create a *default constructor* if you do not. You have seen this all through cps176 when you 
did the following:

```java
public class Example {
	public static void main(String[] args){
		// do something
	}
}
```

By now, you should realize you created a class named `Example`. You should also realize that that class can have an 
instance of itself. So let us do that in `main`.

```java
public class Example {
	public static void main(String[] args){
		Example e = new Example();
		// do something with e
	}
}
```

But you may be asking yourself, or hopefully telling yourself, we can also access `main` by the class itself.

    Strins[] args[] = {"a", "B", "c", ...}
    Example.main(args);
    
In fact, that is exactly what is happening when you call `java Example a B c ...` from the command line. But I digress.

So let us add a default constructor to `Example` just to see it. It wont do anything past default behavior, it is just
 an example.

```java
public class Example {
	
	public Example(){
		// do nothing
	}
	
	public static void main(String[] args){
		Example e = new Example();
		// do something with e
	}
}
```

The constructor is used to create an `instance` of the class. In our main method, we create that instance and assign 
it to the variable `e` of type `Example`.

Now let us create another constructor, but this time for our POJO.

```java
package classes.basic;

public class POJO {
	private int num;
	
	public POJO(int num){
		this.num = num;
	}
	
	public int getNum(){ return num; }
	public void setNum(int num){ this.num = num; }
}
```

Now we didn't create a default constructor here, we created a very specific constructor to set the variable `num` to 
an `int` value the user passed. We still have the default constructor, and for clarity, I will add it now.

```java
package classes.basic;

public class POJO {
	private int num;
	
	public POJO(){
		// do nothing
	}
	
	
	public POJO(int num){
		this.num = num;
	}
	
	public int getNum(){ return num; }
	public void setNum(int num){ this.num = num; }
}
```

Now that we have it, you will notice it still does nothing. Is there an issue that can arise here? What happens if I 
do the following?

    POJO p = new POJO();
    System.out.println(p.getNum());
    
You can see `num` has no value. It will break the system. So maybe, we have our default constructor set `num` to a 
value. 

```java
package classes.basic;

public class POJO {
	private int num;
	
	public POJO(){
		this.num = 0;
	}
	
	public POJO(int num){
		this.num = num;
	}
	
	public int getNum(){ return num; }
	public void setNum(int num){ this.num = num; }
}
```
Ok. Now we have code that will not break. This is good. But did you notice I did `this.num = num` three times? This 
is bad! Bad style really. What happens if the assignment was more complex, say `this.num = num * num + 3 - 6 / 32` 
and then I wanted to instead of dividing by 32 divide by 64? I would have to change it in 3 places. DONT REPEAT 
YOURSELF. No, I am not yelling at you, I am introducing a design concept called DRY. DRY stands for DONT REPEATE 
YOURSELF. Ok, so let's not repeat ourselves. How can we do this? Simple. Look at the example

```java
package classes.basic;

public class POJO {
	private int num;
	
	public POJO(){
		this.setNum(0);
	}
	
	public POJO(int num){
		this.setNum(num);
	}
	
	public int getNum(){ return num; }
	public void setNum(int num){ this.num = num; }
}
```

Now when we change how `num` is set, we only have to change it in one place. We will look at DRY principles 
frequently, and this is only a trivial example. But let me also ask another question, what OOP principal does this 
also fit? It fits `encapsulation`. In encapsulation, we *encapsulate* imperative logic into a method so the work of 
understanding how `num` is set belongs to `setNum`, which by the way, is also `declarative`. But more on that later. 

If you have absorbed what I just said, you may also be thinking that setting `num` to 0 without user consent is spurious, and you would be correct. A better way to handle this example would be to set the default constructor to private so no one outside this class can use it. Lets do it.

```java
package classes.basic;

public class POJO {
	private int num;
	
	/* Restrict access to default constructor */
	private POJO(){}
	
	public POJO(int num){
		this.setNum(num);
	}
	
	public int getNum(){ return num; }
	public void setNum(int num){ this.num = num; }
}
```

By restricting access to the default constructor we as the producer of the POJO class make no assumptions on how the user should instantiate. We remove the *knowledge* base of using our class such that the user needs to know if "If I instantiate with this constructor, it behaves one way. And if I instantiate with the other constructor, it behaves another way". This is a good thing. Try to keep this in mind.

## POJO Conclusion
This is it for our POJO. If we added methods that do specific things, like a `Bottle` having a `pour` method, this is
 no longer plain. There is one modification we can make still that will make our POJO a whole lot better. Let me 
 cover that.
 
 ### Returning the instance
 
 Imagine I have a few other variables to set. Look to my example.
 
 
```java
package classes.basic;

public class POJO {
private int num;
private int denom;

public POJO(){
    this.setNum(0);
    this.setDenom(0);
}

public POJO(int num, int denom){
    this.setNum(num);
    this.setDenom(denom);
}


public int getNum(){ return num; }
public void setNum(int num){ this.num = num; }

public int getDenom(){ return denom; }
public void setDenom(int denom){ this.denom = denom; }
}
```
 
You see I created `denom` as well as tied it in with an accessor and mutator. Is it funny how you thought I was just saying `num` for number before and now you realize it was for `numerator`? I think so. But back to the topic. I can do the following 
just fine.
   
   POJO p = new POJO();
   p.setNum(3);
   p.setDenom(4);
   
But that is way too much extra code for my liking, so let us modify our mutators to do something cool.

```java
package classes.basic;

public class POJO {
    private int num;
    private int denom;
    
    public POJO(){
        this.setNum(0);
        this.setDenom(0);
    }
    
    public POJO(int num, int denom){
        this.setNum(num);
        this.setDenom(denom);
    }
    
    
    public int getNum(){ return num; }
    public int getDenom(){ return denom; }
    
    public POJO setNum(int num){ 
    	this.num = num; 
        return this;
    }
    
    
    public POJO setDenom(int denom){ 
        this.denom = denom; 
        return this;
    }
}
```

You notice how I now return a POJO object, and that object is `this`? I also moved the code around to group the 
accessors together as well as the mutators. Well, we know `this` is this instance, so if the return this is the 
instance, than that means I can use the instance to access its methods. Watch this coolness

    POJO p = new POJO();
    p.setNum(3).setDenom(4);
    
Totally legal code. `p.setNum(3)` returns `p`, so upon return, I can mentally replace `p.setNum(3).setDenom(4)` with 
`p.setDenom(4)`. In fact, that is what the compiler is doing as well. After it executes the `setNum` method, it 
replaces the existing code with the instance, then calling the method `setDenom`. Try it sometime. Some people do not
 like it. When you get to lambdas in csp216, you will appreciate it.
 
 
## Breaking out of the POJO
Since now you clearly see I am creating a `Divide` class, let us update the name.

```java
package classes.basic;

public class Divide {
	...
	...
}
```

Our `Divide` class will no longer be a POJO because we will have a very specific method, `divide`. But past that, it 
will be a pretty simple class. So, let's just get it over with and create that method.

```java
package classes.basic;

public class Divide {
	...
	...
	public double divide(){
		return (this.num * 1.0)/this.denom;
	}
}
```

Here I decided to return a `double` since in our examples we had a `num` of 3 and a `denom` of 4. If we returned the 
value of that as an `int`, it would always be 0. So I used a little trickery of `* 1.0` to the `num` to force it into
 a double, *then* when I divide a `double` by an `int`, I get a double. Thats it. We succeed at creating a class that
  is not a POJO. Here is then entire listing.
  
  
```java
package classes.basic;

public class Divide {
    private int num;
    private int denom;
    
    public Divide(){
        this.setNum(0);
        this.setDenom(0);
    }
    
    public Divide(int num, int denom){
        this.setNum(num);
        this.setDenom(denom);
    }
    
    
    public int getNum(){ return num; }
    public int getDenom(){ return denom; }
    
    public Divide setNum(int num){ 
        this.num = num; 
        return this;
    }
    
    
    public Divide setDenom(int denom){ 
        this.denom = denom; 
        return this;
    }
    
    public double divide(){
        return (this.num * 1.0)/this.denom;
    }
}
```

But there is a serious problem here. Do you see it? Let me give a code example that will break the system.

    Divide d = new Divide();
    d.setNum(3);
    d.divide();
    
Now it is obvious. In our default constructor we set `denom` to 0. 3/0 rips apart the universe. We have to handle 
this `ArithmeticException`. To do so, `divide` needs to throw that exception if `denom` is 0. Lets update the 
`divide` method.

```java
public double divide() throws ArithmeticException {
	if(this.denom == 0) throw new ArithmeticException("Cannot divide by 0");
	return (this.num * 1.0)/this.denom;
}
```

Now if the user calls upon our divide method, they will have to wrap it in a `try/catch`.

    
    try {
        Divide d = new Divide();
        d.setNum(3);
        d.divide();
    } catch (ArtihmeticException ae){
        System.out.println("Whoops. It broke");
        System.exit(1);
    }

## Overloading Methods
There will be times when a class requires more than one method of the same same. Let us use our `divide` method as an example. It makes total sense to also be able to pass the numerator and the denominator when calling divide, but yet we may still want
 keep the original. This would require us to overload the method.
 
```java
public double divide(){ 
	// our old implementation
}

public double divide(int num, int denom){
	return (num * 1.0)/denom;
}
```

Here, we have two methods named `divide`, but we have different parameters. As long as the parameters are unambiguous, eg they differ in parameter types, we can have as many versions of the same method we wish. When we call the method, java will automatically resolve the appropriate method as per the argument type.

## Basic Class Conclusion
We see we have four major types of class visibility: public, protected, package-private, and private. We also learned
 about a POJO. We learned that POJO has member variables and accessors and mutators. We also learned we can write 
 constructors that allow us to set up the instance. We now can start to leverage these concepts to construct complex 
 applications.
