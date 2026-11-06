import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        
        for(int a = 0; a < t; a++) {
            int l_tail = l[n-1];
            int r_tail = r[n-1];
            int d_tail = d[n-1];

            for(int i = n-1; i > 0; i--) {
                l[i] = l[i-1];
                r[i] = r[i-1];
                d[i] = d[i-1];
            }
            l[0] = d_tail;
            r[0] = l_tail;
            d[0] = r_tail;
        }

        StringBuilder result = new StringBuilder();
        for(int a : l) {
            result.append(a+" ");
        }
        result.append("\n");
        for(int a : r) {
            result.append(a+" ");
        }
        result.append("\n");
        for(int a : d) {
            result.append(a+" ");
        }
        System.out.println(result);
    }
}