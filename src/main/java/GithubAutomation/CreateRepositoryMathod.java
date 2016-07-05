package GithubAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateRepositoryMathod 
{
	public static void createRepositoryMathod(WebDriver  driver)
	{
		CreateRepository page = new CreateRepository();
		PageFactory.initElements(driver, page);
		
		page.repositorynametext.sendKeys(DataInput.repositoryname);
        page.createrepositorybutton.click();
	}
}