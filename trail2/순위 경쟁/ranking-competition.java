import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fame = new int[3];
        int[] prev = new int[3];
        Arrays.fill(prev, 1);
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int high = Integer.MIN_VALUE;
            int[] round = new int[3];

            char c = sc.next().charAt(0);
            int s = sc.nextInt();

            if(c == 'A') {
                fame[0] += s;
            } else if(c == 'B') {
                fame[1] += s;
            } else if(c == 'C') {
                fame[2] += s;
            }

            for(int l = 0; l < 3; l++) {
                high = Math.max(fame[l], high); 
            }

            for(int l = 0; l < 3; l++) {
                if(high == fame[l]) {
                    round[l] = 1;
                }
            }
            int pal = 0;
            for(int l = 0; l < 3; l++) {
                if(prev[l] == round[l]) {
                    pal++;
                }
                prev[l] = round[l];
            }
            
            if(pal == 3) {
                continue;
            } else {
                ans++;
            }
        }
        System.out.println(ans);
    }
}