package com.prime.springboot.PrimeGeneration;

import java.util.List;

/**
 * 
 * Interface for the different algorithms for generating 
 * prime numbers within a given range
 *
 */
public interface PrimeGenerator {

	public List<Integer> getPrimes(int lower, int upper);
}
