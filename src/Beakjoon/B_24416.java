package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_24416 {
    public static int cnt = 0;
    public static int dpCnt = 0;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n];

        fibo(n);
        dpFibo(n);
        StringBuffer sb = new StringBuffer();
        sb.append(cnt).append(" ").append(dpCnt);
        System.out.println(sb);
    }

    public static int fibo(int n){
        if(n == 1 || n == 2){
            cnt++;
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
    public static int dpFibo(int n){
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dpCnt++;
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n - 1];
    }

}
