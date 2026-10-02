import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> fring = new ArrayList<>();

        for(int c = 0; c < n; c++) {
            String word = sc.next();
            if(word.equals("push")) {
                int e = sc.nextInt();
                fring.add(e);
            } else if(word.equals("size")) {
                System.out.println(fring.size());
            } else if(word.equals("empty")) {
                System.out.println(fring.isEmpty() ? 1 : 0);
            } else if(word.equals("pop")) {
                System.out.println(fring.remove(fring.size()-1));
            } else if(word.equals("top")) {
                System.out.println(fring.get(fring.size()-1));
            }
        }
    }
}