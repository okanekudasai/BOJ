package complete.src.complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Unit {
    int start, end;
    Unit (int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class Main_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Unit [] data = new Unit [N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            data[i] = new Unit(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(data, (o1, o2) -> {
            return o1.start - o2.start;
        });
//        for (Unit u : data) System.out.println(u.start + " " + u.end);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(data[0].end);
        int answer = 1;
        for (int i = 1; i < N; i++) {
            if (pq.peek() <= data[i].start) {
                pq.poll();
            } else {
                answer++;
            }
            pq.add(data[i].end);
        }
        System.out.println(answer);
    }
}