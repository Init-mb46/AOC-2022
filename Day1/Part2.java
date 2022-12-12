package Day1;

import java.io.*;
import java.util.*;

class Part2 {  
  public static void main(String[] args) throws IOException{
    ArrayList<Integer> input = get_input();
    Collections.sort(input);

    int n = input.size() - 1;
    System.out.println(input.get(n) + input.get(n - 1) + input.get(n - 2));
  }

  public static ArrayList<Integer> get_input() throws IOException {
    File f = new File("input.txt");
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    String line;
    int t = 0;
    ArrayList<Integer> lines = new ArrayList<Integer>();
    while ((line = br.readLine()) != null) {
      if (line.isEmpty()) {
        lines.add(t);
        t = 0;
        continue;
      }
      t += Integer.parseInt(line);
    }
    return lines;
  }
}