package GithubAutomation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login 
{
	@FindBy(id="login_field")
    WebElement usernametext;
    
    @FindBy(id="password")
    WebElement passwordtext;
    
    @FindBy(className="btn-primary")
    WebElement signinbutton;
}
