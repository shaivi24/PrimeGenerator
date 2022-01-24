package com.prime.springboot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.prime.springboot.main.AlgorithmClassifier;

import java.util.List;

public class TestPrimeAlgorithms {

	String[] algorithm;

	@BeforeEach
	void setUp() throws Exception {
		algorithm = new String[3];
		algorithm[0]="naive";
		algorithm[1]="eratosthenes";
		algorithm[2]="sundaram";
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void test1to10Primes() {
		for(String s : algorithm) {
			List<Integer> primes = AlgorithmClassifier.classifier(s, 1, 10);
			assertEquals(4, primes.size(), s + " failed for 0 to 10");
			assertEquals(2, primes.get(0), s + " failed for 0 to 10");
			assertEquals(7, primes.get(primes.size()-1), s + " failed for 0 to 10");
		}
	}

	@Test
	void testIf3IsIncluded() {
		for(String s : algorithm) {
			List<Integer> primes = AlgorithmClassifier.classifier(s, 3, 10);
			assertEquals(3, primes.size(), s + " failed to include lower bound");
			assertEquals(3, primes.get(0), s + " failed to include lower bound");
		}
	}

	@Test
	void testIf53IsIncluded() {
		for(String s : algorithm) {
			List<Integer> primes = AlgorithmClassifier.classifier(s, 1, 53);
			assertEquals(16, primes.size(), s + " failed to include upper bound");
			assertEquals(53, primes.get(primes.size()-1), s + " failed to include upper bound");
		}
	}
	
	@Test
	void test251to6996Primes() {
		for(String s : algorithm) {
			List<Integer> primes = AlgorithmClassifier.classifier(s, 251, 6996);
			assertEquals(846, primes.size(), s + " failed for 251 to 6996");
			assertEquals(251, primes.get(0), s + " failed for 251 to 6996");
			assertEquals(6991, primes.get(primes.size()-1), s + " failed for 251 to 6996");
		}
	}

	@Test
	void test0to100Primes() {
		for(String s : algorithm) {
			List<Integer> primes = AlgorithmClassifier.classifier(s, 0, 100);
			assertEquals(25, primes.size(), s + " failed for 0 to 100");
			assertEquals(2, primes.get(0), s + " failed for 0 to 100");
			assertEquals(97, primes.get(primes.size()-1), s + " failed for 0 to 100");
		}
	}
}
