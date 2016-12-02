package edu.ucsb.cs56.projects.languages.vocab_quiz;
import java.io.*;
import java.util.*;

public class ForeignVocabOutput {
    private FileRead german;
    private FileRead spanish;
    private FileRead french;
    private FileRead italian;
    private FileRead japanese;
    private ForeignVocabQuiz spanishQuiz;
    private ForeignVocabQuiz germanQuiz;

    /** prints words from each languages file containing all the words
     */
    
    public void go() {
	german = new FileRead("german");
	spanish = new FileRead("spanish");
	french = new FileRead("french");
	italian = new FileRead("italian");
	japanese = new FileRead("japanese");
	
	System.out.println("Print words in spanish.txt");
	spanish.printFromFile();
	System.out.println();
	
	System.out.println("Print words in german.txt");
	german.printFromFile();
	System.out.println();
	
	//spanishQuiz = new ForeignVocabQuiz("spanish");
	//germanQuiz = new ForeignVocabQuiz("german");

	System.out.println("Print words in french.txt");
	french.printFromFile();
	System.out.println();

	System.out.println("Print words in italian.txt");
	italian.printFromFile();
	System.out.println();

	System.out.println("Print words in japanese.txt");
	japanese.printFromFile();
	System.out.println();
	
        
    }

    /** main function that calls "go" function
     */
    public static void main(String [] args) {
	ForeignVocabOutput output = new ForeignVocabOutput();
	output.go();
    }
}

