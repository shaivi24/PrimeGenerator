package com.prime.springboot.PrimeGeneration;

import java.util.ArrayList;
import java.util.List;

public class Naive implements PrimeGenerator{

	@Override
	public List<Integer> getPrimes(int lower, int upper) {
		
		// initializing the list for prime numbers
		List<Integer> primes = new ArrayList<>();
		
		// looping through all numbers to check if they are prime
		for (int i=lower; i<=upper; i++) {
			if (checkPrime(i))
				primes.add(i);
		}
		
		// returning the list of prime numbers
		return primes;
	}
	
	/**
	 * Check if the given parameter is prime or not
	 * 
	 * @param n
	 * @returns whether the number is prime
	 */
	public boolean checkPrime(int n) {
		// checking for the base values
		if (n==1 || n==0)
			return false;
		
		// looping from 2 till the number to check
		// if it is divisible by any number other than 1 and n
		for (int i=2; i<n; i++) {
			if (n%i==0)
				return false;
		}
		return true;
	}

}
