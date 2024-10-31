package GC.GCSW;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import Base_Class.BaseClass;

public class ADD_DONOR extends BaseClass {
	@Test
	public void AddDonor() throws InterruptedException {
		BaseClass cred = new BaseClass();
		String un = cred.username;
		String pass = cred.pass;

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.givecentral.org/admin/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// Login...
		WebDriverWait waitofusername = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement elementofusername = waitofusername
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));
		elementofusername.sendKeys(un);
		// driver.findElement(By.cssSelector("#username")).sendKeys("abrark_gc");//
		// username
		WebDriverWait waitofpass = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement elementofpass = waitofpass
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
		elementofpass.sendKeys(pass);
		// driver.findElement(By.cssSelector("#password")).sendKeys("tiger@12345678");//
		// password
		WebDriverWait waitoflogin = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement clicklogin = waitoflogin
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logCnf")));
		clicklogin.click();

		// Click on got it
//	        Thread.sleep(2000);
//	        driver.findElement(By.xpath("//button[@class='driver-popover-next-btn']")).click();
//	        //remove popup
		JavascriptExecutor js = (JavascriptExecutor) driver;
//	        Thread.sleep(5000);
//	        WebElement icon = driver.findElement(By.xpath("//a[@class='bottomContentLink' and @id='popup_modal_remind_later']"));
//	        js.executeScript("arguments[0].scrollIntoView();", icon);
//	        icon.click();
		// click on donors
		Thread.sleep(10000);
		WebDriverWait waitofdonor = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement elementofdonor = waitofdonor.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body/div[@id='page-container']/div[@id='wrapper']/nav[@id='sidebar']/div[1]/ul[1]/li[11]/a[1]/span[1]")));
		elementofdonor.click();
		// click on add new donor
		Thread.sleep(7000);
		WebDriverWait waitofadddonor = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement elementofadddonor = waitofadddonor.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body/div[@id='page-container']/div[@id='wrapper']/nav[@id='sidebar']/div[1]/ul[1]/li[11]/ul[1]/li[1]/a[1]/span[1]")));
		elementofadddonor.click();
		// first name
		Thread.sleep(4000);
		WebElement fname = driver.findElement(By.cssSelector("input[name='donor_first_name']"));
		fname.sendKeys("abrar");
		// last name
		WebElement lname = driver.findElement(By.cssSelector("input[name='donor_last_name']"));
		lname.sendKeys("salman");
		// profile id
		int number;
		Random ran = new Random();
		number = ran.nextInt();
		WebElement profileid = driver.findElement(By.cssSelector("#userid"));
		profileid.sendKeys("abrark_gc" + number);
		// js object

		// address
		WebElement address = driver.findElement(By.cssSelector("input[name='address1']"));
		js.executeScript("arguments[0].scrollIntoView();", address);
		address.sendKeys("Sansarpur(Saharanpur)");
		// country
		WebElement country = driver.findElement(By.cssSelector("#country"));
		js.executeScript("arguments[0].scrollIntoView();", country);
		Select sctcountry = new Select(country);
		sctcountry.selectByVisibleText("United States");
		// city
		WebElement city = driver.findElement(By.cssSelector("input[name='donor_city']"));
		js.executeScript("arguments[0].scrollIntoView();", city);
		city.sendKeys("Saharanpur");
		// state
		WebElement state = driver.findElement(By.xpath("//select[@name='donor_state']"));
		js.executeScript("arguments[0].scrollIntoView();", state);
		Select sct = new Select(state);
		sct.selectByVisibleText("California");
		// zip
		WebElement zip = driver.findElement(By.cssSelector("input[name='zip']"));
		js.executeScript("arguments[0].scrollIntoView();", zip);
		zip.sendKeys("12121");
		// enter parish id
//		Thread.sleep(1300);
		WebElement parishid = driver.findElement(By.xpath("//select[@name='parishid']"));
		Select pid = new Select(parishid);
		pid.selectByVisibleText("106 - Basilica of Bom Jesus - Dallas");
		// submit
		Thread.sleep(1300);
		WebElement submit = driver.findElement(By.cssSelector("input[value='Save Donor']"));
		js.executeScript("arguments[0].scrollIntoView();", submit);
		submit.click();
		// popup
		WebElement popup = driver
				.findElement(By.xpath("//div[@id='systemMessagesDiv']//button[@type='button'][normalize-space()='×']"));
		popup.click();
		driver.close();

	}
}
