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
    private String language = "german";
    private ForeignVocabQuiz quiz;
    private JList list;

    private JTextField textField;
    private JLabel userResult;
    private JLabel yourAnswer;
    private String userGuess;
    private String word;
    private String counterPart;
    private int totalQuestions;
    private int questionsCorrect;
    private int numOfGuesses;

    /**Constructor
     */

    public ForeignVocabQuizGUI(){
	quiz = new ForeignVocabQuiz(language);
    }

    /**Creates GUI and starts quiz.
     *Uses inner class Listener as an action listener.
     */
    public void go()
    {
	JFrame frame = new JFrame("The Foreign Language Vocabulary Quiz");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//JMenuBar
	JMenuBar menuBar = new JMenuBar();

	//JMenu
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

	//JTextArea
	JTextArea text = new JTextArea(10,35);

	//Font
	Font bigFont = new Font("serif", Font.BOLD, 14);

	//JTextField
	textField = new JTextField(1);

	//JLabel
	yourAnswer = new JLabel();
	JLabel yourWord = new JLabel();
	userResult = new JLabel();
	JLabel yourScore = new JLabel("Your score is " + questionsCorrect + "/" + totalQuestions + "."+ newLine);

	//JButtons
	JButton answerButton = new JButton("Answer");
	JButton hintButton = new JButton("Hint!");
	JButton skipButton = new JButton("Skip!");


	//JPanels
	JPanel centerPanel = new JPanel();
	centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS)); 
  	JPanel northPanel = new JPanel();
	northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
	JPanel southPanel = new JPanel();
	southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS)); 
	JPanel eastPanel = new JPanel();
	eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
	JPanel westPanel = new JPanel();
	westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS)); 

	//JScrollPane
	JScrollPane scroller = new JScrollPane(text);
	scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

	//adding and setting
	frame.setJMenuBar(menuBar);
	menuBar.add(languagesMenu);
	menuBar.add(helpMenu);
	menuBar.add(instructionsMenu);
	menuBar.add(settingsMenu);
	languagesMenu.add(german);
	languagesMenu.add(spanish);
	languagesMenu.add(french);
	languagesMenu.add(mandarin);
	languagesMenu.add(russian);
	languagesMenu.add(japanese);


	// JTextArea appends
	text.setLineWrap(true);
	text.setEditable(false);
	text.append("Welcome!" + newLine);
	text.append("This is a vocabulary quiz for a foreign language." + newLine);
	text.append("You have three chances per word." + newLine);
	text.append("We'll begin now." + newLine);

	//Widget locations on Panels
	northPanel.add(yourWord);
	centerPanel.add(textField);
	centerPanel.add(answerButton);
	centerPanel.add(userResult);
    centerPanel.add(yourScore);
	southPanel.add(scroller);
	eastPanel.add(hintButton);
	eastPanel.add(skipButton);

	// getContentPane()
	//frame.getContentPane().add(background);
	//frame.getContentPane().add(BorderLayout.WEST, drawPanel);
	frame.getContentPane().add(BorderLayout.NORTH, northPanel);
	frame.getContentPane().add(BorderLayout.CENTER, centerPanel);
	frame.getContentPane().add(BorderLayout.SOUTH, southPanel);
	frame.getContentPane().add(BorderLayout.EAST, eastPanel);
	frame.getContentPane().add(BorderLayout.WEST, westPanel);
	frame.setSize(700,650);
	frame.setVisible(true);
	textField.requestFocus();
	textField.addActionListener(new Listener());
<<<<<<< HEAD
	answerButton.addActionListener(new Listener()); 
   
	while(quiz.listNotEmpty() == true){
=======

	while(quiz.listNotEmpty()){
>>>>>>> c32beb89a17f6f91014de4bea558d8052504e4a4
	    totalQuestions++;
	    yourScore.setText("Your score is " + questionsCorrect + "/" + totalQuestions + "."+ newLine);
	    numOfGuesses = 0;
	    word = quiz.getRandomWordFromList();
	    counterPart = quiz.getCounterPart();
	    yourWord.setText("Your word is: " + word + newLine);

	    while(quiz.checkUserGuess(userGuess) == false){
		if(numOfGuesses == 3)
		    break;
	    }
	    if(quiz.checkUserGuess(userGuess))
		questionsCorrect++;
	}


	if(!quiz.listNotEmpty()){
	    yourScore.setText("Your score is " + questionsCorrect + "/" + totalQuestions + "."+ newLine);
	    yourWord.setText("Finished!" + newLine);
	    userResult.setText("There are no other words in your file!" + newLine);
	    text.append(newLine + "Thanks for playing. =)");
	}
    }

    class Listener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    userGuess = textField.getText();
	    yourAnswer.setText("Your answer: " + userGuess + newLine);

	    if(quiz.checkUserGuess(userGuess))
		userResult.setText("Correct!" + newLine);
	    else {
		if (numOfGuesses == 2)
		    userResult.setText("The correct answer was: " + counterPart + newLine);
		else
		    userResult.setText("False" + newLine);
		numOfGuesses++;
	    }

	    textField.requestFocus();
	    textField.selectAll();
	}
    }


    /**class MyDrawPanel extends JPanel{
	public void paintComponent(Graphics g) {
	    Image image = new ImageIcon("welcome.gif").getImage();
	    g.drawImage(image, 3, 4, this);
	}
    }
    **/

    /* public void pickLanguage() {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	panel.setBackground(Color.darkGray);
	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	JButton german = new JButton("German");
	JButton spanish = new JButton("Spanish");
	JButton french = new JButton("French");
	JButton japanese = new JButton("Japanese");
	JButton russian = new JButton("Russian");

	german.addActionListener(new buttonListener());
	spanish.addActionListener(new buttonListener());
	french.addActionListener(new buttonListener());
	japanese.addActionListener(new buttonListener());
	russian.addActionListener(new buttonListener());

	panel.add(german);
	panel.add(spanish);
	panel.add(french);
	panel.add(russian);
	panel.add(japanese);
	frame.getContentPane().add(BorderLayout.CENTER, panel);
	frame.setSize(400,400);
	frame.setVisible(true);
    }

    class buttonListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    language = getLabel();
	}
    }
    */

    public static void main(String [] args){
	ForeignVocabQuizGUI gui = new ForeignVocabQuizGUI();
	gui.go();
    }

}//end class
