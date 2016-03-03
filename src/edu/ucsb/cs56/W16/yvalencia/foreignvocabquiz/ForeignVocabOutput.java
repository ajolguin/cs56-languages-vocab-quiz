package edu.ucsb.cs56.W16.yvalencia.foreignvocabquiz;
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
	spanish.readFromFile();
	
	System.out.println("Print words in german.txt");
	german.readFromFile();
	
	spanishQuiz = new ForeignVocabQuiz("spanish");

	
	germanQuiz = new ForeignVocabQuiz("german");
        
    }

    public static void main(String [] args) {
	ForeignVocabOutput output = new ForeignVocabOutput();
	output.go();
    }
}

