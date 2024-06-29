import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    protected WebDriver driver;
    private By userName=By.id("user-name");
    private WebElement userNameElement;
    private By password=By.id("password");
    private WebElement passwordElement;
    private By loginButton=By.id("login-button");
    private WebElement loginButtonElement;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void EnterPassword(String passwordt){
        passwordElement=driver.findElement(password);
        Clear(passwordElement);
        sendText(passwordElement,passwordt);
    }
    public void Clear(WebElement element){
        element.clear();
    }
    public void EnterUserName(String userNamet){
        userNameElement=driver.findElement(userName);
        Clear(userNameElement);
        sendText(userNameElement,userNamet);
    }
    public void Logging(){
        loginButtonElement=driver.findElement(loginButton);
        Clicking(loginButtonElement);

    }


    public static void Clicking(WebElement element){
        element.click();
    }
    public static void sendText(WebElement element,String text){
        element.sendKeys(text);
    }
}
