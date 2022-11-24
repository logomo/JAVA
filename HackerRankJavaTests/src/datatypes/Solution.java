package datatypes;

import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] argh) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			/*
			 * A byte is an 8-bit signed integer. A short is a 16-bit signed integer. An int
			 * is a 32-bit signed integer. A long is a 64-bit signed integer.
			 */
			long short_min = (long) (Math.pow(2, 16) - 1) * -1;
			long short_max = (long) Math.pow(2, 16);
			long int_min = ((long) Math.pow(2, 32) - 1) * -1;
			long int_max = ((long) Math.pow(2, 32));
			long long_min = ((long) Math.pow(2, 64) - 1) * -1;
			long long_max = ((long) Math.pow(2, 64));
			try {
				long x = sc.nextLong();
				System.out.println(x + " can be fitted in:");
				if (x >= -128 && x <= 127) {
					System.out.println("* byte");
				} 
				if (x >= short_min && x <= short_max) {
					System.out.println("* short");
				} 
				if (x >= int_min && x <= int_max) {
					System.out.println("* int");
				}
				if (x >= long_min && x <= long_max) {
					System.out.println("* long");
				}
				// Complete the code

			} catch (Exception e) {
				System.out.println(sc.next() + " can't be fitted anywhere.");
			}

		}
	}
}
