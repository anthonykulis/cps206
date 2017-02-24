package edu.jalc.inclass.cocacola.product.ingredient;

public class IngredientTest {

   public void testGetName(){
      System.out.println("Testing Ingredient::getName");
      String name = "caffeine";
      Ingredient ingredient = new Ingredient(name);
      assert(ingredient.getName().equals(name));
   }

   public void testToString(){
      System.out.println("Testing Ingredient::toString");
      String name = "sugar";
      Ingredient ingredient = new Ingredient(name);
      assert(ingredient.toString().equals(name));
   }

   public static void main(String[] args){
      IngredientTest test = new IngredientTest();
      test.testGetName();
      test.testToString();
      System.out.println("All Tests for Ingredient Passed");
   }
}
