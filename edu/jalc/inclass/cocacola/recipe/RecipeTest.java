package edu.jalc.inclass.cocacola.recipe;

import java.util.*;
import edu.jalc.inclass.cocacola.product.ingredient.Ingredient;


public class RecipeTest {

   public void testGetIngredients(){
      System.out.println("Testing Recipe::getIngredients");
      ArrayList <Ingredient> ingredients =new ArrayList<>();
      Ingredient ingredient =new Ingredient("sugar");
      ingredients.add(ingredient);
      Recipe recipe =new Recipe("name","instructions",ingredient);
      assert(recipe.getIngredients().equals(ingredients));
   }

   public void testGetName(){
      System.out.println("Testing Recipe::getName");
      ArrayList <Ingredient> ingredients =new ArrayList<>();
      Ingredient ingredient =new Ingredient("sugar");
      ingredients.add(ingredient);
      Recipe recipe = new Recipe("sugar","instructions",ingredient);
      assert(recipe.getName().equals("sugar"));
   }

   public void testGetInstructions(){
      System.out.println("Testing Recipe::getInstructions");
      Ingredient ingredient =new Ingredient("sugar");
      Recipe recipe = new Recipe("sugar","add and mix sugar",ingredient);
      assert(recipe.getInstructions().equals("add and mix sugar"));
   
   }

   public void testToString(){
      System.out.println("Testing Recipe::toString");
      Ingredient ingredient =new Ingredient("sugar");
      Recipe recipe = new Recipe("sugar","add and mix sugar",ingredient);
      assert(recipe.toString().equals(recipe.getName() + " - " + recipe.getInstructions()));
   }

   public static void main(String... args){
      RecipeTest recipeTest = new RecipeTest();
      recipeTest.testGetIngredients();
      recipeTest.testGetName();
      recipeTest.testGetInstructions();
      recipeTest.testToString();
      System.out.println("Recipe tests completed");
   }
}
