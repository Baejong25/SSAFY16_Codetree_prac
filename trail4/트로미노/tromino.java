import java.util.Scanner;

public class Main {
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static int[][] grid;
    static int n, m, ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ilza(j, i);
                nien(j, i);
            }
        }
        System.out.println(ans);
    }

    public static void ilza(int x, int y) {
        if(x > 0 && x < m-1) {
            int sum = grid[y][x];
            sum += grid[y][x+dx[0]];
            sum += grid[y][x+dx[2]];
            ans = Math.max(sum, ans);
        }

        if(y > 0 && y < n-1) {
            int sum1 = grid[y][x];
            sum1 += grid[y+dy[1]][x];
            sum1 += grid[y+dy[3]][x];
            ans = Math.max(sum1, ans);
        }

    }

    public static void nien(int x, int y) {
        for(int d = 0; d < 4; d++) {
            int sum = grid[y][x];
            
            if(d < 3) {
                if(x+dx[d] >= m  || x+dx[d] < 0 || y+dy[d] >= n || y+dy[d] < 0) continue;
                if(x+dx[d+1] >= m  || x+dx[d+1] < 0 || y+dy[d+1] >= n || y+dy[d+1] < 0) continue;
                sum += grid[y+dy[d]][x+dx[d]];
                sum += grid[y+dy[d+1]][x+dx[d+1]];
            } else if(d == 3) {
                if(x+dx[d] >= m  || x+dx[d] < 0 || y+dy[d] >= n || y+dy[d] < 0) continue;
                if(x+dx[0] >= m  || x+dx[0] < 0 || y+dy[0] >= n || y+dy[0] < 0) continue;
                sum += grid[y+dy[d]][x+dx[d]];
                sum += grid[y+dy[0]][x+dx[0]];
            }
            ans = Math.max(ans, sum);
        }
    }
}