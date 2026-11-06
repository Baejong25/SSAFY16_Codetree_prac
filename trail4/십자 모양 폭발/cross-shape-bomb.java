import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static Queue<int[]> blast;
    static int[][] grid;
    static int n, r, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        
        explosion(c-1, r-1);
        flatten();

        for(int[] line : grid) {
            for(int a : line) {
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }

    public static void explosion(int x, int y) {
        blast = new ArrayDeque();

        blast.add(new int[] {x, y});
        int range = grid[y][x];
        grid[y][x] = 0;

        while(!blast.isEmpty() && range > 1) {
            int layer = blast.size();
            
            for(int r = 0; r < layer; r++) {
                int[] curr = blast.poll();

                for(int d = 0; d < 4; d++) {
                    int ny = curr[1] + dy[d];
                    int nx = curr[0] + dx[d];

                    if(nx >= n || nx < 0 || ny >= n || ny < 0) continue;
                    if(curr.length == 3 && curr[2] != d) continue;

                    grid[ny][nx] = 0;
                    blast.add(new int[] {nx, ny, d});
                }
            }
            range--;
        }
    }

    public static void flatten() {
        for(int j = 0; j < n; j++) {
            for(int i = n-1; i >= 0; i--) {
                if(grid[i][j] == 0) {
                    int drop = -1;
                    for(int tar = i; tar >= 0; tar--) {
                        if(grid[tar][j] != 0) {
                            drop = tar;
                            break;
                        }
                    }
                    if(drop != -1) {
                        for(int go = drop; go < i; go++) {
                            grid[go+1][j] = grid[go][j];
                            grid[go][j] = 0;
                        }
                    }
                }
            }
        }
    }
}