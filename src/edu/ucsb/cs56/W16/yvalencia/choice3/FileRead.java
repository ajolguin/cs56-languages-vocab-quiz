package edu.ucsb.cs56.W16.yvalencia.choice3;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.net.*;

/**A File Reader.
 *@author Dane Pitkin
 *@author Yessenia Valencia
 *@version Mantis Ticket 0000341, CS56, W16, choice points 3.
 *
 *Reads from a .txt file line by line and
 *creates an <code>ArrayList<String></code> list where 
 *each index contains one line of the file. 
 *
 *The method <code>readFromFile</code> taken from:
 *@link http://www.roseindia.net/java/beginners/java-read-file-line-by-line.shtml
 */


public class FileRead 
{
    private String filename;
    private ArrayList<String> list;
    URL file;



    /** Constructor
     */

    public FileRead(){
	this.filename = "text/vocabulary.txt";
	this.list = new ArrayList<String>();
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

    public void getFileName(){

	file = getClass().getResource(filename);

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
	File file = new File(filename);
	FileInputStream inStream = null;
	BufferedInputStream buffer = null;
	DataInputStream data = null;
	String line = "";
	
	try {
	    inStream = new FileInputStream(file);	    
	    buffer = new BufferedInputStream(inStream);
	    data = new DataInputStream(buffer);
	    while (data.available() != 0) {
		line = data.readLine();
		list.add(line);
	    }	    
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		inStream.close();
		buffer.close();
		data.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }
}//end class
