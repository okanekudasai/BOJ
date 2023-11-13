package complete.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1229 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data, (o1, o2) -> o1[1] - o2[1]);
//        for (int [] i : data) System.out.println(i[0] + " " + i[1]);
        int [] count = new int [N];
        count[0] = 1;
        for (int i = 1; i < N; i++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (data[i][0] > data[j][0]) {
                    flag = true;
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }
            if (!flag) count[i] = 1;
        }
//        System.out.println(Arrays.toString(count));
        int answer = -1;
        for (int i : count) answer = Math.max(answer, i);
        System.out.println(N - answer);
    }
}