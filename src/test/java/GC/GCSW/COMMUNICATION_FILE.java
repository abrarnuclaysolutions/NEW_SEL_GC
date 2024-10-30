package GC.GCSW;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base_Class.BaseClass;

public class COMMUNICATION_FILE {
	@Test
	public void Communicationfile() throws InterruptedException {
		BaseClass cred = new BaseClass();
		String un = cred.username;
		String pass = cred.pass;
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.givecentral.org/admin/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // object of javascript
        JavascriptExecutor js = (JavascriptExecutor)driver;
        // Login form
        // user name
        WebDriverWait waitofusername = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elementofusername = waitofusername.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));
        elementofusername.sendKeys(un);
        // password
        WebDriverWait waitofpass = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elementofpass = waitofpass.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
        elementofpass.sendKeys(pass);
 
        // login button
        WebDriverWait waitoflogin = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement clicklogin = waitoflogin.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logCnf")));
        clicklogin.click();
        
        //Click on got it
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[@class='driver-popover-next-btn']")).click();
      //remove popup
//        Thread.sleep(5000);
//        WebElement icon = driver.findElement(By.xpath("//a[@class='bottomContentLink' and @id='popup_modal_remind_later']"));
//        js.executeScript("arguments[0].scrollIntoView();", icon);
//        icon.click();
        //click on communication
        Thread.sleep(3000);
        WebDriverWait comm = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement communication = comm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Communication']")));
        js.executeScript("arguments[0].scrollIntoView();", communication);
        communication.click();
        //click on new communication
        Thread.sleep(3000);
        WebDriverWait newcomm = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement newcommunication = newcomm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='New Communication Portal (Beta)']"))); 
        js.executeScript("arguments[0].scrollIntoView();", newcommunication);
        Thread.sleep(3000);
        newcommunication.click();
        //switch to new tab
        ArrayList<String> newtab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newtab.get(1));
        //click on send email
        Thread.sleep(4000);
        WebElement sendemail = driver.findElement(By.xpath("//body/div[1]/aside[1]/ul[1]/li[3]/a[1]"));
        sendemail.click();
        //click on new campaign
        driver.findElement(By.xpath("//h5[normalize-space()='New Campaign']")).click();
        //enter text on popup box
        driver.findElement(By.xpath("//input[@id='contacts-campaign-name']")).sendKeys("gfgzdc");
        //click on continue
        driver.findElement(By.xpath("//button[@id='add-contacts-campaign']")).click();
        //enter email
        WebElement emaileElement = driver.findElement(By.xpath("//input[@id='search-input']"));
        emaileElement.sendKeys("abrar@nuclaysolutions.com");
        Thread.sleep(2000);
        emaileElement.sendKeys(Keys.ENTER);
        // check on id
        Thread.sleep(5000);
        WebElement id = driver.findElement(By.xpath("//body[1]/div[1]/main[1]/div[3]/form[1]/div[1]/div[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/label[1]/span[1]"));
        id.click();
        //click on continue
        WebElement contiElement = driver.findElement(By.xpath("//button[@id='continue-btn']"));
        contiElement.click();
        //click on add new template
        WebElement template = driver.findElement(By.xpath("//i[@class='fas fa-plus']"));
        template.click();
        //enter template name
        WebElement tempname = driver.findElement(By.xpath("//input[@placeholder='Enter template name']"));
        tempname.sendKeys("abrar salman");
        //click on confirm
        WebElement con = driver.findElement(By.xpath("//button[normalize-space()='Confirm']"));
        con.click();
        //enter text on email subject
        Thread.sleep(1000);
        WebElement emailsub = driver.findElement(By.xpath("//input[@placeholder='Enter email subject']"));
        emailsub.sendKeys("kuchbhi");
        // click on confirm
        Thread.sleep(2400);
        WebDriverWait con2wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement con2 = con2wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Confirm']")));
//        con2.click();
        Actions conc = new Actions(driver);
        conc.moveToElement(con2).click().perform();

        WebElement dragelement = driver.findElement(By.xpath("//div[@id='toolblocks']//div[2]//div[1]//div[1]"));
        WebElement dropelement = driver.findElement(By.cssSelector(".sortable-blocks-edit.empty.ui-sortable"));
        Actions act = new Actions(driver);
        act.dragAndDrop(dragelement, dropelement).click().perform();
        //select the image
        Thread.sleep(2300);
        WebElement upload = driver.findElement(By.xpath("//input[@class='fileupload nofile']"));
        upload.sendKeys("C:\\Users\\abrar\\OneDrive\\Pictures\\Screenshots\\image.png");
//        Actions image = new Actions(driver);"C:\Users\abrar\OneDrive\Desktop\Document from kaifkhan8534004981.heif"
//        image.sendKeys("C:\\Users\\Cw\\Pictures\\Screenshots\\Screenshot (3).png");
        //click on save
        WebElement save = driver.findElement(By.xpath("//span[normalize-space()='Save']"));
        save.click();
        //click on exit
        WebElement exit = driver.findElement(By.xpath("//a[@id='exit-button']"));
        exit.click();
        //click on select
        Thread.sleep(2300);
        WebElement select = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/button[1]"));
        Actions act3 = new Actions(driver);
        act3.moveToElement(select).click().perform();
        //click on continue
        WebElement cont3Element = driver.findElement(By.xpath("//button[@id='continue-btn']"));
        cont3Element.click();
        //enter email again
        WebElement emailagain = driver.findElement(By.xpath("//input[@id='replyTo']"));
        js.executeScript("arguments[0].scrollIntoView();", emailagain);
        emailagain.sendKeys("abrar@nuclaysolutions.com");
        //click on continue
        WebElement cont4Element = driver.findElement(By.xpath("//button[@id='continue-btn']"));
        cont4Element.click();
        //click on send email
        Thread.sleep(2300);
        WebElement sendemail1 = driver.findElement(By.xpath("//button[contains(text(),'Send Now')]"));
//        sendemail1.click();
        Actions act4 = new Actions(driver);
        act4.moveToElement(sendemail1).click().perform();
        //click on back to dashboard
        Thread.sleep(3000);
        WebElement btdb = driver.findElement(By.xpath("//body/div[@id='emailSent']/div[1]/div[1]/div[1]/a[1]"));
        Actions btd = new Actions(driver);
        btd.moveToElement(btdb).click().perform();
		driver.close();
		Thread.sleep(1000);
		driver.close();
	}

}
