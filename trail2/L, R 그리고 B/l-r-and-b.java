import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] board = new String[10];
        for (int i = 0; i < 10; i++) {
            board[i] = sc.next();
        }

        int stx = 0;
        int sty = 0;
        int enx = 0;
        int eny = 0;
        int obx = 0;
        int oby = 0;

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(board[i].charAt(j) == 'L') {
                    stx = j;
                    sty = i;
                } else if(board[i].charAt(j) == 'B') {
                    enx = j;
                    eny = i;
                } else if(board[i].charAt(j) == 'R') {
                    obx = j;
                    oby = i;
                }
            }
        }
        
        int ans = 0;
        if(stx == enx) {
            if(stx == obx && !((sty > oby && oby < eny) || (sty < oby && oby > eny))) {
                ans = Math.abs(sty-eny)+1;
            } else {
                ans = Math.abs(sty-eny)-1;
            }
        } else if(sty == eny && !((stx > obx && obx < enx) || (stx < obx && obx > enx))) {
            if(sty == oby) {
                ans = Math.abs(stx-enx)+1;
            } else {
                ans = Math.abs(stx-enx)-1;
            }
        } else {
            ans = Math.abs(stx-enx) + Math.abs(sty-eny) -1;
        }

        System.out.println(ans);
    }
}