package com.mowitnow.mower.batch;

import com.mowitnow.mower.domain.Mower;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MowerProcessor implements ItemProcessor<Mower, Mower> {


    public MowerProcessor() {
    }

    @Override
    public Mower process(Mower mower) throws Exception {
        mower.executeInstructions();
        return mower;
    }

}
