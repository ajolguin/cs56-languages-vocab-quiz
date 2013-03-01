//package edu.ucsb.cs56.S11.dpitkin.choice3.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *The test class ForeignVocabWordTest, to test theForeign VocabWord class
 *
 *
 *@author Dane Pitkin
 *@version Choice Points 2 for CS56, S11
 *@see ForeignVocabWord
 */

public class ForeignVocabWordTest{
    
    /**Test the constructor
     */
  
    @Test public void testConstructor(){
	ForeignVocabWord word = new ForeignVocabWord("Hello", "Hallo");
	assertEquals("Hallo", word.getForeignWord());
	assertEquals("Hello", word.getEnglishWord());
    }
    
    /**Test the .equals() methods
     */

    @Test public void testEqualsWord(){
	ForeignVocabWord word = new ForeignVocabWord("Good day", "Guten Tag");
	assertEquals(true, word.equalsForeignWord(word.getForeignWord()));
	assertEquals(true, word.equalsEnglishWord(word.getEnglishWord()));
    }

}//end test