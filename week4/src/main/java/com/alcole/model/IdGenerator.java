package com.alcole.model;

/**
 * Created by alex on 24/11/16.
 */
public class IdGenerator {

    private static final IdGenerator IdGenerator = new IdGenerator();

    private long id;

    private IdGenerator() {
        id = 0L;
    }

    public static IdGenerator getInstance() {
        return IdGenerator;
    }

    public long getId() {
        return ++id;
    }
}
