package com.alcole;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class StepDefinitions {

    private UserLookUpService service;
    private String theUserName;

    private AlbumLookUpService albumService;
    private String albumId;

    @Given("^I use the userlookup service$")
    public void useTheUserLookUpService() {
        service = new UserLookUpService();
    }

    @When("^I enter the username (.+)$")
    public void userUsername(String aUsername) {
        theUserName = aUsername;
    }

    @Then("^the name (.+) should show up$")
    public void checkFullName(String expectedFullName) {
        String name = service.getFullName(theUserName).get();
        Assert.assertEquals(expectedFullName, name);
    }

     @Then("^the number (.+) should show up$")
     public void checkNumber(String num)  {
            String number = service.getPhoneNumberByUsername(theUserName).get();
            Assert.assertEquals(num, number);
     }

    @Given("^I use the albumlookup service$")
    public void useTheAlbumLookUpService() {
        albumService = new AlbumLookUpService();
    }

    @When("^I enter the id (.+)$")
    public void useAlbumIdService(String id) {
        albumId = id;
    }

    @Then("^the album title should be (.+)$")
    public void checkAlbumTitle(String title) {
        String albumTitle = albumService.getTitle(albumId).get();
        Assert.assertEquals(title, albumTitle);
    }

}

