import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

class Main{
  static ArrayList<Question> questions;
  static String filename;
  static FileReader myFile;


public static void main(String[] args) {

Question question1 = new Question("Test","A","B","C","D",5,10);   

questions = new ArrayList<Question>();
questions.add(question1);

String question;
String a;
String b;
String c;
String d;
int answer;
int points;

FileWriter toWriteFile;
try {
toWriteFile = new FileWriter("data.txt");
BufferedWriter output = new BufferedWriter(toWriteFile); 
for(int i=0; i<questions.size(); i++) {
output.write(questions.get(i).getQuestion()); 
output.newLine();
output.write(questions.get(i).getA()); 
output.newLine();
output.write(questions.get(i).getB()); 
output.newLine();
output.write(questions.get(i).getC()); 
output.newLine();
output.write(questions.get(i).getD()); 
output.newLine();
output.write(Integer.toString(questions.get(i).getAnswer())); 
output.newLine();
output.write(Integer.toString(questions.get(i).getPoints())); 
output.newLine();
output.flush();
}
output.close();
  }
catch (IOException exception) {
System.out.println("An error occurred: " + exception);
}
  }
}