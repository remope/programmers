package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1541 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("-");

        int sum = 0;
        for (int i = 0; i < split.length; i++) {
            int temp = 0;

            String[] sumTarget = split[i].split("\\+");
            for (int j = 0; j < sumTarget.length; j++) {
                temp += Integer.parseInt(sumTarget[j]);
            }
            if(i == 0) {
                sum += temp;
            } else {
                sum -= temp;
            }
        }

        System.out.println(sum);


    }
}
