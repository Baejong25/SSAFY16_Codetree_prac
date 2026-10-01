import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        LinkedList<Character> l = new LinkedList<>();
        for(char c : s.toCharArray()) l.add(c);

        ListIterator<Character> it = l.listIterator(l.size());

        for (int i = 0; i < m; i++) {
            String command = br.readLine();
            char c = command.charAt(0);
            if(c == 'L') {
                if(it.hasPrevious()) it.previous();
            } else if(c == 'R') {
                if(it.hasNext()) it.next();
            } else if(c == 'D') {
                if(it.hasNext()) {it.next(); it.remove();}
            } else if(c == 'P') {
                it.add(command.charAt(2));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : l) sb.append(c);
        System.out.println(sb);
    }
}