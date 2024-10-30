package GC.GCSW;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class THEME3_FRONTEND {
	@Test
	public void Theme3_Frontend() throws InterruptedException {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		op.addArguments("incognito");
		ChromeDriver driver1 = new ChromeDriver(op);
		driver1.manage().window().maximize();
		driver1.get("https://www.givecentral.org/appeals-form-registration/acp67189d6b9955a/user/guest");
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
		Random rnd = new Random();
		int rn = rnd.nextInt(1500);
		WebElement un1 = driver1.findElement(By.xpath("//input[@id='uid']"));
		un1.sendKeys("kaif" + rn);
		// password
		WebElement pass1 = driver1.findElement(By.xpath("//input[@id='password']"));
		pass1.sendKeys("kaif" + rn);
		// confirm password
		WebElement cpass = driver1.findElement(By.xpath("//input[@id='cnf_password']"));
		cpass.sendKeys("kaif" + rn);
		// submit form
		driver1.findElement(By.xpath("//input[@id='makePaymentBtn']")).submit();
		// click on submit again
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		// close driver
//		Thread.sleep(2000);
//		driver1.close();
	}
}
