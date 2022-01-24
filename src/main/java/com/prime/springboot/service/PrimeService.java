package com.prime.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prime.springboot.model.Prime;
import com.prime.springboot.repository.PrimeRepository;

/**
 * 
 * Prime Service class to help interact with the database
 *
 */

@Service
public class PrimeService {

	private PrimeRepository primeRepository;

	public PrimeService(PrimeRepository primeRepository) {
		super();
		this.primeRepository = primeRepository;
	}

	/**
	 * Saves the prime object into the database
	 * 
	 * @param prime object
	 * @return
	 */
	public Prime save(Prime prime) {
		return primeRepository.save(prime);
	}
	
	/**
	 * Returns the list of Prime objects stored in the database
	 * 
	 * @returns the list of prime objects from the database using repository
	 */
	public List<Prime> getAll() {
		return primeRepository.findAll();
	}

}
