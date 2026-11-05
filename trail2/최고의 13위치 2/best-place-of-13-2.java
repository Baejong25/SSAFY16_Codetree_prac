import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();

        int ans = 0;

        for(int i1 = 0; i1 < n; i1++) {
            for(int j1 = 0; j1 < n-2; j1++) {
                int s1 = arr[i1][j1] + arr[i1][j1+1] + arr[i1][j1+2];

                for(int i2 = 0; i2 < n; i2++) {
                    for(int j2 = 0; j2 < n-2; j2++) {
                        if(i1 == i2 && Math.abs(j1 - j2) < 3) continue;

                        int s2 = arr[i2][j2] + arr[i2][j2+1] + arr[i2][j2+2];
                        ans = Math.max(ans, s2+s1);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}