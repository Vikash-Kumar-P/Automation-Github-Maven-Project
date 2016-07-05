package GithubAutomation;

import java.util.Scanner;

public class DataInput 
{
	static String username, password, repositoryname, comment, updatetext, path;
	
	public static void dataInput()
	{
		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter your Username:");
	    username = sc.nextLine();
	    System.out.println("Enter Your Password:");
	    password = sc.nextLine();
	    System.out.println("Enter Your new Repository Name:");
	    repositoryname = sc.nextLine();
	    System.out.println("Enter Comment for your Repository:");
	    comment = sc.nextLine();
	    System.out.println("Enter Updation Text for your ReadMe.txt file:");
	    updatetext = sc.nextLine();
	    sc.close();
	}
}
