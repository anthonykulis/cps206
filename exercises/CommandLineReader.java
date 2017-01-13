package exercises;

public class CommandLineReader {

	public static void main(String... args){

		if(args.length == 0) {
			System.out.println("No arguments passed");
		}

		for(String arg :  args){
			System.out.println(arg);
		}

	}
}
