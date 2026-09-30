import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> pro = new ArrayList<>();
        for(int li = 0; li < n; li++) {
            String com = sc.next();

            if(com.equals("push_back")) {
                int con = sc.nextInt();
                pro.add(con);
            } else if(com.equals("get")) {
                int con = sc.nextInt();
                System.out.println(pro.get(con-1));
            } else if(com.equals("size")) {
                System.out.println(pro.size());
            } else if(com.equals("pop_back")) {
                pro.remove(pro.size()-1);
            }
        }        
    }
}