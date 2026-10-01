import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList<Integer> ring = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String command = sc.next();

            if(command.equals("push_back")) {
                int id = sc.nextInt();
                ring.addLast(id);
            } else if(command.equals("push_front")) {
                int id = sc.nextInt();
                ring.addFirst(id);
            } else if(command.equals("pop_front")) {
                System.out.println(ring.removeFirst());
            } else if(command.equals("front")) {
                System.out.println(ring.getFirst());
            } else if(command.equals("pop_back")) {
                System.out.println(ring.removeLast());
            } else if(command.equals("back")) {
                System.out.println(ring.getLast());
            } else if(command.equals("size")) {
                System.out.println(ring.size());
            } else if(command.equals("empty")) {
                int a = ring.isEmpty() ? 1 : 0;
                System.out.println(a);
            }
        }
    }
}