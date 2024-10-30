package GC.GCSW;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base_Class.BaseClass;

public class CROWDFOUNDING_EVENT {
	@Test
	public void CrowdFoundingEvent() throws InterruptedException {
		BaseClass cred = new BaseClass();
		String un = cred.username;
		String pass = cred.pass;
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.givecentral.org/admin/");
//	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Login...
		// user name
		WebDriverWait waitofusername = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement elementofusername = waitofusername
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));
		elementofusername.sendKeys(un);

		// password
		WebDriverWait waitofpass = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement elementofpass = waitofpass
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
		elementofpass.sendKeys(pass);

		// login button
		WebDriverWait waitoflogin = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement clicklogin = waitoflogin
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logCnf")));
		clicklogin.click();

		// Click on got it
//	        Thread.sleep(2000);
//	        driver.findElement(By.xpath("//button[@class='driver-popover-next-btn']")).click();

		// remove popup
		JavascriptExecutor js = (JavascriptExecutor) driver;
//	        Thread.sleep(5000);
//	        WebElement icon = driver.findElement(By.xpath("//a[@class='bottomContentLink' and @id='popup_modal_remind_later']"));
//	        js.executeScript("arguments[0].scrollIntoView();", icon);
//	        icon.click();
		// click on event
		Thread.sleep(3000);
		WebDriverWait eventwait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement event = eventwait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Events']")));
		event.click();
		// click on add new
		Thread.sleep(3000);
		WebDriverWait addnewwait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement addnew = addnewwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body/div[@id='page-container']/div[@id='wrapper']/nav[@id='sidebar']/div[1]/ul[1]/li[10]/ul[1]/li[3]/a[1]/span[1]")));
		addnew.click();
		// event name
		String randomStr = usingRandomUUID();
		WebElement eventname = driver.findElement(By.cssSelector("#event_title"));
		eventname.sendKeys(randomStr);
		// event type
		WebElement eventtype = driver.findElement(By.cssSelector("#event_type"));
		Select type = new Select(eventtype);
		type.selectByVisibleText("Crowdfunding");
		// goal ammount
		WebElement goalammount = driver.findElement(By.cssSelector("#target_amount"));
		goalammount.sendKeys("100");
		// click on next
		WebElement next = driver.findElement(By.cssSelector("#nexttab"));
		js.executeScript("arguments[0].scrollIntoView();", next);
		next.click();
		// account
		Thread.sleep(3000);
		WebElement account = driver.findElement(By.xpath("//select[@id = 'cc_accounts_merchant_id_id']"));
		js.executeScript("arguments[0].scrollIntoView();", account);
		Select acc = new Select(account);
		acc.selectByVisibleText("GiveCentral Vantiv");
		// another account
		WebElement otheracc = driver.findElement(By.cssSelector("#ec_accounts_merchant_id_id"));
		Select acc1 = new Select(otheracc);
		acc1.selectByVisibleText("GiveCentral Vantiv");
		// next
		WebElement nexttab = driver.findElement(By.cssSelector("#nexttab1"));
		js.executeScript("arguments[0].scrollIntoView();", nexttab);
		nexttab.click();
		// click on next
		Thread.sleep(2000);
		WebElement nexttab2 = driver.findElement(By.cssSelector("#nexttab2"));
//		js.executeScript("window.scrollBy(0,1)");
		nexttab2.click();
		// click on next
		Thread.sleep(2000);
		WebElement nexttab5 = driver.findElement(By.xpath("//button[@id='nexttab5']"));
		nexttab5.click();
		// click on next
		Thread.sleep(1500);
		WebElement sepc = driver.findElement(By.xpath("//select[@id='eventParishCategory']"));
		Select def = new Select(sepc);
		def.selectByVisibleText("Default");
		Thread.sleep(1500);
		WebElement nexttab6 = driver.findElement(By.cssSelector("#nexttab6"));
		nexttab6.click();
		// click on next
		Thread.sleep(1500);
		WebElement nexttab7 = driver.findElement(By.cssSelector("#nexttab7"));
		nexttab7.click();
		// click on submit
		Thread.sleep(1000);
		WebElement submit = driver
				.findElement(By.cssSelector("button[class='btn btn-primary btn-shd addEvent freqType']"));
		js.executeScript("arguments[0].scrollIntoView();", submit);
		submit.click();
		driver.close();
	}

	static String usingRandomUUID() {
		UUID randomUUID = UUID.randomUUID();
		return randomUUID.toString().replaceAll("_", "");
	}

}
