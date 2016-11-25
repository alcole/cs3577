package com.alcole.model;

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

    private static RecordManager records;

    @BeforeClass
    public static void beforeTest() {
        System.out.println("Starting LoadRecordTest");
    }

    @Before
    public void initTestCase() {
        records = new RecordManager();

    }

    @AfterClass
    public static void afterTest() {
        System.out.println("Ending LoadRecordTest");
    }

    //@Ignore
    @Test
    public void testRecordAdded() {
        try {
            LoadRecords.readRecords(records);
        }
        catch (IOException e) {
            Assert.fail("Exception " + e);
        }
        assert (records.get(1L).getArtist().equals("The Gun Club"));
    }
}
