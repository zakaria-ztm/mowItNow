package com.mowitnow.mower.batch;

import com.mowitnow.mower.domain.Mower;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
public class BatchConfiguration {

    final MowerFileReader mowerFileReader;
    final MowerProcessor mowerProcessor;
    final MowerWriter mowerWriter;


    public BatchConfiguration(MowerFileReader mowerFileReader, MowerProcessor mowerProcessor, MowerWriter mowerWriter) {
        this.mowerFileReader = mowerFileReader;
        this.mowerProcessor = mowerProcessor;
        this.mowerWriter = mowerWriter;
    }

    @Bean
    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager) {

        return new StepBuilder("step", jobRepository)
                .<Mower, Mower>chunk(15, transactionManager)
                .reader(mowerFileReader)
                .processor(mowerProcessor)
                .writer(mowerWriter)
                .build();
    }

    @Bean
    public Job mowerJob(JobRepository jobRepository, Step step) {

        Flow flow = new FlowBuilder<SimpleFlow>("Mower flow")
                .start(step)
                .end();

        return new JobBuilder("Mower Job", jobRepository)
                .start(flow)
                .end()
                .build();
    }
}
