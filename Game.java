import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game implements ActionListener {
  JLabel label2;
  JLabel scoreLabel;
  JLabel currentQuestion;
  JLabel response;
  int scoreTotal = 0;
  static ArrayList<Question> questions;
  static String filename;
  static FileReader myFile;
  int i = 0;

  Game() {
  JFrame frame = new JFrame("Group XX's Trivia Game");
  frame.setLayout(new FlowLayout());
  frame.setSize(500,500);

  currentQuestion = new JLabel (questions.get(i).getQuestion());
  frame.add(currentQuestion);
  JButton buttonA = new JButton (questions.get(i).getA());
  JButton buttonB = new JButton (questions.get(i).getB());
  JButton buttonC = new JButton (questions.get(i).getC());
  JButton buttonD = new JButton (questions.get(i).getD());
  JButton nextQuestion = new JButton ("Next Question");

  buttonA.addActionListener(this);
  buttonB.addActionListener(this);
  buttonC.addActionListener(this);
  buttonD.addActionListener(this);
  nextQuestion.addActionListener(this);
  frame.add(buttonA); 
  frame.add(buttonB);
  frame.add(buttonC);
  frame.add(buttonD);

  frame.add(nextQuestion);

  label2 = new JLabel("Worth " + (questions.get(i).getPoints()));
  response = new JLabel ("");
  frame.add(label2);
  scoreLabel = new JLabel ("");
  frame.add(scoreLabel);
  frame.setVisible(true);
  frame.add(response);
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

if(ae.getActionCommand().equals("Next Question")) {
  i++;
}
else if (ae.getActionCommand().equals(questions.get(i).getAnswer())) {
  scoreTotal = scoreTotal + (questions.get(i).getPoints());
  String s = Integer.toString(scoreTotal);
  response.setText("Correct!");
  scoreLabel.setText("Current Score:" + scoreTotal);
  }

  else {
    response.setText(questions.get(i).getAnswer());
    i++;
  }
}

}












