package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String channelStr = br.readLine();
        int channel = Integer.parseInt(channelStr);
        int n = Integer.parseInt(br.readLine());
        boolean[] error = new boolean[10];
        if(n != 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                error[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int clickButton = Math.abs(100 - channel);
        for (int i = 0; i < 1000000; i++) {
            String s = String.valueOf(i);
            int length = s.length();

            boolean hasError = false;
            for (int j = 0; j < length; j++) {
                if(error[s.charAt(j) - '0']){
                    hasError = true;
                    break;
                }
            }
            if(!hasError){
                int val = Math.abs(channel - i) + length;
                clickButton = Math.min(clickButton, val);
            }
        }
        System.out.println(clickButton);


    }
}

