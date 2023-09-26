package com.springBatch.springBatchSample.generic;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

@FunctionalInterface
public interface PdfItemWriter<T> extends ItemWriter<T>{
    void write(Chunk<? extends T> chunk) throws Exception;
}