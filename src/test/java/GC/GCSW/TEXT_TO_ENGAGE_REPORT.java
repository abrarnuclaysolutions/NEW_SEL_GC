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

public class TEXT_TO_ENGAGE_REPORT {
	@Test
	public void TextToEngageReport() throws InterruptedException {
		BaseClass cred = new BaseClass();
		String un = cred.username;
		String pass = cred.pass;
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//URL
        driver.get("https://www.givecentral.org/text-to-give/8476");
        //first name
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("abrar");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("khan");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abrar@nuclaysolutions.com");
        driver.findElement(By.xpath("//input[@name='zip']")).sendKeys("12121");
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("sansarpur");
        driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("212,212,212");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
        js.executeScript("arguments[0].scrollIntoView();", city);
        city.sendKeys("saharanpur");
        WebElement state = driver.findElement(By.xpath("//select[@name='state']"));
        js.executeScript("arguments[0].scrollIntoView();", state);
        Select st = new Select(state);
        st.selectByVisibleText("California ");
        //get userid text
        String useridtext = driver.findElement(By.xpath("//input[@placeholder='Userid']")).getAttribute("value");
        System.out.print(useridtext);
        WebElement amo = driver.findElement(By.xpath("//input[@name='amount']"));
        js.executeScript("arguments[0].scrollIntoView();", amo);
        amo.sendKeys("1");
        WebElement cardno = driver.findElement(By.xpath("//input[@name='card_no']"));
        js.executeScript("arguments[0].scrollIntoView();", cardno);
        cardno.sendKeys("4242424242424242");
        WebElement month = driver.findElement(By.xpath("//select[@name='sel_month1']"));
        js.executeScript("arguments[0].scrollIntoView();", month);
        Select mo = new Select(month);
        mo.selectByVisibleText("02");
        WebElement year = driver.findElement(By.xpath("//select[@name='sel_year1']"));
        js.executeScript("arguments[0].scrollIntoView();", year);
        Select ye = new Select(year);
        ye.selectByVisibleText("2025");
        driver.findElement(By.xpath("//button[@class='button btn-primary addPMBtn']")).click();
        Thread.sleep(2600);
//        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        driver.get("https://www.givecentral.org/admin/");
        driver.findElement(By.cssSelector("#username")).sendKeys(un);// username
        driver.findElement(By.cssSelector("#password")).sendKeys(pass);// password
        driver.findElement(By.cssSelector("#logCnf")).click();// login button
      //remove popup
//        Thread.sleep(3000);
//        WebElement icon = driver.findElement(By.xpath("//a[@class='bottomContentLink' and @id='popup_modal_remind_later']"));
//        js.executeScript("arguments[0].scrollIntoView();", icon);
//        icon.click();
      //Click on Reports
        Thread.sleep(2000);
        WebDriverWait rp = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement rpc = rp.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='page-container']/div[@id='wrapper']/nav[@id='sidebar']/div[1]/ul[1]/li[5]/a[1]/span[1]")));
        rpc.click();
        //click on Text To Engage Reports
        Thread.sleep(3400);
        WebDriverWait tter = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement tterc = tter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Text to Engage Report')]")));
        tterc.click();
        WebElement ad = driver.findElement(By.xpath("//body/div[@id='page-container']/div[@id='wrapper']/div[@id='page-wrapper']/div[@id='content']/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]"));
        ad.click();
        Thread.sleep(1300);
        WebElement td = driver.findElement(By.xpath("//input[@id='date_from1']"));
        td.click();
        
        WebElement seltd = driver.findElement(By.xpath("//td[@class=' ui-datepicker-week-end ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today' or @class=' ui-datepicker-week-end  ui-datepicker-today' or @class='  ui-datepicker-today' or @class=' ui-datepicker-week-end ui-datepicker-days-cell-over  ui-datepicker-today' or @class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today' or @class=' ui-datepicker-week-end  ui-datepicker-today']"));
        seltd.click();
        WebElement apply = driver.findElement(By.xpath("//input[@id='submitForm']"));
        js.executeScript("arguments[0].scrollIntoView();", apply);
        apply.click();
        
        WebElement searchicon = driver.findElement(By.xpath("//input[@id='searchboxCustom']"));
        searchicon.click();
        searchicon.sendKeys(useridtext);
        Thread.sleep(2000);
		
	}
}
