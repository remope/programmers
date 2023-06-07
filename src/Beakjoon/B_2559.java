package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2559 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] ary = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        int lPoint = 0;
        int rPoint = lPoint + k - 1;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = lPoint; i <= rPoint; i++) {
            sum += ary[i];
        }
        max = Math.max(max, sum);
        while(rPoint < n - 1){
            sum -= ary[lPoint];
            lPoint++;
            rPoint++;
            sum += ary[rPoint];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
