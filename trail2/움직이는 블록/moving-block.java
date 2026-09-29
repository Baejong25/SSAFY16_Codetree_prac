import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = new int[n];
        int ave = 0;
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
            ave += blocks[i];
        }
        ave /= n;

        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(blocks[i] > ave) {
                ans += blocks[i] - ave;
            }
        }

        System.out.println(ans);
    }
}