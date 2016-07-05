package GithubAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ChangeReadmeMathod 
{

	public static void changeReadmeMathod(WebDriver driver) throws Exception
	{
		ChangeReadme page = new ChangeReadme();
    	PageFactory.initElements(driver, page);
    	
    	driver.get("https://github.com/"+DataInput.username+"/"+DataInput.repositoryname+"/edit/master/ReadMe.txt");
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='new_blob']/div[3]/div[2]/div/textarea")).sendKeys(DataInput.updatetext);
        page.updatebtn.click();
	}
}
