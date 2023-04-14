package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2178 {
    static int[][] maze;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();

            for (int j = 0; j < s.length(); j++) {
                maze[i][j] = s.charAt(j) - '0';
                if(maze[i][j] == 0){
                    visit[i][j] = true;
                }
            }
        }

        System.out.println(bfs());


    }
    public static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 0});
        while(true){
            int[] before = queue.poll();
            int x = before[0];
            int y = before[1];
            int count = before[2] + 1;
            if(x == n - 1 && y == m - 1){
                return count;
            }
            for(int i = 0; i < 4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX >= 0 && newX < n && newY >= 0 && newY < m && !visit[newX][newY]){
                    visit[newX][newY] = true;
                    queue.add(new int[] {newX, newY, count});
                }
            }
        }
    }
}
