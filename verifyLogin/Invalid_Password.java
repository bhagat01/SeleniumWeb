package verifyLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Invalid_Password {
	WebDriver driver;
	String URL;
	
	@BeforeTest
	public void beforeTest() {
		driver= new ChromeDriver();
		URL = ("http://www.demo.guru99.com/V4/");
		
	}
  @Test
  public void InvalidID() {
	  driver.get(URL);
	  driver.manage().window().maximize();
	  //entering valid username
	  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys("mngr127325");
	  //Invalid password
	  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("udemy");
	  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
	  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
	  String textTitle = driver.switchTo().alert().getText();
	  System.out.println(textTitle);
  }
  @AfterTest
  public void afterTest() {
	  driver.close();
  }
}
