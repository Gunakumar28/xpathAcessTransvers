package xpathacess;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAccesForMAkeMyTrip {
	
	@Test
	public void makeMyTrip() throws AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//li[@data-cy='account']")).click();
		WebElement findElement = driver.findElement(By.xpath("//input[@id='fromCity']"));
		findElement.sendKeys("chennai");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//*[@id='toCity']")).sendKeys("bangalore");
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_DOWN);
		robot1.keyRelease(KeyEvent.VK_DOWN);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath("//*[text()='Search']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String text = driver.findElement(By.xpath("//div[@class='makeFlex spaceBtwCenter textCenter fontSize12']//following::div[@class='makeFlex timingOption']//following::div[@class='makeFlex spaceBtwCenter textCenter fontSize12']")).getText();
		System.out.println(text);
		

	}

}
