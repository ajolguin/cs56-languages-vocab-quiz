package edu.ucsb.cs56.projects.languages.vocab_quiz;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.net.*;

/**A File Reader.
 *@author Dane Pitkin
 *@author Yessenia Valencia
 *@version cs56-languages-vocab-quiz, CS56, W16
 *
 *Reads from a .txt file line by line and
 *creates an <code>ArrayList<String></code> list where
 *each index contains one line of the file.
 *
 *The method <code>readFromFile</code> taken from:
 *@link http://www.roseindia.net/java/beginners/java-read-file-line-by-line.shtml
 */


public class FileRead {
    
    private String filename;
    private ArrayList<String> list;
    private URL fileURL; 
    private File fileFile;
    
    /** Constructor
     */
    
    //    public FileRead(){
    //	this.list = new ArrayList<String>();
    //	setFileName(); 
    //}
    
    public FileRead(String language) {
	this.filename =  "" + language + ".txt";
	this.list = new ArrayList<String>();
	this.fileURL = getClass().getResource(filename); 
	this.fileFile = new File(fileURL.getFile()); 
    }
    
    /** Get the list of words.
     *@return list A list of type ArrayList<String>.
     */
    
    public ArrayList<String> getList(){
	return this.list;
    }
    
    /** Get the size of the list.
     *@return list.size() Of type int.
     */
    
    public int getSizeOfArray(){
	return list.size();
    }
    
    
    /** Gets name of .txt file from the user.
     *At the moment, it's just hardcoded in.
     *Not good programming syle.
     */
    
    public String getFileName(){
	return filename; 
    }

    public URL getFileURL() {
	return fileURL;
    }

    public File getFiletoRead() {
	return fileFile;
    }

    public void setFileName(String newName) {
	filename = "" + newName + ".txt"; ;
	fileURL = getClass().getResource(filename);
	fileFile = new File(fileURL.getFile()); 
    }

    
    /** Reads data from file and stores it in <code>list</code>.
     *
     *Each line in the .txt file is one index of <code>list</code>.
     *If you want the list to be on word per index, you must only
     *have one word per line.
     *
     *Code borrowed and modified from:
     *@link http://www.rgagnon.com/javadetails/java-0077.html
     *@link http://www.mkyong.com/java/how-to-read-file-from-java-bufferedinputstream-example/
     *@exception Exception catch any exception reading from file
     */

    public void readFromFile(){
	try {
	    BufferedReader br = new BufferedReader(new FileReader(fileFile)); 
	    String line = "";
	    while ((line = br.readLine()) != null) 
		list.add(line);
	    br.close(); 
	}
	catch (IOException e) {
	    e.printStackTrace();
	    System.out.println("FileRead readFromFile() not working"); 
	}
	//finally {
	//  try {
	//	br.close();
	//  }
	//  catch (IOException e) {
	//e.printStackTrace();
	//  }
    }
    public void printFromFile(){
	try {
	    BufferedReader br = new BufferedReader(new FileReader(fileFile));
	    String line = "";
	    while ((line = br.readLine()) != null) {
		System.out.println(line);
	    }
	    br.close();
	}
	catch (IOException e) {
	    e.printStackTrace();
	    System.out.println("FileRead readFromFile() not working");
	}
	
    }
}
    
