package com.mowitnow.mower.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MowerTest {


    @Test
    void itShouldStayInPositionAndRotateLeftWhenInstructionIsG() {

        // GIVEN

        Lawn lawn = Lawn.getInstance();
        lawn.setWidth(5);
        lawn.setHeight(5);

        Mower mowerInNorth = Mower.builder().lawn(lawn).currentX(3).currentY(3).direction('N').instructions("G").build();
        Mower mowerInEast = Mower.builder().lawn(lawn).currentX(3).currentY(3).direction('E').instructions("G").build();
        Mower mowerInWest = Mower.builder().lawn(lawn).currentX(3).currentY(3).direction('W').instructions("G").build();
        Mower mowerInSouth = Mower.builder().lawn(lawn).currentX(3).currentY(3).direction('S').instructions("G").build();

        // WHEN
        mowerInNorth.executeInstructions();
        mowerInEast.executeInstructions();
        mowerInWest.executeInstructions();
        mowerInSouth.executeInstructions();



        // THEN
        Assertions.assertEquals(mowerInNorth.getCurrentX(), 3);
        Assertions.assertEquals(mowerInNorth.getCurrentY(), 3);
        Assertions.assertEquals(mowerInNorth.getDirection(), 'W');

        Assertions.assertEquals(mowerInEast.getCurrentX(), 3);
        Assertions.assertEquals(mowerInEast.getCurrentY(), 3);
        Assertions.assertEquals(mowerInEast.getDirection(), 'N');

        Assertions.assertEquals(mowerInWest.getCurrentX(), 3);
        Assertions.assertEquals(mowerInWest.getCurrentY(), 3);
        Assertions.assertEquals(mowerInWest.getDirection(), 'S');

        Assertions.assertEquals(mowerInSouth.getCurrentX(), 3);
        Assertions.assertEquals(mowerInSouth.getCurrentY(), 3);
        Assertions.assertEquals(mowerInSouth.getDirection(), 'E');


    }

    @Test
    void itShouldStayInPositionAndRotateRightWhenInstructionIsD() {

        // GIVEN

        Lawn lawn = Lawn.getInstance();
        lawn.setWidth(5);
        lawn.setHeight(5);

        Mower mowerInNorth = Mower.builder().lawn(lawn).currentX(3).currentY(3).direction('N').instructions("D").build();
        Mower mowerInEast = Mower.builder().lawn(lawn).currentX(3).currentY(3).direction('E').instructions("D").build();
        Mower mowerInWest = Mower.builder().lawn(lawn).currentX(3).currentY(3).direction('W').instructions("D").build();
        Mower mowerInSouth = Mower.builder().lawn(lawn).currentX(3).currentY(3).direction('S').instructions("D").build();

        // WHEN
        mowerInNorth.executeInstructions();
        mowerInEast.executeInstructions();
        mowerInWest.executeInstructions();
        mowerInSouth.executeInstructions();



        // THEN
        Assertions.assertEquals(mowerInNorth.getCurrentX(), 3);
        Assertions.assertEquals(mowerInNorth.getCurrentY(), 3);
        Assertions.assertEquals(mowerInNorth.getDirection(), 'E');

        Assertions.assertEquals(mowerInEast.getCurrentX(), 3);
        Assertions.assertEquals(mowerInEast.getCurrentY(), 3);
        Assertions.assertEquals(mowerInEast.getDirection(), 'S');

        Assertions.assertEquals(mowerInWest.getCurrentX(), 3);
        Assertions.assertEquals(mowerInWest.getCurrentY(), 3);
        Assertions.assertEquals(mowerInWest.getDirection(), 'N');

        Assertions.assertEquals(mowerInSouth.getCurrentX(), 3);
        Assertions.assertEquals(mowerInSouth.getCurrentY(), 3);
        Assertions.assertEquals(mowerInSouth.getDirection(), 'W');


    }

    @Test
    void itShouldMoveForwardInTheCurrentDirectionWhenInstructionIsA() {

        // GIVEN

        Lawn lawn = Lawn.getInstance();
        lawn.setWidth(5);
        lawn.setHeight(5);

        Mower mowerInNorth = Mower.builder().lawn(lawn).currentX(3).currentY(3).direction('N').instructions("A").build();
        Mower mowerInEast = Mower.builder().lawn(lawn).currentX(3).currentY(3).direction('E').instructions("A").build();
        Mower mowerInWest = Mower.builder().lawn(lawn).currentX(3).currentY(3).direction('W').instructions("A").build();
        Mower mowerInSouth = Mower.builder().lawn(lawn).currentX(3).currentY(3).direction('S').instructions("A").build();

        // WHEN
        mowerInNorth.executeInstructions();
        mowerInEast.executeInstructions();
        mowerInWest.executeInstructions();
        mowerInSouth.executeInstructions();



        // THEN
        Assertions.assertEquals(mowerInNorth.getCurrentX(), 3);
        Assertions.assertEquals(mowerInNorth.getCurrentY(), 4);
        Assertions.assertEquals(mowerInNorth.getDirection(), 'N');

        Assertions.assertEquals(mowerInEast.getCurrentX(), 4);
        Assertions.assertEquals(mowerInEast.getCurrentY(), 3);
        Assertions.assertEquals(mowerInEast.getDirection(), 'E');

        Assertions.assertEquals(mowerInWest.getCurrentX(), 2);
        Assertions.assertEquals(mowerInWest.getCurrentY(), 3);
        Assertions.assertEquals(mowerInWest.getDirection(), 'W');

        Assertions.assertEquals(mowerInSouth.getCurrentX(), 3);
        Assertions.assertEquals(mowerInSouth.getCurrentY(), 2);
        Assertions.assertEquals(mowerInSouth.getDirection(), 'S');

    }

    @Test
    void itShouldNotMoveWhenTheNextPositionIsOutOfBoundaries() {

        // GIVEN

        Lawn lawn = Lawn.getInstance();
        lawn.setWidth(5);
        lawn.setHeight(5);

        Mower mowerInNorth = Mower.builder().lawn(lawn).currentX(5).currentY(5).direction('N').instructions("A").build();
        Mower mowerInEast = Mower.builder().lawn(lawn).currentX(5).currentY(5).direction('E').instructions("A").build();
        Mower mowerInWest = Mower.builder().lawn(lawn).currentX(0).currentY(5).direction('W').instructions("A").build();
        Mower mowerInSouth = Mower.builder().lawn(lawn).currentX(5).currentY(0).direction('S').instructions("A").build();

        // WHEN
        mowerInNorth.executeInstructions();
        mowerInEast.executeInstructions();
        mowerInWest.executeInstructions();
        mowerInSouth.executeInstructions();



        // THEN
        Assertions.assertEquals(mowerInNorth.getCurrentX(), 5);
        Assertions.assertEquals(mowerInNorth.getCurrentY(), 5);
        Assertions.assertEquals(mowerInNorth.getDirection(), 'N');

        Assertions.assertEquals(mowerInEast.getCurrentX(), 5);
        Assertions.assertEquals(mowerInEast.getCurrentY(), 5);
        Assertions.assertEquals(mowerInEast.getDirection(), 'E');

        Assertions.assertEquals(mowerInWest.getCurrentX(), 0);
        Assertions.assertEquals(mowerInWest.getCurrentY(), 5);
        Assertions.assertEquals(mowerInWest.getDirection(), 'W');

        Assertions.assertEquals(mowerInSouth.getCurrentX(), 5);
        Assertions.assertEquals(mowerInSouth.getCurrentY(), 0);
        Assertions.assertEquals(mowerInSouth.getDirection(), 'S');

    }


}
