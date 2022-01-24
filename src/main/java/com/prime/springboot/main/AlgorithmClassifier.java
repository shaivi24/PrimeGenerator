package com.prime.springboot.main;

import java.util.ArrayList;
import java.util.List;

import com.prime.springboot.PrimeGeneration.SieveOfEratosthenes;
import com.prime.springboot.PrimeGeneration.Naive;
import com.prime.springboot.PrimeGeneration.OptimizedNaive;
import com.prime.springboot.PrimeGeneration.PrimeGenerator;

public class AlgorithmClassifier {

	public static List<Integer> classifier(String algorithm, int lower, int upper) {
		
		// declaring a prime generator object to initialize 
		// according to the algorithm selected
		PrimeGenerator p;
		
		// conditions to check the algorithm
		if (algorithm.equalsIgnoreCase("naive")) {
			p = new Naive();
		}
		else if (algorithm.equalsIgnoreCase("optnaive")) {
			p = new OptimizedNaive();
		}
		else if (algorithm.equalsIgnoreCase("eratosthenes")) {
			p = new SieveOfEratosthenes();
		}
		else {
			System.out.println("Invalid Technique");
			return new ArrayList<>();
		}
		
		// returning the list of integers by calling the proper
		// algorithm
		return p.getPrimes(lower, upper);
	}
}
