package exercises.dependencyInjection;

public class Driver {

	public static void main(String... args){
		Example example = new Example();
		Example injectedExample = new Example(() -> System.out.println("Injected Optional::doOptional called"));

		Injectable injectable = () -> System.out.println("mystery method injected");
		example.doOptional();
		example.doMysteryMethod(injectable);

		injectedExample.doOptional();
		injectedExample.doMysteryMethod(injectable);
	}
}
