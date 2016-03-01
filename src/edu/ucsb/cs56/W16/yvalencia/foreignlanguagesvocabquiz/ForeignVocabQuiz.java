package edu.ucsb.cs56.W16.yvalencia.foreignlanguagesvocabquiz;

import java.io.*;
import java.util.*;


/** A Foreign Vocab Quiz class that supports its GUI. 
 *
 *
 *
 *@author Dane Pitkin
 *@author Yessenia Valencia
 *@version Mantis Ticket 0000341, CS56, W16, choice points 3
 *@see ForeignVocabQuizGUI
 */

public class ForeignVocabQuiz{

    private ArrayList<ForeignVocabWord> vocabList;
    private FileRead file;
    private boolean displayForeignWord;
    private ForeignVocabWord testWord;
    private String counterPart;
    
    
    /**Constructor:
     *Sets up a ForeignVocabQuiz application by 
     *intializing private data members.
     *Also reads file that was given by user.
     */

    public ForeignVocabQuiz(){//sets up application
	vocabList = new ArrayList<ForeignVocabWord>();
	file = new FileRead();
	file.getFileName();
	file.readFromFile();
	setUpVocabList();
    }
    
    /** Sort the list of words from file from 
     *<code>ArrayList<String></code> into a list of 
     *Foreign Vocab Words of type <code>ArrayList<ForeignVocabWord></code>.
     * Assumes foreign word comes before english word.
     */
    private void setUpVocabList(){
	String foreignWord = "";
	String englishWord = "";
	ForeignVocabWord word;
	ArrayList<String> list = file.getList();
	int size = file.getSizeOfArray();
	
	for(int i = 0; i<size; i++){
	    if(i%2 == 0)//We assume the foreign word comes first
		foreignWord = list.get(i);
	    if(i%2 == 1){
		englishWord = list.get(i);
		word = new ForeignVocabWord(englishWord, foreignWord);
		vocabList.add(word);
	    }
	    
	}
    }
    
    public boolean listNotEmpty(){
	return !(vocabList.isEmpty());
    }
    
    public String getCounterPart(){
	return counterPart;
    }
    
    /**Get a random index from <code>vocabList</code>.
     *@param aList the list of ForeignVocabWords.
     *@return randNum a random number within the 
     *boundaries of the array indices.
     */

    public int randomIndex(ArrayList<ForeignVocabWord> aList){
	int size = aList.size();
	int randNum = (int)(Math.random()*size);
	return randNum;
    }
    
    /**Finds and gets a random word from the vocab list.
       @return String - the word to be tested on
    */
    
    public String getRandomWordFromList(){
     int randomNum = 0;
	int index = 0;
	testWord = null;
	displayForeignWord = false;
	
	index = randomIndex(vocabList);
	testWord = vocabList.get(index);
	
	//randomize displaying english/foreign word
	randomNum = (int)(Math.random()*2);	    
	if (randomNum == 0)//randomNum is either 0 or 1
	    displayForeignWord = true;//just to make code understandable
	
	vocabList.remove(index);//remove word from vocabList
	
	if (displayForeignWord){ // equals true
	    counterPart = testWord.getEnglishWord();
	    return testWord.getForeignWord();//Display foreign word
	}
	else{ //if displayForeignWord is false, display english word
	    counterPart = testWord.getForeignWord();
	    return testWord.getEnglishWord();
	}
 }
    
    /** Checks users guess with the correct vocab word.
     *@return boolean - speficies if answer was correct or not
     */
    
    public boolean checkUserGuess(String guess){
	if (displayForeignWord){
	    if (testWord.equalsEnglishWord(guess))
		return true;
	}
	else{
	    if (testWord.equalsForeignWord(guess))
		return true;
	}
	return false;
    }

}//end class
	
	
		    
