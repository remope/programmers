package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());


        int[] ary = new int[k];

        long max = 0;

        for (int i = 0; i < k; i++) {
            ary[i] = Integer.parseInt(br.readLine());
            if(max < ary[i]){
                max = ary[i];
            }
        }

        max++;

        long mid = 0;
        long min = 0;

        while(min < max){
            mid = (min + max) / 2;

            long count = 0;

            for (int i = 0; i < k; i++) {
                count += (ary[i] / mid);
            }

            if(count < n) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
