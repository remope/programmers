package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class B_1793 {
    public static void main(String[] args) throws IOException {
        BigInteger[] dp = new BigInteger[251];

        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");

        for (int i = 3; i < 251; i++) {
            dp[i] = dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));
        }


        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            System.out.println(dp[sc.nextInt()]);
        }
    }
}
