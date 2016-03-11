package edu.ucsb.cs56.W16.yvalencia.foreignvocabquiz;

import java.io.*;
import java.util.*;


/** A Foreign Vocab Quiz class that supports its GUI.
 *
 *
 *
 *@author Dane Pitkin
 *@author Yessenia Valencia
 *@version cs56-language-vocab-quiz, CS56, W16
 *@see ForeignVocabQuizGUI
 */

public class ForeignVocabQuiz{
    
    private ArrayList<ForeignVocabWord> vocabList;
    private FileRead file;
    private boolean displayForeignWord;
    private ForeignVocabWord testWord;
    private String quizWord; 
    private String counterPart;
    private int numOfTerms; 

    /**Constructor:
     *Sets up a ForeignVocabQuiz application by
     *intializing private data members.
     *Also reads file that was given by user.
     */
    
    public ForeignVocabQuiz(String language) {
	vocabList = new ArrayList<ForeignVocabWord>();
	file = new FileRead(language);
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
	numOfTerms = 0;
	
	for(int i = 0; i<size; i++){
	    if(i%2 == 0)//We assume the foreign word comes first
		foreignWord = list.get(i);
	    if(i%2 == 1){
		englishWord = list.get(i);
		word = new ForeignVocabWord(englishWord, foreignWord);
		vocabList.add(word);
		numOfTerms++; 
	    }
	    
	}
    }

 
    public boolean listNotEmpty(){
	return !vocabList.isEmpty(); 
    }
    
    public int getSize() {
	return vocabList.size();  
    }
    
    public String getCounterPart(){
	return counterPart;
    }
    
    public String getQuizWord() {
	return quizWord;
    }
    
    /**Get a random index from <code>vocabList</code>.
     *@param aList the list of ForeignVocabWords.
     *@return randNum a random number within the
     *boundaries of the array indices.
     */
    
    public int randomIndex(ArrayList<ForeignVocabWord> aList) {
	int sizeOfCurrentList = aList.size();
	int randNum = (int)(Math.random() * sizeOfCurrentList);
	return randNum;
    }
    
    /**Finds and sets a random word from the vocabList.
     *@return String - the word to be tested on
     */
    
    public String getRandomWordFromList() {
	displayForeignWord = false;
	
	int index = randomIndex(vocabList);
	testWord = vocabList.get(index);
	vocabList.remove(index);
	
	//randomize displaying english/foreign word
	int randomNum = (int)(Math.random()*2);
	
	if (randomNum == 0)//randomNum is either 0 or 1
	    displayForeignWord = true;//just to make code understandable
	
	
	if(displayForeignWord){// equals true
	    quizWord = testWord.getForeignWord();
	    counterPart = testWord.getEnglishWord();
	    return testWord.getForeignWord();//Display foreign word
	}
	
	else {
	    //if displayForeignWord is false, display english word
	    quizWord = testWord.getEnglishWord(); 
	    counterPart = testWord.getForeignWord();
	    return testWord.getEnglishWord();
	}
	
    }
    
    
    /** Checks users guess with the correct vocab word.
     *@return boolean - specifies if answer was correct or not
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
