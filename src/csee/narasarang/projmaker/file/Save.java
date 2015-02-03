package csee.narasarang.projmaker.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import csee.narasarang.projmaker.file.Attachment;

public class Save  {
	
    private String path = Attachment.openpath();
	public File openfile = new File (path);

	public Save ()  {
	  
	//이동전의 폴더
	 String infile = path;
	  //이동후의 폴더
	 String outFolder = "C:\\";
	 String fileName = openfile.getName();
	   
	
    fileCopy(infile, outFolder+"\\"+fileName);
		  
	 }
	   
	public static void fileCopy(String inFileName, String outFileName) {
	  try {
	   FileInputStream fis = new FileInputStream(inFileName);
	   FileOutputStream fos = new FileOutputStream(outFileName);
	   
	   int data = 0;
	   while((data=fis.read())!=-1) {
	    fos.write(data);
	   }
	   fis.close();
	   fos.close();
	   
	  } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	}	  
}
