package com.prime.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prime.springboot.model.Prime;

/**
 * Prime Repository extends the Jpa Repository which 
 * helps in interacting with the datasource
 *
 */
public interface PrimeRepository extends JpaRepository<Prime, Long>{

}
