package edu.ucsb.cs56.projects.languages.vocab_quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
   A test class to test the GUI functionality.

   @author Adrian Olguin
   @author Cristobal Caballero
   @version cs56-languages-vocab-quiz, CS56, F16
   @see ForeignVocabQuiz, ForeignVocabQuizGUI 
*/

public class ForeignVocabQuizGUITest {
    /** Test the ForeignVocabQuiz constructor
	
     */

    @Test public void testConstructor(){
	ForeignVocabQuiz test1 = new ForeignVocabQuiz("german");
	ForeignVocabQuiz test2 = new ForeignVocabQuiz("spanish");
	ForeignVocabQuiz test3 = new ForeignVocabQuiz("french");
	ForeignVocabQuiz test4 = new ForeignVocabQuiz("italian");
	ForeignVocabQuiz test5 = new ForeignVocabQuiz("japanese");
	
	assertEquals(true, test1.getLanguage().equals("german"));
	assertEquals(true, test2.getLanguage().equals("spanish"));
	assertEquals(true, test3.getLanguage().equals("french"));
	assertEquals(true, test4.getLanguage().equals("italian"));
	assertEquals(true, test5.getLanguage().equals("japanese"));
    }

    // @Test public void testGUI(){
    //	ForeignVocabQuizGUI guiTest = new ForeignVocabQuizGUI();
    
}
