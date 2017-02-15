package edu.jalc.inclass.cocacola.recipe.store;


import edu.jalc.inclass.cocacola.employee.Employee;
import edu.jalc.inclass.cocacola.recipe.Recipe;
import edu.jalc.inclass.cocacola.security.PinNumber;

import java.util.HashMap;

/*

		This is a store of secret recipes.

		There can only be one instance of the store!
		The store houses a collection of recipes that require a pin number to access.
		This pin number belongs to an employee, so only that employee, using their pin, can access the recipe!
		Make sure your `getRecipe` method checks for the employee's pin against the recipes pin! If the pins do not
		match, throw an exception.
 */
public class SecretRecipeStore {

	private static SecretRecipeStore secretRecipeStore = null;
	private final HashMap<Recipe, PinNumber> store;

	private SecretRecipeStore(){
		this.store = new HashMap<>();
	}

	public static SecretRecipeStore getInstance(){
		if(secretRecipeStore == null) secretRecipeStore = new SecretRecipeStore();
		return secretRecipeStore;
	}

	public SecretRecipeStore addRecipe(Recipe recipe, Employee employee){
		this.store.put(recipe, employee.getPinNumber());
		return this;
	}

	public Recipe getRecipe(String name, Employee employee) throws Exception {
		Recipe recipe = this.findByName(name);
		if(recipe == null) throw new Exception("Cannot find recipe: " + name);
		PinNumber recipePin = this.store.get(recipe);
		if(employee.getPinNumber().getPin() != recipePin.getPin()) throw new Exception("Pins do not match");
		return recipe;
	}


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
