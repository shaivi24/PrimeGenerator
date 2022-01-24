package com.prime.springboot.main;

import java.util.List;

public class Main {

	/**
	 * Input from Command line
	 * 'algorithm' 'lower' 'upper'
	 * different algorithms: naive, eratosthenes, sundaram
	 * @param args
	 */
	public static void main(String[] args) {
		
		// checking if the number of arguments are less than 3
		// if so, error message is printed
		if (args.length<3) {
			System.out.println("Insufficient Arguments!");
			return;
		}
		
		// extracting input from the arguments
		String algorithm = args[0];
		int lower = Integer.parseInt(args[1]);
		int upper = Integer.parseInt(args[2]);
		
		// taking the list of prime numbers from PrimeAlgorithmClassifier class
		List<Integer> primes = AlgorithmClassifier.classifier(algorithm, lower, upper);
		
		// printing the prime numbers on command line
		for(int e : primes)
			System.out.print(e+" ");
	}

}
