package edu.ucsb.cs56.projects.languages.vocab_quiz;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   A GUI for ForeignVocabQuiz.
   
   @author Adrian Olguin
   @author Cristobal Caballero
   @version cs56-languages-vocab-quiz, CS56, F16
   @see ForeignVocabQuiz
*/


public class ForeignVocabQuizGUI {
    
    private final static String newLine = "\n";
    
    //private String languageChoice; 
    private ForeignVocabQuiz quiz;
    
    private JLabel yourGuess;
    // private JLabel numGuesses; 
    private JLabel yourResult; 
    private JLabel quizWord;
    private JLabel yourCorrectScore;
    private JLabel yourIncorrectScore;
    private JLabel yourGuessCount;
    
    private String userGuess;
    private String randomWord; 
    private String counterPart;
    private String myLanguage;

    private String newRandomWord;
    private String newCounterPart;
    
    private int numOfGuesses = 0;
    private int totalQuestions = 0; 
    private int questionsCorrect = 0;
    private int questionsIncorrect = 0;
    //CHANGES CHANGES CHANGES
    private int guessesAllowed = 3;
    private JButton hardButton;
    private JButton hintButton;
    private JButton skipButton;

    
    // for the GUI
    
    private JFrame frame; 
    private JMenuBar menuBar;
    private JTextField textField;
  
    
    
    /**Constructor:
     * Creates an ForeignVocabQuiz object by
     * initializing private member variables
     * 
     */
    
    public ForeignVocabQuizGUI() {
	quiz = new ForeignVocabQuiz(this.pickLanguage());
    }
    
    
    public String pickLanguage() {
	String[] availableLanguages = {"german", "spanish", "french", "italian","japanese"};
	String s = (String) JOptionPane.showInputDialog(frame,"Welcome!" + newLine + "This is a vocabulary quiz for a foreign language." + newLine + "First you will pick the language you want to be quizzed on." + newLine + "You will then be given a word and you have to try to guess the proper translate in either English or your choice of language" + newLine+  "You will have three guesses per word." + newLine + "Which language would you like to be quizzed on?:\n", "Pick your language!", JOptionPane.PLAIN_MESSAGE, null, availableLanguages,"german");
	return s;  
    }
    
    public void setUpMenuBar() {
	menuBar = new JMenuBar(); //JMenu
	JMenu languagesMenu = new JMenu("Language");
	JMenu helpMenu = new JMenu("Help");
	JMenu instructionsMenu = new JMenu("How to Play");
	JMenu settingsMenu = new JMenu("Settings");
	
	//JMenuItems
	JMenuItem german = new JMenuItem("German");
	JMenuItem spanish = new JMenuItem("Spanish");
	JMenuItem french = new JMenuItem("French");
	JMenuItem italian = new JMenuItem("Italian");
	JMenuItem japanese = new JMenuItem("Japanese");
	
	frame.setJMenuBar(menuBar);
	menuBar.add(settingsMenu);
	menuBar.add(languagesMenu);
	menuBar.add(instructionsMenu);	
	menuBar.add(helpMenu);
	languagesMenu.add(german);
	languagesMenu.addSeparator(); 
	languagesMenu.add(spanish);
	languagesMenu.addSeparator();
	languagesMenu.add(french);
	languagesMenu.addSeparator();
	languagesMenu.add(italian);
	languagesMenu.addSeparator();
	languagesMenu.add(japanese);
    }
    
    public void go(){
	
	frame = new JFrame();
	setUpMenuBar(); 
	
	textField = new JTextField(20);
	
	JTextArea textArea = new JTextArea(10,35);
	
	JScrollPane scroller = new JScrollPane(textArea);
	scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	//CHANGES CHANGES CHANGES CHANGES CHANGES
	JButton easyButton = new JButton("Easy");
	JButton mediumButton = new JButton("Medium");
	hardButton = new JButton("Hard");
	
	JButton answerButton = new JButton("Answer!");
	hintButton = new JButton("Hint!");
	skipButton = new JButton("Skip!");
	
	yourGuess = new JLabel();
	yourResult = new JLabel();
	quizWord = new JLabel("The word is: "); 
	JLabel quizLanguage = new JLabel("Current language being tested on: ");
	yourCorrectScore = new JLabel("Questions correct: " + questionsCorrect);
	yourIncorrectScore = new JLabel("Questions incorrect: " + questionsIncorrect);
	//CHANGES CHANGES CHANGES CHANGES CHANGES
	yourGuessCount = new JLabel("Number of Guesses: " + numOfGuesses + "/" + guessesAllowed);
	
	JPanel northPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	JPanel southPanel = new JPanel();
	JPanel eastPanel = new JPanel(); 
	
	northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
	centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
	southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
	eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS)); 

	northPanel.add(quizLanguage);
	northPanel.add(quizWord);
	northPanel.add(textField);
	northPanel.add(answerButton);
	
	centerPanel.add(yourGuess);
	centerPanel.add(yourResult);
	centerPanel.add(yourCorrectScore);
	centerPanel.add(yourIncorrectScore);
	centerPanel.add(yourGuessCount);
	
	eastPanel.add(hintButton);
	eastPanel.add(skipButton);
	//CHANGES CHANGES CHANGES CHANGES CHANGES
	eastPanel.add(easyButton);
	eastPanel.add(mediumButton);
	eastPanel.add(hardButton);
	
	southPanel.add(scroller);
	
	
        textField.requestFocus();

	//CHANGES CHANGES CHANGES CHANGES CHANGES
	easyButton.addActionListener(new easyListener());
	mediumButton.addActionListener(new mediumListener());
	hardButton.addActionListener(new hardListener());
	
	textField.addActionListener(new Listener());
	answerButton.addActionListener(new Listener());
	hintButton.addActionListener(new hintListener());
	skipButton.addActionListener(new skipListener());
	
        Container contentPane = frame.getContentPane();
	contentPane.add(northPanel, BorderLayout.NORTH);
	contentPane.add(centerPanel, BorderLayout.CENTER);
	contentPane.add(southPanel, BorderLayout.SOUTH);
	contentPane.add(eastPanel, BorderLayout.EAST); 
	
	frame.setSize(600,550);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	while(quiz.listNotEmpty()) {    
	    
	    numOfGuesses = 0;
	    
	    randomWord = quiz.getRandomWordFromList();
	    counterPart = quiz.getCounterPart();
	    myLanguage = quiz.getLanguage();

	    quizLanguage.setText("Your language is: " + myLanguage);
	    quizWord.setText("Your word is: " + randomWord);
	    
	    
	    yourCorrectScore.setText("Your correct score is " + questionsCorrect + "/" + totalQuestions + ".");
	    yourIncorrectScore.setText("Your incorrect score is " +  questionsIncorrect + "/" + totalQuestions + ".");
	    
	    while(quiz.checkUserGuess(userGuess) == false){
		if(numOfGuesses == 3) {
		    questionsIncorrect++;
		    break;
		}
	    }

	    /*if(skipButton.isSelected()){
		randomWord = quiz.getRandomWordFromList();
		counterPart = quiz.getCounterPart();
		quizWord.setText("Your word is: " + randomWord);
		numOfGuesses = 0;
		}*/
	    
	    if(quiz.checkUserGuess(userGuess) == true){ 
		questionsCorrect++;
	    }
	    
	    numOfGuesses = 0;
	    //randomWord = quiz.getRandomWordFromList();
	    //counterPart = quiz.getCounterPart(); 
	    totalQuestions++;
	}
	
	if(!quiz.listNotEmpty()){
	    yourCorrectScore.setText(" ");
	    yourIncorrectScore.setText(" "); 
	    yourGuess.setText(" ");
	    yourResult.setText(" ");
	    
	    textArea.append("You are finished!" + newLine);
	    textArea.append("Your final score: " + newLine);
	    textArea.append("Correct: " + questionsCorrect + "/" + totalQuestions + newLine);
	    textArea.append("Incorrect: " + questionsIncorrect + "/" + totalQuestions + newLine);
	    textArea.append("Thank you for playing!");
	}
    }
    
    class Listener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    userGuess = textField.getText(); 
	    yourGuess.setText("You guessed: " + userGuess + ".");
	    numOfGuesses++;
	    
	    if(quiz.checkUserGuess(userGuess)){
		newRandomWord = quiz.getRandomWordFromList();
		newCounterPart = quiz.getCounterPart();
		quizWord.setText("Your word is: " + newRandomWord);
		textField.setText("");
		yourResult.setText("Correct!");
		questionsCorrect++;
		totalQuestions++;
		numOfGuesses = 0;
		yourGuessCount.setText("Number of Guesses: " + numOfGuesses + "/" + guessesAllowed);
	    }

	    else {
		newCounterPart = quiz.getCounterPart();
		if(numOfGuesses == guessesAllowed){
		    textField.setText("");
		    yourResult.setText("The correct answer was: " + newCounterPart);
		    newRandomWord = quiz.getRandomWordFromList();
		    newCounterPart = quiz.getCounterPart();

		    quizWord.setText("Your word is: " + newRandomWord);
		    questionsIncorrect++;
		    totalQuestions++;
		    numOfGuesses = 0;
		    yourGuessCount.setText("Number of Guesses: " + numOfGuesses + "/" + guessesAllowed);
		}
		else
		    yourResult.setText("Incorrect! Try again");
		yourGuessCount.setText("Number of Guesses: " + numOfGuesses + "/" + guessesAllowed);
		
	    }
  

	    yourCorrectScore.setText("Your correct score is " + questionsCorrect + "/" + totalQuestions + ".");
	    yourIncorrectScore.setText("Your incorrect score is " +  questionsIncorrect + "/" + totalQuestions + ".");
	    textField.requestFocus();
	    textField.selectAll();
	}
    }
    
    public void getWord() {
	randomWord = quiz.getRandomWordFromList();
	counterPart = quiz.getCounterPart();
	totalQuestions++; 
	numOfGuesses = 0;
    }

    //CHANGES CHANGES CHANGES CHANGES CHANGES
    class easyListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    guessesAllowed = 5;
	    getWord();
	    totalQuestions = 0;
	    quizWord.setText("Your word is: " + randomWord);
	    textField.setText("");
	    questionsCorrect = 0;
	    questionsIncorrect = 0;
	    yourGuessCount.setText("Number of Guesses: " + numOfGuesses + "/" + guessesAllowed);
	    yourCorrectScore.setText("Your correct score is " + questionsCorrect + "/" + totalQuestions + ".");
	    yourIncorrectScore.setText("Your incorrect score is " +  questionsIncorrect + "/" + totalQuestions + ".");
	    hintButton.setVisible(true);
	    skipButton.setVisible(true);
	}
    }

    class mediumListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    guessesAllowed = 3;
	    getWord();
	    totalQuestions = 0;
	    quizWord.setText("Your word is: " + randomWord);
	    textField.setText("");
	    questionsCorrect = 0;
	    questionsIncorrect = 0;
	    yourGuessCount.setText("Number of Guesses: " + numOfGuesses + "/" + guessesAllowed);
	    yourCorrectScore.setText("Your correct score is " + questionsCorrect + "/" + totalQuestions + ".");
	    yourIncorrectScore.setText("Your incorrect score is " +  questionsIncorrect + "/" + totalQuestions + ".");
	    hintButton.setVisible(true);
	    skipButton.setVisible(true);
	}
    }

    class hardListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    guessesAllowed = 2;
	    getWord();
	    totalQuestions = 0;
	    quizWord.setText("Your word is: " + randomWord);
	    textField.setText("");
	    questionsCorrect = 0;
	    questionsIncorrect = 0;
	    yourGuessCount.setText("Number of Guesses: " + numOfGuesses + "/" + guessesAllowed);
	    yourCorrectScore.setText("Your correct score is " + questionsCorrect + "/" + totalQuestions + ".");
	    yourIncorrectScore.setText("Your incorrect score is " +  questionsIncorrect + "/" + totalQuestions + ".");
	    hintButton.setVisible(false);
	    skipButton.setVisible(false);
	}
    }
    
    class skipListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    getWord();
	    quizWord.setText("Your word is: " + randomWord);
	    
	}
    }
    
    class hintListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    newCounterPart = quiz.getCounterPart();
	    JOptionPane.showMessageDialog(frame, "Your word is " + newCounterPart.length() + " letters long!" , "Here is your hint!" , JOptionPane.INFORMATION_MESSAGE);
	}
    }

    
    /*class instructionListener implemenets ActionListener {
      public void actionPerformed(ActionEvent event) {
      JOptionPane.showMessageDialog(frame, "You have been given a vocabulary word respective to the language you chose or it's English translation. Your task is to type in the correct translation and select 'Answer!' to verify if your submission was correct. You have the ability to use the 'skip' or 'hint' buttons to help you if the word is too difficult! After three incorrect attempts, you will receive a new word and 0 points for that previous term.", JOptionPane.INFORMATION_MESSAGE);
      } */
    
    public static void main(String[] args) {
	ForeignVocabQuizGUI gui = new ForeignVocabQuizGUI(); 
	gui.go(); 
    }
}
