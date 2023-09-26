package com.springBatch.springBatchSample.config;

import com.springBatch.springBatchSample.entity.Customer;
import com.springBatch.springBatchSample.generic.Processor;

public class CustomerProcessor extends Processor<Customer, Customer> {

    @Override
    public Customer process(Customer customer) throws Exception {
            return customer;
    }
}