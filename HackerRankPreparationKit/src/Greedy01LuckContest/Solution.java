package Greedy01LuckContest;

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
	 * Complete the 'luckBalance' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER k 2. 2D_INTEGER_ARRAY contests
	 */

	public static int luckBalance(int k, List<List<Integer>> contests) {
		List<Integer> important = contests.stream().filter(lst -> lst.get(1) == 1).map(lst -> lst.get(0))
				.collect(toList());
		important.sort((a, b) -> a - b);
		
		//important.stream().forEach(i -> { System.out.print(i + " "); });
		//System.out.println();
		
		Integer sum = 0;
		for (Integer i = 0; i < important.size() -k; i++) {
			sum += important.get(i);
		}
		Integer maxPoints = 0;
		for (List<Integer> record : contests) {
			maxPoints += record.get(0);
		}
		//System.out.println(maxPoints - 2*sum);
		return maxPoints - 2*sum;
		// Write your code here

	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		Path inputPath = Paths.get("src\\Inputs\\Greedy01LuckContest\\input.txt");
		Path outputPath = Paths.get("src\\Inputs\\Greedy01LuckContest\\output.txt");
		BufferedReader bufferedReader = Files.newBufferedReader(inputPath.toAbsolutePath(), Charset.forName("UTF-8"));
		BufferedWriter bufferedWriter = Files.newBufferedWriter(outputPath, StandardOpenOption.CREATE);
		// BufferedReader bufferedReader = new BufferedReader(new
		// InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int k = Integer.parseInt(firstMultipleInput[1]);

		List<List<Integer>> contests = new ArrayList<>();

		IntStream.range(0, n).forEach(i -> {
			try {
				contests.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int result = Result.luckBalance(k, contests);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
