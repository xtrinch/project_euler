package code;
import report.*;

public class LargestPalindromeProduct004 {

	/**

	A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
	Find the largest palindrome made from the product of two 3-digit numbers.

	 */
	
	/*
	 * returns a decimal digit at a specific index within the digit
	 */
	public static int getDigit(int num, int index) {
		
		for(int i=numDigits(num)-1; i>index; i--) {
			num = num / 10;
		}
		return num % 10;
	}
	
	/*
	 * returns the number of decimal digits in a binary integer
	 */
	public static int numDigits(int num) {
		return ((int) Math.floor(Math.log10(num)))+1;
	}
	
	/*
	 * checks whether the number is a palindrome
	 */
	public static boolean isPalindrome(int potentialPalindrome) {
		int numDig = numDigits(potentialPalindrome);
		
		int i=0, j = numDig-1;
		while(i < j) {
			int leftDig = getDigit(potentialPalindrome, i);
			//System.out.println(leftDig);
			int rightDig = getDigit(potentialPalindrome, j);
			//System.out.println(leftDig);
			if (leftDig != rightDig)	return false;
			
			i++;
			j--;
		}

		
		return true;
	}
	
	public static void main(String[] args) {

		ExecutionTime time = new ExecutionTime();
		
		int maxPal = -1;
		
		for (int i=100; i<1000; i++) {
			for (int j=100; j<1000; j++) {
				
				int potPal = i * j;
				boolean isPal = isPalindrome(potPal);
				if (isPal && potPal > maxPal) {
					maxPal = potPal;
					
				}
			}
		}
		
		System.out.println("Largest palindrome: "+maxPal);
		System.out.println(time.endTime());
	}

}