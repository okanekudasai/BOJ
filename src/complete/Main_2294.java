package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(),  " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        HashSet<Integer> coin = new HashSet<>();
        for (int i = 0; i < N; i++) {
            coin.add(Integer.parseInt(br.readLine()));
        }
        boolean [] visit = new boolean[K+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        ArrayDeque<Integer> count = new ArrayDeque<>();
        q.offerLast(0);
        count.offerLast(0);
        while(!q.isEmpty()) {
            int total = q.poll();
            int cnt = count.poll();
            for (int i : coin) {
                int next = total + i;
//                System.out.println(next);
                if (next > K) continue;
                if (next == K) {
                    System.out.println(cnt + 1);
                    return;
                }
                if (visit[next]) continue;
                visit[next] = true;
                q.offerLast(total + i);
                count.offerLast(cnt + 1);
            }
//            System.out.println(q);
        }
        System.out.println(-1);
    }
}