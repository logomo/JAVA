package Greedy04MinMaxArray;

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
	 * Complete the 'maxMin' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER k 2. INTEGER_ARRAY arr
	 */

	private static void helper(List<int[]> combinations, int data[], int start, int end, int index) {
		if (index == data.length) {
			int[] combination = data.clone();
			combinations.add(combination);
		} else if (start <= end) {
			data[index] = start;
			helper(combinations, data, start + 1, end, index + 1);
			helper(combinations, data, start + 1, end, index);
		}
	}

	private static List<int[]> generate(int n, int r) {
		List<int[]> combinations = new ArrayList<>();
		helper(combinations, new int[r], 0, n - 1, 0);
		return combinations;
	}

	public static int maxMin(int k, List<Integer> arr) {
		// Write your code here
		// 1. Generate list of combinations
		List<int[]> indexes = generate(arr.size(), k);
		// indexes.stream().forEach(ar -> System.out.println(Arrays.toString(ar)));

		// 2. Generate subarrays with proper values
		List<List<Integer>> subarrays = new LinkedList<>();
		for (int[] comb : indexes) {
			List<Integer> subarr = new ArrayList<>();
			for (k = 0; k < comb.length; k++) {
				subarr.add(arr.get(comb[k]));
			}
			subarrays.add(subarr);
		}

		// 3. Calculate min max for each selection
		// subarrays.stream().forEach(ar -> System.out.println(ar));
		List<Integer> minMaxForEachComb = subarrays.stream().map((List<Integer> comb) -> {
			List<Integer> temp = new ArrayList<>(comb);
			Collections.sort(temp);
			Integer min = temp.get(0);
			Integer max = temp.get(temp.size() - 1);
			return max - min;
		}).collect(Collectors.toList());
		// System.out.print(minMaxForEachComb);

		// 4 Find the lowerst numer aka most "equal"
		List<Integer> minMaxCopy = new LinkedList<>(minMaxForEachComb);
		Collections.sort(minMaxCopy);
		return minMaxCopy.get(0);
	}

}

// Note to myself -> this can be solved without heap overflow, due the memory missmanagement, because it is possible to evaluate case by case, not to generate all cases at once

public class Solution {
	public static void main(String[] args) throws IOException {
		Path inputPath = Paths.get("src\\Inputs\\Greedy04MinMaxArray\\input.txt");
		Path outputPath = Paths.get("src\\Inputs\\Greedy04MinMaxArray\\output.txt");
		BufferedReader bufferedReader = Files.newBufferedReader(inputPath.toAbsolutePath(), Charset.forName("UTF-8"));
		BufferedWriter bufferedWriter = Files.newBufferedWriter(outputPath, StandardOpenOption.CREATE);

		// BufferedReader bufferedReader = new BufferedReader(new
		// InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		int k = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int result = Result.maxMin(k, arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
