import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int cnt = 0;

        for(int i = 0; i < n; i++) {
            int prev = 0;
            int happy = 1;
            int hi = 1;

            for(int j = 0; j < n; j++) {
                if(prev == grid[i][j]) {
                    happy++;
                    if(happy > hi) {
                        hi = happy;
                    }
                } else if(prev != grid[i][j]) {
                    happy = 1;
                }
                prev = grid[i][j];
            }
            if(hi >= m) {
                cnt++;
            }
        }

        for(int i = 0; i < n; i++) {
            int prev = 0;
            int happy = 1;
            int hi = 1;

            for(int j = 0; j < n; j++) {
                if(prev == grid[j][i]) {
                    happy++;
                    if(happy > hi) {
                        hi = happy;
                    }
                } else if(prev != grid[i][j]) {
                    happy = 1;
                }
                prev = grid[j][i];
            }
            if(hi >= m) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}