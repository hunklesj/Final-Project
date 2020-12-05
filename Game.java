import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public Class Game implements ActionListener {
  JLabel label;

Game (){
  JFrame frame = new JFrame("Group XX's Trivia Game");
  frame.setLayout(new FlowLayout());
  frame.setSize(220,90);
  label = new Jlabel ("Welcome!");
  frame.add(label);
  frame.setVisible(true);
}


}
