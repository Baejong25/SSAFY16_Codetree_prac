import java.util.Scanner;
public class Main {
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        int ans = -1;

        for(int r1 = 0; r1 < n; r1++) {
            for(int c1 = 0; c1 < m; c1++) {
                for(int r2 = r1; r2 < n; r2++) {
                    for(int c2 = c1; c2 < m; c2++) {
                        if(hasMinus(r1, c1, r2, c2)) continue;
                        int size = (r2-r1+1) * (c2-c1+1);
                        ans = Math.max(size, ans);
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static boolean hasMinus(int y1, int x1, int y2, int x2) {
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                if(grid[j][i] <= 0) return true;
            }
        }
        return false;
    }
}