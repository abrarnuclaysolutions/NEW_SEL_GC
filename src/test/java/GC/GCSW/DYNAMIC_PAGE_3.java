package GC.GCSW;

import java.time.Duration;
import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base_Class.BaseClass;

public class DYNAMIC_PAGE_3 {
	@Test
	public void DynamicPage3() throws InterruptedException {
		BaseClass cred = new BaseClass();
		String un = cred.username;
		String pass = cred.pass;
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.givecentral.org/admin/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		// object of javascript
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Login...
		// user name
		WebDriverWait waitofusername = new WebDriverWait(driver, Duration.ofSeconds(4));
		WebElement elementofusername = waitofusername
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));
		elementofusername.sendKeys(un);

		// password
		WebDriverWait waitofpass = new WebDriverWait(driver, Duration.ofSeconds(4));
		WebElement elementofpass = waitofpass
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
		elementofpass.sendKeys(pass);

		// login button
		WebDriverWait waitoflogin = new WebDriverWait(driver, Duration.ofSeconds(4));
		WebElement clicklogin = waitoflogin
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logCnf")));
		clicklogin.click();

		// Click on got it
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//button[@class='driver-popover-next-btn']")).click();

		// remove popup
//         Thread.sleep(5000);
//         WebElement icon = driver.findElement(By.xpath("//a[@class='bottomContentLink' and @id='popup_modal_remind_later']"));
//         js.executeScript("arguments[0].scrollIntoView();", icon);
//         icon.click();
		// click on Dynamic pages
		Thread.sleep(3000);
		WebDriverWait dynamicwait = new WebDriverWait(driver, Duration.ofSeconds(4));
		WebElement clickdynamic = dynamicwait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Dynamic Pages']")));
		js.executeScript("arguments[0].scrollIntoView();", clickdynamic);
		clickdynamic.click();
		// click on personalized giving pages
		Thread.sleep(3000);
		WebDriverWait personalwait = new WebDriverWait(driver, Duration.ofSeconds(4));
		WebElement personalclick = personalwait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Personalized Giving Pages')]")));
		personalclick.click();
		// click on add new
		WebElement addnew = driver.findElement(By.cssSelector(".uploader.pull-right"));
		addnew.click();
		// page title
		WebElement title = driver.findElement(By.cssSelector("#template_name"));
		title.sendKeys("abrar salman");
		// click on next
		WebElement next = driver.findElement(By.cssSelector("#btn-text"));
		next.click();
		// hover and click the element
		WebElement themeclick = driver.findElement(By.cssSelector(".fa.choose.choose-theme.theme-3"));
		// Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.moveToElement(themeclick).build().perform();
		Thread.sleep(1200);
		WebElement templaElement = driver.findElement(By.cssSelector(".fa.choose.choose-theme.theme-3"));
		templaElement.click();
		// click on next
		WebElement next1 = driver.findElement(By.cssSelector("button[class='next-button']"));
		next1.click();

		// Click on show login option
		Thread.sleep(1200);
		WebElement sloc = driver.findElement(By.xpath("//input[@id='login_checkbox']"));
		sloc.click();
		// Show Save Profile Option
		WebElement spo = driver.findElement(By.xpath("//input[@id='register_checkbox']"));
		js.executeScript("arguments[0].scrollIntoView();", spo);
		spo.click();
		// section heading
		WebElement secheading = driver.findElement(By.xpath("//input[@name='event_block_header_label']"));
		secheading.sendKeys("kaif aslam");

		WebElement checkElement = driver.findElement(By.xpath("//input[@id='payment_option_one_time']"));
		checkElement.click();

		WebElement sel = driver.findElement(By.xpath("//select[@id='one_time_event']"));
		Select drop = new Select(sel);
		drop.selectByVisibleText("11july");
		// click on check2
		WebElement checkElement2 = driver.findElement(By.xpath("//input[@id='payment_option_recurring']"));
		js.executeScript("arguments[0].scrollIntoView();", checkElement2);
		checkElement2.click();
		// select one event2
		WebElement selecElement = driver.findElement(By.xpath("//select[@id='recurring_event']"));
		Select drop2Select = new Select(selecElement);
		drop2Select.selectByVisibleText("22oct30");
		// Title
		WebElement tiElement = driver.findElement(By.cssSelector("input[name='form_title']"));
		js.executeScript("arguments[0].scrollIntoView();", tiElement);
		tiElement.sendKeys("Kaif Aslam");

		Random rn = new Random();
		int randomStr = rn.nextInt(10000);
		WebElement url = driver.findElement(By.cssSelector("#page_url"));
		url.sendKeys("Unique" + randomStr);
		System.out.print(randomStr);
		// payment methods type
		WebElement paymethod = driver.findElement(By.cssSelector("input[value='cc']"));
		js.executeScript("arguments[0].scrollIntoView();", paymethod);
		paymethod.click();
		// payment2 methods type
		WebElement paymethod2 = driver.findElement(By.cssSelector("input[value='ec']"));
		paymethod2.click();

		// submit
		Thread.sleep(1200);
		WebElement submit = driver.findElement(By.cssSelector("input[value='Submit']"));
		js.executeScript("arguments[0].scrollIntoView();", submit);
		submit.click();
		// click on close
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='close' and @type='button' and @data-dismiss='modal']")).click();
		// copy URL
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/a[1]")).click();
		// close driver
		Thread.sleep(1200);
		driver.close();
		// open url
//        op.addArguments("--remote-allow-origins=*");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		op.addArguments("incognito");
		ChromeDriver driver1 = new ChromeDriver(op);
		driver1.manage().window().maximize();
		driver1.get("https://www.givecentral.org/Unique" + randomStr);
		JavascriptExecutor js1 = (JavascriptExecutor) driver1;
		// fill form
		Thread.sleep(1400);
		// fname
		WebElement fname = driver1.findElement(By.xpath("//input[@name='firstName']"));
		js1.executeScript("arguments[0].scrollIntoView();", fname);
		fname.sendKeys("abrar");
		// lname
		WebElement lname = driver1.findElement(By.xpath("//input[@name='familyLastName']"));
		lname.sendKeys("khan");
		// email
		driver1.findElement(By.xpath("//input[@name='email']")).sendKeys("abrar@nuclaysolutions.com");
		// address
		driver1.findElement(By.xpath("//input[@name='address']")).sendKeys("sansarpur");
		// state
		WebElement state = driver1.findElement(By.xpath("//select[@id='state']"));
		js1.executeScript("arguments[0].scrollIntoView();", state);
		Select st = new Select(state);
		st.selectByValue("CA");
		// city
		driver1.findElement(By.xpath("//input[@name='city']")).sendKeys("saharanpur");
		// zip
		driver1.findElement(By.xpath("//input[@name='zip']")).sendKeys("12121");
		// amount
		driver1.findElement(By.xpath("//input[@name='recurr_gen_amount']")).sendKeys("0.05");
		// add frequency
		WebElement af = driver1.findElement(By.xpath("//select[@name='recurr_payment_frequency']"));
		Select cf = new Select(af);
		cf.selectByVisibleText("One-Time");
		// add parish
//        WebElement parish = driver1.findElement(By.xpath("//select[@name='selectMultipleParishRecurr']"));
//        js1.executeScript("arguments[0].scrollIntoView();", parish);
//        Select par = new Select(parish);
//        par.selectByVisibleText("Basilica of Bom Jesus - city2 (106)");
		// name on card
		driver1.findElement(By.xpath("//input[@name='cc_name_on_card']")).sendKeys("Abrar");
		// card number
		driver1.findElement(By.xpath("//input[@id='cc_card_no']")).sendKeys("4242424242424242");
		// select month
		WebElement month = driver1.findElement(By.xpath("//select[@name='sel_month']"));
		js1.executeScript("arguments[0].scrollIntoView();", month);
		Select mon = new Select(month);
		mon.selectByVisibleText("02");
		// select year
		WebElement year = driver1.findElement(By.xpath("//select[@name='sel_year']"));
		Select yer = new Select(year);
		yer.selectByVisibleText("2025");
		// cvv
		driver1.findElement(By.xpath("//input[@id='cc_cvv']")).sendKeys("121");
		// zip
		driver1.findElement(By.xpath("//input[@id='cc_zip']")).sendKeys("12121");
		// add username
		WebElement un1 = driver1.findElement(By.xpath("//input[@id='uid']"));
		un1.sendKeys("kaif" + randomStr);
		// password
		WebElement pass1 = driver1.findElement(By.xpath("//input[@id='password']"));
		pass1.sendKeys("kaif" + randomStr);
		// confirm password
		WebElement cpass = driver1.findElement(By.xpath("//input[@id='cnf_password']"));
		cpass.sendKeys("kaif" + randomStr);
		// submit form
		driver1.findElement(By.xpath("//input[@id='makePaymentBtn']")).submit();
		// click on submit again
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		// close driver
		Thread.sleep(2000);
		driver1.close();
	}

	static String usingRandomUUID() {
		UUID randomUUID = UUID.randomUUID();
		return randomUUID.toString().replaceAll("_", "");
	}
}
