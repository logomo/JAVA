package Greedy02MinimumDifferenceInArray;

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
	 * Complete the 'minimumAbsoluteDifference' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY arr as parameter.
	 */

	public static int minimumAbsoluteDifference(List<Integer> arr) {
		// Write your code here
		Integer min = Integer.MAX_VALUE;
		for (int k = 0; k < arr.size() - 1; k++) {
			for (int l = k + 1; l < arr.size(); l++) {
				Integer a = arr.get(k);
				Integer b = arr.get(l);
				Integer comp_val = Math.abs(a - b);
				if (comp_val < min) {
					min = comp_val;
				}
			}
		}

		return min;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		Path inputPath = Paths.get("src\\Inputs\\Greedy02MinimumDifferenceInArray\\input.txt");
		Path outputPath = Paths.get("src\\Inputs\\Greedy02MinimumDifferenceInArray\\output.txt");
		BufferedReader bufferedReader = Files.newBufferedReader(inputPath.toAbsolutePath(), Charset.forName("UTF-8"));
		BufferedWriter bufferedWriter = Files.newBufferedWriter(outputPath, StandardOpenOption.CREATE);
		// BufferedReader bufferedReader = new BufferedReader(new
		// InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int result = Result.minimumAbsoluteDifference(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
