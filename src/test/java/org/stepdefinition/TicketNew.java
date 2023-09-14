package org.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.baseticket.BaseClassCucu;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TicketNew extends BaseClassCucu {
	
	
	
	@Given("user has to open the browser")
	public void userHasToOpenTheBrowser() {
		//implicity();
		browserLanch();
	   // throw new cucumber.api.PendingException();
	}

	@When("user has to load the ticket new url")
	public void userHasToLoadTheTicketNewUrl() {
		
		urlLanch("https://ticketnew.com/movies");

	   // throw new cucumber.api.PendingException();
	}

	@When("user has to select the location")
	public void userHasToSelectTheLocation() {
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();
		
					}

	@When("user has to search the movies")
	public void userHasToSearchTheMovies() throws AWTException {
		
		driver.findElement(By.xpath("//i[@class='searchBlack']")).click();
	implicity();
		
		driver.findElement(By.xpath("//input[@type='search']")).click();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("kushi");
		driver.findElement(By.xpath("//div[text()='Kushi']")).click();
		//driver.findElement(By.xpath("//a[@class='H5SearchMoviesList_listItem__t_YNk']")).click();
		driver.findElement(By.xpath("//input[@id='Tamil-index-selection-dialog']")).click();
		System.out.println("clicked");
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
	   // throw new cucumber.api.PendingException();
	}

	@When("user haas to select the movie and theatre")
	public void userHaasToSelectTheMovieAndTheatre() {
	   // throw new cucumber.api.PendingException();
	}

	@When("user has to select the show time")
	public void userHasToSelectTheShowTime() {
		implicity();
	   driver.findElement(By.xpath("//div[text()='Sun']")).click();
	   driver.findElement(By.xpath("//div[text()='PADMAM']")).click();
	}

	@When("user has to select the seat")
	public void userHasToSelectTheSeat() {
		implicity();
		driver.findElement(By.xpath("(//span[@class='available FixedSeating_leftGroupSeat__ZfnoZ'])[2]")).click();
	   // throw new cucumber.api.PendingException();
	}

	@When("user has to cilck the book btn")
	public void userHasToCilckTheBookBtn() {
		driver.findElement(By.xpath("//button[text()='Book ']")).click();
		
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
	}

	@When("user has to pay for ticket")
	public void userHasToPayForTicket() {
		
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
	}

	@Then("close the page when get the ticket")
	public void closeThePageWhenGetTheTicket() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new cucumber.api.PendingException();
	}


}
