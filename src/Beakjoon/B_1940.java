package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] ary = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            ary[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ary);
        int answer = 0;
        int start = 0; int end = n - 1;
        while(start < end){
            if(ary[start] + ary[end] == m){
                answer++;
                start++;
                end--;
            }else if(ary[start] + ary[end] < m){
                start++;
            }else if(ary[start] + ary[end] > m){
                end--;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
