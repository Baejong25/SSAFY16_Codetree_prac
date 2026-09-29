import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = 0;
        Arrays.sort(arr);
        if(arr[n-1] > 0) {
            if(arr[0]*arr[1] >= arr[n-2]*arr[n-1]){
                ans = arr[0] * arr[1] * arr[n-1];
            } else {
                ans = arr[n-1] * arr[n-2] * arr[n-3];
            }
        } else {
            ans = arr[n-1] * arr[n-2] * arr[n-3];
        }
        System.out.println(ans);
    }
}