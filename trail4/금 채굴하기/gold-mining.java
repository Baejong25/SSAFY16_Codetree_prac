import java.util.*;

public class Main {
    static int n, m, ans;
    static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
    static int[][] grid;
    static boolean[][] digged;
    static Queue<int[]> seq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        ans = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                digged = new boolean[n][n];
                digging(j, i);
            }
        }

        System.out.println(ans);
    }

    public static void digging(int x, int y) {
        seq = new ArrayDeque<>();

        seq.add(new int[] {x, y});
        digged[y][x] = true;
        int gold = grid[y][x] == 1 ? 1 : 0;
        int layer = 0;

        while(!seq.isEmpty()) {
            if(checking(layer, gold)) {
                ans = Math.max(ans, gold);
            }
            int size = seq.size();
            for(int s = 0; s < size; s++) {
                int[] curr = seq.poll();
                for(int d = 0; d < 4; d++) {
                    int nx = curr[0] + dx[d];
                    int ny = curr[1] + dy[d];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if(digged[ny][nx]) continue;

                    seq.add(new int[] {nx, ny});
                    digged[ny][nx] = true;
                    if(grid[ny][nx] == 1) gold++;
                }
            }
            layer++;
        }
    }

    public static boolean checking(int l, int g) {
        return ((l*l) + ((l+1)*(l+1))) <= g * m;
    }
}