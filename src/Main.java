import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long [] summation = new long [201];
        for (int i = 0; i <= N; i++) summation[i] = 1;
        for (int k = 1; k < K; k++) {
            long [] temp = new long [201];
            for (int i = 0; i <= 200; i++) {
                for (int j = 0; j <= N; j++) {
                    if (i + j > N) break;
//                    System.out.println(i + " " + j);
                    temp[i+j] += summation[i];
                    temp[i+j] %= 1_000_000_000;
                }
            }
            for (int i = 0; i <= 200; i++) {
                summation[i] = temp[i];
            }
        }
        System.out.println(summation[N]);
    }
}