# Iterators

So far in Java you have only used `for`, `while`, and `do while` loops. Maybe you where introduced to `enhanced for 
loops`. Iterators though, do the same *thing*, but fall into a different category. While the loops I mentioned are 
language constructs, iterators are classes. You can, and will in cps215, create your own. But what I want to 
introduce here is how to use them since you will encounter them in the Java api.

Imagine we are using an [ArrayList](http://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) and it is 
populated with type `String` of `A, B, C, D, ..`. If you wanted to iterate this, sure you could construct any of the 
language constructs to loop it. But you could also use an iterator. Imagine the following code existing somewhere 
usable.

```java
ArrayList<String> letters = new ArrayList<>();
letters.add("A");
letters.add("B");
...
...
...
```

Now if we wanted to *iterate* across each element with a `for` loop, but stop when we got to `"F"`, we'd need code 
that looks like the following:
 
```java
for(int i = 0; i < letters.size(); i++){
	String letter = letters.get(i);
	if(letter.equals("F")) break;
}
```

Alternatively, if we wanted to use an iterator, we would have the following code:
```java
Iterator<String> it = letters.iterator();
do {
	String letter = letters.next();
} while(!letter.equals("F") && it.hasNext());
```

Using iterators provides an alternative to having to manage `int`s. Feel free to use any style as long as that style 
is conducive to your task at hand.