package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B_10826 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());

        if(n == 0){
            sb.append(0).append('\n');
        }else if(n == 1){
            sb.append(1).append('\n');
        }else{
            BigInteger[] dp = new BigInteger[n + 1];

            dp[0] = BigInteger.ZERO;
            dp[1] = BigInteger.ONE;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i-1].add(dp[i - 2]);
            }
            sb.append(dp[n]).append('\n');
        }

        System.out.println(sb);
    }
    /*
    //자료형의 범위 문제로 틀림, BigInteger 사용
    public static long[] dp = new long[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 1;
        System.out.println(fibo(n));
    }

    public static long fibo(int n){
        if(dp[n] > 0){
            return dp[n];
        }else{
            long temp = fibo(n - 1) + fibo(n - 2);
            dp[n] = temp;
            return temp;
        }
    }
    */
}
