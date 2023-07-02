package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1890 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][n+1];
        dp[1][1] = 1;

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= n; j++){
                int move = Integer.parseInt(st.nextToken());

                if(dp[i][j] >= 1 && move != 0) {
                    if (j + move <= n)
                        dp[i][j + move] += dp[i][j];

                    if (i + move <= n)
                        dp[i + move][j] += dp[i][j];
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append(dp[n][n]);

        System.out.println(sb);

    }
    /*
    //그래프 탐색으로 풀면 메모리 초과 발생, dp 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dx = {1, 0};
        int[] dy = {0, 1};
        int count = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int move = map[poll[0]][poll[1]];
            for (int i = 0; i < 2; i++) {
                int nx = poll[0] + move * dx[i];
                int ny = poll[1] + move * dy[i];

                if(nx == n - 1 && ny == n - 1){
                    count++;
                }else if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        System.out.println(count);
    }
    */
}
