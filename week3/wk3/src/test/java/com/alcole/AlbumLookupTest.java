package com.alcole;

import org.apache.http.client.methods.HttpGet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by alex on 18/11/16.
 */
public class AlbumLookupTest {

    private AlbumLookUpService albumService;

    @BeforeClass
    public static void beforeTest() {
        System.out.println("Starting AlbumLookupServiceTest");
    }

    @AfterClass
    public static void afterTest() {
        System.out.println("Ending AlbumLookupServiceTest");
    }

    @Before
    public void initTestCase() {
        albumService = new AlbumLookUpService();
    }

    @After
    public void afterTestCase() {
        System.out.println("End of Test");
    }

    @Test
    public void testRequestPreparation() {
        HttpGet request = albumService.prepareRequest("test.co.uk?id=", "1");
        assertEquals(request.getURI().toString(), "test.co.uk?id=1");
    }

    @Test
    public void testJSONresponse() {
        Optional<String> title = albumService.getTitle("2");
        assertTrue(title.isPresent());
        assertEquals(title.get(), "sunt qui excepturi placeat culpa" );
    }
}
