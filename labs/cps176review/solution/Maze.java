package labs.cps176review.solution;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Maze {

	private char[][] maze;
	private int xPos;
	private int yPos;
	private boolean atFinish;

	ArrayList<Direction> moves = new ArrayList<>();

	private Maze(){}

	public Maze(char[][] maze){
		this.maze = maze;
	}

	public void setStartingPosition(int x, int y){
		this.xPos = x;
		this.yPos = y;
	}

	public boolean moveUp(){
		return move(Direction.UP);
	}

	public boolean moveDown(){
		return move(Direction.DOWN);
	}

	public boolean moveRight(){
		return move(Direction.RIGHT);
	}

	public boolean moveLeft(){
		return move(Direction.LEFT);
	}

	public boolean isUpOpen(){
		return isOpen(xPos, yPos - 1);
	}

	public boolean isDownOpen(){
		return isOpen(xPos, yPos + 1);
	}

	public boolean isLeftOpen(){
		return isOpen(xPos - 1, yPos);
	}

	public boolean isRightOpen(){
		return isOpen(xPos + 1, yPos);
	}

	public String getMoves(){
		return moves.stream().map(move -> {
			switch(move) {
				case UP:
					return "Up";
				case DOWN:
					return "Down";
				case LEFT:
					return "Left";
				case RIGHT:
					return "Right";
			}
			return null;
		}).collect(Collectors.toList()).toString();
	}

	public boolean isAtFinish(){ return atFinish; }

	public int getNumberOfMovesTaken(){ return moves.size(); }

	private boolean move(Direction direction){
		switch (direction){
			case UP:
				if(isUpOpen()) yPos--;
				else return false;
				break;
			case DOWN:
				if(isDownOpen()) yPos++;
				else return false;
				break;
			case LEFT:
				if(isLeftOpen()) xPos--;
				else return false;
				break;
			case RIGHT:
				if(isRightOpen()) xPos++;
				else return false;
				break;
			default: return false;
		}

		if(maze[yPos][xPos] == 'f') atFinish = true;

		moves.add(direction);

		return true;
	}

	private boolean isOpen(int x, int y){
		return maze[y][x] == ' ' || maze[y][x] == 'f';
	}
}