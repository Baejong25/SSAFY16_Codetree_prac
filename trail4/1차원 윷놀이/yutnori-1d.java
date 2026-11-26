import java.util.Scanner;
public class Main {
    public static int n, m, k, ans;
    public static int[] nums, dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        ans = 0;
        dist = new int[k];

        DFS(0);
        System.out.println(ans);
    }

    public static void DFS(int idx) {
        if(idx == n) {
            ans = Math.max(ans, getPoint());
            return;
        }

        for(int i = 0; i < k; i++) {
            dist[i] += nums[idx];
            DFS(idx+1);
            dist[i] -= nums[idx];
        }
    }
    
    public static int getPoint() {
        int score = 0;
        for(int i = 0; i < k; i++) {
            if(dist[i] >= m-1) {
                score++;
            }
        }
        return score;
    }
}