import java.util.*;
public class Main {
    public static int[] digit;
    public static int n, idx, ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        digit = new int[n];
        ans = 0;

        DFS(0);
        System.out.println(ans);
    }

    public static void DFS(int idx) {
        if (idx == n) {
            if(isBeautiful()) {
                ans++;
            }
            return;
        }

        for(int i = 1; i <= 4; i++) {
            digit[idx] = i;
            DFS(idx+1);
        }
    }

    public static boolean isBeautiful() {
        for(int i = 0; i < n; i++) {
            int num = digit[i];
            if(num+i > n) return false;
            if(num == 1) continue;
            for(int d = i; d < num+i; d++) {
                if(digit[d] != num) {
                    return false;
                }
            }
            i += num-1;
        }
        return true;
    }
}