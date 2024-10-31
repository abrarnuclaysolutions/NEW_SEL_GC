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

public class MAKE_GUEST_PAYMENT {
	@Test
	public void MakeGuestPayment() throws InterruptedException {
		BaseClass cred = new BaseClass();
		String un = cred.username;
		String pass = cred.pass;
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// URL
		driver.get("https://www.givecentral.org/admin/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Login...
		driver.findElement(By.cssSelector("#username")).sendKeys(un);// username
		driver.findElement(By.cssSelector("#password")).sendKeys(pass);// password
		driver.findElement(By.cssSelector("#logCnf")).click();// login button

		// javascript object
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// click on payment
		Thread.sleep(2100);
		WebDriverWait paymentwait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement clickpayment = paymentwait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Payments']")));
		clickpayment.click();
		// click on make guest payment
		Thread.sleep(2500);
		WebDriverWait guestpay = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement clickguest = guestpay.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Make Guest Payment']")));
		clickguest.click();
		// check on click event
		Thread.sleep(1000);
		WebElement check = driver.findElement(By.xpath("//input[@value='41880']"));
//		        js.executeScript("arguments[0].scrollIntoView();", check);
		check.click();
		// add amount
		WebElement eventpay = driver.findElement(By.xpath("//input[@id='amount_41880']"));
		eventpay.sendKeys("0.05");
		// scroll and click on continue
		Thread.sleep(2000);
		WebElement cont = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-shd' and @id='eventBtn']"));
		js.executeScript("window.scrollBy(0,900)");
		js.executeScript("arguments[0].scrollIntoView();", cont);
		cont.click();
		// first name
		Thread.sleep(750);
		WebElement firstname = driver.findElement(By.cssSelector("input[name='donor_first_name']"));
		firstname.sendKeys("kaif");
		// last name
		WebElement lastname = driver.findElement(By.cssSelector("input[name='donor_last_name']"));
		lastname.sendKeys("khan");
		// email
		WebElement email = driver.findElement(By.cssSelector("input[placeholder='you@domain.com']"));
		email.sendKeys("abrar@nuclaysolutions.com");
		// address
		WebElement address = driver.findElement(By.cssSelector("input[name='address1']"));
		address.sendKeys("sansarpur(saharanpur)");
		// country
		WebElement country = driver.findElement(By.cssSelector("#country"));
		Select selectcountry = new Select(country);
		selectcountry.selectByVisibleText("United States");
		// state
		WebElement state = driver.findElement(By.cssSelector("#donor_state"));
		Select selectstate = new Select(state);
		selectstate.selectByVisibleText("California  ");
		// city
		WebElement city = driver.findElement(By.cssSelector("input[name='donor_city']"));
		city.sendKeys("saharanpur");
		// zip code
		WebElement zipcode = driver.findElement(By.cssSelector("#zip"));
		zipcode.sendKeys("23445");
		// click on continue
		WebElement continueelement = driver.findElement(By.cssSelector("#profileBtn"));
		continueelement.click();

		// name on card
		WebElement namecard = driver.findElement(By.cssSelector("input[name='cc_name_on_card']"));
		namecard.sendKeys("abrarkhan");
		// card number
		WebElement cardnumber = driver.findElement(By.cssSelector("#cc_card_no"));
		cardnumber.sendKeys("42424242424242");
		// select month
		WebElement month = driver.findElement(By.cssSelector("#sel_month"));
		Select selectmonth = new Select(month);
		selectmonth.selectByVisibleText("06");
		// select year
		WebElement year = driver.findElement(By.cssSelector("#sel_year"));
		Select selectyear = new Select(year);
		selectyear.selectByVisibleText("2024");

		// Enter cvv
		WebElement cvv = driver.findElement(By.cssSelector("#cc_cvv"));
		cvv.sendKeys("121");
		// address1
		WebElement clickcheck = driver.findElement(By.cssSelector("#pDemoAdd"));
		clickcheck.click();

		// submit
		WebDriverWait submitwait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement submit = submitwait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Submit']")));
		js.executeScript("arguments[0].scrollIntoView();", submit);
		submit.click();
		Thread.sleep(2000);
		// close driver
		driver.close();

	}
}
