import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        
        int right_x = Math.max(Math.max(Math.max(x1,x2),a1),a2);
        int left_x = Math.min(Math.min(Math.min(x1,x2),a1),a2);
        int up_y = Math.max(Math.max(Math.max(y1,y2),b1),b2);
        int down_y = Math.min(Math.min(Math.min(y1,y2),b1),b2);

        System.out.println((right_x - left_x) * (up_y - down_y));
    }
}