package com.suslu.codility.test;

public class SingeltonWithDataRace {

    SingeltonValue instance;

    public SingeltonValue instance() {
        if (instance == null) {
            instance = new SingeltonValue();
        }
        return instance;
    }
}
