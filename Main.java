import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.awt.*;
import java.awt.event.*;

class Main {
 public static void main(String args[]) {
  SwingUtilities.invokeLater(new Runnable() {
    public void run() {
       new Game();
    }
  });
 }
}

 



