package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[][] point = new int[4][2];

        point[0][0] = Integer.parseInt(st.nextToken());
        point[0][1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        point[1][0] = Integer.parseInt(st.nextToken());
        point[1][1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        point[2][0] = Integer.parseInt(st.nextToken());
        point[2][1] = Integer.parseInt(st.nextToken());

        int xSum = point[0][0] + point[1][0];
        int ySum = point[0][1] + point[1][1];
        if((double) xSum/2 != (double) point[0][0]){
            point[3][0] = xSum - point[2][0];
        }else{
            point[3][0] = point[2][0];
        }

        if((double) ySum/2 != (double) point[0][1]){
            point[3][1] = ySum - point[2][1];
        }else{
            point[3][1] = point[2][1];
        }

        System.out.printf("%d %d", point[3][0], point[3][1]);

    }
}
