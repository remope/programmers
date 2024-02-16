package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] potions = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            potions[i] = Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = n - 1;
        long sum = 0;
        long min = Long.MAX_VALUE;
        int minLeft = left;
        int minRight = right;

        for (int i = 0; i < n; i++) {

        }

        while(right > left) {
            sum = potions[left] + potions[right];
            if(min > Math.abs(sum)) {
                min = Math.abs(sum);
                minLeft = left;
                minRight = right;
            }

            if(sum >= 0) {
                right--;
            }else if(sum < 0) {
                left++;
            }
        }

        System.out.println(potions[minLeft] + " " + potions[minRight]);
    }
}
