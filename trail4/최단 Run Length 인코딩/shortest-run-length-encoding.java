import java.util.Scanner;

public class Main {
    static String A;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.next();
        ans = Integer.MAX_VALUE;
        String B = "";

        for(int i = 0; i < A.length(); i++) {
            if(i == 0) {
                ans = Math.min(ans, calc(A));
                B = shift(A);
            } else if(i > 0) {
                ans = Math.min(ans, calc(B));
                B = shift(B);
            }
        }
        System.out.println(ans);
    }

    public static String shift(String a) {
        String b = "";
        char move = a.charAt(a.length()-1);
        b += move;
        for(int i = 0; i < a.length()-1; i++) {
            b += a.charAt(i);
        }
        return b;
    }

    public static int calc(String code) {
        char prev = code.charAt(0);
        int len = 2;
        int row = 1;

        for(int i = 1; i < code.length(); i++) {
            if(prev != code.charAt(i)) {
                len += 2;
                row = 1;
                prev = code.charAt(i);
            } else {
                row++;
                prev = code.charAt(i);
                if(row >= 10) {
                    len += 1;
                }
            }
        }
        return len;
    }
}