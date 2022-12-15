package Day7;

import java.io.*;
import java.util.*;

class Part2 {
  public static void main(String[] args) throws IOException {
    File f = new File("Day7/input.txt");
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    MDir home = new MDir(null, "/");
    MDir currentDirectory = home;
    ArrayList<MDir> allDirs = new ArrayList<>();
    allDirs.add(home);
    String line;

    while ((line = br.readLine()) != null) {
      if (line.substring(0,1).equals("$")) {
        // command
        line = line.substring(1).trim();
        String command = line.split(" ")[0];
        String pointer = line.split(" ").length > 1 ? line.split(" ")[1] : null;
        if (command.equals("cd")) {
          if (pointer.equals("..")) {
            currentDirectory = currentDirectory.back() != null ? currentDirectory.back() : currentDirectory;
            continue;
          } else if (pointer.equals("/")) {
            currentDirectory = home;
            continue;
          } else {
            // uh change dir?
            for (MDir x : currentDirectory.getContents()) {
              if (x.getName().equals(pointer)) {
                currentDirectory = x;
                break;
              }
            }
            continue;
          }
        } else if (command.equals("ls")) {
          // do nothing? just listing
          continue;
        }
      } else {
        String first = line.split(" ")[0];
        String second = line.split(" ")[1];
        if (first.equals("dir")) {
          //make dir
          MDir n = new MDir(currentDirectory, second);
          currentDirectory.append(n);
          allDirs.add(n);
        } else {
          MFile x = new MFile(currentDirectory, second, Integer.parseInt(first));
          currentDirectory.append(x);
        }
      }
    }

    br.close();
    long totalSize = home.getSize();
    long requiredSpace = 30000000 - (70000000-totalSize);
    long bestOption = totalSize;

    for (MDir x : allDirs) {
      long s = x.getSize();
      if (s > requiredSpace && s < bestOption) {
        bestOption = s;
      }
    }
    
    System.out.println(bestOption);
  }
}