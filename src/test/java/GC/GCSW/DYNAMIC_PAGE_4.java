package GC.GCSW;

import java.time.Duration;
import java.util.Random;

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

public class DYNAMIC_PAGE_4 {
	@Test
	public void DynamicPage4() throws InterruptedException {
		BaseClass cred = new BaseClass();
		String un = cred.username;
		String pass = cred.pass;
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.givecentral.org/admin/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		// object of javascript
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Login...
		// user name
		Thread.sleep(3000);
		WebDriverWait waitofusername = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement elementofusername = waitofusername
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));
		elementofusername.sendKeys(un);

		// password
		WebDriverWait waitofpass = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement elementofpass = waitofpass
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
		elementofpass.sendKeys(pass);

		// login button
		WebDriverWait waitoflogin = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement clicklogin = waitoflogin
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logCnf")));
		clicklogin.click();

		// Click on got it
//        Thread.sleep(1200);
//        driver.findElement(By.xpath("//button[@class='driver-popover-next-btn']")).click();

		// remove popup
//        Thread.sleep(1400);
//        WebElement icon = driver.findElement(By.xpath("//a[@class='bottomContentLink' and @id='popup_modal_remind_later']"));
//        js.executeScript("arguments[0].scrollIntoView();", icon);
//        icon.click();
		// click on Dynamic pages
		Thread.sleep(1200);
		WebDriverWait dynamicwait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement clickdynamic = dynamicwait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Dynamic Pages']")));
		js.executeScript("arguments[0].scrollIntoView();", clickdynamic);
		clickdynamic.click();
		// click on personalized giving pages
		Thread.sleep(1000);
		WebDriverWait personalwait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
		WebElement themeclick = driver.findElement(By.xpath(
				"//body/div[@id='page-container']/div[@id='wrapper']/div[@id='page-wrapper']/div[@id='content']/form[@id='dynamicFormBuilder']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/a[1]"));
		// Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.moveToElement(themeclick).build().perform();
		Thread.sleep(2000);
		WebElement templaElement = driver.findElement(By.xpath(
				"//body/div[@id='page-container']/div[@id='wrapper']/div[@id='page-wrapper']/div[@id='content']/form[@id='dynamicFormBuilder']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/a[1]"));
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

		// check on multiple event
		Thread.sleep(1400);
		WebElement mpl = driver.findElement(By.xpath(
				"//body/div[@id='page-container']/div[@id='wrapper']/div[@id='page-wrapper']/div[@id='content']/form[@id='dynamicFormBuilder']/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[11]/div[4]/div[1]/label[2]/input[1]"));
		mpl.click();

		// add group
		Thread.sleep(1500);
		WebElement ag = driver.findElement(By.xpath("//input[@id='AddGroup']"));
		js.executeScript("arguments[0].scrollIntoView();", ag);
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", ag);
		ag.click();
		// group label
		WebElement gl = driver.findElement(By.xpath("//input[@id='groupLabel1']"));
		gl.sendKeys("Nothing");
		// click on select event
		WebElement cse = driver.findElement(By.xpath("//select[@id='groupMulEvent1']"));
		// select event
		Select st = new Select(cse);
		st.selectByVisibleText("nodesg");
		st.selectByVisibleText("nodesig2");
		// add group
		Thread.sleep(1500);
		WebElement ag1 = driver.findElement(By.xpath("//input[@id='AddGroup']"));
//        js.executeScript("arguments[0].scrollIntoView();", ag);
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", ag);
		ag1.click();
		// group label
		WebElement gl1 = driver.findElement(By.xpath("//input[@id='groupLabel2']"));
		gl1.sendKeys("Nothing1");
		// click on select event
		Thread.sleep(2000);
		WebElement cse1 = driver.findElement(By.xpath("//select[@id='groupMulEvent2']"));
		// select event
		Select st1 = new Select(cse1);
		st1.selectByVisibleText("nodesg");
		st1.selectByVisibleText("nodesig2");

		// select logo image
		WebElement li = driver.findElement(By.xpath("//input[@id='formLogo']"));
		js.executeScript("arguments[0].scrollIntoView();", li);
		li.sendKeys("C:\\Users\\abrar\\OneDrive\\Pictures\\Screenshots\\image.png");
		// select bg image
		WebElement bg = driver.findElement(By.xpath("//input[@id='bgImage']"));
		bg.sendKeys("C:\\Users\\abrar\\OneDrive\\Pictures\\Screenshots\\image.png");
		// enter title
		WebElement title1 = driver.findElement(By.xpath(
				"//body/div[@id='page-container']/div[@id='wrapper']/div[@id='page-wrapper']/div[@id='content']/form[@id='dynamicFormBuilder']/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[31]/div[2]/div[1]/input[1]"));
		js.executeScript("arguments[0].scrollIntoView();", title1);
		title1.sendKeys("kaif");
		// enter URL
		Random rn = new Random();
		int data = rn.nextInt(15000);
		System.out.print(data);
		WebElement url = driver.findElement(By.xpath("//input[@id='page_url']"));
		url.sendKeys("Unique" + data);
		// payment method type 1
		WebElement paymethod = driver.findElement(By.cssSelector("input[value='cc']"));
		js.executeScript("arguments[0].scrollIntoView();", paymethod);
		paymethod.click();
		// payment2 method type 2
		WebElement paymethod2 = driver.findElement(By.cssSelector("input[value='ec']"));
		paymethod2.click();
		// submit
		WebElement submit = driver.findElement(By.cssSelector("input[value='Submit']"));
		js.executeScript("arguments[0].scrollIntoView();", submit);
		submit.click();
		Thread.sleep(1200);
//		driver.get("https://www.givecentral.org/admin/show-appeal-pages/add-new-form");
		// click on close
		driver.findElement(By.xpath("//button[@class='close' and @type='button' and @data-dismiss='modal']")).click();
		// copy URL
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/a[1]")).click();
		// close driver
		Thread.sleep(1200);
		driver.close();
		// open url
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		op.addArguments("incognito");
		ChromeDriver driver1 = new ChromeDriver(op);
		driver1.manage().window().maximize();
		driver1.get("https://www.givecentral.org/Unique" + data);
		JavascriptExecutor js1 = (JavascriptExecutor) driver1;
		// fill form
		Thread.sleep(1200);
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
		Select st11 = new Select(state);
		st11.selectByValue("CA");
		// city
		driver1.findElement(By.xpath("//input[@name='city']")).sendKeys("saharanpur");
		// zip
		driver1.findElement(By.xpath("//input[@name='zip']")).sendKeys("12121");
		// click on check button
//        driver.findElement(By.xpath("//body/div[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]/span[1]")).click();
		// add username
		WebElement un1 = driver1.findElement(By.xpath("//input[@id='uid']"));
		un1.sendKeys("kaif" + data);
		// password
		WebElement pass1 = driver1.findElement(By.xpath("//input[@id='password']"));
		pass1.sendKeys("kaif" + data);
		// confirm password
		WebElement cpass = driver1.findElement(By.xpath("//input[@id='cnf_password']"));
		cpass.sendKeys("kaif" + data);
		// amount
		driver1.findElement(By.xpath(
				"//body/div[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/label[2]/input[1]"))
				.sendKeys("0.05");
		// add frequency
		WebElement af = driver1.findElement(By.xpath(
				"//body/div[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/label[2]/select[1]"));
		Select cf = new Select(af);
		cf.selectByVisibleText("One-Time");
		// add destination
		Thread.sleep(1200);
		WebElement des = driver1.findElement(By.xpath(
				"//body/div[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[7]/div[1]/div[1]/label[2]/select[1]"));
		js1.executeScript("arguments[0].scrollIntoView();", des);
		Select adddes = new Select(des);
		adddes.selectByVisibleText("In memory of");
//        //add parish
//        WebElement parish = driver1.findElement(By.xpath("//select[@name='selectMultipleParishRecurr']"));
//        js1.executeScript("arguments[0].scrollIntoView();", parish);
//        Select par = new Select(parish);
//        par.selectByVisibleText("Immaculate Conception Parish - 9 (106)");
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
		// submit form
		driver1.findElement(By.xpath("//input[@id='makePaymentBtn']")).submit();
		// click on submit again
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		// close driver
		Thread.sleep(1200);
		driver1.close();

	}
}
