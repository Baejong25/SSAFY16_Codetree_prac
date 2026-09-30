import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        
        int ans = 0;
        int k = (int) Math.sqrt(x);
        while (k * k > x) k--;
        while ((k + 1) * (k + 1) <= x) k++;

        if (x == k * k) {
            ans = 2 * k - 1;
        } else if (x <= k * k + k) {
            ans = 2 * k;
        } else {
            ans = 2 * k + 1;
        }

        System.out.println(ans);
    }
}