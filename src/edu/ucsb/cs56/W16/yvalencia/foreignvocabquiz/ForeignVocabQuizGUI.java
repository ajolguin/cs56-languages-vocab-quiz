package edu.ucsb.cs56.W16.yvalencia.foreignvocabquiz;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   A GUI for ForeignVocabQuiz.
   
   @author Yessenia Valencia
   @version cs56-languages-vocab-quiz, CS56, W16
   @see ForeignVocabQuiz
*/


public class ForeignVocabQuizGUI {
    
    private final static String newLine = "\n";
    
    // for quizGUI and from ForeignVocabQuiz
    private ForeignVocabQuiz quiz;
    private JLabel yourGuess; 
    private JLabel result; 
    private JLabel quizWord; 
    private JLabel yourScore;  
    private String language; 
    private String userGuess; 
    private String word; 
    private String counterPart;
    private int totalQuestions; 
    private int questionsCorrect; 
    private int numOfGuesses; 
    private int hintLength; 
    
    // for the GUI
    private JFrame frame; 
    private JMenuBar menuBar;
    private JTextField field; 
    private JTextArea textArea; 
    
    public ForeignVocabQuizGUI() { quiz = new ForeignVocabQuiz(this.pickLanguage()); } 
    
    public String pickLanguage()
    {
        String[] availableLanguages = {"german", "spanish", "french", "mandarin", "russian", "japanese"};
        String s = (String)JOptionPane.showInputDialog(frame, "Which language would you like to be quizzed on?:\n", "Pick your language!", JOptionPane.PLAIN_MESSAGE, null, availableLanguages,"german");
        return s;  
    }
 
    public void setUpMenuBar()
    {
        menuBar = new JMenuBar(); //JMenu
        JMenu languagesMenu = new JMenu("Language");
        JMenu helpMenu = new JMenu("Help");
        JMenu instructionsMenu = new JMenu("How to Play");
        JMenu settingsMenu = new JMenu("Settings");
        
        //JMenuItems
        JMenuItem german = new JMenuItem("German");
        JMenuItem spanish = new JMenuItem("Spanish");
        JMenuItem french = new JMenuItem("French");
        JMenuItem mandarin = new JMenuItem("Mandarin");
        JMenuItem russian = new JMenuItem("Russian");
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
        languagesMenu.add(mandarin);
        languagesMenu.addSeparator();
        languagesMenu.add(russian);
        languagesMenu.addSeparator();
        languagesMenu.add(japanese);
    }
    
    public void go()
    {
        frame = new JFrame(); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setUpMenuBar(); 
        
        //JButton
        JButton answerButton = new JButton("Answer"); 
        JButton hintButton = new JButton("Hint"); 
        JButton skipButton = new JButton("Skip"); 
        
        //JTextField
        field = new JTextField(20); 
        textArea = new JTextArea(10,35); 
        
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setPreferredSize(new Dimension(250, 80));
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        //JLabels
        quizWord = new JLabel(); 
        yourGuess = new JLabel(); 
        result = new JLabel(); 
        yourScore = new JLabel(); 
        
        
        //JPanels
        
        // We want this pane to have components top to bottom
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.PAGE_AXIS));
        northPanel.add(quizWord); 
        northPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        // We want these to be left to right
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.LINE_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
        centerPanel.add(Box.createHorizontalGlue()); 
        centerPanel.add(field); 
        centerPanel.add(Box.createRigidArea(new Dimension(10,0))); 
        centerPanel.add(answerButton); 
        
        // this one is going to contain the results of the quiz and input
        // top to bottom
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.PAGE_AXIS));
        southPanel.add(yourGuess); 
        southPanel.add(Box.createRigidArea(new Dimension(0,5)));
        southPanel.add(result); 
        southPanel.add(Box.createRigidArea(new Dimension(0,5)));
        southPanel.add(yourScore); 
        southPanel.add(Box.createRigidArea(new Dimension(0,5)));
        southPanel.add(scroller); 
        southPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        // this one is going to contain the other buttons that offer other functionalities apart from the answerButton
        JPanel eastButtonPanel = new JPanel();
        eastButtonPanel.setLayout(new BoxLayout(eastButtonPanel, BoxLayout.PAGE_AXIS));
        eastButtonPanel.add(hintButton); 
        eastButtonPanel.add(Box.createRigidArea(new Dimension(0,5)));
        eastButtonPanel.add(skipButton); 
        eastButtonPanel.add(Box.createRigidArea(new Dimension(0,5)));
        eastButtonPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5)); 
        
        // this one is going to be reserved for potential icons/images
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.PAGE_AXIS));
        westPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));  
        
        textArea.setLineWrap(true); 
        textArea.setEditable(false); 
        textArea.append("Welcome!" + newLine); 
        textArea.append("This is a vocabulary quiz for a foreign language." + newLine); 
        textArea.append("You will have three guesses per word." + newLine); 
        textArea.append("We'll begin now." + newLine);
        
        field.requestFocus(); 
        field.addActionListener(new Listener()); 
        answerButton.addActionListener(new Listener()); 
	// hintButton.addActionListener(new hintListener()); 
        //skipButton.addActionListener(new skipListener()); 
        
        Container contentPane = frame.getContentPane(); 
        contentPane.add(northPanel, BorderLayout.NORTH); 
        contentPane.add(centerPanel, BorderLayout.CENTER); 
        contentPane.add(southPanel, BorderLayout.SOUTH); 
        contentPane.add(eastButtonPanel, BorderLayout.EAST); 
        contentPane.add(westPanel, BorderLayout.WEST);
        
        frame.setSize(650,600);
        frame.setVisible(true); 
        quizGUI();
    }
    
    public void quizGUI() {
	while(quiz.listNotEmpty()) { 
	    totalQuestions++; 
	    numOfGuesses = 0; 
	    
	    word = quiz.getRandomWordFromList();
	    counterPart = quiz.getCounterPart();
	    
	    quizWord.setText("Your word is: " + word + "." + newLine);
	    
	    while(quiz.checkUserGuess(userGuess) == false){
		if(numOfGuesses == 3)
		    break;
	    }
	    if(quiz.checkUserGuess(userGuess))
		questionsCorrect++; 
	    
	    yourScore.setText("Your current score is " + questionsCorrect + "/" + totalQuestions + "!" + newLine); 
	    
	}
	
	if(!quiz.listNotEmpty()){
	    yourScore.setText("Your final score is " + questionsCorrect + "/" + totalQuestions + "!"+ newLine);
	    yourGuess.setText("Finished!" + newLine);
	    result.setText("This quiz is over!");
	    textArea.append(newLine + "Thanks for playing. =)" + newLine + "Play Again!");
	}
    }
    
    class Listener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    userGuess = field.getText();
	    yourGuess.setText(userGuess); 
	    if(numOfGuesses < 3){
		if(quiz.checkUserGuess(userGuess))
		    result.setText("Your guess is correct!");
		
		else {
		    if (numOfGuesses == 2)
			result.setText("The correct answer was: " + counterPart);
		    else
			result.setText("Your guess was wrong! Try again!");
		    
		    numOfGuesses++;
		}
	    }
	    
	    field.requestFocus();
	    field.selectAll();
	}
    }


    
    
    public static void main(String[] args) {
	ForeignVocabQuizGUI gui = new ForeignVocabQuizGUI(); 
	gui.go(); 
    }   
}	
