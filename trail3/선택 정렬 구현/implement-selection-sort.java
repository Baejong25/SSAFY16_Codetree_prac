import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        for(int i = 0; i < n-1; i++) {
            int chan = i;
            for(int j = i; j < n; j++) {
                if(arr[chan] > arr[j]) {
                    chan = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[chan];
            arr[chan] = tmp;
        }
        
        for(int a : arr) {
            System.out.printf("%d ", a);
        }
    }
}