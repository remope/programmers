package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = per(x, y);

        int res = -1;
        int left = 0;
        int right = (int) 1e9;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (per(x + mid, y + mid) != z) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(res);
    }

    static int per(int x, int y) {
        return (int) ((long) y * 100 / x);
    }
}
