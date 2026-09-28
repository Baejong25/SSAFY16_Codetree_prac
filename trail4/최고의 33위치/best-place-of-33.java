import java.util.Scanner;
public class Main {
    static int[] dr = new int[] {-1, -1, -1, 0, 1, 1, 1, 0, 0};
    static int[] dc = new int[] {-1, 0, 1, 1, 1, 0, -1, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int ans = 0;

        for(int i = 1; i < n-1; i++) {
            for(int j = 1; j < n-1; j++) {
                int coins = 0;
                for(int d = 0; d < 9; d++) {
                    int coin = grid[i+dr[d]][j+dc[d]];
                    if(coin == 1) {
                        coins++;
                    }
                }
                ans = Math.max(ans, coins);
            }
        }

        System.out.println(ans);
    }
}