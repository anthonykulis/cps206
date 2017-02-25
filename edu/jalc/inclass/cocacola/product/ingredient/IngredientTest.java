package edu.jalc.inclass.cocacola.product.ingredient;

public class IngredientTest {

	public void testGetName(){
		System.out.println("Testing Ingredient::getName");
      Ingredient ingredient = new Ingredient("carbonated water");
		assert(ingredient.getName().equals("carbonated water"));
	}

	public void testtoString(){
		System.out.println("Testing Ingredient::getName");
      Ingredient ingredient = new Ingredient("carbonated water");
		assert(ingredient.toString().equals("carbonated water"));
	}

	public static void main(String... args){
		IngredientTest ingredientTest = new IngredientTest();
		ingredientTest.testGetName();
		ingredientTest.testtoString();
		System.out.println("Completed testing Ingredients");
	}
}
