package edu.jalc.inclass.cocacola.product.ingredient;

public class Ingredient {
	private final String name;

	private Ingredient(){
		this.name = null;
	}

	public Ingredient(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public String toString(){
		return this.getName();
	}

}
