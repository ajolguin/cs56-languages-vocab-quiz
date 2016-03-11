package edu.ucsb.cs56.W16.yvalencia.foreignvocabquiz;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   A GUI for ForeignVocabQuiz.

   @author Dane Pitkin
   @author Yessenia Valencia
   @version cs56-languages-vocab-quiz, CS56, W16
   @see ForeignVocabQuiz
*/


public class ForeignVocabQuizGUI {
    
    private final static String newLine = "\n";
    
    // for quizGUI and from ForeignVocabQuiz
    private String languageChoice; 
    private ForeignVocabQuiz quiz;

    private JLabel yourGuess;
    private JLabel numGuesses; 
    private JLabel yourResult; 
    private JLabel quizWord; 
    private JLabel yourScore;
    private JLabel yourCorrectScore;
    private JLabel yourIncorrectScore;

    private String userGuess;
    private String randomWord; 
    private String counterPart;
    private int numOfGuesses; 
    private int questionsCorrect;
    private int questionsIncorrect; 
    private int totalQuestions; 
    private boolean correct; 
    
    
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
	languageChoice = this.pickLanguage(); 
	quiz = new ForeignVocabQuiz(languageChoice);
	numOfGuesses = 0;
	questionsCorrect = 0;
	totalQuestions = 1;
	correct = false;
	
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
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setUpMenuBar(); 

	textField = new JTextField(20); 
	
	JPanel northPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	JPanel southPanel = new JPanel();
	
	northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
	centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
	southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
	
	Container contentPane = frame.getContentPane();
	contentPane.add(northPanel, BorderLayout.NORTH);
	contentPane.add(centerPanel, BorderLayout.CENTER);
	contentPane.add(southPanel, BorderLayout.SOUTH);
	
	
	JButton answerButton = new JButton("Answer!");
	JButton hintButton = new JButton("Hint!");
	JButton skipButton = new JButton("Skip!"); 
	
	textField.requestFocus();
	textField.addActionListener(new checkGuessListener()); 
	answerButton.addActionListener(new checkGuessListener());
	hintButton.addActionListener(new hintListener());
	skipButton.addActionListener(new skipButtonListener());
	
	
	yourGuess = new JLabel(); 
	numGuesses = new JLabel(); 
	yourResult = new JLabel(); 
	quizWord = new JLabel();
	yourScore = new JLabel("Your current score is: "); 
	yourCorrectScore = new JLabel("Correct: " + questionsCorrect + "/" + totalQuestions); 
	yourIncorrectScore = new JLabel("Incorrect: " + questionsIncorrect + "/" + totalQuestions);
	
	northPanel.add(quizWord);
	northPanel.add(textField);
	northPanel.add(answerButton);
	
	centerPanel.add(yourGuess);
	centerPanel.add(yourResult);
	centerPanel.add(yourScore);
	centerPanel.add(yourCorrectScore);
	centerPanel.add(yourIncorrectScore); 
	
	southPanel.add(hintButton);
	southPanel.add(skipButton);
	
	frame.setSize(600,550);
	frame.setVisible(true);
	
	yourScore.setText("Your current score is: "); 
	yourCorrectScore.setText("Correct: " + questionsCorrect + "/" + totalQuestions); 
	yourIncorrectScore.setText("Incorrect: " + questionsIncorrect + "/" + totalQuestions);
	
	while(quiz.listNotEmpty()) {
	    getWord(); 
	    while(!correct) {
		if(numOfGuesses == 3) {
		    questionsIncorrect++; 
		    yourResult.setText("Right answer is: " + counterPart);
		    break;
		}
	    }
	    
	    if(correct) 
		questionsCorrect++;
	    
	    
	    yourScore.setText("Your current score is: ");
	    yourCorrectScore.setText("Correct: " + questionsCorrect + "/" + totalQuestions);
	    yourIncorrectScore.setText("Incorrect: " + questionsIncorrect + "/" + totalQuestions);
	}
	
	
	if(!quiz.listNotEmpty()) {
	    yourScore.setText("Your final score is: "); 
	    yourCorrectScore.setText("Correct: " + questionsCorrect + "/" + totalQuestions);
	    yourIncorrectScore.setText("Incorrect: " + questionsIncorrect + "/" + totalQuestions);
	    yourGuess.setText("Finished!");
	    yourResult.setText("This quiz is over! Thanks for playing");
	}
    }
    
    class checkGuessListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    userGuess = textField.getText();
	    yourGuess.setText("You guessed: " + userGuess);
	    
	    if(quiz.checkUserGuess(userGuess)) {
		yourResult.setText("You are correct!");
		correct = true; 
	    }
	    
	    else {
		yourResult.setText("Incorrect! Try again!"); 
		numOfGuesses++;
		correct = false; 
	    }
	    
	    
	    textField.requestFocus();
	    textField.selectAll(); 
	}
    }
    
    public void getWord() {
	randomWord = quiz.getRandomWordFromList();
	counterPart = quiz.getCounterPart();
	quizWord.setText("The word is: " + randomWord); 
	totalQuestions++; 
	numOfGuesses = 0;
	correct = false; 
    }
    
    class skipButtonListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    getWord();
	}
    }
    
    class hintListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    JOptionPane.showMessageDialog(frame, "Your word is " + counterPart.length() + " letters long!" , "Here is your hint!" , JOptionPane.INFORMATION_MESSAGE);
	}
    }
    
    public static void main(String[] args) {
	ForeignVocabQuizGUI gui = new ForeignVocabQuizGUI(); 
	gui.go(); 
    }
}
