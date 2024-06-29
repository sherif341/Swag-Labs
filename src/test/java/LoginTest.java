import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    protected WebDriver driver;
    private LoginPage loginPage;
    @BeforeTest
    public void Setup(){
        loginPage=new LoginPage(driver);
        loginPage.driver=new EdgeDriver();
    }
    @BeforeMethod
    public void GetUrl(){
        loginPage.driver.get("https://www.saucedemo.com/");
    }
    @Test(priority = 2)
    public void InValidLogin(){
        loginPage.EnterUserName("asld.com");
        loginPage.EnterPassword("15");
        loginPage.Logging();
        String actual=loginPage.driver.findElement(By.cssSelector(".error-message-container.error")).getText();
        Assert.assertEquals(actual,"Epic sadface: Username and password do not match any user in this service");

    }
    @Test(priority = 1)
    public void ValidLogin(){
        loginPage.EnterUserName("standard_user");
        loginPage.EnterPassword("secret_sauce");
        loginPage.Logging();
        String actual=loginPage.driver.findElement(By.className("app_logo")).getText();
        Assert.assertEquals(actual,"Swag Labs");
    }
    @Test(priority = 3)
    public void LoginWithEmptyUserName(){
        loginPage.EnterUserName("");
        loginPage.EnterPassword("secret_sauce");
        loginPage.Logging();
        String actual=loginPage.driver.findElement(By.cssSelector(".error-message-container.error")).getText();
        Assert.assertEquals(actual,"Epic sadface: Username is required");
    }
    @Test(priority = 4)
    public void LoginWithEmptyPassword(){
        loginPage.EnterUserName("standard_user");
        loginPage.EnterPassword("");
        loginPage.Logging();
        String actual=loginPage.driver.findElement(By.cssSelector(".error-message-container.error")).getText();
        Assert.assertEquals(actual,"Epic sadface: Password is required");
    }
    @AfterTest
    public void Close(){
        loginPage.driver.quit();
    }
}
