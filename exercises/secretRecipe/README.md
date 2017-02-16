# Secret Recipe Lab
Provide a singleton class that holds secret recipes for coca cola.

## Objective
There should only exist one store of secret recipes and that store's recipes should only be able to be accessed by a users pin number.

## Rules
* The `SecretRecipeStore` should be a singleton
* The `SecretRecipeStore` should provide two instance methods `getRecipe`, `addRecipe`
* Recipes should not be allowed to be accessed unless a `Employee` `PinNumber` is passed with the recipe name.
* Since the Employee PinNumber is only known by the employee, do not pass the `PinNumber`, but rather the `Employee`
* Verify the pin numbers match, throw an exception if they do not.

## Tips
* Use a `HashMap` to store your recipes with pins. Think about how to access it. Remember, a `HashMap` has a key and value. Think about what should be the key and what should be the value. You will need to be able to find it by recipe name.

## Grading
This is a non-graded exercise but extra credit is available. This extra credit was detailed in a class wide email.