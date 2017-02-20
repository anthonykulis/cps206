package edu.jalc.inclass.cocacola.product.ingredient;

public class IngredientTest {

   public void testGetName(){
      System.out.println("Testing Ingredient::getName");
      Ingredient ingredient = new Ingredient("Coke");
      assert(ingredient.getName().equals("Coke"));
   }

   public void testtoString(){
      System.out.println("Testing Ingredient::toString");
      Ingredient ingredient = new Ingredient("Coke");
      assert(ingredient.toString().equals("Coke"));
   }

   public static void main(String... args){
      IngredientTest ingredientTest = new IngredientTest();
      ingredientTest.testGetName();
      ingredientTest.testtoString();
      System.out.println("Completed testing Ingredients");
   }
}
