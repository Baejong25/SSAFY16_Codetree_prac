import java.util.Scanner;
public class Main {
    static int[] dx = {1, -1, -1, 1}, dy = {-1, -1, 1, 1};
    static boolean[][] visited;
    static int ans, n, sy, sx;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sx = j;
                sy = i;
                rotate(j, i, 0, 0);
            }
        }
        System.out.println(ans);
    }

    public static void rotate(int x, int y, int idx, int sum) {
        if(idx == 4) {
            if(x == sx && y == sy)
                ans = Math.max(ans, sum);
            return;
        }
        if(x+dx[idx] < 0 || x+dx[idx] >= n || y+dy[idx] < 0 || y+dy[idx] >= n) {
            return;
        }


        rotate(x+dx[idx], y+dy[idx], idx, sum+grid[y][x]);
        rotate(x+dx[idx], y+dy[idx], idx+1, sum+grid[y][x]);
    }
}