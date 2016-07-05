package GithubAutomation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateRepository 
{
	@FindBy(className="btn-sm")
    WebElement newrepositorybutton;
    
    @FindBy(id="repository_name")
    WebElement repositorynametext;
    
    @FindBy(className="btn-primary")
    WebElement createrepositorybutton;
}
