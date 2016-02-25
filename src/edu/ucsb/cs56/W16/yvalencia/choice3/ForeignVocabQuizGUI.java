package edu.ucsb.cs56.W16.yvalencia.choice3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   A GUI for ForeignVocabQuiz.

   @author Yessenia Valencia
   @version Mantis Ticket 0000341, CS56, W16, choice points 3
   @see ForeignVocabQuiz
*/


public class ForeignVocabQuizGUI {

    private final static String newLine = "\n";

    private JTextField field;
    private JLabel label3; //arbitrary name, should fix it
    private ForeignVocabQuiz quiz;
    private String userGuess;
    private String word;
    private String counterPart;
    private int totalQuestions = 1;
    private int questionsCorrect;
    private int numOfGuesses;

    /**Constructor
     */

    public ForeignVocabQuizGUI(){
	quiz = new ForeignVocabQuiz();
    }

    /**Creates GUI and starts quiz.
     *Uses inner class Listener as an action listener.
     */

    public void go(){
	JFrame frame = new JFrame();
	JTextArea text = new JTextArea(10,35);

	field = new JTextField(20);


	JLabel label = new JLabel("Your answer: ");
	JLabel label2 = new JLabel();
	label3 = new JLabel();
	JLabel label4 = new JLabel("Your score is " + questionsCorrect + "/" + totalQuestions + ".");

	JButton button = new JButton("answer");

	JPanel panel = new JPanel();
  	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();


	JScrollPane scroller = new JScrollPane(text);
	scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

	text.setLineWrap(true);
	text.setEditable(false);

	text.append("Welcome!" + newLine);
	text.append("This is a vocabulary quiz for a foreign language." + newLine);
	text.append("You have three chances per word." + newLine);
	text.append("We'll begin now." + newLine);

	field.requestFocus();
	field.addActionListener(new Listener());

	button.addActionListener(new Listener());



	panel2.add(label2);
	panel.add(label);
	panel.add(field);
	panel.add(button);
	panel.add(label3);
	panel3.add(label4);
	panel3.add(scroller);

	frame.getContentPane().add(BorderLayout.NORTH, panel2);
	frame.getContentPane().add(BorderLayout.CENTER, panel);
	frame.getContentPane().add(BorderLayout.SOUTH, panel3);

	frame.setSize(450,300);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



	while(quiz.listNotEmpty()){
	    label4.setText("Your score is " + questionsCorrect + "/" + totalQuestions + ".");
	    numOfGuesses = 0;
	    word = quiz.getRandomWordFromList();
	    counterPart = quiz.getCounterPart();
	    label2.setText("Your word is: " + word);
	    while(quiz.checkUserGuess(userGuess) == false){
		if(numOfGuesses == 3)
		    break;
	    }

	    if (quiz.checkUserGuess(userGuess))
		questionsCorrect++;
	    totalQuestions++;
	}

	if(!quiz.listNotEmpty()){
	    label4.setText("Your score is " + questionsCorrect + "/" + totalQuestions + ".");
	    label2.setText("Finished!");
	    label3.setText(" ");
	    text.append(newLine + "Thanks for playing. =)");
	}
    }

    class Listener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    userGuess = field.getText();
	    if(numOfGuesses < 3){
		if(quiz.checkUserGuess(userGuess))
		    label3.setText("Correct!");
		else{
		    if (numOfGuesses == 2)
			label3.setText("The correct answer was: " + counterPart);
		    else
			label3.setText("False");
		    numOfGuesses++;
		}
	    }
	    field.requestFocus();
	    field.selectAll();
	}
    }

   public static void main(String [] args){
	ForeignVocabQuizGUI gui = new ForeignVocabQuizGUI();
	gui.go();
    }

}//end class
