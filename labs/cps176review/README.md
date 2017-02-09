# Lab 1 - CPS176 Review

This lab will cover all the concepts you learned in CPS176. 

## Topic
Write a *Maze* application such that the user can navigate a text based maze.
 
## Rules
* The user should be *randomly* dropped into the maze. Make sure not to put the user in a wall or the exit!
* The user should be prompted after each step on which direction they may go next. Only allowed options are *Up*, 
*Right*, *Left*, *Down*. If a wall blocks a direction, that direction should not be included. E.g. if they reached a 
dead end after only being able to go *Up*, the only option available should be *Down*. This establishes your knowledge of user input,
 string matching, conditions, and loops.

* The user should be allowed to type *History* and each step they have taken so far. This establishes your knowledge 
of arrays.

* When the user reaches the exit, the should be rewarded with some congratulatory message and the number of steps it 
took them to complete the maze. Again, this establishes your knowledge of array use.

* The user should load the program with 1 argument, the maze file they wish to use. If not supplied, a default maze 
should be loaded (from text file). This establishes your knowledge of file i/o and main method arguments, and 
populating a 2 dimensional array.

## Example of Maze
Use the following as an example to construct your maze. Of course, you may substitute as you see fit. In my example, **x** is a wall, **f** is the finish.

	xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	x     x                 x     f
	xxxx  xxxxx  xxx   xxxxxx  xxxx
	x            x                x
	xx  xxxxx  xxxxxxxx  xxxxxxxxxx
	x       x                     x
	xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	
	
## Extra Credit
Add monsters to the maze. If a user encounters a monster, they are overcome by fear and move 5 random places. This should not include the exit! This also means make sure not to put a monster in front of the exit, but the monsters should be randomly placed. 

To run the application, it should be optional to have monsters. This means `java Maze MyMazeMap addMonsters 5` or `java Maze` or `java Maze MyMazeMap` are all legal options. The generic usage syntax would look like `java Maze [maze file] addMonsters <number of monsters>`. Of course, if the user doesn't pass a maze file, for this one, we will not allow them to add random monsters.

## *Run By* Date
While this, and all labs, are due at the end of the semester, if you wish to be eligible for the extra credit, this assignment must be submitted in running order by Friday at midnight, Feb 10, 2017. You may either submit via D2L or by Github commit (make sure I am following you on Github and that you tag me in the commit). 
