package SVG;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SvgElement {

	WebDriver driver;
	ChromeOptions c;
	
	@BeforeClass
	public void launchBrowser()
	{
		c = new ChromeOptions();
		c.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(c);
	}
	
	
	@Test(enabled=false)
	public void handleSVG() throws InterruptedException
	{
		
		driver.get("http://debeissat.nicolas.free.fr/svg3d.php");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.switchTo().frame("svg_result");
	    List <WebElement> list = driver.findElements(By.xpath("//*[name()='svg']//*[local-name()='path' and contains(@id ,'face')]"));
	    
	    for(WebElement e:list)
	    {
	    	String text = e.getAttribute("d");
	    	System.out.println(text);
	    }
		
	    driver.close();
	}
	
	@Test(enabled=false)
	public void flipKartSVG() throws InterruptedException
	{
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
	//	WebElement popUp = driver.findElement(By.cssSelector("._2QfC02"));
	//	WebElement closeButton = driver.findElement(By.cssSelector("._2doB4z"));
		
		genericWait(driver.findElement(By.cssSelector("._2QfC02")), driver);
		genericWait(driver.findElement(By.cssSelector("._2doB4z")), driver);
	//	closeButton.click();
		driver.findElement(By.cssSelector("._2doB4z")).click();
		
		driver.findElement(By.className("_3704LK")).sendKeys("bharat mata ki jai");
		
		WebElement searchButton = driver.findElement(By.xpath("(//*[name()='svg']//*[local-name()='path' and @class='_34RNph'])[1]"));
		genericWait(searchButton, driver);
		
		searchButton.click();
		
		Thread.sleep(5000);
	//	genericWait(driver.findElement(By.cssSelector(".IRpwTa")), driver);
		List <WebElement> list = driver.findElements(By.cssSelector("._4ddWXP .s1Q9rs"));

		list.stream().forEach(e->e.click());
	//	Thread.sleep(4000);
		
		Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			String parentID = driver.getWindowHandle();
		
			while(it.hasNext())
			{
				String title = driver.switchTo().window(it.next()).getTitle();
				System.out.println(title);	
			}
		//	Thread.sleep(2000);
			driver.switchTo().window(parentID);
			System.out.println("parentID---->"+parentID);
			Thread.sleep(2000);
			genericWait(driver.findElement(By.xpath("//*[text()='SOCIAL']")), driver);
			
			List<WebElement> footerSOcialLinks = driver.findElements(By.xpath("//*[text()='SOCIAL']//parent::div[@class='_2Brcj4']/a"));
	//		Thread.sleep(2000);
			String clicks = Keys.chord(Keys.COMMAND,Keys.ENTER);
			for(int i=0 ; i<footerSOcialLinks.size();i++)
			{
				System.out.println("link----->" +footerSOcialLinks.get(i).getAttribute("href"));
				footerSOcialLinks.get(i).sendKeys(clicks);
			}	
					
		//	footerSOcialLinks.stream().forEach(e->e.sendKeys(clicks));
			
	}
	
	@Test(enabled=false)
	public void graphSVG()
	{
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		
List<WebElement>list = driver.findElements(By.xpath("//*[name()='svg']//*[local-name()='g' and @class ='highcharts-series-group']//*[name()='rect']"));

		System.out.println(	"size -->" + list.size());
		
		Actions a =  new Actions(driver);
		for(WebElement e:list)
		{
			a.moveToElement(e).perform();
String text = driver.findElement(By.xpath("//*[name()='svg']//*[local-name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']")).getText();		
		
System.out.println(text);
		
		
		}
		
	
	
	
	
	}
	
	
	
	@AfterClass(enabled=false)
	public void tearDown()
	{
		driver.quit();
	}
	
	public void genericWait(WebElement ele, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(11));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
}
