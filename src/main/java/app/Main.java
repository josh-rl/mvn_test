package app;

import java.io.File;
import java.io.FileWriter;

/**
 * MathNum demo app
 * @author Joshua Lawrinenko
 */
public class Main 
{
	/**
	 * Scanner
	 */
	public static java.util.Scanner in = new java.util.Scanner(System.in);

	/**
	 * Test function 0
	 */
	public static void test0() {
		long a, b;
		int c, d, e;
		
		System.out.println();
		System.out.print("Enter 2 numbers, desired precision, and 2 powers.\nFormat <long long int int int>: ");
		a = in.nextLong();
		b = in.nextLong();
		c = in.nextInt();
		d = in.nextInt();
		e = in.nextInt();
		MathNum num1 = new MathNum(a);
		MathNum num2 = new MathNum(b);
		MathNum.setDefPrec(c);

		System.out.println();
		System.out.println("GCD of : " + num1 + ", " + num2 + " = " + num1.gcd(num2));
		System.out.println("LCM of : " + num1 + ", " + num2 + " = " + num1.lcm(num2));
		System.out.println("Sqrt of : " + num1 + " = " + num1.sqrt());
		System.out.println("Sqrt of : " + num2 + " = " + num2.sqrt());
		System.out.println("Factors of : " + num1 + " : " + num1.getFactors());
		System.out.println("Factors of : " + num2 + " : " + num2.getFactors());
		System.out.println("Prime factors of : " + num1 + " : " + num1.getPrimeFactors());
		System.out.println("Prime factors of : " + num2 + " : " + num2.getPrimeFactors());
		System.out.println("POW : " + num1 + "^" + Integer.toString(d) + " = " + num1.pow(d));
		System.out.println("POW : " + num2 + "^" + Integer.toString(e) + " = " + num2.pow(e));
		System.out.println();
	}

	/**
	 * Test function 1
	 * @param a long
	 * @param b long
	 * @param c int
	 * @param d int
	 * @param e int
	 */
	public static void test1(long a, long b, int c, int d, int e) {
		MathNum num1 = new MathNum(a);
		MathNum num2 = new MathNum(b);
		MathNum.setDefPrec(c);

		System.out.println();
		System.out.println("GCD of : " + num1 + ", " + num2 + " = " + num1.gcd(num2));
		System.out.println("LCM of : " + num1 + ", " + num2 + " = " + num1.lcm(num2));
		System.out.println("Sqrt of : " + num1 + " = " + num1.sqrt());
		System.out.println("Sqrt of : " + num2 + " = " + num2.sqrt());
		System.out.println("Factors of : " + num1 + " : " + num1.getFactors());
		System.out.println("Factors of : " + num2 + " : " + num2.getFactors());
		System.out.println("Prime factors of : " + num1 + " : " + num1.getPrimeFactors());
		System.out.println("Prime factors of : " + num2 + " : " + num2.getPrimeFactors());
		System.out.println("POW : " + num1 + "^" + Integer.toString(d) + " = " + num1.pow(d));
		System.out.println("POW : " + num2 + "^" + Integer.toString(e) + " = " + num2.pow(e));
		System.out.println();
	}

	/**
	 * Outputs primes up to x in file "primes.txt"
	 * @param x integer
	 */
	public static void test2(int x) {
		if (x < 1 || x > 2_000_000) return;
		try {
			File f = new File("primes.txt");
			FileWriter fw = new FileWriter(f);
			for (long i = 1; i < x; i += 2) {
				if (MathNum.isPrime(i)) fw.write(Long.toString(i) + ",\n");
			}
			fw.close();
		} catch(java.io.IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Demos MathNum operations
	 * @param args args
	 * @throws java.io.IOException from Scanner
	 */
	public static void main(String[] args) throws java.io.IOException {
		test0();
		// test1(9_120_120_120L, 4_000_000_500L, 20, 0, 0);
		// test1(1_327_000_327L, 7_327_327_327L, 20, 0, 0);
	}
}
