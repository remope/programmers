package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_9663 {

    public static int N;
    public static int[] ary;
    public static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = 0;
        ary = new int[N];

        nQ(0);
        System.out.println(count);

    }

    public static void nQ(int depth) {
        if(depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            ary[depth] = i;
            if(isPossible(depth)) {
                nQ(depth + 1);
            }
        }
    }

    public static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            if (ary[col] == ary[i]) {
                return false;
            }

            else if (Math.abs(col - i) == Math.abs(ary[col] - ary[i])) {
                return false;
            }
        }

        return true;
    }
}
