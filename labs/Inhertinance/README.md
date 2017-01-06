# Lab 3 - Inheritance
This lab will cover writing inherited objects.

## Topic

You will do the quintessential *Shape* inheritance problem. This means you will need to have a series of objects that inherit from *TwoDimensionalShape*. This will also be your first introduction to using polymorphism. 

This lab will guide you through proper inheritance, only abstracting functionality out to the proper super classes. 
It will also demonstrate how polymorphism can be used via the open/closed principle.

## Rules

* You are to write 5 instantiable classes: *Circle*, *Ellipse*, *Rectangle*, *Square*, *RightTriangle*. Each of these classes should inherit from their proper parent, and those parents inherit from their proper parent, etc, until you reach the *TwoDimensionalShape* super class.

* Each of these classes must be able to compute their *area* and *perimeter* (*circumference*) via proper inheritance.

* Each of these classes must provide a human readable *toString* method.

* Each of these classes must provide an *equals* method. This method must be able to compare any *TwoDimensionalShape* to see if their areas are equal. If and only if the area is equal do we say they are equal. You do not have to consider round off error.

* Finally, you will write a driver. The driver should demonstrate use of polymorphism by comparing different object 
instances. Your driver should have at least one of each of your instantiable classes. You should be able to 
compare these objects to see if they are of equal area. That means if I had a rectangle with a height of 10 and a 
width of 2, it should equal a triangle with a height of 10 and a base of 4.

## Tips

* Use *2PI * sqrt ((a<sup>2</sup> + b<sup>2</sup>)/2)* when computing the circumference of an ellipse. Make sure to use the proper formula for computing the circumference of a circle though.

* When computing the 2 lengths of a ellipse, the proper terms are *minor* and *major* axis.

## Grading
You will be graded on proper use of keywords. Methods that should not be allowed to be overridden should be handled 
as such, classes not meant to be instantiated should be blocked, and child classes requiring implementations should be forced 
to do so. Do not violate DRY, Open/Closed, etc, and you will get full marks. This lab is not difficult, but requires 
attention to detail. 

## Extra Credit
This lab will have 2 parts of extra, totally 10 possible. 

### Part 1
Write unit tests with 100% method coverage. You may use jUnit if you so choose, or write private helper methods to 
*set, get, assert*. Make sure to enable assertions when testing with *java -ea MyTest*

### Part 2
Write a class that either takes a Circle and returns a Square with the same area, or takes a Square and returns a 
Circle with the same area. Hint, there will be round off errors. If you wish, you could use a class (not 
primitive) to represent the decimal data type. This is a *lot* of extra work though. Feel free to simply use 
primitives. 
 
## Run By Date
 
While this, and all labs, are due at the end of the semester, if you wish to be eligible for the extra credit, this assignment must be submitted in running order by Friday at midnight, March 10, 2017. You may either submit via D2L or by Github commit (make sure I am following you on Github and that you tag me in the commit).