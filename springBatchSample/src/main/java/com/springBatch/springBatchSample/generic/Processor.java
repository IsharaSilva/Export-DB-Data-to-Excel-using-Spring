package com.springBatch.springBatchSample.generic;

import org.springframework.batch.item.ItemProcessor;

public class Processor<I, O> implements ItemProcessor<I, O> {

    @Override
    public O process(I input) throws Exception {
        return (O) input;
    }
}