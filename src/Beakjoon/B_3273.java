package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_3273 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] ary = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());
        int left = 0, right = n - 1;
        int res = 0;
        Arrays.sort(ary);

        while(left < right){
            int sum = ary[left] + ary[right];
            if(sum == x) {
                res++;
                left++;
                right--;
            }else if(sum > x) {
                right--;
            }else {
                left++;
            }
        }

        System.out.println(res);
    }
}
