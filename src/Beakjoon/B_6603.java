package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_6603 {
    public static int k;
    public static int[] lotto;
    public static boolean[] visited;
    public static int[] result;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
            if(k == 0) {
                break;
            }

            lotto = new int[k];
            visited = new boolean[k];
            result = new int[6];

            for (int i = 0; i < k; i++) {
                lotto[i] = Integer.parseInt(st.nextToken());
            }

            backTracking(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);

    }
    public static void backTracking(int start, int depth) {
        if(depth == 6) {
            for (int num : result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < k; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = lotto[i];
                backTracking(i, depth + 1);
                visited[i] = false;
            }
        }
    }
}
