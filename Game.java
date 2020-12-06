import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public Class Game implements ActionListener {
  JLabel label;
  JLabel label2;
  Jlabel scoreLabel;
  int scoreTotal;
Game (){
  JFrame frame = new JFrame("Group XX's Trivia Game");
  frame.setLayout(new FlowLayout());
  frame.setSize(220,90);

  JButton a = newJButton (1);
  JButton b = newJButton (2);
  JButton c = newJButton (3);
  JButton d = newJButton (4);
  JButton nextQuestion = newJButton ("Next Question");

  a.addActionListener(this);
  b.addActionListener(this);
  c.addActionListener(this);
  d.addActionListener(this);
  nextQuestion.addActionListener(this);

  label = new Jlabel ("Welcome!");
  frame.add(label);
  label2 = new JLabel(question + "Worth " + points " points");
  frame.add(label2);
  scoreLabel = new Jlabel (scoreTotal);
  frame.add(scoreLabel);
}


  static ArrayList<Question> questions;
static String filename;
static FileReader myFile;

questions = new ArrayList<Question>();

String question;
String a;
String b;
String c;
String d;
int answer;
int points;

try {
myFile = new FileReader("data.txt");
BufferedReader reader = new BufferedReader(myFile);

while (reader.ready()) {
question = reader.readLine();
a = reader.readLine();
b = reader.readLine();
c = reader.readLine();
d = reader.readLine();
answer = Integer.parseInt(reader.readLine());
points = Integer.parseInt(reader.readLine());
Question theQuestion = new Question(question, a, b, c, d, answer, points);
questions.add(theQuestion);
}
reader.close();
}

catch (IOException exception) {
System.out.println("An error occurred: " + exception);
}
for(int i=0; i<questions.size(); i++) {
System.out.printf("%-25s %-20s %-20s %n", questions.get(i).getQuestion(), questions.get(i).getA(), questions.get(i).getAnswer());
}


public void actionPerformed(ActionEvent ae) {
  if(ae.getActionCommand().equals()
}

}














}




