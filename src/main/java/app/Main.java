package app;

import java.io.IOException;

/**
 * Simple math arithmetic app.
 * @author Joshua Lawrinenko
 */
public class Main 
{
	public static java.util.Scanner in = new java.util.Scanner(System.in);
	/**
	 * Performs MathNum operations.
	 * @param args cmd line args
	 */
	public static void main( String[] args ) throws IOException {
		int a, b, c;
		
		System.out.print("Enter 2 numbers and a desired precision: ");
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		MathNum num1 = new MathNum(a);
		MathNum num2 = new MathNum(b);
		MathNum.setDefPrec(c);

		System.out.println();
		System.out.println("GCD of : " + num1 + ", " + num2 + " = " + num1.gcd(num2));
		System.out.println("LCM of : " + num1 + ", " + num2 + " = " + num1.lcm(num2));
		System.out.println("Sqrt of : " + num1 + " = " + num1.sqrt());
		System.out.println("Sqrt of : " + num2 + " = " + num2.sqrt());
	}
}
