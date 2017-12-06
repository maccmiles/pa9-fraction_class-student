package edu.wit.cs.comp1000;

import java.util.Scanner;

// TODO: document this class
public class Fraction {
	private int num;//NUMERATOR
	private int den;//DENOMINATOR
	/**
	 * Error to output if denominator is zero
	 */
	@SuppressWarnings("unused")
	private static final String E_DEN_ZERO = "Denominator cannot be zero.";

	/**
	 * Error to output if dividing by zero
	 */
	@SuppressWarnings("unused")
	private static final String E_DIV_ZERO = "Cannot divide by zero.";

	/**
	 * Returns the greatest common divisor (gcd) of two integers
	 * 
	 * @param num1 integer 1
	 * @param num2 integer 2
	 * @return gcd of integers 1 and 2
	 */
	private static int gcd(int num1, int num2) {
		int t;
		while (num2 != 0) {
			t = num2;
			num2 = num1 % num2;
			num1 = t;
		}

		return num1;
	}

	/**
	 * Returns the simplified form of a fraction
	 * 
	 * @param f fraction (numerator=[0], denominator=[1])
	 * @return simplified fraction (numerator=[0], denominator=[1])
	 */
	@SuppressWarnings("unused")
	private static int[] simplifyFraction(int[] f) {
		final int gcd = gcd(f[0], f[1]);
		int[] result = {f[0]/gcd, f[1]/gcd};

		if ((result[0]<0 && result[1]<0) || (result[1]<0)) {
			result[0] = -result[0];
			result[1] = -result[1];
		}

		return result;
	}

	/**
	 * Constructs a fraction given a numerator/denominator
	 * 
	 * If denominator = 0, exit with message
	 * 
	 * @param n numerator
	 * @param d denominator
	 */
	public Fraction(int n, int d) {
		if(d == 0) {
			System.out.println(E_DEN_ZERO);
			System.exit(0);//Exit if Denominator is 0
		}
		int []arr=new int[] {n,d};//create temp array
		num=simplifyFraction(arr)[0];//simplify numerator
		den =simplifyFraction(arr)[1];//simplify denominator
	}

	/**
	 * Constructs a fraction as 0/1
	 */
	public Fraction() {
		num = 0;
		den = 1;
	}

	/**
	 * Constructs a fraction given input from a supplied Scanner
	 * 
	 * If denominator = 0, exit with message
	 * 
	 * @param s scanner from which to read fraction components
	 */
	public Fraction(Scanner s) {
		System.out.printf("Enter numerator: ");
		int n = s.nextInt();
		System.out.printf("Enter denominator: ");
		int d = s.nextInt();
		if(d == 0) {
			System.out.println(E_DEN_ZERO);
			System.exit(0);//exit if denominator is 0
		}
		int []arr=new int[] {n,d};//create temp array
		num=simplifyFraction(arr)[0];//simplify numerator
		den =simplifyFraction(arr)[1];//simplify denominator
	}

	/**
	 * Gets the decimal value of a fraction
	 * 
	 * @return decimal version
	 */
	public double toDecimal() {
		return ((num*1.0)/(den*1.0));//return numerator/denominator, casted as double
	}

	/**
	 * Returns the string value of a fraction:
	 * - if denominator is 1, "numerator"
	 * - else, "numerator/denominator (decimal with three decimal places)"
	 * 
	 * @return string formatted fraction
	 */
	public String toString() {
		if (den == 1) {
			return num+"";//Return numerator casted as string
		}
		return String.format("%d/%d (%.3f)",num,den,this.toDecimal());//construct string in fraction format, with trailing decimal
	}

	/**
	 * Gets the fraction numerator
	 * 
	 * @return numerator
	 */
	public int getNumerator() {
		return num;//return Numerator
	}

	/**
	 * Gets the fraction denominator
	 * 
	 * @return denominator
	 */
	public int getDenominator() {
		return den;//return Denominator
	}

	/**
	 * Adds a fraction to this fraction
	 * 
	 * @param f fraction to add
	 * @return a new fraction that sums this and the supplied parameter
	 */
	public Fraction plus(Fraction f) {
		Fraction f2 = new Fraction(num*f.getDenominator()+(f.getNumerator()*den),den*f.getDenominator());//create new fraction
		int []arr=new int[] {f2.getNumerator(),f2.getDenominator()};//create temp array
		int t1=simplifyFraction(arr)[0];//simplify numerator
		int t2 =simplifyFraction(arr)[1];//simplify denominator
		return new Fraction(t1,t2);//return t1,t2
	}

	/**
	 * Subtracts a fraction from this fraction
	 * 
	 * @param f fraction to subtract
	 * @return a new fraction that results from subtracting the supplied parameter from this
	 */
	public Fraction minus(Fraction f) {
		Fraction f2 = new Fraction(num*f.getDenominator()-(f.getNumerator()*den),den*f.getDenominator());//create new fraction
		int []arr=new int[] {f2.getNumerator(),f2.getDenominator()};//create temp array
		int t1=simplifyFraction(arr)[0];//simplify numerator
		int t2 =simplifyFraction(arr)[1];//simplify denominator
		return new Fraction(t1,t2);//return t1,t2
	}

	/**
	 * Multiplies a fraction with this fraction
	 * 
	 * @param f fraction to multiply
	 * @return a new fraction that is the product of this and the supplied parameter
	 */
	public Fraction times(Fraction f) {
		Fraction f2 = new Fraction(num*f.getNumerator(),den*f.getDenominator());//create new fraction
		int []arr=new int[] {f2.getNumerator(),f2.getDenominator()};//create temp array
		int t1=simplifyFraction(arr)[0];//simplify numerator
		int t2 =simplifyFraction(arr)[1];//simplify denominator
		return new Fraction(t1,t2);//return t1,t2
	}

	/**
	 * Divides a fraction into this fraction
	 * 
	 * @param f fraction with which to divide
	 * @return a new fraction that is the quotient of this and the supplied parameter
	 */
	public Fraction divides(Fraction f) {
		if (f.getNumerator()==0) {
			System.out.println(E_DIV_ZERO);
			System.exit(0);//quit if numerator is 0
		}
		Fraction f2 = new Fraction(num*f.getDenominator(),den*f.getNumerator());//create new fraction
		int []arr=new int[] {f2.getNumerator(),f2.getDenominator()};//create temp array
		int t1=simplifyFraction(arr)[0];//simplify numerator
		int t2 =simplifyFraction(arr)[1];//simplify denominator
		return new Fraction(t1,t2);//return t1,t2
	}

}
