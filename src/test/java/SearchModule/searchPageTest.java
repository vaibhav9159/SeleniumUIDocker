package SearchModule;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.*;

import BaseTest.baseTest;
import DriversFactory.driversFactory;
import PageObjects.SearchGoPage;

public class searchPageTest extends baseTest{
	
	SearchGoPage sp ;
	
	@BeforeClass
	public void launchAppAndSearch() throws Exception
	{
		sp = new SearchGoPage(driversFactory.getDriver());
	}
	
	@Test(priority=1)
	public void searchVideos()
	{
		sp.searchText("om namah shivaya");
		sp.videosLink();
		AssertJUnit.assertTrue(sp.videosLink()>0);
	}
	
}
