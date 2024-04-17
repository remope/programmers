package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] potion = new int[N];

        for (int i = 0; i < N; i++) {
            potion[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(potion);

        int right = N - 1;
        int minLeft = 0;
        int minRight = N - 1;
        int min = Integer.MAX_VALUE;

        for(int left = 0; left < N; left++) {
            while(left < right) {
                int sum = potion[left] + potion[right];
                if(Math.abs(sum) < min) {
                    minLeft = left;
                    minRight = right;
                    min = Math.abs(sum);
                }

                if(sum > 0) {
                    right--;
                }else {
                    left++;
                }
            }
        }
        System.out.println(potion[minLeft] + " " + potion[minRight]);
    }
}
