package GithubAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommitComment 
{
	public static String commitComment(WebDriver driver)
	{
		driver.get("https://github.com/"+DataInput.username+"/"+DataInput.repositoryname);
        List<WebElement> ls = driver.findElements(By.className("message"));
		WebElement msg = ls.get(2);
		String s=msg.getText();
		return s;
	}
}
