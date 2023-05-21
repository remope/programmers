package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1010 {
    public static int[][] dp = new int[31][31];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(comb(m, n)).append("\n");
        }
        System.out.println(sb);
    }

    public static int comb(int n, int r) {
        if(n < 0 || r < 0){
            return 1;
        }
        if (dp[n][r] > 0) {
            return dp[n][r];
        }
        else if (n == r || r == 0) {
            return dp[n][r] = 1;
        }

        else {
            return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
        }
    }
}
