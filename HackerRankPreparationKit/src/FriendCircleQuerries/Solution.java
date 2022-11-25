package FriendCircleQuerries;

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
import java.util.regex.*;

public class Solution {

	static Map<Integer, Set<Integer>> circlesRegister = new HashMap<>();
	static int maxSize = 0;

	static void addFriends(int first, int second) {
		Integer firstId = first;
		Integer secondId = second;

		Set<Integer> newCircle = new HashSet<>();
		newCircle.add(firstId);
		newCircle.add(secondId);

		if (circlesRegister.containsKey(firstId)) {
			Set<Integer> firstCircle = circlesRegister.get(firstId);
			newCircle.addAll(firstCircle);
		}

		if (circlesRegister.containsKey(secondId)) {
			Set<Integer> secondCircle = circlesRegister.get(secondId);
			newCircle.addAll(secondCircle);
		}

		newCircle.stream().forEach(id -> circlesRegister.put(id, newCircle));

		if (newCircle.size() > maxSize) {
			maxSize = newCircle.size();
		}

	}

	// Complete the maxCircle function below.
	static int[] maxCircle(int[][] queries) {
		int[] results = new int[queries.length];
		for (int k = 0; k < queries.length; k++) {
			addFriends(queries[k][0], queries[k][1]);
			results[k] = maxSize;
		}
		return results;
	}

	public static void main(String[] args) throws IOException {
		try {
			Path inputPath = Paths.get("src\\Inputs\\FriendCircleQuerries\\input.txt");
			BufferedReader scanner = Files.newBufferedReader(inputPath.toAbsolutePath());
			Path outputPath = Paths.get("src\\Inputs\\FriendCircleQuerries\\output.txt");
			BufferedWriter bufferedWriter = Files.newBufferedWriter(outputPath.toAbsolutePath(),
					StandardOpenOption.CREATE);

			int q = Integer.parseInt(scanner.readLine());

			int[][] queries = new int[q][2];

			for (int i = 0; i < q; i++) {
				String[] queriesRowItems = scanner.readLine().split(" ");

				for (int j = 0; j < 2; j++) {
					int queriesItem = Integer.parseInt(queriesRowItems[j]);
					queries[i][j] = queriesItem;
				}
			}

			int[] ans = maxCircle(queries);

			for (int i = 0; i < ans.length; i++) {
				bufferedWriter.write(String.valueOf(ans[i]));

				if (i != ans.length - 1) {
					bufferedWriter.write("\n");
				}
			}

			bufferedWriter.newLine();

			bufferedWriter.close();

			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
