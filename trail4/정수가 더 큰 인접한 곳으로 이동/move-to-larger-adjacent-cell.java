import java.util.Scanner;
public class Main {
    public static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    public static int n, r, c;
    public static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        grid = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        walk(c, r);
    }

    public static void walk(int x, int y) {
        if (cantGo(x, y)) {
            System.out.print(grid[y][x] + " ");
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= n + 1 || nx < 1 || ny < 1 || ny >= n + 1) continue;
            if (grid[ny][nx] <= grid[y][x]) continue;
            System.out.print(grid[y][x] + " ");
            walk(nx, ny);
            break;
        }
    }

    public static boolean cantGo(int x, int y) {
        for (int d = 0; d < 4; d++) {
            if (x + dx[d] < n + 1 && x + dx[d] >= 1 && y + dy[d] >= 1 && y + dy[d] < n + 1 && grid[y][x] < grid[y + dy[d]][x + dx[d]]) return false;

        }
        return true;
    }
}
