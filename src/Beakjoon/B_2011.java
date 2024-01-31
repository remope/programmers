package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2011 {
    public static final int MOD = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pw = br.readLine();
        int len = pw.length();

        int[] dp = new int[len + 1];

        dp[0] = 1;

        for (int i = 1; i <= len; i++) {
            int before = pw.charAt(i - 1) - '0';
            if(before >= 1 && before <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= MOD;
            }

            if(i == 1) {
                continue;
            }

            int beforeTwoChar = pw.charAt(i - 2) - '0';

            if(beforeTwoChar == 0) {
                //두번째 앞의 숫자가 0일 경우 i - 2와 i - 1로 이루어지는 숫자 x
                continue;
            }

            int beforeNum = beforeTwoChar * 10 + before;
            if(beforeNum >= 10 && beforeNum <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[len]);
    }
}
