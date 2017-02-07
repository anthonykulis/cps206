# Basic Windows Command Line Cheat Sheet

Use this [website](http://simplyadvanced.net/blog/cheat-sheet-for-windows-command-prompt/) as reference. If needed, I will add to this page.

## Listing a Directory
To see the contents of your current directory

    dir 
    
   
## Change Directory
Changing directory takes you from one "folder" to another. A directory is the same thing as a folder. Using this command is literally the equivalent of clicking in explorer.

    cd myFolder
    
The above command will take you from your current directory into `myFolder`. To change to `myFolder`, it needs to reside in the current directory.

Hint, you can use `tab` to cycle through all your current working directory's files and directories.

## Change Drives
To change drives (one letter to another). I am using `e` as an example. You need to replace `e` with the drive you wish to change to.

    cd e:
    
   
## Go up a directory
Sometimes we go too far. If you find yourself needing to go up a directory, simply use

    cd ..
    
## Run a java application
While in the current directory that contains the `myApplication.class` file you wish to run, type

    java myApplication
    
Of course, if your application has a different name, substitute that for `myApplication`. 

This is the "head" to your application. Being that you wish to enter the application here, this class **must** have a main method of proper syntax

    public static void main(String[] args){}
    

### Running a java application with arguments
Since your `main` method has the parameter of `String[] args`, you can pass arguments at the command line. To do so, and assuming your application name is `myApplication` and you wanted to pass it `cat`, `dog`, and `horse`, simply type

    java myApplication cat dog horse
    
By using spaces between items, you will automatically populate the `args` array of type `String` with 

    args[0] = "cat";
    args[1] = "dog";
    args[2] = "horse";
    
You can have as many arguments as you wish assuming your args array doesn't get so large as to consume all your ram.

## Compiling a java application 
While in the current working directory that contains `myApplication.java` file you wish to compile, type

    javac myApplication.java
    
Of course, if your application name differs, use that name in place of `myApplication`. Make sure to continue to identify the `.java` extension.


### Caveat - Using windows cmd line with packages
Today in class we noticed that not all machines are created equal. This may be because of different java version, configurations, who knows. But what we did find was that 

	javac edu\jalc\classes\Driver.java
	
works, but 

	java edu\jalc\classes\Driver
	
does not.

The best I can figure is that `java` itself doesn't know how to resolve the windows path. This makes some sense, but it is totally confusing that `javac` does.

To fix this, compile like stated, but run with 	

	java edu/jalc/classes/Driver
	
Or, more simply, you can also run it as follows:

	java edu.jalc.classes.Driver