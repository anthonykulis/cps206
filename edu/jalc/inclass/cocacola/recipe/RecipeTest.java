package edu.jalc.inclass.cocacola.recipe;

import edu.jalc.inclass.cocacola.product.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipeTest {

   public void testGetIngredients(){
      System.out.println("Testing Recipe::getIngredients");
      ArrayList<Ingredient> ingredients = new ArrayList<>();
      Ingredient[] ingredient = new Ingredient[2];
      ingredient[0] = new Ingredient("Sugar");
      ingredient[1] = new Ingredient("Water");
      ingredients.addAll(Arrays.asList(ingredient));
      Recipe recipe = new Recipe("Coke", "Add Sugar", ingredient);
      assert(recipe.getIngredients().equals(ingredients));
   }

   public void testGetName(){
      System.out.println("Testing Recipe::getName");
      Ingredient ingredient = new Ingredient("Sugar");
      Recipe recipe = new Recipe("Coke", "Add Sugar", ingredient);
      assert(recipe.getName().equals("Coke"));	
   }

   public void testGetInstructions(){
      System.out.println("Testing Recipe::getInstructions");
      Ingredient ingredient = new Ingredient("Sugar");
      Recipe recipe = new Recipe("Coke", "Add Sugar", ingredient);
      assert(recipe.getInstructions().equals("Add Sugar"));	
   }

   public void testToString(){
      System.out.println("Testing Recipe::toString");
      Ingredient ingredient = new Ingredient("Sugar");
      Recipe recipe = new Recipe("Coke", "Add Sugar", ingredient);
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
