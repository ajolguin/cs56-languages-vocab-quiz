package edu.ucsb.cs56.W16.yvalencia.foreignvocabquiz;

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
    URL file;

    /** Constructor
     */

    public FileRead(){
	this.filename = "text/vocabulary.txt";
	this.list = new ArrayList<String>();
    }

    // public FileRead(String language) {
    //	this.filename = language + ".txt";
    //	this.list = new ArrayList<String>();
    //}

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
	try {
	    File file = new File(filename);
	    BufferedReader br = new BufferedReader(new FileReader(file));
	    String line;
	    while ((line = br.readLine()) != null) {
		list.add(line);
	    }
	    br.close();
	}

	catch (IOException e) {
	    e.printStackTrace();
	}
	//	finally {
	//  try {
	//      ;
	//  }
	//  catch (IOException e) {
	//	e.printStackTrace();
	//  }
	//
    }


}//end class
