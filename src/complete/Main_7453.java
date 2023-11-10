package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int [] A = new int [N];
        int [] B = new int [N];
        int [] C = new int [N];
        int [] D = new int [N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int helper;
        helper = 0;
        int [] AplusB = new int [N*N];
        for (int a : A) {
            for (int b : B) {
                AplusB[helper] = a + b;
                helper++;
            }
        }
        helper = 0;
        int [] CplusD = new int [N*N];
        for (int c : C) {
            for (int d : D) {
                CplusD[helper] = c + d;
                helper++;
            }
        }
        Arrays.sort(CplusD);
//        System.out.println(Arrays.toString(AplusB));
//        System.out.println(Arrays.toString(CplusD));
        long answer = 0;
        for (int i : AplusB) {
            int left = 0;
            int right = N * N;
            while (left < right) {
                int mid = (left + right) / 2;
                if (CplusD[mid] < -i) left = mid+1;
                else right = mid;

            }
//            System.out.println("*" + -i + " " + left);
            if (right < N*N && CplusD[right] == -i) {
                int up_left = 0;
                int up_right = N * N;
                while (up_left < up_right) {
                    int up_mid = (up_left + up_right) / 2;
                    if (CplusD[up_mid] <= -i) up_left = up_mid+1;
                    else up_right = up_mid;
                }
//                System.out.println(-i + " " + (right) + " " + (up_right));
                answer += up_right - right;
            }
        }
        System.out.println(answer);
    }
}