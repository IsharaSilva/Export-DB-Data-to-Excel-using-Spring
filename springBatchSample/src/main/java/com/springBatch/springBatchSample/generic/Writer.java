package com.springBatch.springBatchSample.generic;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class Writer<T> implements ItemWriter<T> {

	@Override
	public void write(Chunk<? extends T> chunk) throws Exception {
		System.out.println("Thread Name: " + Thread.currentThread().getName());	
	}
}