package com.prime.springboot.controller;

import java.util.List;
import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prime.springboot.main.AlgorithmClassifier;
import com.prime.springboot.model.Prime;
import com.prime.springboot.service.PrimeService;

@RestController
public class PrimeController {

	private PrimeService primeService;

	public PrimeController(PrimeService primeService) {
		super();
		this.primeService = primeService;
	}


	/**
	 * RestAPI for getting the list of numbers 
	 * 
	 * @param algorithm	
	 * @param lower bound
	 * @param upper bound
	 * @returns the list of prime numbers
	 */
	@GetMapping("/prime")
	public List<Integer> primesss(@RequestParam("algorithm") String algorithm, 
			@RequestParam("lower") int lower, 
			@RequestParam("upper") int upper) {
		
		// declaring a prime object 
		Prime p = new Prime();
		
		// setting the timestamp, algorithm and
		// upper and lower bounds
		p.setTimestamp(Timestamp.from(Instant.now()));
		p.setLower(lower);
		p.setUpper(upper);
		p.setAlgorithm(algorithm);
		
		
		long start = System.currentTimeMillis();
		
		// calling the classifier method to get the list of primes using 
		// the proper classified algorithm
		List<Integer> primes = AlgorithmClassifier.classifier(algorithm, lower, upper);
		
		long end = System.currentTimeMillis();
		
		// getting the time taken by the algorithm
		p.setElapsedTime((end - start)/1000.0);
		p.setNumberOfPrime(primes.size());
		
		// saving the object to database using prime Service
		primeService.save(p);
		return primes;
	}
	
	/**
	 * Gives the list of objects stored in the database
	 * 
	 * @returns the list of prime objects
	 */
	@GetMapping("/database")
	public List<Prime> getDatabase(){
		return primeService.getAll();
	}

	/**
	 * Gives the list of objects stored in the database 
	 * with uses the particular algorithm
	 * 
	 * @param algorithm
	 * @returns the list of prime objects
	 */
	@GetMapping("/database/{algorithm}")
	public List<Prime> getAlgorithmData(@PathVariable("algorithm") String algorithm) {
		return primeService.getAlgorithm(algorithm);
	}

}
