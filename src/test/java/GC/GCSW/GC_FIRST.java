package GC.GCSW;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Base_Class.BaseClass;

public class GC_FIRST {
	@Test
	public void GcFirst() throws InterruptedException {
		BaseClass cred = new BaseClass();
		String un = cred.username;
		String pass = cred.pass;
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Website URL with Location
		driver.get("https://www.givecentral.org/location/7/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Select Event
		Thread.sleep(3000);
		WebElement selevent = driver
				.findElement(By.xpath("//h6[contains(text(),'E2d2b102-fcab-4036-aa13-e60362125b47')]"));
		selevent.click();
		// Add amount
		Thread.sleep(1400);
		WebElement addqnt = driver.findElement(By.xpath("//input[@id='noOfTickets']"));
		addqnt.sendKeys("1");

		// Add To My Gift Basket
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();

		// Click on CheckOut
		Thread.sleep(2400);
		WebElement checkout = driver.findElement(By.xpath("//button[@id='checkoutBtn']"));
		js.executeScript("window.scrollBy(100,0)");
		checkout.click();
		// Click on Continue
		Thread.sleep(800);
		driver.findElement(By.xpath("//body/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]"))
				.click();

		// Login
		driver.findElement(By.cssSelector("#username")).sendKeys("kaif12345");
		driver.findElement(By.cssSelector("#password")).sendKeys("kaif12345");
		driver.findElement(By.cssSelector("#logCnf")).click();

		// submit after login
		driver.findElement(By.cssSelector("#submit_gift")).click();

	}
}
