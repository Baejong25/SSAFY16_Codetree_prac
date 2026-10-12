import java.util.*;

public class Main {
    public static int n, m, q;
    public static int[][] ice;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        ice = new int[n][m];
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                ice[i][j] = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int r = sc.nextInt();
            char d = sc.next().charAt(0);
            
            DFS(r-1, d, 0);
            if(d == 'R') {
                shift(r-1, 'L');
            } else if(d == 'L') {
                shift(r-1, 'R');
            }
            DFS(r-1, d, 1);

        }

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                System.out.print(ice[r][c]+ " ");
            }
            System.out.println();
        }
    }

    public static void shift(int line, char a) {
        if(a == 'R') {
            int first = ice[line][0];
            for(int i = 0; i < m-1; i++) {
                ice[line][i] = ice[line][i+1];
            }
            ice[line][m-1] = first;
        } else if(a == 'L') {
            int last = ice[line][m-1];
            for(int i = m-1; i > 0; i--) {
                ice[line][i] = ice[line][i-1];
            }
            ice[line][0] = last;
        }
    }

    public static void DFS(int line, char a, int dir) {
        shift(line, a);
        char next = 'b';

        if(a == 'L') {
            next = 'R';
        } else if(a == 'R') {
            next = 'L';
        }

        int up = 0;
        int down = 0;

        for(int i = 0; i < m; i++) {
            if(line-1 >= 0 && ice[line][i] == ice[line-1][i] && dir == 0 && up == 0) {
                up++;
                DFS(line-1, next, 0);
            }
            if(line+1 < n && ice[line][i] == ice[line+1][i] && dir == 1 && down == 0) {
                down++;
                DFS(line+1, next, 1);
            }
        }
    }
}