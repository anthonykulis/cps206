# Order Lab (Jan 24 and 26)
Create an application named `Order` that reads any number of orders from file and creates receipts for them.

## Requirements
* Read the order file(s) from command line
* Use the `Calculator` class to compute the total
* Provide a discount if order says it has a discount
* Compute taxes at 5%, providing a before tax and after tax total.
* List each item in the order, quantity, price per item, and price per quantity. I will provide some order files on my repository for you to use.


## Grading
This is a non-graded exercise

### Extra Credit
This assignment will have 5 points extra credit if and only if you provide an `Item` class that represents each item read. An item can be a discount and a tax. We will learn later how to succinctly handle this.

## Tips
1. Read the command line. Make sure the arguments passed are legitimate text files (string)

2. Delegate reading the file(s). This means you will need to loop the command line arguments and should give the work load off to a method (or class) to read the given file. Handle any exceptions gracefully. It may be that one order is messed up but the 30 other ones passed are not. Do not exit because one is broken. Figure out a way to be graceful about it.

3. Do not compute the total while you are reading. Instead collect each item and put it into an array. The array may fill up before the order is read. You may need to resize the array.

4. Once collected, iterate the array computing the total. Reuse our previous work (`Calculator`). If yours didn't work, use mine.

5. Delegate printing the receipt. 