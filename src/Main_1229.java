import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class Unit_1229 {
    int value, count;
    Unit_1229(int value, int count) {
        this.value = value;
        this.count = count;
    }
}
public class Main_1229 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] coin = new int [707];
        coin[0] = 1;
        for (int i = 1; i < 707; i++) {
            coin[i] = coin[i-1] + i*4 + 1;
        }

        ArrayDeque<Unit_1229> q = new ArrayDeque<>();
        q.offerLast(new Unit_1229(0, 0));
        int [] count = new int [1_000_001];
        boolean [] check = new boolean [1_000_001];
        while (!q.isEmpty()) {
            Unit_1229 u = q.pollFirst();
            for (int c : coin) {
                if (c > N) break;
//                System.out.println(u.value + " " + c);
                if (u.value + c == N) {
                    System.out.println(u.count+1);
                    return;
                }
                if (u.value + c > N) continue;
                if (check[u.value + c] && count[u.value + c] <= u.count + 1) continue;
                check[u.value + c] = true;
                count[u.value + c] = u.count + 1;
                q.offerLast(new Unit_1229(u.value + c, u.count + 1));
            }
//            System.out.println(Arrays.toString(count));
        }
    }
}