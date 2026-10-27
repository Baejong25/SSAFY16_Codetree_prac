import java.util.Scanner;
public class Main {
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] building = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                building[i][j] = sc.nextInt();
        int[][] queries = new int[q][4];
        for (int i = 0; i < q; i++)
            for (int j = 0; j < 4; j++)
                queries[i][j] = sc.nextInt();

        for(int re = 0; re < q; re++) {
            int sy = queries[re][0]-1;
            int sx = queries[re][1]-1;
            int ey = queries[re][2]-1;
            int ex = queries[re][3]-1;
            int t = 0;

            int r = sy;
            int c = sx;
            int d = 0;
            int prev = building[r][c];

            while(t < ((ex-sx+ey-sy+2)*2)-4) {
                int nr = r + dy[d];
                int nc = c + dx[d];
                if(nr > ey || nr < sy || nc > ex || nc < sx) {
                    d = (d+1) % 4;
                    nr = r + dy[d];
                    nc = c + dx[d];
                }
                int tmp = building[nr][nc];
                building[nr][nc] = prev;
                prev = tmp;
                r = nr;
                c = nc;

                t++;
            }
            int[][] copy = new int[n][m];
            for(int i = 0; i < n; i++)
                copy[i] = building[i].clone();
            
            for(int i = sy; i <= ey; i++) {
                for(int j = sx; j <= ex; j++) {
                    int sum = copy[i][j];
                    int block = 1;
                    for(int di = 0; di < 4; di++) {
                        if(j+dx[di] >= m || j+dx[di] < 0 || i+dy[di] >= n || i+dy[di] < 0) {
                            continue;
                        }
                        sum += copy[i+dy[di]][j+dx[di]];
                        block++;
                    }
                    building[i][j] = sum/block;
                }
            }            
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(building[i][j]+" ");
            }
            System.out.println();
        }
    }
}