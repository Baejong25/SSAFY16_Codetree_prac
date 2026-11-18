import java.util.Scanner;

public class Main {
    public static int k, n;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n];

        DFS(0);
    }

    public static void DFS(int idx) {
        if (idx == n) {
            show();
            return;
        }

        for (int i = 1; i <= k; i++) {
            arr[idx] = i;
            DFS(idx + 1);
        }
    }

    public static void show() {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
