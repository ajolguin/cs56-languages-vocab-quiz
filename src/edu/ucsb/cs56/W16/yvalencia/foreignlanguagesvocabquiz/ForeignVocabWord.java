package edu.ucsb.cs56.W16.yvalencia.foreignlanguagesvocabquiz;


/**A vocabulary word that holds both the english and foreign versions of the word.
 *
 * @author Yessenia Valencia ,cs56-languages-vocab-quiz, CS56, W16, foreignlanguagesvicabquiz.
 */

public class ForeignVocabWord{

    private String englishWord;
    private String foreignWord;


    /** Constructor
     *@param foreign  initializes foreign word
     *@param english  initializes English word
     */

    public ForeignVocabWord(String english, String foreign){
	this.englishWord = english;
	this.foreignWord = foreign;
    }

    /**Constructor
     */

    public ForeignVocabWord(){
	this.englishWord = "";
	this.foreignWord = "";
    }

    /** Get English word.
     *@return <code>englishWord</code> of type String.
     */

    public String getEnglishWord(){
	return this.englishWord;
    }


    /** Get foreign word.
     *@return <code>foreignWord</code> of type String.
     */

    public String getForeignWord(){
	return this.foreignWord;
    }

    /**Set English word.
     *@param word of type String.
     */

    public void setEnglishWord(String word){
	englishWord = word;
    }

    /** Set foreign word.
     *@param word of type String.
     */

    public void setForeignWord(String word){
	foreignWord = word;
    }

    /** Compares a word with <code>foreignWord</code> ignoring case.
     *@param word word to compare.
     *@return <code>boolean</code> - are the two words equal?
     */

    public boolean equalsForeignWord(String word){
	return this.foreignWord.equalsIgnoreCase(word);
    }


    /** Compares a word with <code>englishWord</code> ignoring case.
     *@param word word to compare.
     *@return <code>boolean</code> - are the two words equal?
     */
    public boolean equalsEnglishWord(String word){
	return this.englishWord.equalsIgnoreCase(word);
    }
}//end class
