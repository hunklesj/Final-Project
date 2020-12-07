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
  int scoreTotal = 0;
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



}

public void actionPerformed(ActionEvent ae) {
  if(ae.getActionCommand().equals(answer){
  scoreTotal = scoreTotal + points;
  label.setText(scoreTotal);
  }
   
}

}














}




