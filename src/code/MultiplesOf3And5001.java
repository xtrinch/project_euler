package code;
import java.math.*;
import report.*;

public class MultiplesOf3And5001 {

	/**
	
	If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
	Find the sum of all the multiples of 3 or 5 below 1000.
	
	**/
	
	public static int formulaSum(int div1, int div2, int upTo) {
		int lcm = div1 * div2;
		// number of multiples of div1
		int numMultiples1 = upTo / div1;
		// number of multiples of div2
		int numMultiples2 = upTo / div2;
		// number of multiples div1 and div2 have in common
		int numIntersectMultiples = upTo / lcm;
		
		// sum of all multiples of div1: div1 * (n*(n+1)/2)
		int sumMultiples1 = div1 * (numMultiples1 * (numMultiples1 + 1)) / 2;
		int sumMultiples2 = div2 * (numMultiples2 * (numMultiples2 + 1)) / 2;
		int sumIntersectMultiples = lcm * (numIntersectMultiples * (numIntersectMultiples + 1)) / 2;

		return sumMultiples1 + sumMultiples2 - sumIntersectMultiples;
	}
	
	public static int simpleSum(int div1, int div2, int upTo) {
		int sum = 0;
		for (int i=0; i<upTo; i++) {
			if (i % div1 == 0 || i % div2 == 0) {
				sum += i;
			}
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		ExecutionTime time = new ExecutionTime();

		
		//System.out.println(simpleSum(3, 5, 1000));
		System.out.println(formulaSum(3, 5, 1000));
		System.out.println(time.endTime());
	}
	
}
