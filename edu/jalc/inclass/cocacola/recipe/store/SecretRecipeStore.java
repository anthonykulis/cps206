package edu.jalc.inclass.cocacola.recipe.store;


import edu.jalc.inclass.cocacola.employee.Employee;
import edu.jalc.inclass.cocacola.recipe.Recipe;
import edu.jalc.inclass.cocacola.security.PinNumber;

import java.util.HashMap;

/*
		This is a store of secret recipes.
 */
public class SecretRecipeStore {

	/*
		Our one instance of the class, be lazy in instantiation
	 */
	private static SecretRecipeStore secretRecipeStore = null;

	/*
		Our secret we are protecting.
	 */
	private final HashMap<Recipe, PinNumber> store;

	/*
		private so only this class can call it.
		Note we need a store, so create it.
	 */
	private SecretRecipeStore(){
		this.store = new HashMap<>();
	}

	/*
		Our singleton pattern
	 */
	public static SecretRecipeStore getInstance(){
		if(secretRecipeStore == null) secretRecipeStore = new SecretRecipeStore();
		return secretRecipeStore;
	}

	/*
		add a recipe, use the employees pin number to "secure" it
	 */
	public SecretRecipeStore addRecipe(Recipe recipe, Employee employee){
		this.store.put(recipe, employee.getPinNumber());
		return this;
	}

	/*
		get the recipe, only allowing the employee who put it there to get to it
		throw an exception if that recipe doesn't exist and throw on if the pin is bad.
	 */
	public Recipe getRecipe(String name, Employee employee) throws Exception {
		Recipe recipe = this.findByName(name);
		if(recipe == null) throw new Exception("Cannot find recipe: " + name);
		PinNumber recipePin = this.store.get(recipe);
		if(employee.getPinNumber().getPin() != recipePin.getPin()) throw new Exception("Pins do not match");
		return recipe;
	}


	/*
		Since we are storing the recipe object as a key, we have
		to find it by name. typically we wouldn't do this because a hashmap
		is meant to have fast lookup times (this isn't), and we would do something
		like HashMap<String, HashMap<Recipe, PinNumber>>, but this is just a simple
		exercise, so no worries. We will also assume no recipe has two of the same names.
	 */
	private Recipe findByName(String name){
		Recipe recipe = null;
		for(Recipe r : this.store.keySet()){
			if(r.getName().equals(name)){
				recipe = r;
				break;
			}
		}
		return recipe;
	}
}
