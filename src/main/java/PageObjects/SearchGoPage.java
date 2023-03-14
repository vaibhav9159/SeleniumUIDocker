package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseTest.baseTest;

public class SearchGoPage extends baseTest{

	private WebDriver ldriver;
	public SearchGoPage(WebDriver rdriver)
	{
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css="input[id*='input_homepage']")
	WebElement searchBar;
	
	@FindBy(css=".search__button")
	WebElement searchButton;
	
	@FindBy(css="a[data-zci-link='videos']")
	WebElement videos;
	
	@FindBy(css=".tile__body a")
	List <WebElement> videosList;
	
	public void searchText(String text)
	{
		waitForElement(ldriver,searchButton);
		searchBar.sendKeys(text);
		searchButton.click();
	}
	
	public int videosLink()
	{
		waitForElement(ldriver,videos);
		videos.click();
		
		By by = By.cssSelector(".tile__body a");
		waitForElementCount(ldriver,by);
		
		for(WebElement e: videosList)
		{	
			String links= e.getAttribute("href");
			String text =  e.getText();
			log.info("link --> "+ links + " --> link text --> "+ text);
		}
		log.info("total videos ----> "+videosList.size());
		return videosList.size();
	}
	
}
