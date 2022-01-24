package com.prime.springboot.PrimeGeneration;

import java.util.ArrayList;
import java.util.List;

public class OptimizedNaive implements PrimeGenerator {

	@Override
	public List<Integer> getPrimes(int lower, int upper) {
		
		// initializing a list of prime numbers
		List<Integer> primes = new ArrayList<>();
		
		// looping through to check for prime numbers
		for (int i=lower; i<=upper; i++) {
			if (checkPrime(i))
				primes.add(i);
		}
		
		return primes;
	}
	
	/**
	 * Checks whether the number is prime number
	 * 
	 * @param n
	 * @returns whether the number is prime
	 */
	public boolean checkPrime(int n) {
		if (n==1)
			return false;
		else if (n==2)
			return true;
		
		// return false if the number is even
		else if (n%2==0) {
			return false;
		}
		
		// otherwise loop through till the root of the number
		for (int i=3; i*i<=n; i+=2) {
			if (n%i==0)
				return false;
		}
		return true;
	}

}
