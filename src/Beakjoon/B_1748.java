package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1748 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        int num = 1;
        int digit = 10;

        for (int i = 1; i <= n; i++) {
            if (i % digit == 0) {
                num += 1;
                digit *= 10;
            }
            result += num;
        }

        System.out.println(result);
    }
}
