import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;


class Question {
  private String question;
  private String a;
  private String b;
  private String c;
  private String d;
  private int answer;
  private int points;

Question () {
  question = "";
  a = "";
  b = "";
  c = "";
  d = "";
 answer = 0;
 points = 0;

}
	Question (String aQuestion, String aA, String aB, String aC, String aD, int aAnswer, int aPoints) 	{
  question = aQuestion;
  a = aA;
  b = aB;
  c = aC;
  d = aD;
  answer = aAnswer;
  points = aPoints;

  }

  String getQuestion() {
     return question;
  }

 String getA (){
   return a;
 }
 String getB (){
   return b;
 }
 String getC (){
   return c;
 }
  String getD (){
   return d;
 }
 int getAnswer (){
   return answer;
 }
 int getPoints (){
   return points;
 }


  }



