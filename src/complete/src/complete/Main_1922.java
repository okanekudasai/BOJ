package complete.src.complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Vertex {
    int to, cost;
    Vertex(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
public class Main_1922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        HashMap<Integer, ArrayList<Vertex>> graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Vertex(b, c));
            graph.get(b).add(new Vertex(a, c));
        }

        PriorityQueue<Vertex> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        boolean [] visit = new boolean[N+1];
        visit[1] = true;
        for (Vertex v : graph.get(1)) {
            pq.offer(v);
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            Vertex v = pq.poll();
            if (visit[v.to]) continue;
            visit[v.to] = true;
            answer += v.cost;
//            System.out.println(answer);
//            for (int i = 1; i <= N; i++) System.out.print(i + " : " + visit[i] + "  /  ");
//            System.out.println();
            for (Vertex next_vertex : graph.get(v.to)) {
                if (visit[next_vertex.to]) continue;
                pq.offer(next_vertex);
            }
        }
        System.out.println(answer);
    }
}