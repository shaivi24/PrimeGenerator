package com.prime.springboot.PrimeGeneration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenes implements PrimeGenerator {

	@Override
	public List<Integer> getPrimes(int lower, int upper) {
		
		// declaring a boolean array 
		boolean[] prime = new boolean[upper+1];
		List<Integer> primes = new ArrayList<Integer>();
		
		// filling default value of true 
		Arrays.fill(prime, true);
		
		prime[0] = false;
		prime[1] = false;
		
		// looping through the array to mark all multiples of prime numbers
		// as false (not prime)
		for (int i=2; i*i<upper+1; i++) {
			// if number is prime
			if (prime[i]) {
				// marking all multiples as false
				for (int j=i*i; j<upper+1; j+=i) {
					prime[j] = false;
				}
			}
		}
		
		// adding the prime number between and including lower and upper bounds
		for (int i=lower; i<=upper; i++) {
			if (prime[i]) primes.add(i);
		}
		
		return primes;
	}

}
