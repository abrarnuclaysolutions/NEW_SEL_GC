package GC.GCSW;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base_Class.BaseClass;

public class ADD_NEW_EVENT {
	@Test
	public void AddNewEvent() throws InterruptedException {
		BaseClass cred = new BaseClass();
		String un = cred.username;
		String pass = cred.pass;
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.givecentral.org/admin/donor-details/profile/kaif12345");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Login...
		driver.findElement(By.cssSelector("#username")).sendKeys(un);// username
		driver.findElement(By.cssSelector("#password")).sendKeys(pass);// password
		driver.findElement(By.cssSelector("#logCnf")).click();// login button

		// Click on got it
//	        Thread.sleep(2000);
//	        driver.findElement(By.xpath("//button[@class='driver-popover-next-btn']")).click();
		// URL of profile
		driver.get("https://www.givecentral.org/admin/donor-details/profile/abrarkhan");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Click on add new event
		Thread.sleep(7000);
		WebElement addnewevent = driver.findElement(By.xpath("//button[contains(text(),'Add new Event')]"));
		js.executeScript("arguments[0].scrollIntoView();", addnewevent);
		addnewevent.click();
		// Select an event
		WebElement selectevent = driver.findElement(By.cssSelector("#event"));
		selectevent.click();
		Select dropSelect = new Select(selectevent);
		dropSelect.selectByVisibleText("testevnt17Jan2024");
		// add Frequency
		WebDriverWait waitoffrequency = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addfrequency = waitoffrequency
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#paymentFrequency")));
		addfrequency.click();
		Select weeklyselect = new Select(addfrequency);
		weeklyselect.selectByVisibleText("Weekly");
		// add amount
		driver.findElement(By.cssSelector("#amount")).sendKeys("0.05");
		// paymentstartdate
		WebElement selectdate = driver.findElement(By.cssSelector("#paymentStartDate"));
		selectdate.click();
		Thread.sleep(5000);
		WebElement dayselect = driver.findElement(By.xpath(
				"//td[@class=' ui-datepicker-week-end ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today' or @class=' ui-datepicker-week-end  ui-datepicker-today' or @class='  ui-datepicker-today' or @class=' ui-datepicker-days-cell-over  ui-datepicker-today' or @class=' ui-datepicker-week-end ui-datepicker-days-cell-over  ui-datepicker-today']"));
		dayselect.click();// currant date issue
//		Actions std = new Actions(driver);
		// Add payment method
		WebElement clickpaymethod = driver.findElement(By.cssSelector("#paymentMethod"));
		Select addpaymethod = new Select(clickpaymethod);
		addpaymethod.selectByVisibleText("Visa - xxx1111 added on 2017-04-12 expiring on 2017-04-30");
		// add source code
		WebElement sourcecode = driver.findElement(By.cssSelector(".caret"));
		js.executeScript("arguments[0].scrollIntoView();", sourcecode);
		sourcecode.click();
		WebElement clickonsourcecode = driver.findElement(By.xpath("//a[normalize-space()='110022 -']"));
		js.executeScript("arguments[0].scrollIntoView();", clickonsourcecode);
		clickonsourcecode.click();
		// click on submit
		WebElement submitelement = driver.findElement(By.xpath("//input[@id='submit']"));
		js.executeScript("arguments[0].scrollIntoView();", submitelement);
		submitelement.click();
		// click on popup
//	        WebElement popup = driver.findElement(By.cssSelector("div[id='systemMessagesDiv'] button[type='button']"));
//	        popup.click();  
//	        driver.close();

	}
}
