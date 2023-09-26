package com.springBatch.springBatchSample.generic;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.core.io.Resource;

public class FlatFileReader<T> {

    public ItemReader<T> createFlatFileReader(Resource resource, Class<T> targetType, LineMapper<T> lineMapper) {
        FlatFileItemReader<T> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(resource);
        itemReader.setName(targetType.getSimpleName() + "FlatFileReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper);
        return itemReader;
    }
}