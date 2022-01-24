package com.prime.springboot.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="primes")
public class Prime {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="timestamp", nullable=false)
	private Timestamp timestamp;

	@Column(name="lower")
	private int lower;

	@Column(name="upper")
	private int upper;

	@Column(name="elapsed_time")
	private double elapsedTime;

	@Column(name="algorithm")
	private String algorithm;

	@Column(name="number_of_prime")
	private int numberOfPrime;

}
