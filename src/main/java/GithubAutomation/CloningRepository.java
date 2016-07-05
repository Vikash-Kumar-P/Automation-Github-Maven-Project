package GithubAutomation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CloningRepository 
{
	public static String cloningRepository() throws Exception
	{
		File file=new File("/home/vikashkumar/Downloads/shell2.sh");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);        
       
        pw.println("#!/bin/bash");
        pw.println("echo \"hello !!\"");  
        pw.println("cd ~");
        pw.println("cd Downloads");
        pw.println("cd Github");
        pw.println("rm -rf "+DataInput.repositoryname);
        pw.println("git clone https://github.com/"+DataInput.username+"/"+DataInput.repositoryname+".git");
        pw.println("echo \"completed\"");
        
        pw.close();
        
        file.setExecutable(true);
        
        File wd=new File("/home/vikashkumar/Downloads");
        ProcessBuilder processBuilder = new ProcessBuilder("./shell2.sh");
	    processBuilder.directory(wd);
	    
	    processBuilder.start();      
	    Thread.sleep(5000);
	    
	    BufferedReader br = new BufferedReader(new FileReader("/home/vikashkumar/Downloads/Github/"+DataInput.repositoryname+"/ReadMe.txt"));
	    String updatedline = br.readLine();
	    
	    br.close();
	    return updatedline;
	}
}
