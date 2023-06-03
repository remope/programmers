package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dpMax = new int[3];
        int[] dpMin = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int x3 = Integer.parseInt(st.nextToken());

        dpMax[0] = dpMin[0] = x1;
        dpMax[1] = dpMin[1] = x2;
        dpMax[2] = dpMin[2] = x3;

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            x3 = Integer.parseInt(st.nextToken());

            int beforeMax0 = dpMax[0];
            int beforeMax2 = dpMax[2];
            int beforeMin0 = dpMin[0];
            int beforeMin2 = dpMin[2];

            dpMax[0] = Math.max(dpMax[0], dpMax[1]) + x1;
            dpMax[2] = Math.max(dpMax[1], dpMax[2]) + x3;
            dpMax[1] = Math.max(Math.max(beforeMax0, dpMax[1]), beforeMax2) + x2;

            dpMin[0] = Math.min(dpMin[0], dpMin[1]) + x1;
            dpMin[2] = Math.min(dpMin[1], dpMin[2]) + x3;
            dpMin[1] = Math.min(Math.min(beforeMin0, dpMin[1]), beforeMin2) + x2;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(Math.max(Math.max(dpMax[0], dpMax[1]), dpMax[2])).append(' ');
        sb.append(Math.min(Math.min(dpMin[0], dpMin[1]), dpMin[2]));
        System.out.println(sb);


/*
        //슬라이딩 윈도우 기법 없이 그냥 푼 문제, 메모리 초과
        int n = Integer.parseInt(br.readLine());
        int[] move = {-1, 0, 1};

        int[][] dpMax = new int[n][n];
        int[][] dpMin = new int[n][n];
        int[][] score = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            dpMax[0][i] = dpMin[0][i] = score[0][i];
        }

        for (int i = 1; i < n; i++) {
            Arrays.fill(dpMin[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < n; j++) {

                for (int k = 0; k < 3; k++) {
                    int moveX = j + move[k];
                    if(moveX >= 0 && moveX < n){
                        dpMax[i][j] = Math.max(dpMax[i][j], score[i][j] + dpMax[i - 1][moveX]);
                        dpMin[i][j] = Math.min(dpMin[i][j], score[i][j] + dpMin[i - 1][moveX]);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, dpMin[n - 1][i]);
            max = Math.max(max, dpMax[n - 1][i]);
        }

        StringBuffer sb = new StringBuffer();
        sb.append(max).append(' ').append(min);

        System.out.println(sb);
*/
    }
}
