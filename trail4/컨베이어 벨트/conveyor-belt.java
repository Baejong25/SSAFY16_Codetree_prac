import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] top = new int[n];
        int[] bottom = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bottom[i] = sc.nextInt();
        }

        for(int a = 0; a < t; a++) {
            int t_tail = top[n-1];
            int b_tail = bottom[n-1];
            for(int i = n-1; i > 0; i--) {
                top[i] = top[i-1];
            }
            top[0] = b_tail;

            for(int i = n-1; i > 0; i--) {
                bottom[i] = bottom[i-1];
            }
            bottom[0] = t_tail;
        }

        StringBuilder result = new StringBuilder();
        for(int a : top) {
            result.append(a+" ");
        }
        result.append("\n");
        for(int a : bottom) {
            result.append(a+" ");
        }
        System.out.println(result);
    }
}