package com.alcole.services;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;



/**
 * Created by alex on 25/11/16.
 */
public class LoadRecordTest {

    private static RecordManagerImpl records;

    @BeforeClass
    public static void beforeTest() {
        System.out.println("Starting LoadRecordTest");
    }

    @Before
    public void initTestCase() {
        records = new RecordManagerImpl();

    }

    @AfterClass
    public static void afterTest() {
        System.out.println("Ending LoadRecordTest");
    }

//
}
