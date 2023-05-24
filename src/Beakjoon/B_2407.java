package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B_2407 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger num1 = BigInteger.ONE;
        BigInteger num2 = BigInteger.ONE;

        for (int i = 0; i < m; i++) {
            num1 = num1.multiply(new BigInteger(String.valueOf(n - i)));
            num2 = num2.multiply(new BigInteger(String.valueOf(i + 1)));
        }

        BigInteger result = num1.divide(num2);

        System.out.println(result);
    }

    /*
    //Long 자료형의 파스칼의 삼각형을 사용해도 자료형의 범위를 넘을 수 있기 때문에 BigInteger 사용
    public static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dp = new long[101][101];

        System.out.println(comb(n, m));
    }

    public static long comb(int n, int r) {
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
    */
}
