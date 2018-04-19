package verifyLogin;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class guru99Login {
	WebDriver driver;
	String URL;

	@BeforeTest
	public void beforeTest() {
	 URL =("http://www.demo.guru99.com/V4/");
	//System.setProperty("webdriver.chrome.driver","C://Users//ritaknaff//Downloads//chromedriver_win32//chromedriver.exe");
	driver = new FirefoxDriver();	
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	}
  @Test
  public void login() throws IOException {
	  driver.get(URL);
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys("mngr127325");
	  Assert.assertTrue(true);
	  System.out.println("username entered");
	  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("AjyqEzy");
	  Assert.assertTrue(true);
	  System.out.println("Password entered");
	  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
	  Assert.assertTrue(true);
	  System.out.println("login succesfully");
	  String title = driver.getTitle();
	  Assert.assertEquals(title, "Guru99 Bank Manager HomePage");
	  System.out.println("title matched");
	  
	  //Taking Screenshot
	  File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File destFile = new File("C:\\Users\\ritaknaff\\Desktop\\Gure99Banking\\test-output\\Thrive.png");
	  FileUtils.copyFile(srcFile, destFile);
	  
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td"));
	  String op = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
	  System.out.println(op);
	  
  }
  @AfterTest
  public void afterTest() throws Exception {
	  Thread.sleep(2000);
	  driver.close();
  }
}





