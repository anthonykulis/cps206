# Lab 3 - Inheritance
This lab will cover writing inherited objects.

## Topic

You will do the quintessential *Shape* inheritance problem. This means you will need to have a series of objects that inherit from *TwoDimensionalShape*. This will also be your first introduction to using polymorphism. 

This lab will guide you through proper inheritance, only abstracting functionality out to the proper super classes. 
It will also demonstrate how polymorphism can be used via the open/closed principle.

## Rules
* You will write an *abstract TwoDimensionalShape* class. This class will provide base properties, methods, and define required methods to be implemented by child classes.
	
* Each child class will be required to implement *area*, hence, the *TwoDimensionalShape* class will require that abstract method.

* The *TwoDimensionalShape* class should implement the *equals* method and determine if the comparision of the two objects has the same area via polymorphism.
	
* You will define an *abstract EdgedShape* class from *TwoDimensionalShape*. This class will be the parent for all objects with a *width* and *height*. It should also force the child classes to provide a *perimeter* method. 

* You will define an abstract *EllipseShape* class from *TwoDimensionalShape*. This class will be the parent for all objects with *minor* and 
*major* axis
. It should force all child classes to provide a *circumference* method. Furthermore, since the area can be computed 
now, this class should compute a *final area* method and it should provide a *final equals* method to see if the area
 of the ellipse shapes are the same.

* You will define an *abstract Triangle* class. This class with only implement the *area* method, *1/2 * b * h*.
* You will define a *RightTriangle* class. This class should be *final* and inherit *EdgedShape*. This class will compute its perimeter using Pythagoras' theorem.

* You will define a *Rectangle* class. Again, this class should inherit *EdgedShape*. It will compute its area, *b * 
h*, and provide an *equals* method to see if the triangles area of equal values.

* You will define a *final Square* class. Fortunately, this class already has all its methods and properties defined. 

* You will define a *Ellipse* class. This class should provide a *circumference* method using the approximation of *2PI * sqrt ((a<sup>2</sup> + b<sup>2</sup>)/2)*. 

* You will define a *final Circle* class. This class should a *circumference* method using *2PI * minor * major*, or 
since *minor == major*, *2PI * R*.

* Finally, you will write a driver. The driver should demonstrate use of polymorphism by comparing different object 
instances. Your driver should have at least one *Triangle*, *Square*, *Ellipse*, and *Circle*. You should be able to 
compare these objects to see if they are of equal area. That means if I had a rectangle with a height of 10 and a 
width of 2, it should equal a triangle with a height of 10 and a base of 4.

## Extra Credit
This lab will have 2 parts of extra, totally 10 possible. 

### Part 1
Write unit tests with 100% method coverage. You may use jUnit if you so choose, or write private helper methods to 
*set, get, assert*.

### Part 2
Write a class that either takes a Circle and returns a Square with the same area, or takes a Square and returns a 
Circle with the same area. Hint, you will need to use a class (not primitive) to represent the decimal data type. You
 will need to investigate this on your own for the purpose of handling round off error.
 
## Run By Date
 
While this, and all labs, are due at the end of the semester, if you wish to be eligible for the extra credit, this assignment must be submitted in running order by Friday at midnight, March 10, 2017. You may either submit via D2L or by Github commit (make sure I am following you on Github and that you tag me in the commit).