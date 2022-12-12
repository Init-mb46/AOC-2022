package Day2;

import java.util.*;
import java.io.*;

class Part1 {
  public static void main (String[] args) throws IOException {

    //Input
    File f = new File("Day2/input.txt");
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    String line;
    int score = 0;
    while ((line = br.readLine()) != null) {
      String o = line.substring(0,1);
      String p = line.substring(2);
    
      score += p.equals("X") ? 1 : p.equals("Y") ? 2 : 3;

      if (p.equals("X") && o.equals("C") || p.equals("Y") && o.equals("A") || p.equals("Z") && o.equals("B")) {
        score += 6;
      } else if (p.equals("X") && o.equals("A") || p.equals("Y") && o.equals("B") || p.equals("Z") && o.equals("C")) {
        score += 3;
      }
    }
    br.close();
    
    System.out.println(score);
  }
}