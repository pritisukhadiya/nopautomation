import com.google.common.annotations.VisibleForTesting;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;


public class NopCommerce {

  //  WAP to register on nopcommerce website
    protected static WebDriver driver;
    @Test

    public static void main (String[] args){

       //declaration and instantiation of objects

        System.setProperty("webdriver.chrome.driver","Chrome\\chromedriver.exe");

        driver = new ChromeDriver();

        //implicit wait applied to driver instance

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        //asking driver to get the url
        driver.get("http://demo.nopcommerce.com/");

        //use to maximize the window
        driver.manage().window().maximize();

        //for registration
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();

        driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Rishi");

        driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Patel");

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("rishi1@yahoo.com");

        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("abc123");

        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("abc123");

        driver.findElement(By.xpath("//input[@id='register-button']")).click();

        //for new user Registration
        String successmsg = "Your registration completed";

        String actualregistrationSuccessmessage = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals(successmsg,actualregistrationSuccessmessage);

        driver.close();
    }

}
