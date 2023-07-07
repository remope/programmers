package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_10610 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        long sum = 0;
        int[] numCount = new int[10];
        for(int i=0; i < num.length(); i++) {
            int digit = Integer.parseInt(num.substring(i, i+1));
            numCount[digit] += 1;
            sum += digit;
        }

        if(!num.contains("0") || sum % 3 != 0) {
            System.out.println("-1");
            return;
        }

        StringBuffer sb = new StringBuffer();

        for(int i = 9; i >= 0; i--) {
            for (int j = 0; j < numCount[i]; j++) {
                sb.append(i);
            }
        }
        System.out.println(sb);
    }
}
