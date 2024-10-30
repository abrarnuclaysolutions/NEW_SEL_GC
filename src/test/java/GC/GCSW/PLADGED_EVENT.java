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

public class PLADGED_EVENT {
	@Test
	public void PladgedEvent() throws InterruptedException {
		BaseClass cred = new BaseClass();
		String un = cred.username;
		String pass = cred.pass;
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.givecentral.org/admin/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Login...
		WebDriverWait waitofusername = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement elementofusername = waitofusername
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));
		elementofusername.sendKeys(un);
		// driver.findElement(By.cssSelector("#username")).sendKeys("abrark_gc");//
		// username
		WebDriverWait waitofpass = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement elementofpass = waitofpass
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
		elementofpass.sendKeys(pass);
		// driver.findElement(By.cssSelector("#password")).sendKeys("tiger@12345678");//
		// password
		WebDriverWait waitoflogin = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement clicklogin = waitoflogin
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logCnf")));
		clicklogin.click();

		// Click on got it
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[@class='driver-popover-next-btn']")).click();

		// remove popup
		JavascriptExecutor js = (JavascriptExecutor) driver;
//        Thread.sleep(5000);
//        WebElement icon = driver.findElement(By.xpath("//a[@class='bottomContentLink' and @id='popup_modal_remind_later']"));
//        js.executeScript("arguments[0].scrollIntoView();", icon);
//        icon.click();
		// click on event
		Thread.sleep(5000);
		WebDriverWait eventwait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement event = eventwait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Events']")));
		event.click();
		// click on add new
		Thread.sleep(4000);
		WebDriverWait addnewwait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement addnew = addnewwait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Add New']")));
		addnew.click();
		// event name
		String randomStr = usingRandomUUID();
		WebElement eventname = driver.findElement(By.cssSelector("#event_title"));
		eventname.sendKeys(randomStr);
		// event type
		WebElement eventtype = driver.findElement(By.cssSelector("#event_type"));
		Select type = new Select(eventtype);
		type.selectByVisibleText("Pledged Events");
		// click on next
		Thread.sleep(1500);
		WebElement next = driver.findElement(By.cssSelector("#nexttab"));
		js.executeScript("arguments[0].scrollIntoView();", next);
		next.click();
		// account
		Thread.sleep(1500);
		WebElement account = driver.findElement(By.cssSelector("#cc_accounts_merchant_id_id"));
		Select acc = new Select(account);
		acc.selectByVisibleText("GiveCentral Vantiv");
		// another account
		WebElement otheracc = driver.findElement(By.cssSelector("#ec_accounts_merchant_id_id"));
		Select acc1 = new Select(otheracc);
		acc1.selectByVisibleText("GiveCentral Vantiv");
		// next
		Thread.sleep(1500);
		WebElement nexttab = driver.findElement(By.cssSelector("#nexttab1"));
		js.executeScript("arguments[0].scrollIntoView();", nexttab);
		nexttab.click();
		// click on next
		Thread.sleep(1400);
		WebElement nextagain = driver.findElement(By.cssSelector("#nexttab2"));
		nextagain.click();
		// click on next
		Thread.sleep(1400);
		WebElement next3 = driver.findElement(By.cssSelector("#nexttab3"));
		js.executeScript("arguments[0].scrollIntoView();", next3);
		next3.click();
		// next5
		Thread.sleep(1000);
		WebElement next5 = driver.findElement(By.cssSelector("#nexttab5"));
		next5.click();
		// next6
		Thread.sleep(1400);
		WebElement sepc = driver.findElement(By.xpath("//select[@id='eventParishCategory']"));
		Select def = new Select(sepc);
		def.selectByVisibleText("Default");
		WebElement next6 = driver.findElement(By.cssSelector("#nexttab6"));
		next6.click();
		// next7
		Thread.sleep(1000);
        WebElement next7 = driver.findElement(By.cssSelector("#nexttab7"));
        next7.click();
		// submit
        Thread.sleep(1200);
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
