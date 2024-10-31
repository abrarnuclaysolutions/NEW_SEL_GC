package GC.GCSW;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base_Class.BaseClass;

public class CREATE_PLADGE {
	@Test
	public void CreatePladge() throws InterruptedException {
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

//      //remove popup
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Click on Donors
		Thread.sleep(10000);
		WebDriverWait waitofdonors = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement donorelement = waitofdonors.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body/div[@id='page-container']/div[@id='wrapper']/nav[@id='sidebar']/div[1]/ul[1]/li[11]/a[1]/span[1]")));
		donorelement.click();
		// view all donors
		Thread.sleep(5000);
		WebDriverWait viewalldonor = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement donorelement1 = viewalldonor.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'View All Donors')]")));
		donorelement1.click();
		// driver.findElement(By.cssSelector(
		// "body > div:nth-child(3) > div:nth-child(9) > nav:nth-child(1) >
		// div:nth-child(1) > ul:nth-child(1) > li:nth-child(9) > ul:nth-child(2) >
		// li:nth-child(3) > a:nth-child(1) > span:nth-child(1)"))
		// .click();
		// Add text on Profile ID
		driver.findElement(By.cssSelector("#userid")).sendKeys("abrarkhan");
		// Scroll page and Click on Search Donor.
		WebElement searchdonor = driver.findElement(By.cssSelector("#SubmitBtn"));
		js.executeScript("arguments[0].scrollIntoView();", searchdonor);
		searchdonor.click();
		// Scroll and Click on link(kaif12345).
		Thread.sleep(4000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("abrarkhan"))).click().perform();
		WebElement scrollid = driver.findElement(By.linkText("abrarkhan"));
		js.executeScript("arguments[0].scrollIntoView();", scrollid);
		scrollid.click();
		// switch on other tab
		ArrayList<String> newtab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newtab.get(1));
		// Scroll and Click on Create pledge.
		WebElement pledgeelement = driver.findElement(By.xpath("//button[contains(text(),'Create Pledge')]"));
		js.executeScript("arguments[0].scrollIntoView();", pledgeelement);
		pledgeelement.click();
		// Select Event By DropDown.
		WebElement eventelement = driver.findElement(By.cssSelector("#event"));
		Select Dropdownselect = new Select(eventelement);
		Dropdownselect.selectByVisibleText("pldggee");
		// Fill ammount.
		driver.findElement(By.cssSelector("#pledgeAmount")).sendKeys("0.05");
		// Add Frequency.
		WebElement frequencyelement = driver.findElement(By.cssSelector("#paymentFrequency"));
		Select dropdownselect1 = new Select(frequencyelement);
		dropdownselect1.selectByVisibleText("One-Time");
		// Select Date
		WebElement datepicker = driver.findElement(By.cssSelector("#paymentStartDate"));
		js.executeScript("arguments[0].scrollIntoView();", datepicker);
		datepicker.click();
		WebElement dayselect = driver
				.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover"));
		dayselect.click();

		// Fill installment amount
		Thread.sleep(3000);
		WebDriverWait waitofamount = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement objofamount = waitofamount
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='amount']")));
		js.executeScript("arguments[0].scrollIntoView();", objofamount);
		objofamount.sendKeys("0.05");

		// add source code
		WebElement sourcecode = driver.findElement(By.cssSelector(".caret"));
		js.executeScript("arguments[0].scrollIntoView();", sourcecode);
		sourcecode.click();
		WebElement clickonsourcecode = driver.findElement(By.xpath("//a[normalize-space()='110011']"));
		js.executeScript("arguments[0].scrollIntoView();", clickonsourcecode);
		clickonsourcecode.click();

		// add parish id
		WebElement pid = driver.findElement(By.xpath("//select[@id='parish_id']"));
		Select spid = new Select(pid);
		spid.selectByVisibleText("105 - St. Paul Cathedral");

		// add designation
		WebElement adddesignation = driver.findElement(By.xpath("//select[@id='selDesignation']"));
		Select valueofadddesignation = new Select(adddesignation);
		valueofadddesignation.selectByVisibleText("In memory of");

		// Click on add
		driver.findElement(By.xpath("//button[@id='AddDesignation']")).click();

		// Click on Continue button.
		WebElement continuebutton = driver.findElement(By.cssSelector("#pledgeSubmit"));
		js.executeScript("arguments[0].scrollIntoView();", continuebutton);
		continuebutton.click();
		// SELECT payment methods
		WebElement payelement = driver.findElement(By.cssSelector("#paymentMethod"));
		Select paymethods = new Select(payelement);
		paymethods.selectByVisibleText("Visa - xxx1111 added on 04/12/2017 expiring on 2017-04-30");
		// click on continue
		WebElement paycontinuebutton = driver.findElement(By.cssSelector("#continueBtn"));
		paycontinuebutton.click();
		// click on ok button
		driver.findElement(By.cssSelector("button[data-bb-handler='confirm']")).click();
//  //get all text
		Thread.sleep(2000);
		String id = driver.findElement(By.xpath("//ul[@class='error twelve columns']")).getText();
//  text.getText().toString();
		System.out.println(id);
//   String id = "Sorry, Your payment for today with Transaction ID - C6432651B9390D has failed.";
		String text = id.substring(52, 66);// s=53 . e=68
		System.out.println(text);
		// Cencel popup
		driver.findElement(By.xpath("//div[@id='systemMessagesDiv']//button[@type='button'][normalize-space()='×']"))
				.click();
		// Click on Reports
		Thread.sleep(2000);
		WebDriverWait rp = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement rpc = rp.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body/div[@id='page-container']/div[@id='wrapper']/nav[@id='sidebar']/div[1]/ul[1]/li[5]/a[1]/span[1]")));
		rpc.click();
		// click on transaction report
		WebElement tr = driver.findElement(By.xpath(
				"//body/div[@id='page-container']/div[@id='wrapper']/nav[@id='sidebar']/div[1]/ul[1]/li[5]/ul[1]/li[11]/a[1]/span[1]"));
		tr.click();
		// click on advanced report
		WebElement adr = driver.findElement(By.xpath(
				"//body/div[@id='page-container']/div[@id='wrapper']/div[@id='page-wrapper']/div[@id='content']/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/img[1]"));
		adr.click();
		// select payment status
		WebElement pts = driver.findElement(By.xpath("//select[@id='payment_status']"));
//     pts.click();
		Select dd = new Select(pts);
		dd.selectByVisibleText("Success+Failed+Refunds+Rejects ");
		// select date
		Thread.sleep(2000);
		WebElement td = driver.findElement(By.xpath("//input[@id='date_from1']"));
		td.click();
//     Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//td[@class=' ui-datepicker-week-end ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today' or @class=' ui-datepicker-week-end  ui-datepicker-today' or @class=' ui-datepicker-today' or @class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']"))
				.click();
		// select date2
		WebElement td2 = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']"));
		td2.click();
		driver.findElement(By.xpath(
				"//td[@class=' ui-datepicker-week-end ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today' or @class=' ui-datepicker-week-end  ui-datepicker-today' or @class=' ui-datepicker-today' or @class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']"))
				.click();
		// payment method type
		WebElement pmt = driver.findElement(By.xpath("//select[@id='payment_method_type']"));
		Select all = new Select(pmt);
		all.selectByVisibleText("All");
		// check all
//     driver.findElement(By.xpath("//input[@id='selectAll']")).click();
		// click on apply
		WebElement ap = driver.findElement(By.xpath("//input[@id='submitForm']"));
		js.executeScript("arguments[0].scrollIntoView();", ap);
		ap.click();
		// click on search icon
		WebElement si = driver.findElement(By.xpath("//input[@id='searchboxCustom']"));
		si.click();
		si.sendKeys(text);

	}
}
