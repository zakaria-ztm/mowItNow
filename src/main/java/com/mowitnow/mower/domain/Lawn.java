package com.mowitnow.mower.domain;


public class Lawn {

    private static Lawn instance = null;

    private int width;
    private int height;


    private Lawn() {
        width = 0;
        height = 0;
    }


    public static Lawn getInstance() {

        if (instance == null) {
            instance = new Lawn();
        }
        return instance;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public synchronized void setWidth(int width) {
        this.width = width;
    }

    public synchronized void setHeight(int height) {
        this.height = height;
    }


}
