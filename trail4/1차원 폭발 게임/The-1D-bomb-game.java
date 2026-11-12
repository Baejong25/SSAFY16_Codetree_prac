import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(sc.nextInt());

        while (true) {
            List<Integer> next = new ArrayList<>();
            boolean exploded = false;

            int i = 0;
            while (i < list.size()) {
                int j = i;
                while (j < list.size() && list.get(j).equals(list.get(i))) j++;

                if (j - i >= m) {
                    exploded = true;
                } else {
                    for (int k = i; k < j; k++) next.add(list.get(k));
                }
                i = j;
            }

            list = next;                      
            if (!exploded) break;
        }

        System.out.println(list.size());
        for (int a : list) System.out.println(a);
    }
}