package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());
        int count = 0;

        int[] token = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            token[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = n - 1; i >= 0; i--){
            count += (int) value / token[i];
            value %= token[i];
        }

        System.out.println(count);
    }
}
