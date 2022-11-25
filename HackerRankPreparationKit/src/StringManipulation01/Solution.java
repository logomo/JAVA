package StringManipulation01;

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
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static int makeAnagram(String a, String b) {
    // Write your code here
    	char[] pa = a.toCharArray();
    	Arrays.sort(pa);
    	char[] pb = b.toCharArray();
    	Arrays.sort(pb);
    	
    	int ha=0;
    	int hb=0;
    	int counter = 0;
    	while (ha < a.length() && hb < b.length()) {
    		char val_a = pa[ha];
    		char val_b = pb[hb];
    		
    		if (val_a == val_b) {
    			counter ++;
    			ha ++;
    			hb ++;
    			continue;
    		}
    		if (val_a > val_b) {
    			hb ++;
    		}
    		else {
    			ha ++;
    		}
    	}
    	return a.length() + b.length() - 2 * counter;	
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
    	
		Path inputPath = Paths.get("src\\Inputs\\StringManipulation01\\input.txt");
		Path outputPath = Paths.get("src\\Inputs\\StringManipulation01\\output.txt");
		BufferedReader bufferedReader = Files.newBufferedReader(inputPath.toAbsolutePath(), Charset.forName("UTF-8"));
		BufferedWriter bufferedWriter = Files.newBufferedWriter(outputPath, StandardOpenOption.CREATE);
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = Result.makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

