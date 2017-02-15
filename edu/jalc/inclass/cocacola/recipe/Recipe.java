package edu.jalc.inclass.cocacola.recipe;

import edu.jalc.inclass.cocacola.product.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;

public class Recipe {
	private final ArrayList<Ingredient> ingredients;
	private final String name;
	private final String instructions;

	private Recipe(){
		this.ingredients = new ArrayList<>();
		this.name = null;
		this.instructions = null;
	}

	public Recipe(String name, String instructions, Ingredient... ingredients){
		this.name = name;
		this.instructions = instructions;
		this.ingredients = new ArrayList<>();
		this.ingredients.addAll(Arrays.asList(ingredients));
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Ingredient> getIngredients(){
		// return an new list, keeping this one immutable
		return (ArrayList<Ingredient>) this.ingredients.clone();
	}

	public String getName(){
		return this.name;
	}

	public String getInstructions(){
		return this.instructions;
	}

	public String toString(){
		return this.getName() + " - " + this.getInstructions();
	}
}
