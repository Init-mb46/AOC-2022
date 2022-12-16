package Day9;

import java.util.*;
import java.io.*;
import java.lang.Math;

public class Part2 {
  public static boolean adjacent(Pair x, Pair y) { 
    if (Math.abs(x.x - y.x) <= 1 && Math.abs(x.y - y.y) <= 1) return true;
    return false;
  }
  public static void main(String[] args) throws IOException {
    File f = new File("Day9/input.txt");
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    String line;
    
    HashSet<String> positionsVisited = new HashSet<>(); 
    Pair h = new Pair(0,0);
    ArrayList<Pair> tail = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
      tail.add(new Pair(0,0));
    }
    positionsVisited.add(tail.get(0).toString());

    while ((line = br.readLine()) != null) {
      String direction = line.split(" ")[0];
      int change = Integer.parseInt(line.split(" ")[1]);

      for (int i = 1; i <= change; i++) {
        Pair c = h.getPair();
        switch (direction) {
          case "U":
            c.x++; 
            break;
          case "D":
            c.x--;
            break;
          case "R":
            c.y++;
            break;
          default:
            c.y--;
            break;
        }

        Pair prev = c;
        for (Pair p : tail) {
          if (!adjacent(prev, p)) {
            if (Math.abs(p.x - prev.x) != 0 || Math.abs(p.y - prev.y) != 0) {
              p.x += prev.x - p.x > 1 ? 1 : prev.x - p.x < 1 ? -1 : 0;
              p.y += prev.y - p.y > 1 ? 1 : prev.y - p.y < 1 ? -1 : 0;
            }            
            positionsVisited.add(p.toString());
          } else {
            break;
          }
          prev = p;
        }
        h.x = c.x;
        h.y = c.y;
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