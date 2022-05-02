package com.cb.coink.model;

import java.util.ArrayList;

public class Modelo {
    private static final Modelo ourInstance = new Modelo();


    public static Modelo getInstance() {
        return ourInstance;
    }

    public Modelo() {
    }


    public Person person = new Person();


}