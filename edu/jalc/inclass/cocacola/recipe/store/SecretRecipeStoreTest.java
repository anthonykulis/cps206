package edu.jalc.inclass.cocacola.recipe.store;

import edu.jalc.inclass.cocacola.employee.Employee;
import edu.jalc.inclass.cocacola.product.ingredient.Ingredient;
import edu.jalc.inclass.cocacola.recipe.Recipe;
import edu.jalc.inclass.cocacola.security.PinNumber;

public class SecretRecipeStoreTest {

	public void testGetInstance(){
		System.out.println("Testing SecretRecipeTest::getInstance");

		/*
		  very simple test, we can only have one instance of the store
		 */
		SecretRecipeStore store = SecretRecipeStore.getInstance();
		SecretRecipeStore other = SecretRecipeStore.getInstance();

		assert(store == other);
	}

	public void testGetRecipe() throws Exception {
		System.out.println("Testing SecretRecipeTest::addRecipe");

		SecretRecipeStore store = SecretRecipeStore.getInstance();

		/*
			typically we would use a tool (library) to mock these composite objects, but
			for simplicity sake in this class, just create them.
		 */
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

		/*
			typically we would use a tool (library) to mock these composite objects, but
			for simplicity sake in this class, just create them.
		 */
		Recipe recipe = new Recipe("name", "instructions", new Ingredient("ingredient"));
		PinNumber pinNumber = new PinNumber(1234);
		Employee employee = new Employee("employee", pinNumber);

		/*
			add to the store, we will change pins to cause it to fail
		 */
		store.addRecipe(recipe, employee);

		boolean exceptionThrown = false;
		try {

			/*
			 change the pin, forcing the failure
			 */
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

		/*
			Obviously these two tests do not check for what exception was thrown.
			Typically we would have custom exceptions for this and check that, but
			since that is beyond the scope of this class, we will let it slide this time.
		 */
		secretRecipeStoreTest.testGetRecipeWithNoRecipe();
		secretRecipeStoreTest.testGetRecipeWithBadPin();

		System.out.println("Completed SecretRecipeStore tests");
	}
}
