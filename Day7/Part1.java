package Day7;

import java.io.*;
import java.util.*;

class Part1 {
  public static void main(String[] args) throws IOException {
    File f = new File("Day7/input.txt");
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    MDir home = new MDir(null, "/");
    MDir currentDirectory = home;
    ArrayList<MDir> allDirs = new ArrayList<>();
    allDirs.add(home);
    long total = 0;
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

    for (MDir x : allDirs) {
      long size = x.getSize();
      if (size <= 100000) {
        total += size;
      }
    }
    System.out.println(total);
  }
}

class MDir {
  private ArrayList<MDir> contents;
  private MDir parent;
  private String name;
  public long size;
  
  public MDir(MDir parent, String name) {
    this.parent = parent;
    this.name = name;
    this.size = 0;

    contents = new ArrayList<>();
  }
  
  public MDir back() {
    return parent;
  } 

  public void append(MDir x) {
    contents.add(x);
  }

  public String getName() {
    return name;
  }

  public ArrayList<MDir> getContents() {
    return contents;
  }

  public long getSize() {
    if (contents.size() == 0) return 0;
    long total = 0;
    for (MDir x : contents) { 
      if (x instanceof MFile) {
        x = (MFile) x;
      }
      total += x.getSize();
    }
    return total;
  }
}

class MFile extends MDir{
  public MFile(MDir parent, String name, long size) {
    super(parent, name);
    this.size = size;
  }
  
  @Override
  public long getSize() {
    return size;
  }
}