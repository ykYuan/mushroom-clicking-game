import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class HighScoreFinder {
	private int highestScore;
	private String line;
	private TreeMap <Integer, String> ScoreNameMap = new TreeMap<Integer, String>();
	private BufferedWriter writer;
	private TreeSet<String> allLines = new TreeSet<String>();

	public HighScoreFinder(java.io.Reader in) throws IOException {
		if (in != null) {
		BufferedReader bufferedReader = new BufferedReader(in);
		line = bufferedReader.readLine();
		while (line != null) {
		String[] splitString = line.split(":");
		String key = splitString[1].trim();
		int value = Integer.valueOf(splitString[0].trim());
		allLines.add(line);
		ScoreNameMap.put(value, key);
		line = bufferedReader.readLine();
		}
		}
	}

	public int getHighestScore() {
		Set<Integer> allScores = ScoreNameMap.keySet();
		for (int element: allScores) {
			highestScore = Math.max(highestScore, element);
		}
		return highestScore;
	}
	
	public String getHighestScoreName() {
		Set<Integer> allScores = ScoreNameMap.keySet();
		for (int element: allScores) {
			highestScore = Math.max(highestScore, element);
		}
		return ScoreNameMap.get(this.highestScore);
	}
	
	public void updateScoreList(int newScore, String newName) {
		try {
			writer = new BufferedWriter(new FileWriter("High Scores List"));
			writer.write(newScore + ":" + newName);
			writer.newLine();
			for (String element : allLines) {
				writer.write(element);
				writer.newLine();
			}
			writer.close();
			ScoreNameMap.put(newScore, newName);
			Set<Integer> allScores = ScoreNameMap.keySet();
			for (int element: allScores) {
				highestScore = Math.max(highestScore, element);
			}
			allLines.add(newScore + ":" + newName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
