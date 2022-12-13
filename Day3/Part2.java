package Day3;

import java.util.*;
import java.io.*;

class Part2 {
  public static void main(String[] args) throws IOException{
    File f = new File("Day3/input.txt");
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    String line;
    int total = 0;

    while ((line = br.readLine()) != null) {
      String[] lines = new String[3];
      lines[0] = line;
      lines[1] = br.readLine();
      lines[2] = br.readLine();
      boolean bre = false;

      for (char s1 : lines[0].toCharArray()) {
        if (bre) break;
        for (char s2 : lines[1].toCharArray()) {
          if (bre) break;
          for (char s3 : lines[2].toCharArray()) {
            if (s1 == s2 && s2 == s3) {
              //found character
              total += s1 >= 97 ? s1 - 96 : s1 - 38;
              bre = true;
              break;
            }
          }
        }
      }
    }

    br.close();
    System.out.println(total);

  }
}