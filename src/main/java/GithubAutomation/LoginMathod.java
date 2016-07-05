package GithubAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginMathod 
{
	public static WebDriver loginMathod()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://github.com/login");
    
		Login page = new Login();
		PageFactory.initElements(driver, page);
    
		page.usernametext.sendKeys(DataInput.username);
		page.passwordtext.sendKeys(DataInput.password);
		page.signinbutton.click();   
		
		return driver;
	}
}
