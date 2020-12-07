import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.awt.*;
import java.awt.event.*;

class Readfile {
static ArrayList<Question> questions;
static String filename;
static FileReader myFile;

questions = new ArrayList<Question>();

String question;
String a;
String b;
String c;
String d;
String answer;
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
answer = reader.readLine();
points = Integer.parseInt(reader.readLine());
Question theQuestion = new Question(question, a, b, c, d, answer, points);
questions.add(theQuestion);
}
reader.close();
} catch (IOException exception) {
System.out.println("An error occurred: " + exception);
}
}