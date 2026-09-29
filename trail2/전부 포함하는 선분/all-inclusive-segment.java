import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }

        int ans = 101;
        for(int e = 0; e < n; e++) {
            int mi = 101;
            int ma = -1;
            for(int s = 0; s < n; s++) {
                if(s == e) continue;
                mi = Math.min(x1[s], mi);
                ma = Math.max(x2[s], ma);
            }
            ans = Math.min(ans, ma-mi);
        }
        System.out.println(ans);
    }
}
