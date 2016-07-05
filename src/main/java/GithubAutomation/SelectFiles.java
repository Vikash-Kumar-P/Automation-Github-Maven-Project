package GithubAutomation;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;

public class SelectFiles 
{
	public static void selectFiles()
	{
		JFileChooser fileChooser = new JFileChooser();
    	fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        Component parent = null;
		int result = fileChooser.showOpenDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) 
        {
            File selectedFile = fileChooser.getSelectedFile();
            DataInput.path=selectedFile.getAbsolutePath();
        }
        DataInput.path = DataInput.path.replace(" ", "\\ ");
	}
}
