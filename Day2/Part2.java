package Day2;

import java.util.*;
import java.io.*;

class Part2 {
  public static void main (String[] args) throws IOException {

    //Input
    File f = new File("input.txt");
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    String line;
    int score = 0;
    while ((line = br.readLine()) != null) {
      String o = line.substring(0,1);
      String m = line.substring(2);
      String p = "";

      switch(m) {
        case("X"):
          p = o.equals("A") ? "Z" : o.equals("B") ? "X" : "Y";
          break;
        case("Y"):
          p = o.equals("A") ? "X" : o.equals("B") ? "Y" : "Z";
          score += 3;
          break;
        case("Z"):
          p = o.equals("A") ? "Y" : o.equals("B") ? "Z" : "X";
          score += 6;
          break;
      }
      
      score += p.equals("X") ? 1 : p.equals("Y") ? 2 : 3;
    }
    br.close();
    
    System.out.println(score);
  }
}