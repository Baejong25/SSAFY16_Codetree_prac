import java.util.Scanner;
public class Main {
    static int n, ans;
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        ans = Integer.MAX_VALUE;
        DFS(0);
        System.out.println(ans);
    }

    public static void DFS(int g) {
        if(g == n) {
            return;
        }
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if(g == i) continue;
            sum += a[i]*Math.abs(g-i);
        }
        ans = Math.min(ans, sum);
        DFS(g+1);
    }
}