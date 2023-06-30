package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1926 {
    public static int n, m;
    public static int[][] image;
    public static boolean[][] visited;
    public static int count = 0, max = Integer.MIN_VALUE;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        image = new int[n][m];
        visited = new boolean[n][m];



        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                image[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(image[i][j] == 1){
                    image[i][j] = 0;
                    count++;
                    bfs(i, j);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        if(max == Integer.MIN_VALUE){
            //예외처리 고려하기
            max = 0;
        }
        sb.append(count).append('\n').append(max);
        System.out.println(sb);
    }
    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int size = 1;
        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && image[nx][ny] == 1){
                    image[nx][ny] = 0;
                    size++;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        max = Math.max(max, size);

    }
}
