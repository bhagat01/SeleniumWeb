package verifyLogin;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.maven.wagon.providers.http.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Invalid_UserID {
	WebDriver driver;
	String URL;
	
	@BeforeTest
	public void beforeTest() {
		driver= new ChromeDriver();
		URL = ("http://www.demo.guru99.com/V4/");
		
	}
  @Test
  public void InvalidID() throws IOException {
	  driver.get(URL);
	  driver.manage().window().maximize();
	  //entering invalid username
	  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys("Thrive");
	  //valid password
	  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("AjyqEzy");
	  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  Alert alert= driver.switchTo().alert();
	  File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  File DestFile = new File("C:\\Users\\ritaknaff\\Desktop\\Gure99Banking\\test-output\\screenshots.png");
	  FileUtils.copyFile(srcFile, DestFile);
	  alert.accept();
  }
  
  @AfterTest
  public void afterTest() {
	 // driver.close();
  }
}


