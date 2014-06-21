package code;

public class EvenFibonacciNumbers002 {

	/**
	 
	By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
	 
	**/
	
	
	public static void main(String[] args) {
		
		int term1 = 0, term2 = 1, temp = 0, sum = 0;
		while ((temp = term1 + term2) <= (4 * Math.pow(10, 6))) {
			term1 = term2;
			term2 = temp;
			if((temp % 2) == 1) {
				sum += temp;
			}
		}
		
		System.out.println(sum);
	}
	
}
