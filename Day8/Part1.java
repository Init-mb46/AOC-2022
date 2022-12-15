package Day8;

import java.io.*;

public class Part1 {
    public static boolean check_visible(int[][] heightmap, int x, int y) {
        //check top
        boolean blocked = true;
        for (int i = x - 1; i >= 0; i--) {
            if (heightmap[i][y] >= heightmap[x][y]) {
                break;
            }
            if (i == 0) return true;
        }
        for (int i = x + 1; i < heightmap.length; i++) {
            if (heightmap[i][y] >= heightmap[x][y]) {
                break;
            }
            if (i >= heightmap.length - 1) return true;
        }
        for (int i = y - 1; i >= 0; i--) {
            if (heightmap[x][i] >= heightmap[x][y]) {
                break;
            }
            if (i == 0) return true;
        }
        for (int i = y + 1; i < heightmap.length; i++) {
            if (heightmap[x][i] >= heightmap[x][y]) {
                break;
            }
            if (i >= heightmap.length - 1) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        File f = new File("Day8/input.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        int[][] heightmap = new int[line.length()][line.length()];
        int size = heightmap.length;

        int x = 0;
        while (line != null) {
            String s = line;
            line = br.readLine();

            for (int y = 0; y < size; y++) {
                heightmap[x][y] = Integer.parseInt(s.substring(y, y + 1));
            }
            x++;
        }

        br.close();

        int total = 4 * size - 4;

        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j < size - 1; j++) {
                if (check_visible(heightmap,i,j)) total++;
            }
        }

        System.out.println(total);
    }
}
