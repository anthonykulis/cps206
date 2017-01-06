# Lab 2 - The POJO
This lab will cover writing POJOs, establishing a basis for Single Use Purpose

## Topic
You will pick an every day object. From this object, you will identify every property (not action) that is has. From this, you will create plain old java objects (POJOs) that allow to eventually instantiate this object in its entirety.

You are not responsible for its actions. Eg, if your choice of object is a television, *turnOn* is not required to be written.

## Example

Imagine I chose a Soda bottle. Because I have, you may not choose this item. As I look at the bottle I notice it has the following properties


### Bottle

* A lid
* A label
* A volume
* A capacity
* ...
* ...
* ...

While volume and capacity can be described as primitives, label and lid cannot. This means I need to also define composite objects for each of these.

### Lid
* Diameter
* Height
* Color
* ...

### Label
* Text
* Images
* Color
* ...

Now as I realize that a Color is a combination of Red, Blue, and Green values, I see I need another class, *Color*. Furthermore, the labels Image, well that is an object too. So I will also have to create the Image class. 

## Rules
* The Object you wish to describe as a POJO must have composite objects (POJOs). Do not get carried way. If the object you selected is that complex, you may stop at 2 sub levels of composition (eg bottle -> label -> color)

* You must have at least two sub-levels of composition (eg bottle -> label -> color)

* You must have accessors and mutators for each property with proper visibility

* Properties must be of proper visibility

## Extra Credit
To receive the extra credit for this lab, you must write unit tests for each method! You are required to have 100% method coverage. This means one unit test to *set*, *get*, and *assert* is acceptable. 

If you are not using maven to import jUnit, you may write your tests as private methods called by the main method. If you are using jUnit, be sure to submit your tests with proper naming conventions. If you are using maven to manage the project, be sure to submit the *pom.xml* file as well. 

## Run By Date
While this, and all labs, are due at the end of the semester, if you wish to be eligible for the extra credit, this assignment must be submitted in running order by Friday at midnight, Feb 17, 2017. You may either submit via D2L or by Github commit (make sure I am following you on Github and that you tag me in the commit).