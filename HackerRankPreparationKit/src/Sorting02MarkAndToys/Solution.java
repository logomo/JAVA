package Sorting02MarkAndToys;

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
     * Complete the 'maximumToys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY prices
     *  2. INTEGER k
     */

    public static int maximumToys(List<Integer> prices, int k) {
    	Comparator<Integer> PRICE_ASCENDING = (Integer a, Integer b) -> a-b; 
		prices.sort(PRICE_ASCENDING);
		int remainingBudget = k;
		int count = 0;
		for (Integer price : prices) {
			remainingBudget = remainingBudget - price;
			if (remainingBudget >=0) {
				count++;
			}
			else{
				break;
			}
			
		}
		
		return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
    	Path inputPath = Paths.get("src\\Inputs\\Sorting02MarkAndToys\\input.txt");
    	Path outputPath = Paths.get("src\\Inputs\\Sorting02MarkAndToys\\output.txt");
		BufferedReader bufferedReader = Files.newBufferedReader(inputPath.toAbsolutePath(), Charset.forName("UTF-8"));

        BufferedWriter bufferedWriter = Files.newBufferedWriter(outputPath, StandardOpenOption.CREATE);

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
