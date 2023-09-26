package com.springBatch.springBatchSample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBatch.springBatchSample.entity.Customer;

public interface CustomerRepository  extends JpaRepository<Customer,Integer> {
}