package Day6;

import java.io.*;

public class Part2 {
  public static void main (String[] args) throws IOException {
    File f = new File("Day6/input.txt");
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    int loc = 0;
    String input = br.readLine();
    br.close();

    for (int i = 13; i < input.length(); i++) {
      boolean bre = false; 
      for (int j = i - 13; j <= i; j++) {
        for (int z = j + 1; z <= i; z++) {
          if (input.charAt(j) == input.charAt(z)) {
            bre = true;
          }
        }
      }
      if (bre) continue;
      loc = i + 1;
      break;
    }
    System.out.println(loc);
  }
}
