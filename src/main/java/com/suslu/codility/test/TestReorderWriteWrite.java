package com.suslu.codility.test;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.infra.results.II_Result;

public class TestReorderWriteWrite {

    SingeltonWithDataRace singelton = new SingeltonWithDataRace();

    @Actor
    public void actor1(II_Result r) {
        if (singelton.instance().initialized) {
            r.r1 = 1;
        } else {
            r.r1 = 0;
        }
    }

    @Actor
    public void actor2(II_Result r) {
        if (singelton.instance().initialized) {
            r.r2 = 1;
        } else {
            r.r2 = 0;
        }
    }
}
