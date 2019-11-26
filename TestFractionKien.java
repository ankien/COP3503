import java.util.Scanner;

/*  Andrew Kien
 *  This program accepts integer inputs for the numerator and denominator of two fractions.
 *  It then prints the reduced result of Addition, Subtraction, Multiplication, and Division of the two fractions.
 */ 
 
public class TestFractionKien {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// Stage 1: No-arg constructor for myFraction1 of the Fraction class.
		Fraction myFraction1 = new Fraction();
		
		// Stage 2: Prompts input for the values of the first fraction, then assigns these values to the object of myFraction1.
		System.out.print("Enter numerator for myFraction1: ");
		int n1 = input.nextInt();
		System.out.print("Enter denominator for myFraction1: ");
		int d1 = input.nextInt();
		
		myFraction1 = new Fraction(n1,d1);
		
		// Stage 3: Prompts input for the values of the second fraction, the object is initialized and given its arguments in one step.
		System.out.print("\nEnter numerator for myFraction2: ");
		int n2 = input.nextInt();
		System.out.print("Enter denominator for myFraction2: ");
		int d2 = input.nextInt();
		
		Fraction myFraction2 = new Fraction(n2,d2);
		
		// Stage 4: Prints a string of each fraction by calling a method in the Fraction class.
		System.out.println("\nmyFraction1 = " + myFraction1.printFraction());
		System.out.println("myFraction2 = " + myFraction2.printFraction());
		
		// Stage 5: Prints the data fields of each fraction individually using accessor methods.
		System.out.println("\nThe numerator of myFraction1 is: " + myFraction1.getNumerator());
		System.out.println("The denominator of myFraction1 is: " + myFraction1.getDenominator());
		
		System.out.println("\nThe numerator of myFraction2 is: " + myFraction2.getNumerator());
		System.out.println("The denominator of myFraction2 is: " + myFraction2.getDenominator());
		
		// Stage 6: The sum of both fractions in reduced form is printed.
		System.out.println("\n" + myFraction1.printFraction() + " + " + myFraction2.printFraction() + " = " + myFraction1.addFraction(myFraction2).reduceFraction().printFraction());
		
		// Stage 7: Subtracts, multiplies, and divides the fractions and prints them like in Stage 6.
		System.out.println(myFraction1.printFraction() + " - " + myFraction2.printFraction() + " = " + myFraction1.subtractFraction(myFraction2).reduceFraction().printFraction());
		System.out.println(myFraction1.printFraction() + " * " + myFraction2.printFraction() + " = " + myFraction1.multiplyFraction(myFraction2).reduceFraction().printFraction());
		System.out.println("(" + myFraction1.printFraction() + ")" + " / " + "(" + myFraction2.printFraction() + ")" + " = " + myFraction1.divideFraction(myFraction2).reduceFraction().printFraction());

		
		input.close();
	}
}

class Fraction {
	
	private int numerator;
	private int denominator;
	
	Fraction() {
		numerator   = 0;
		denominator = 1;
	}
	
	Fraction(int newNumerator, int newDenominator) {
		numerator   = newNumerator;
		denominator = newDenominator;
	}
	
	/* Takes the values from the constructors above.
	 * Returns these values in a string for the main class to print.
	 */
	String printFraction() {
		return String.format("%d / %d", numerator, denominator);
	}
	
	int getNumerator() {
		return numerator;
	}
	
	int getDenominator() {
		return denominator;
	}
	
	/* Finds the GCD of fractions through use of a formula: (gcd(a,b) = a) if b is 0; otherwise, (gcd(a,b) = gcd(b, a % b))
	 * It uses recursion to loop itself until a GCD is found, and returns the integer value of data field "a".
	 */
	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
	
	/* Uses the GCD calculation to reduce the fraction.
	 * It reduces the numerator and denominator individually for each object where it's called.
	 */
	Fraction reduceFraction() {
		int gcdCalc = gcd(numerator, denominator);
		this.numerator   /= gcdCalc;
		this.denominator /= gcdCalc;
		return this;
	}
	
	/* Finds the sum of two fractions:
	 * a/b + c/d = (a*d + c*b) / (b*d)
	 */
	public Fraction addFraction(Fraction myFraction) {
		int numeratorSum   = ((this.numerator * myFraction.denominator) + (myFraction.numerator * this.denominator));
		int denominatorSum = (this.denominator * myFraction.denominator);
		return new Fraction(numeratorSum, denominatorSum);
	}
	
	/* Finds the difference of two fractions:
	 * a/b - c/d = (a*d - c*b) / (b*d)
	 */
	public Fraction subtractFraction(Fraction myFraction) {
		int numeratorDifference   = ((this.numerator * myFraction.denominator) - (myFraction.numerator * this.denominator));
		int denominatorDifference = (this.denominator * myFraction.denominator);
		return new Fraction(numeratorDifference, denominatorDifference);
	}
	
	/* Finds the product of two fractions:
	 * a/b * c/d = (a*c) / (b*d)
	 */
	public Fraction multiplyFraction(Fraction myFraction) {
		int numeratorProduct   = (this.numerator * myFraction.numerator);
		int denominatorProduct = (this.denominator * myFraction.denominator);
		return new Fraction(numeratorProduct, denominatorProduct);
	}
	
	/* Finds the quotient of two fractions:
	 * (a/b) / (c/d) = (a*d) / (b*c)
	 */
	public Fraction divideFraction(Fraction myFraction) {
		int numeratorQuotient   = (this.numerator * myFraction.denominator);
		int denominatorQuotient = (this.denominator * myFraction.numerator);
		return new Fraction(numeratorQuotient, denominatorQuotient);
	}
}
