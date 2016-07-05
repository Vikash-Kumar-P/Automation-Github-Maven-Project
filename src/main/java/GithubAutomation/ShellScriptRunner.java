package GithubAutomation;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ShellScriptRunner 
{
	public static void shellScriptRunner() throws Exception
	{
		File file=new File("/home/vikashkumar/Downloads/shell1.sh");
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);        
   
		pw.println("#!/bin/bash");
		pw.println("echo \"hello !!\"");  
		pw.println("cd ~");
		pw.println("cd Downloads");
		pw.println("mkdir Github");
		pw.println("cd Github");
		pw.println("mkdir "+DataInput.repositoryname);
		pw.println("cd "+DataInput.repositoryname);
		pw.println("cp -a "+DataInput.path+"/. /home/vikashkumar/Downloads/Github/"+DataInput.repositoryname+"/");
		pw.println("touch ReadMe.txt");
		pw.println("git init");
		pw.println("git add .");
		pw.println("git commit -m\""+DataInput.comment+"\"");
		pw.println("git remote add origin https://"+DataInput.username+":"+DataInput.password+"@github.com/"+DataInput.username+"/"+DataInput.repositoryname+".git");
		pw.println("git push origin master");
		pw.println("echo \"completed\"");
 
		pw.close();
    
		file.setExecutable(true);
    
		File wd=new File("/home/vikashkumar/Downloads");
		ProcessBuilder processBuilder = new ProcessBuilder("./shell1.sh");
		processBuilder.directory(wd);
		processBuilder.start();      
		Thread.sleep(5000);
	}
}
