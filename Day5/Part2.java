package Day5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Part2 {
    public static void main (String[] args) throws IOException {
        File f = new File("Day5/input.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<Stack<String>> stacks = new ArrayList<>();

        ArrayList<String> stackLines = new ArrayList<>();
        String line;
        String result = "";

        while (!(line = br.readLine()).isEmpty()) {
            stackLines.add(line);
        }

        for (int i = 0; i < stackLines.get(stackLines.size()-1).replaceAll("\\s+", "").length(); i++) {
            stacks.add(new Stack<>());
        }

        for (int i = stackLines.size() - 2; i >= 0; i--) {
            String l = stackLines.get(i);
            while (l.contains("[") || l.contains("]")) {
                l = l.replaceAll("[\\[\\]]", "").replaceAll("\s\s", " ");
            }

            for (int j = 0; j < l.length(); j++) {
                char letter = l.charAt(j);
                if(letter < 65 || letter > 90) continue;
                stacks.get(j / 2).add(String.valueOf(letter));
            }
        }

        while ((line = br.readLine()) != null) {
            String[] directions = line.replaceAll("[(move)(from)(to)]", "").trim().replaceAll("\\s+", " ").split(" ");
            int count = Integer.parseInt(directions[0]);
            int stacknum = Integer.parseInt(directions[1]) - 1;
            int destination = Integer.parseInt(directions[2]) - 1;

            String[] t = new String[count];
            for (int i = 0; i < count; i++) {
                t[i] = stacks.get(stacknum).pop();
            }
            for (int i = t.length - 1; i >= 0; i--) {
                stacks.get(destination).push(t[i]);
            }
        }

        for (Stack<String> stack : stacks) {
            result += stack.pop();
        }

        br.close();
        System.out.println(result);
    }
}
