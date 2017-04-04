package exercises.dependencyInjection;

public class Example implements Mysterious, Optional {

	private Optional optional;

	public Example(){}

	public Example(Optional optional){
		this.optional = optional;
	}

	@Override
	public void doOptional() {
		if(this.optional != null) optional.doOptional();
		else System.out.println("Default Example::doOptional used");
	}

	@Override
	public void doMysteryMethod(Injectable injectable) {
		injectable.doInjected();
	}
}
