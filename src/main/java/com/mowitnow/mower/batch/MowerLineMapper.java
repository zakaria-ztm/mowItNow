package com.mowitnow.mower.batch;

import com.mowitnow.mower.domain.Lawn;
import com.mowitnow.mower.domain.Mower;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.stereotype.Component;


@Component
public class MowerLineMapper implements LineMapper<Mower> {

    private static final String SEPARATOR = " ";


    private final Lawn lawn;

    public MowerLineMapper() {
        this.lawn = Lawn.getInstance();
    }


    @Override
    public Mower mapLine(String line, int lineNumber) throws Exception {

        if (lineNumber == 1) {
            lawn.setWidth(Integer.parseInt(line.split(SEPARATOR)[0]));
            lawn.setHeight(Integer.parseInt(line.split(SEPARATOR)[1]));
        } else if (line.split(SEPARATOR).length == 3) {
            return Mower.builder()
                    .currentX(Integer.parseInt(line.split(SEPARATOR)[0]))
                    .currentY(Integer.parseInt(line.split(SEPARATOR)[1]))
                    .direction(line.split(SEPARATOR)[2].toCharArray()[0])
                    .build();
        } else if (line.split(SEPARATOR).length == 1) {
            return Mower.builder()
                    .instructions(line)
                    .build();
        }
        return null;
    }
}
