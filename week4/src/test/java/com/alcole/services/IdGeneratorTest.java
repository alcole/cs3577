package com.alcole.services;

import com.alcole.services.IdGenerator;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by alex on 24/11/16.
 */
public class IdGeneratorTest {

    private IdGenerator idGenerator;

    @BeforeClass
    public static void beforeTest() {
        System.out.println("Starting IdGeneratorTest");
    }

    @Before
    public void initTestCase() {
        idGenerator = IdGenerator.getInstance();
    }

    @AfterClass
    public static void afterTest() {
        System.out.println("Ending IdGeneratorTest");
    }

    @Test
    public void isSingleton() {
        IdGenerator idg2 = IdGenerator.getInstance();
        assertEquals(idGenerator, idg2);
    }

    @Test
    public void testReturnsId() {
        assert (idGenerator.getId() > 0);
    }

    @Test
    public void testIncrements() {
        Long id1 = idGenerator.getId();
        Long id2 = idGenerator.getId();
        assert (id1 < id2);
    }

    @Test
    public void testIncrementsFromDifferentVariables() {
        IdGenerator idGenerator2 = IdGenerator.getInstance();
        Long id1 = idGenerator.getId();
        Long id2 = idGenerator2.getId();
        assert (id1 < id2);
    }
}
