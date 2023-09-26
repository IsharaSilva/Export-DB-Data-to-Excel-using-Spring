package com.springBatch.springBatchSample.config;

import org.springframework.batch.item.Chunk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springBatch.springBatchSample.entity.Customer;
import com.springBatch.springBatchSample.generic.Writer;
import com.springBatch.springBatchSample.repository.CustomerRepository;

@Component
public class CustomerWriter extends Writer<Customer> {

    @Autowired
    private CustomerRepository customerRepository;

	@Override
	public void write(Chunk<? extends Customer> chunk) throws Exception {
		System.out.println("Thread Name : -"+Thread.currentThread().getName());
        customerRepository.saveAll(chunk);
	}	
}