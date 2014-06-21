package code;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class LargestPrimeFactor003 {
	
	/**
	The prime factors of 13195 are 5, 7, 13 and 29.
	What is the largest prime factor of the number 600851475143 ?
	**/
	
	// generates the sieve of erastothenes
	// incrementally generates prime numbers
	// continually divides the big integer until the result is 1 (which means we have divided with all of the prime factors)

	public static int nextPrime(int prevPrime, BitSet sieve) {
		
		// get the prime, it is where sieve.get returns false
		int i=1;
		while(sieve.get(prevPrime + i))	i++;
		int nextPrime = prevPrime + i;
		
		// correct the sieve
		i=2;
		while(nextPrime * i < sieve.size() && nextPrime * i > nextPrime * (i-1)) {
			sieve.set(nextPrime * i);
			i++;
		}
		
		return nextPrime;
	}
	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();

		// create a sieve in the form of a BitSet which is a bitmap
		BitSet sieve = new BitSet(Integer.MAX_VALUE);
		BigInteger numToFactor = new BigInteger("600851475143");

		// initialize to first prime
		int prime = 2;
		
		// dokler nismo dobili vseh faktorjev in delili še z zadnjim praštevilom -> dobili 1
		while(numToFactor.intValue() != 1) {
			BigInteger modulus = numToFactor.mod(BigInteger.valueOf((long)prime));
			int m = modulus.intValue();
			
			if (m == 0) numToFactor = numToFactor.divide(BigInteger.valueOf((long)prime));
			else prime = nextPrime(prime, sieve);
		}

		System.out.println("Largest prime factor: " + prime);

		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Execution time: "+totalTime/1000.0 + "s");
		
	}
}
