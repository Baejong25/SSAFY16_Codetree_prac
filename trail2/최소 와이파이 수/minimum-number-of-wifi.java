import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int cnt = 0;
        int i = 0;
        while (i < n) {
            if (arr[i] == 1) {
                cnt++;
                i += 2 * m + 1;
            } else {
                i++;
            }
        }

        System.out.println(cnt);
    }
}