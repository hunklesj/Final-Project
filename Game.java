import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
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
  frame.getContentPane().setBackground(Color.RED);

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
  currentQuestion = new JLabel ("Welcome!");
  currentQuestion.setFont(new Font("SanSerif",Font.BOLD,15));
  frame.add(currentQuestion);
  frame.add(start);
  finish = new JLabel("");
  response = new JLabel ("");
  scoreLabel = new JLabel ("");

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
    buttonA.setVisible(true);
    buttonB.setVisible(true);
    buttonC.setVisible(true);
    buttonD.setVisible(true);

    frame.add(buttonA);
    frame.add(buttonB);
    frame.add(buttonC);
    frame.add(buttonD);
    start.setVisible(false);
    frame.add(response);
    page.setText("Question 1");
    page.setVisible(true);
 
  
    }

    else if(ae.getActionCommand().equals(questions.get(i).getAnswer())){
      buttonA.setVisible(false);
      buttonB.setVisible(false);
      buttonC.setVisible(false);
      buttonD.setVisible(false);
      currentQuestion.setText("");
      frame.add(nextQuestion);
      response.setVisible(true);
      nextQuestion.setVisible(true);
      page.setVisible(false);
      response.setText("Correct!");
      frame.add(scoreLabel);
      scoreLabel.setVisible(true);
      scoreTotal = scoreTotal + (questions.get(i).getPoints());
      String s = Integer.toString(scoreTotal);
      scoreLabel.setText("You have " + s + " Points.");
    }



  else if (ae.getActionCommand().equals("Next Question")) {
            if (questionNumber != questions.size()){
            i++;
            questionNumber++;
            String p = Integer.toString(questionNumber);
            page.setText("Question " + p + ".");
            buttonA.setVisible(true);
            buttonB.setVisible(true);
            buttonC.setVisible(true);
            buttonD.setVisible(true);
            nextQuestion.setVisible(false);
            response.setVisible(false);
             page.setVisible(true);
            currentQuestion.setText(questions.get(i).getQuestion());
            buttonA.setText(questions.get(i).getA());
            buttonB.setText(questions.get(i).getB());
            buttonC.setText(questions.get(i).getC());
            buttonD.setText(questions.get(i).getD());
    }
            else {
              
                scoreLabel.setVisible(true);
                buttonA.setVisible(false);
                buttonB.setVisible(false);
                buttonC.setVisible(false);
                buttonD.setVisible(false);
                nextQuestion.setVisible(false);
                response.setVisible(false);
                page.setVisible(false);

                String s = Integer.toString(scoreTotal);
                int allScore = 0;
                    for (int x = 0; x < questions.size(); x++) {
                    allScore = allScore + (questions.get(x).getPoints());
                    }
                  double grade;
                  grade = ((scoreTotal *100) / allScore);
                  scoreLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
                  scoreLabel.setForeground(Color.WHITE);
                  scoreLabel.setText("You Got a " + s + " out of " + allScore);
                  FileWriter toWriteFile; 
                  if (grade < 50){
                    response.setText("Better Luck Next Time!");
                  }
                      else if (grade < 70){
                        response.setText("Good Try!");
                      }
                      else if (grade < 85){
                        response.setText("Good Job!");
                      }
                      else if (grade < 90){
                        response.setText ("So Close!");
                      }
                      else{
                        response.setText("Perfect!");
                      }
                    response.setVisible(true);
                  try
                  { 
                  toWriteFile = new FileWriter("scores.txt"); 
                  BufferedWriter output = new BufferedWriter(toWriteFile); 
                  output.write(Integer.toString(scoreTotal)); 
                  output.newLine();
                  output.close(); 
                  } 
                  catch (IOException excpt) 
                  { 
                  excpt.printStackTrace(); 
                  } 
                  


                }
            }
else {
      buttonA.setVisible(false);
      buttonB.setVisible(false);
      buttonC.setVisible(false);
      buttonD.setVisible(false);
      scoreLabel.setVisible(true);
      page.setVisible(false);
      frame.add(nextQuestion);
      currentQuestion.setText("");
      nextQuestion.setVisible(true);
      response.setText("Incorrect!");
      response.setVisible(true);
      String s = Integer.toString(scoreTotal);
      
   
}

}
}












