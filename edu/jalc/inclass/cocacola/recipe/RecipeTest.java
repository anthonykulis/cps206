package edu.jalc.inclass.cocacola.recipe;

import java.util.ArrayList;
import java.util.Arrays;
import edu.jalc.inclass.cocacola.product.ingredient.Ingredient;

public class RecipeTest {

	public void testGetIngredients(){
		System.out.println("Testing Recipe::getIngredients");
		ArrayList<Ingredient> ingredients = new ArrayList<>();
		Ingredient[] ingredient = new Ingredient[3];
		ingredient[0] = new Ingredient("milk");
		ingredient[1] = new Ingredient("cat");
		ingredient[2] = new Ingredient("salt");
		ingredients.addAll(Arrays.asList(ingredient));
		Recipe recipe = new Recipe("food", "Burn it", ingredient);
		assert(recipe.getIngredients().equals(ingredients));
	}

	public void testGetName(){
		System.out.println("Testing Recipe::getName");
		Ingredient ingredient = new Ingredient("salt");
		Recipe recipe = new Recipe("food", "Burn it",ingredient);
		assert(recipe.getName().equals("food"));
	}

	public void testGetInstructions(){
		System.out.println("Testing Recipe::getInstructions");
		Ingredient ingredient = new Ingredient("salt");
		Recipe recipe = new Recipe("food", "Burn it", ingredient);
		assert(recipe.getInstructions().equals("Burn it"));
	}

	public void testToString(){
		System.out.println("Testing Recipe::toString");
		Ingredient ingredient = new Ingredient("salt");
		Recipe recipe = new Recipe("food", "Burn it", ingredient);
		assert(recipe.toString().equals(recipe.getName() + " - " + recipe.getInstructions()));
	}

	public static void main(String... args){
		RecipeTest recipeTest = new RecipeTest();
		recipeTest.testGetIngredients();
		recipeTest.testGetInstructions();
		recipeTest.testGetName();
		recipeTest.testToString();
		System.out.println("Recipe tests completed");
	}
}
