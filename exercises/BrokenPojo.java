package exercises;

public class BrokenPojo {

	String name;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		// broken!
		return "not your name " + name;
	}

	public static void main(String... args){
		BrokenPojo brokenPojo = new BrokenPojo();
		String name = "anthony";
		brokenPojo.setName(name);

		// will not test w/o -ea flag

		// expected style with : operator, second half is your detail on its failure
		assert brokenPojo.getName().equals(name) : "name in pojo is not " + name + " but rather >> " + brokenPojo.getName();

		// alternative option that works, but not accepted for EC. Note, the first assertion prevents this one from firing
		assert brokenPojo.getName().equals(name);
	}
}
