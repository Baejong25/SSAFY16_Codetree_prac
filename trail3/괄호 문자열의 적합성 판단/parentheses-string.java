import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        int idx = 0;
        char[] stack = new char[str.length()];
        String ans = "";

        for(int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if(a == '(') {
                stack[idx++] = a;
            } else {
                if(idx == 0) {
                    System.out.println("No");
                    return;
                }
                stack[--idx] = ' ';
            }
        }

        if(idx == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}