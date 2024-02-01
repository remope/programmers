package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10164 {
    public static int N;
    public static int M;
    public static int K;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int result = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K != 0) {
            int row = (K - 1) / M;
            int col = (K - 1) % M;

            int first = dpFunc(row, col);
            int second = dpFunc(N - row - 1, M - col - 1);
            result = first * second;
        } else {
            result = dpFunc(N - 1, M - 1);
        }

        System.out.println(result);
    }

    public static int dpFunc(int x, int y) {
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 0; i < x + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < y + 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < x + 1; i++) {
            for (int j = 1; j < y + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[x][y];
    }
}
