package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_14888 {
    public static int N;
    public static int[] nums;
    public static int[] op = new int[4];
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 전체 수의 개수 N 입력
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        // N개의 수를 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자의 등장 개수를 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(nums[0], 1);
        sb.append(max).append("\n").append(min);
        System.out.println(sb);

    }

    public static void backTracking(int value, int index) {
        if (index == N) {
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }


        for (int j = 0; j < 4; j++) {
            if(op[j] == 0) {
                continue;
            }
            op[j]--;
            switch(j){
                case 0:
                    backTracking(value + nums[index], index + 1);
                    break;
                case 1:
                    backTracking(value - nums[index], index + 1);
                    break;
                case 2:
                    backTracking(value * nums[index], index + 1);
                    break;
                case 3:
                    backTracking(value / nums[index], index + 1);
                    break;
            }
            op[j]++;
        }

    }
}
