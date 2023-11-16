package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649 {
    static int N, M;
    static int [] arr;
    static boolean [] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int [M];
        visit = new boolean [N+1];
        dfsing(0);
        System.out.print(sb);
    }
    static void dfsing(int level) {
        if (level >= M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue;
            arr[level] = i;
            visit[i] = true;
            dfsing(level+1);
            visit[i] = false;
            arr[level] = 0;
        }
    }
}
