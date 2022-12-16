package Day9;

import java.util.*;
import java.io.*;
import java.lang.Math;

public class Part1 {
  public static boolean adjacent(Pair x, Pair y) { 
    if (Math.abs(x.x - y.x) <= 1 && Math.abs(x.y - y.y) <= 1) return true;
    return false;
  }
  public static void main(String[] args) throws IOException {
    File f = new File("Day9/input.txt");
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    String line;
    
    ArrayList<String> positionsVisited = new ArrayList<>(); 
    Pair h = new Pair(0,0);
    Pair t = new Pair(0,0);
    positionsVisited.add(t.toString());

    System.out.println(positionsVisited);
    while ((line = br.readLine()) != null) {
      String direction = line.split(" ")[0];
      int change = Integer.parseInt(line.split(" ")[1]);

      for (int i = 1; i <= change; i++) {
        Pair cH = h.getPair();
        switch (direction) {
          case "U":
            cH.x++; 
            break;
          case "D":
            cH.x--;
            break;
          case "R":
            cH.y++;
            break;
          default:
            cH.y--;
            break;
        }
        if (!adjacent(cH,t)) {
          t.x = h.x;
          t.y = h.y;
          if (!positionsVisited.contains(t.toString())) positionsVisited.add(t.toString());
        }
        h.x = cH.x;
        h.y = cH.y;
      }
    }
    
    System.out.println(positionsVisited.size());
  }
}

class Pair {
  int x;
  int y;
  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
  public Pair getPair() {
    return new Pair(x, y);
  }
  public String toString() {
    return "(" + x + "," + y + ")";
  }
}