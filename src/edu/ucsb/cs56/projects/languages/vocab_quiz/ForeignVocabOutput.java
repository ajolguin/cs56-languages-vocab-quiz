package edu.ucsb.cs56.projects.languages.vocab_quiz;
import java.io.*;
import java.util.*;

public class ForeignVocabOutput {
    private FileRead german;
    private FileRead spanish;
    private ForeignVocabQuiz spanishQuiz;
    private ForeignVocabQuiz germanQuiz;
    
    public void go() {
	german = new FileRead("german");
	
	spanish = new FileRead("spanish");
	
	System.out.println("Print words in spanish.txt");
	spanish.printFromFile();
	
	System.out.println("Print words in german.txt");
	german.printFromFile();
	
	//	spanishQuiz = new ForeignVocabQuiz("spanish");

	
	//germanQuiz = new ForeignVocabQuiz("german");
        
    }

    public static void main(String [] args) {
	ForeignVocabOutput output = new ForeignVocabOutput();
	output.go();
    }
}

