package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int data = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        int[] ary = new int[data + 1];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i <= data; i++){
            ary[i] = ary[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine(), " ");

            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            System.out.println(ary[right] - ary[left - 1]);
        }
    }
}
