import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Game implements ActionListener {
  JLabel finish;
  JLabel scoreLabel;
  JLabel currentQuestion;
  JLabel response;
  int scoreTotal = 0;
  static ArrayList<Question> questions;
  static String filename;
  static FileReader myFile;
  int i = 0;
  JLabel page;
  int questionNumber = 1;
  JFrame frame;
  JButton buttonA;
  JButton buttonB;
  JButton buttonC;
  JButton buttonD;
  JButton nextQuestion;
  JButton start;
  
  Game() { 
  frame = new JFrame("Group XX's Trivia Game");
  frame.setLayout(new FlowLayout());
  frame.setSize(500,500);

  buttonB = new JButton ("");
  buttonC = new JButton ("");
  buttonD = new JButton ("");
  start = new JButton ("Start");
  buttonA = new JButton ("");
  nextQuestion = new JButton ("");
  start.addActionListener(this);
  nextQuestion.setText("Next Question");
  nextQuestion.addActionListener(this);
  
  page = new JLabel("");
  frame.add(page);
  frame.add(start);

  currentQuestion = new JLabel ("");
  frame.add(currentQuestion);
  finish = new JLabel("");
  response = new JLabel ("");
  scoreLabel = new JLabel ("");
  frame.add(scoreLabel);
  frame.add(response);
  frame.setVisible (true);
}

public void actionPerformed(ActionEvent ae) {
questions = new ArrayList<Question>();
String question;
String a;
String b;
String c;
String d;
String answer = "";
int points = 0;
try{
myFile = new FileReader("data.txt");
BufferedReader reader = new BufferedReader(myFile);
while (reader.ready()) {
question = reader.readLine();
a = reader.readLine();
b = reader.readLine();
c = reader.readLine();
d = reader.readLine();
answer = reader.readLine();
points = Integer.parseInt(reader.readLine());
Question theQuestion = new Question(question, a, b, c, d, answer, points);
questions.add(theQuestion);
}
reader.close();
} catch (IOException exception) {
System.out.println("An error occurred: " + exception);
}

  if (ae.getActionCommand().equals("Start")) {
    currentQuestion.setText(questions.get(0).getQuestion());
    buttonA.setText(questions.get(0).getA());
    buttonB.setText(questions.get(0).getB());
    buttonC.setText(questions.get(0).getC());
    buttonD.setText(questions.get(0).getD());

    buttonA.addActionListener (this);
    buttonB.addActionListener(this);
    buttonC.addActionListener(this);
    buttonD.addActionListener(this);
  

    frame.add(buttonA);
    frame.add(buttonB);
    frame.add(buttonC);
    frame.add(buttonD);
    start.setVisible(false);
    }

    else if(ae.getActionCommand().equals(questions.get(i).getAnswer())){
      buttonA.setVisible(false);
      buttonB.setVisible(false);
      buttonC.setVisible(false);
      buttonD.setVisible(false);
      currentQuestion.setText("");
      frame.add(nextQuestion);
      nextQuestion.setVisible(true);
      response.setVisible(true);
      response.setText("Correct!");
      scoreTotal = scoreTotal + (questions.get(i).getPoints());
      String s = Integer.toString(scoreTotal);
      scoreLabel.setText(s);
    }


  else if (ae.getActionCommand().equals("Next Question")) {
            if (questionNumber != questions.size()){
            i++;
            questionNumber++;
            String p = Integer.toString(questionNumber);
            page.setText(p);
            buttonA.setVisible(true);
            buttonB.setVisible(true);
            buttonC.setVisible(true);
            buttonD.setVisible(true);
            nextQuestion.setVisible(false);
            response.setVisible(false);
            currentQuestion.setText(questions.get(i).getQuestion());
            buttonA.setText(questions.get(i).getA());
            buttonB.setText(questions.get(i).getB());
            buttonC.setText(questions.get(i).getC());
            buttonD.setText(questions.get(i).getD());
    }
            else {
              
                finish.setText("finished");
                scoreLabel.setVisible(true);
                frame.add(finish);
                buttonA.setVisible(false);
                buttonB.setVisible(false);
                buttonC.setVisible(false);
                buttonD.setVisible(false);
                nextQuestion.setVisible(false);
                response.setVisible(false);
                page.setVisible(false);

                }
            }
else {
      buttonA.setVisible(false);
      buttonB.setVisible(false);
      buttonC.setVisible(false);
      buttonD.setVisible(false);
      frame.add(nextQuestion);
      currentQuestion.setText("");
      nextQuestion.setVisible(true);
      response.setText("Incorrect!");
      response.setVisible(true);
      String s = Integer.toString(scoreTotal);
      scoreLabel.setText(s);
}

}
}












