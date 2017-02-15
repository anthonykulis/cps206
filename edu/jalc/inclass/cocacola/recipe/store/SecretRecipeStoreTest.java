package edu.jalc.inclass.cocacola.recipe.store;

import edu.jalc.inclass.cocacola.employee.Employee;
import edu.jalc.inclass.cocacola.product.ingredient.Ingredient;
import edu.jalc.inclass.cocacola.recipe.Recipe;
import edu.jalc.inclass.cocacola.security.PinNumber;

public class SecretRecipeStoreTest {

	public void testGetInstance(){
		System.out.println("Testing SecretRecipeTest::getInstance");

		SecretRecipeStore store = SecretRecipeStore.getInstance();
		SecretRecipeStore other = SecretRecipeStore.getInstance();
		assert(store == other);
	}

	public void testGetRecipe() throws Exception {
		System.out.println("Testing SecretRecipeTest::addRecipe");

		SecretRecipeStore store = SecretRecipeStore.getInstance();
		Recipe recipe = new Recipe("name", "instructions", new Ingredient("ingredient"));
		PinNumber pinNumber = new PinNumber(1234);
		Employee employee = new Employee("employee", pinNumber);
		store.addRecipe(recipe, employee);
		assert(recipe == store.getRecipe("name", employee));
	}


	public void testGetRecipeWithNoRecipe(){
		System.out.println("Testing SecretRecipeTest::getRecipe with no recipe");
		SecretRecipeStore store = SecretRecipeStore.getInstance();
		boolean exceptionThrown = false;
		try {
			store.getRecipe("none-found", null);
		} catch(Exception e){
			exceptionThrown = true;
		}
		assert(exceptionThrown);
	}

	public void testGetRecipeWithBadPin(){
		System.out.println("Testing SecretRecipeTest::getRecipe with bad pin");
		SecretRecipeStore store = SecretRecipeStore.getInstance();
		Recipe recipe = new Recipe("name", "instructions", new Ingredient("ingredient"));
		PinNumber pinNumber = new PinNumber(1234);
		Employee employee = new Employee("employee", pinNumber);
		store.addRecipe(recipe, employee);
		boolean exceptionThrown = false;
		try {
			employee.setPinNumber(new PinNumber(2345));
			store.getRecipe("name", employee);
		} catch(Exception e){
			exceptionThrown = true;
		}
		assert(exceptionThrown);
	}

	public static void main(String... args) throws Exception {
		SecretRecipeStoreTest secretRecipeStoreTest = new SecretRecipeStoreTest();
		secretRecipeStoreTest.testGetInstance();
		secretRecipeStoreTest.testGetRecipe();
		secretRecipeStoreTest.testGetRecipeWithNoRecipe();
		secretRecipeStoreTest.testGetRecipeWithBadPin();
		System.out.println("Completed SecretRecipeStore tests");
	}
}
