package Sorting03Comparator;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Stream;

class Player {
	private Integer score;
	private String name;

	public static Comparator<Player> SCORE_DESCENDING = (Player o1, Player o2) -> (int) o2.score - o1.score;
	public static Comparator<Player> NAME_ASCENDING = (Player o1, Player o2) -> o1.name.compareToIgnoreCase(o2.name);

	@Override
	public String toString() {
		return "Player [score=" + score + ", name=" + name + "]";
	}

	public Player(Integer score, String name) {
		super();
		this.score = score;
		this.name = name;

	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Player parsePlayer(String var) {
		String input[] = var.split(" ");
		String name = input[0];
		Integer score = Integer.parseInt(input[1]);
		return new Player(score, name);
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		Path inputPath = Paths.get("src\\Inputs\\Sorting03Comparator\\input.txt");
		Path outputPath = Paths.get("src\\Inputs\\Sorting03Comparator\\output.txt");
		BufferedReader bufferedReader = Files.newBufferedReader(inputPath.toAbsolutePath(), Charset.forName("UTF-8"));
		BufferedWriter bufferedWriter = Files.newBufferedWriter(outputPath, StandardOpenOption.CREATE);
		// BufferedReader bufferedReader = new BufferedReader(new
		// InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int playerCount = Integer.parseInt(bufferedReader.readLine().replaceAll("\\s+$", ""));
		List<Player> players = new ArrayList<>();
		String playerRecord;
		while ((playerRecord = bufferedReader.readLine()) != null) {
			players.add(Player.parsePlayer(playerRecord));
		}

		players.sort(Player.SCORE_DESCENDING.thenComparing(Player.NAME_ASCENDING));
		players.stream().forEach(p -> {
			try {
				bufferedWriter.write(p.getName() + " " + p.getScore().toString() + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}

/*
 * BufferedReader bufferedReader = new BufferedReader(new
 * InputStreamReader(System.in)); BufferedWriter bufferedWriter = new
 * BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
 */
