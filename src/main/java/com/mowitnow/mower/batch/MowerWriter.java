package com.mowitnow.mower.batch;

import com.mowitnow.mower.domain.Mower;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MowerWriter implements ItemWriter<Mower> {


    public MowerWriter() {
    }

    @Override
    public void write(Chunk<? extends Mower> chunk) {

        log.info("Liste des positions et directions des différentes tondeuses : ");

        for (int i = 0; i < chunk.size(); i++){
            log.info("{}", chunk.getItems().get(i));
        }

    }


}