package GithubAutomation;


import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest 
{
	static WebDriver driver;
	static String updatedline, commitmessage;
	
	@BeforeTest
	public void beforTest()
	{
		//Taking input username password repositoryname etc.
 		DataInput.dataInput();		
	}
	
	@Test
	public void testOne()
	{
		//Login into Github
		driver = LoginMathod.loginMathod();
		//Test for login done
		Assert.assertEquals("GitHub",driver.getTitle());
	}
	
	@Test(dependsOnMethods={"testOne"})
	public void testTwo()
	{
		//Clicking create new repository on dashboard
		DashboardMathod.dashboardMathod(driver);
		//Check for new repository click
		Assert.assertEquals("Create a New Repository",driver.getTitle());
	}
	
	@Test(dependsOnMethods={"testTwo"})
	public void testThree()
	{
		//Creating WebDriver drivernew repository by giving repository name 
		CreateRepositoryMathod.createRepositoryMathod(driver);
		//Test for made repository
		Assert.assertEquals("Vikash-Kumar-P/"+DataInput.repositoryname,driver.getTitle());
	}
	
	@Test(dependsOnMethods={"testThree"})
	public void testFour()
	{
		//Coping file of project to upload to new created repository
		SelectFiles.selectFiles();
		//Test for non-emptiness of selected directory
		String path1 = DataInput.path.replace("\\","");
		Assert.assertNotEquals(0,new File(path1).listFiles().length);
	}
	
	@Test(dependsOnMethods={"testFour"})
	public void testFive() throws Exception
	{
		//Running shell script to push the project files to github
		ShellScriptRunner.shellScriptRunner();
		//Test for presence of pushed project
		Assert.assertEquals(0,PushedFileCheck.pushedFileCheck(driver));
	}
	
	@Test(dependsOnMethods={"testFive"})
	public static void testSix()
	{
		//Test for commitment of comment
		commitmessage = CommitComment.commitComment(driver);
		Assert.assertEquals(DataInput.comment,commitmessage);
	}
	
	@Test(dependsOnMethods={"testSix"})
	public static void testSeven() throws Exception
	{
		//Making change in readme file
		ChangeReadmeMathod.changeReadmeMathod(driver);
		//Cloning the project to local directory
		updatedline = CloningRepository.cloningRepository();
		//Test for cloning success
		Assert.assertEquals(0,CloneSuccessTest.cloneSuccessTest(driver));
	}
	
	@Test(dependsOnMethods={"testSeven"})
	public static void testEight()
	{
		
		//Test for change in readme file
		Assert.assertEquals(updatedline,DataInput.updatetext);
	}
}