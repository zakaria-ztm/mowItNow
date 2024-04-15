package com.mowitnow.mower.batch;

import com.mowitnow.mower.domain.Mower;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class MowerFileReader implements ItemReader<Mower> {

    static int lineNumber = 0;
    private static final String FILE_NAME = "data.txt";

    private FlatFileItemReader<Mower> delegate;

    public MowerFileReader() {
        this.delegate = new FlatFileItemReader<>();
        this.delegate.setResource(new ClassPathResource(FILE_NAME));
        this.delegate.setLineMapper(new MowerLineMapper());
    }

    @Override
    public Mower read() throws Exception {
        this.delegate.open(new ExecutionContext());

        if (lineNumber == 0) {
            this.delegate.read();
            lineNumber++;
        }


        Mower mowerPosition = this.delegate.read();
        Mower mowerInstructions = this.delegate.read();

        if (mowerPosition == null || mowerInstructions == null) return null;

        return Mower.builder()
                .currentX(mowerPosition.getCurrentX())
                .currentY(mowerPosition.getCurrentY())
                .direction(mowerPosition.getDirection())
                .instructions(mowerInstructions.getInstructions())
                .build();

    }
}