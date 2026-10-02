import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        // 버킷 10개 (한 번 만들어두고 매 자리마다 비워서 재사용)
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < 10; i++) bucket.add(new ArrayList<>());

        // exp = 1, 10, 100, ... (1의 자리부터 최상위 자리까지)
        for (int exp = 1; ; exp *= 10) {
            for (int i = 0; i < 10; i++) bucket.get(i).clear();

            // 현재 자리 숫자에 따라 버킷에 넣기
            for (int i = 0; i < n; i++) {
                bucket.get((arr[i] / exp) % 10).add(arr[i]);
            }

            // 버킷 0~9 순서대로 다시 arr에 이어붙이기
            int idx = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < bucket.get(i).size(); j++) {
                    arr[idx++] = bucket.get(i).get(j);
                }
            }

            // 최상위 자리까지 처리했으면 종료 (exp가 오버플로우하기 전에 멈춤)
            if (max / exp < 10) break;
        }

        StringBuilder sb = new StringBuilder();
        for (int x : arr) sb.append(x).append(' ');
        System.out.println(sb.toString().trim());
    }
}