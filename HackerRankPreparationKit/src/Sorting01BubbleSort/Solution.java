package Sorting01BubbleSort;

import java.io.*;
import java.math.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
	 * Complete the 'countSwaps' function below.
	 *
	 * The function accepts INTEGER_ARRAY a as parameter.
	 */

	public static void countSwaps(List<Integer> a) {
		// Write your code here
		int swapCount = 0;
		for (int k = 0; k < a.size(); k++) {
			for (int l = 0; l < a.size() - 1; l++) {
				if (a.get(l) > a.get(l + 1)) {
					Integer tmp = a.get(l + 1);
					a.set(l + 1, a.get(l));
					a.set(l, tmp);
					swapCount++;
				}
			}
		}

		System.out.println("Array is sorted in " + swapCount + " swaps.");
		System.out.println("First Element: " + a.get(0));
		System.out.println("Last Element: " + a.get(a.size() - 1));
	}

}

public class Solution {
	// C:\DEV\JAVA\HackerRankPreparationKit\Inputs\Sorting01BubbleSort\input.txt
	// C:\DEV\JAVA\HackerRankPreparationKit\src\Inputs\Sorting01BubbleSort\input.txt
	public static void main(String[] args) throws IOException {
		Path inputPath = Paths.get("src\\Inputs\\Sorting01BubbleSort\\input.txt");

		BufferedReader bufferedReader = Files.newBufferedReader(inputPath.toAbsolutePath(), Charset.forName("UTF-8"));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		Result.countSwaps(a);

		bufferedReader.close();
	}
}
