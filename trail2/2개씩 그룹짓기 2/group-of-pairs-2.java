import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length-n; i++) {
            ans = Math.min(arr[i+n]-arr[i], ans);
        }
        System.out.println(ans);
    }
}



// 2 5 7 9 10 15
// 3 2 2 1 5