## Builder Pattern
This is the most common. Documentation for this pattern is best found [here](https://www.tutorialspoint.com/design_pattern/builder_pattern.htm). The reason for this because we end up with lots of classes that have many properties and become hard to instantiate. 

Let us imagine we have this class

```java
class Bottle {
	public Bottle(double volume, Lid lid, Label label, Content content){
		...
		...
	}
}
```

And of course, its composite objects

```java
class Lid {
	public Lid(Color color, Logo logo){
		...
		...
	}
}

class Label{
	public Label(Logo logo, List<Ingredient> ingredientList){
		...
		...
	}
}

class Content {
	public Content(double volume, List<Ingredient> ingredientList){
		...
		...
	}
}

class Color {
	public Color(int red, int green, int blue){
		...
		...
		..
	}
}

class Logo {
	public Logo(Image image, String text){
		...
		...
	}
}

class Ingredient {
	public Ingredient(String name){
		...
		...
	}
}

class Image {
	public Image(Byte[] bytes){
		...
		...
	}
}

```

I think you can see that would be a pain to instantiate multiples of this `Bottle` class. But what if we simply created a builder for it? Wouldn't it be easier to simply call `Bottle soda = SodaBottleBuilder.build()`?


```java
interface BottleBuilderInterface {
	Bottle build();
}
```

Now we could do the following

```java
SodaBottleBuilder implements BottleBuilderInterface {
	public Bottle build(){
		Image image = new Image(bytes);
		Ingredient sugar = new Ingredient("sugar");
		List<Ingredient> ingredients = new ArrayList<>();
		ingredients.add(sugar);
		Color color = new Color(255, 255, 255);
		
		Content soda = new Content(20, ingredients);
		
		Logo logo = new Logo(image, "soda");
		Lid lid = new Lid(color, logo);
		
		Label label = new Label(logo, ingredients);
		
		return new Bottle(20, lid, label, content);
	}
}
```
That simplifies it, but its still pretty blah. It doesn't give us much leeway to make various bottles. So lets take 
the things that may vary and make it optional to the user and hide the things that cant be modififed by the user.

```java
interface BottleBuilderInterface {
	void addIngredient(String name);
	void addLogoImage(Byte bytes);
	void setLidColor(int red, int green, int blue);
	void setCapacity(double capacity);
	void setVolume(double volume);
	Bottle build();
}

SodaBottleBuilder implements BottleBuilderInterface {
	
	private List<Ingredient> ingredients = new ArrayList<>();
	private Image image;
	private Color color;
	private double capacity;
	private double volume;
	
	void addIngredient(String name){
		this.ingredients.add(new Ingredient(name));
	}
	
	void addLogoImage(Byte bytes){
		this.image = new Image(bytes);
	}
	
	void setLidColor(int red, int green, int blue){
		this.color = new Color(red, green, blue);
	}
	
	void setCapacity(double capacity){
		this.capacity = capacity;
	}
	
	void setVolume(double volume){
		this.volume = volume;
	}
	
	public Bottle build(){
		Lid lid = new Lid(color, logo);
		Label label = new Label(logo, ingredients);
		Content content = new Content(this.volume, ingredients);
		return new Bottle(this.capacity, lid, label, content);
	}
}
```

This is a much cleaner implementation and easily scalable. We could imagine the following:

```java
SodaBottleBuilder builder = new SodaBottleBuilder();
builder.setCapacity(20);
builder.setVolume(20);
builder.addIngredient("sugar");

// build coke first
builder.setLidColor(255, 0, 0);
builder.addLogoImage(cokeLogoBytes);
Bottle cocacola = builder.build();

// now build pepsi
builder.setLidColor(0,0,255);
builder.addLogoImage(pepsiLogoBytes);
Bottle pepsi = builder.build();

// now build mountain dew
builder.setLidColor(0,255,0);
builder.addLogoImage(dewLogoBytes);
Bottle mountainDew = builder.build();
```