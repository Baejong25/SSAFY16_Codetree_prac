import java.util.Scanner;
public class Main {
    public static int k, n;
    public static int[] hand;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();

        hand = new int[n];
        permute(0);
    }

    public static void permute(int idx) {
        if(idx == n) {
            showme();
            return;
        }

        for(int i = 1; i <= k; i++) {
            hand[idx] = i;
            permute(idx+1);
        }
    }

    public static void showme() {
        int high = 1;
        int cnt = 1;
        for(int i = 1; i < n; i++) {
            int prev = hand[i-1];
            if(prev == hand[i]) {
                cnt++;
                if(high < cnt) {
                    high = cnt;
                }
            } else {
                cnt = 1;
            }
        }
        if(high >= 3) return;

        for(int i = 0; i < n; i++) {
            System.out.print(hand[i]+" ");
        }
        System.out.println();
    }
}