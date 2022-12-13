package Day3;

import java.util.*;
import java.io.*;

class Part1 {
  public static void main(String[] args) throws IOException {
    File f = new File("Day3/input.txt");
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    String line;
    int total = 0;
    
    while ((line = br.readLine()) != null) {
      String l = line.substring(0, line.length() / 2);
      String r = line.substring(line.length() / 2);
      boolean bre = false;
      for (char c : l.toCharArray()) {
        if (bre) break;
        for (char z : r.toCharArray()) {
          if (c == z) {
            int x = c >= 97 ? c - 96 : c - 38;
            total += x;
            bre = true;
            break;
          }
        }
      }
    }

    br.close();
    System.out.println(total);
    
  }
}