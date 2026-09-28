import java.util.Scanner;
public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        hi(n);
    }

    public static void hi(int i) {
        if(i == 0) {
            return;
        }
        System.out.println("HelloWorld");
        hi(i-1);
    }
}