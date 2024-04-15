package com.mowitnow.mower.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mower {

    private int currentX;
    private int currentY;
    private char direction;
    private String instructions;
    private Lawn lawn = Lawn.getInstance();


    public void executeInstructions() {
        for (int i = 0; i < instructions.length(); i++) {
            switch (instructions.charAt(i)) {
                case 'G' -> rotateLeft();
                case 'D' -> rotateRight();
                case 'A' -> moveForward(Lawn.getInstance());
            }
        }

    }

    private void moveForward(Lawn lawn) {


        switch (direction) {
            case 'N' -> currentY = currentY < lawn.getWidth() ? currentY + 1 : currentY;
            case 'E' -> currentX = currentX < lawn.getHeight() ? currentX + 1 : currentX;
            case 'W' -> currentX = currentX > 0 ? currentX - 1 : currentX;
            case 'S' -> currentY = currentY > 0 ? currentY - 1 : currentY;
        }
    }

    private void rotateLeft() {
        switch (direction) {
            case 'N' -> direction = 'W';
            case 'S' -> direction = 'E';
            case 'W' -> direction = 'S';
            case 'E' -> direction = 'N';
        }
    }

    private void rotateRight() {
        switch (direction) {
            case 'N' -> direction = 'E';
            case 'S' -> direction = 'W';
            case 'W' -> direction = 'N';
            case 'E' -> direction = 'S';
        }
    }


    @Override
    public String toString() {
        return currentX + " " + currentY + " " + direction;
    }
}
