package Day6;

import java.io.*;

public class Part1 {
  public static void main (String[] args) throws IOException {
    File f = new File("Day6/input.txt");
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    int loc = 0;
    String input = br.readLine();
    br.close();

    for (int i = 3; i < input.length(); i++) {
      char a = input.charAt(i-3);
      char b = input.charAt(i-2);
      char c = input.charAt(i-1);
      char d = input.charAt(i);
      
      if (a != b && a != c && a != d && b != c && b != d && c != d) {
        loc = i + 1;
        break;
      }
    }

    System.out.println(loc);
  }
  
}
