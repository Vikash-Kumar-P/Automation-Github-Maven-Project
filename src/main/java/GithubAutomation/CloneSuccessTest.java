package GithubAutomation;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CloneSuccessTest 
{
	static int x=1;
	
	public static int cloneSuccessTest(WebDriver driver)
	{
		File folder1 = new File("/home/vikashkumar/Downloads/Github");
		File[] listOfFiles1 = folder1.listFiles();
		
		File folder = new File("/home/vikashkumar/Downloads/Github/"+listOfFiles1[0].getName());
		File[] listOfFiles = folder.listFiles();
		
		driver.get("https://github.com/"+DataInput.username+"/"+DataInput.repositoryname);
        
        List<WebElement> ls =  driver.findElements(By.className("js-navigation-open"));
        
        int a = 0;
		for(int i=1; i<ls.size(); i++)
		{
			for(int j=0; j<ls.size(); j++)
			{
				a = 0;
				if(ls.get(i).getText().equals(listOfFiles[ls.size()-j-1].getName()))
					a=1;
			}
			if(a == 1)
				if(!(ls.get(i).getText().equals(listOfFiles[ls.size()-i-1].getName())))
					x=0;
		}
		return x;
	}
}
