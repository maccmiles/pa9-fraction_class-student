package edu.wit.cs.comp1000;
import java.util.Scanner;

/**
 * PA9a
 * @author Miles Macchiaroli
 *
 */
public class PA9a {

	/**
	 * Program execution point:
	 * input two fractions via the keyboard
	 * (using the Scanner constructor),
	 * output the two fractions, all pairwise
	 * {+ - * /} operations, and the first squared
	 * minus the second 
	 * 
	 * @param args command-line arguments (ignored)
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);//call scanner
		System.out.printf("== F1 ==%n");
		Fraction FracA = new Fraction(input);
		System.out.printf("== F2 ==%n");
		Fraction FracB = new Fraction(input);
		/////PRINT//////
		System.out.printf("%nF1: %s%n", FracA);
		System.out.printf("F2: %s%n", FracB);
		System.out.printf("F1+F1: %s%n", FracA.plus(FracA));
		System.out.printf("F2+F2: %s%n", FracB.plus(FracB));
		System.out.printf("F1+F2: %s%n", FracA.plus(FracB));
		System.out.printf("F2+F1: %s%n", FracB.plus(FracA));
		System.out.printf("F1-F1: %s%n", FracA.minus(FracA));
		System.out.printf("F2-F2: %s%n", FracB.minus(FracB));
		System.out.printf("F1-F2: %s%n", FracA.minus(FracB));
		System.out.printf("F2-F1: %s%n", FracB.minus(FracA));
		System.out.printf("F1*F1: %s%n", FracA.times(FracA));
		System.out.printf("F2*F2: %s%n", FracB.times(FracB));
		System.out.printf("F1*F2: %s%n", FracA.times(FracB));
		System.out.printf("F2*F1: %s%n", FracB.times(FracA));
		System.out.printf("F1/F1: %s%n", FracA.divides(FracA));
		System.out.printf("F2/F2: %s%n", FracB.divides(FracB));
		System.out.printf("F1/F2: %s%n", FracA.divides(FracB));
		System.out.printf("F2/F1: %s%n", FracB.divides(FracA));
		System.out.printf("F1*F1-F2: %s%n", FracA.times(FracA).minus(FracB));

	}

}
