package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9251 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int length1 = s1.length();
        int length2 = s2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else if(dp[i - 1][j] >= dp[i][j - 1]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        System.out.println(dp[length1][length2]);

    }
}
