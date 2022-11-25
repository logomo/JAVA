package StringManipulation03Sherlock;

import java.io.*;
import java.math.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'isValid' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING s as
	 * parameter.
	 */

	public static String isValid(String s) {
		// Write your code here
		char[] myCharArray = s.toCharArray();

		Stream<Character> myStreamOfCharacters = IntStream.range(0, myCharArray.length).mapToObj(i -> myCharArray[i]);

		List<Character> myListOfCharacters = myStreamOfCharacters.collect(Collectors.toList());

		Map<Character, List<Character>> histogram = myListOfCharacters.stream()
				.collect(Collectors.groupingBy(ch -> ch));
		Map<Integer, List<List<Character>>> secondHistogram = histogram.values().stream()
				.collect(Collectors.groupingBy(lst -> lst.size()));

		if (secondHistogram.values().size() == 1) {
			return "YES";
		}
		if (secondHistogram.values().size() == 2) {
			List<Integer> counts = secondHistogram.values().stream().map(lst -> lst.size())
					.collect(Collectors.toList());
			if (counts.get(0) == 1 || counts.get(1) == 1) {
				return "YES";
			}
		}
		return "NO";
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		Path inputPath = Paths.get("src\\Inputs\\StringManipulation03Sherlock\\input.txt");
		Path outputPath = Paths.get("src\\Inputs\\StringManipulation03Sherlock\\output.txt");
		BufferedReader bufferedReader = Files.newBufferedReader(inputPath.toAbsolutePath(), Charset.forName("UTF-8"));
		BufferedWriter bufferedWriter = Files.newBufferedWriter(outputPath, StandardOpenOption.CREATE);
		// BufferedReader bufferedReader = new BufferedReader(new
		// InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		String result = Result.isValid(s);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
