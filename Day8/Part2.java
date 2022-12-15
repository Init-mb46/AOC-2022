package Day8;

import java.io.*;

public class Part2 {
    public static int get_Scenic_Score(int[][] heightmap, int x, int y) {
        int x1 = 1;
        for (int i = x - 1; i >= 0; i--) {
            if (heightmap[i][y] >= heightmap[x][y] || i == 0) {
                break;
            }
            x1++;
        }
        int x2 = 1;
        for (int i = x + 1; i < heightmap.length ; i++) {
            if (heightmap[i][y] >= heightmap[x][y] || i == heightmap.length - 1) {
                break;
            }
            x2++;
        }
        int x3 = 1;
        for (int i = y - 1; i >= 0; i--) {
            if (heightmap[x][i] >= heightmap[x][y] || i == 0) {
                break;
            }
            x3++;
        }
        int x4 = 1;
        for (int i = y + 1; i < heightmap.length; i++) {
            if (heightmap[x][i] >= heightmap[x][y] || i == heightmap.length - 1) {
               break;
            }
            x4++;
        }
        System.out.println(x1 + " " + x2 + " " + x3 + " " + x4 + " = " + x1 * x2 * x3 * x4);
        return x1 * x2 * x3 * x4;
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

        int bestScore = 0;
        int o = heightmap[0][0];

        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j < size - 1; j++) {
                int p = get_Scenic_Score(heightmap,i,j);
                if (p > bestScore) {
                    bestScore = p;
                    o = heightmap[i][j];
                }
            }
        }

        System.out.println(o);
        System.out.println(bestScore);
    }
}
