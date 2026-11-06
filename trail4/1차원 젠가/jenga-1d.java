import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
        }
        int s1 = sc.nextInt()-1;
        int e1 = sc.nextInt()-1;
        int s2 = sc.nextInt()-1;
        int e2 = sc.nextInt()-1;
        
        for(int o = s1; o <= e1; o++) {
            blocks[o] = 0;
        }

        int adj = e1-s1+1;
        for(int d = s1-1; d >= 0 ; d--) {
            blocks[adj+d] = blocks[d];
            blocks[d] = 0;
        }

        for(int o = s2+adj; o <= e2+adj; o++) {
            blocks[o] = 0;
        }

        int adj2 = e2-s2+1;
        for(int d = s2+adj-1; d >= 0; d--) {
            blocks[adj2+d] = blocks[d];
            blocks[d] = 0;
        }

        int len = 0;

        for(int i = 0; i < n; i++) {
            if(blocks[i] != 0) len++;
        }

        System.out.print(len+"\n");
        for(int a : blocks) {
            if(a == 0) continue;
             System.out.println(a);
        }
    }
}