package labs.cps176review.solution;

import java.util.Scanner;

public class Driver {

	static Scanner scanner = new Scanner(System.in);

	static String prompt(String msg){
		System.out.println(msg);
		return scanner.nextLine();
	}

	static void message(String msg){
		System.out.println(msg);
	}

	public static void main(String... args) throws Exception {

		// check for custom map
		if(args.length > 1){
			System.err.println("Usage: java Driver [maze file]");
			System.exit(1);
		}

		Maze maze;
		MazeReader mazeReader = new MazeReader();
		String mazeFileName = "./labs/cps176review/solution/defaultMaze";

		// set default map if needed
		if(args.length == 1) mazeFileName = args[0];

		// read in map
		char[][] mazeData = mazeReader.getMazeData(mazeFileName);
		maze = new Maze(mazeData);

		// naively find empty spot to start
		int x = 0;
		int y = 0;
		int area = mazeData.length * mazeData[0].length;
		int i = 0;
		for(; i < area; i++){
			y = (int)(Math.random() * mazeData.length);
			x = (int)(Math.random() * mazeData[0].length);
			if(mazeData[y][x] == ' ') break;
		}

		// whoops, broken map?
		if(i == area) throw new Exception("Unable to find a random starting location, please load again. I am kind of " +
						"naive on finding a random starting point. If that doesn't work, load a different map.");

		// set the starting point
		maze.setStartingPosition(x, y);

		// run until won
		boolean atFinish = maze.isAtFinish();
		String lastMessage = "Welcome to the maze, get ready to die!";

		while(!atFinish){

			// clear screen each tick
			final String ANSI_CLS = "\u001b[2J";
			final String ANSI_HOME = "\u001b[H";
			System.out.print(ANSI_CLS + ANSI_HOME);
			System.out.flush();

			message(lastMessage);
			message("Type a direction - ");
			if(maze.isUpOpen()) message("Up is open");
			if(maze.isDownOpen()) message("Down is open");
			if(maze.isRightOpen()) message("Right is open");
			if(maze.isLeftOpen()) message("Left is open");
			message("History -> " + maze.getMoves());

			switch(prompt("Which way do you wish to go").toLowerCase()){
				case "up":
					if(!maze.moveUp()) lastMessage = "Up isn't open";
					break;
				case "down":
					if(!maze.moveDown()) lastMessage = "Up isn't open";
					break;
				case "left":
					if(!maze.moveLeft()) lastMessage = "Left isn't open";
					break;
				case "right":
					if(!maze.moveRight()) lastMessage = "Right isn't open";
					break;
				case "history":

					break;
				default:
					lastMessage = "I dont know how to go that way";
			}

			atFinish = maze.isAtFinish();
		}

		message("Amazing, you did it in " + maze.getNumberOfMovesTaken() + " moves!");
	}
}