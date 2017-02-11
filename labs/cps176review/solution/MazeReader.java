package labs.cps176review.solution;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;

public class MazeReader {
	public char[][] getMazeData(String fileName) throws IOException {

		ArrayList<String> fileLines = new ArrayList<>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
		String currentLine;
		while((currentLine = bufferedReader.readLine()) != null){
			fileLines.add(currentLine);
		}

		char[][] maze = new char[fileLines.size()][];
		Iterator iterator = fileLines.iterator();
		int i = 0;
		while(iterator.hasNext()){
			String line = (String) iterator.next();
			maze[i] = new char[line.length()];
			for(int j = 0; j < line.length(); j++){
				maze[i][j] = line.charAt(j);
			}
			i++;
		}

		return maze;
	}
}