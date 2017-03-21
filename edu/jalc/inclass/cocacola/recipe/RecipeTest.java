package edu.jalc.inclass.cocacola.recipe;

import edu.jalc.inclass.cocacola.product.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipeTest {

   public void testGetIngredients(){
      System.out.println("Testing Recipe::getIngredients");
      ArrayList<Ingredient> ingredients = new ArrayList<>();
      Ingredient[] ingredient = new Ingredient[3];
      ingredient[0] = new Ingredient("caffeine");
      ingredient[1] = new Ingredient("sodium");
      ingredient[2] = new Ingredient("corn syrup");
      ingredients.addAll(Arrays.asList(ingredient));
      Recipe recipe = new Recipe("Coke", "add vanilla extract", ingredient);
      assert(recipe.getIngredients().equals(ingredients));
   }

   public void testGetName(){
      System.out.println("Testing Recipe::getName");
      Ingredient ingredient = new Ingredient("sodium");
      Recipe recipe = new Recipe("coke", null, ingredient);
      assert(recipe.getName().equals("Coke"));
   }

   public void testGetInstructions(){
      System.out.println("Testing Recipe::getInstructions");
      Ingredient ingredient = new Ingredient("sodium");
      Recipe recipe = new Recipe(null, "add soidum", ingredient);
      assert(recipe.getInstructions().equals("add sodium"));
   }

   public void testToString(){
      System.out.println("Testing Recipe::toString");
      Ingredient ingredient = new Ingredient("sodium");
      Recipe recipe = new Recipe("Coke", "add sodium", ingredient);
      assert(recipe.toString().equals(recipe.getName() + " - " + recipe.getInstructions()));
   }

   public static void main(String[] args){
      RecipeTest test = new RecipeTest();
      test.testGetIngredients();
      test.testGetInstructions();
      test.testGetName();
      test.testToString();
      System.out.println("All Tests for Recipe Passed");
   }
}
