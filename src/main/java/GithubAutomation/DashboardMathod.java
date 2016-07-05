package GithubAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardMathod 
{
	public static void dashboardMathod(WebDriver  driver)
	{
		Dashboard page = new Dashboard();
		PageFactory.initElements(driver, page);
		
		page.newrepositorybutton.click();
	}
}