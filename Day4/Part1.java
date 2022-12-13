package Day4;

import java.io.*;

public class Part1 {
    public static void main (String[] args) throws IOException {
        File f = new File("Day4/input.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int total = 0;

        while ((line = br.readLine()) != null) {
            String elf1R = line.split(",")[0];
            String elf2R = line.split(",")[1];

            int elf1a = Integer.parseInt(elf1R.split("-")[0]);
            int elf1b = Integer.parseInt(elf1R.split("-")[1]);
            int elf2a = Integer.parseInt(elf2R.split("-")[0]);
            int elf2b = Integer.parseInt(elf2R.split("-")[1]);

            if (elf1a >= elf2a && elf1b <= elf2b || elf1a <= elf2a && elf1b >= elf2b) {
                total++;
            }
        }
        br.close();
        System.out.println(total);
    }
}
