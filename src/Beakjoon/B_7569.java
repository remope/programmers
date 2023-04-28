package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7569 {
    static int[][][] tomato;
    static int m, n, h;     // [n][m][h]
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        tomato = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < m; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if(tomato[i][j][k] == 1){
                        queue.add(new int[] {i, j, k});
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int z = poll[0];
            int x = poll[1];
            int y = poll[2];


            for (int i = 0; i < 6; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                int newZ = z + dz[i];

                if(newX < 0 || newX >= n || newY < 0 || newY >= m || newZ < 0 || newZ >= h){
                    continue;
                }
                if(tomato[newZ][newX][newY] == 0){
                    tomato[newZ][newX][newY] = tomato[z][x][y] + 1;
                    queue.add(new int[] {newZ, newX, newY});
                }
            }
        }

        if(isZero()){
            return -1;
        }

        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                for (int k = 0; k < m; k++) {
                    if(tomato[i][j][k] > max){
                        max = tomato[i][j][k];
                    }
                }
            }
        }
        return max - 1;
    }

    public static boolean isZero(){
        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                for (int k = 0; k < m; k++) {
                    if(tomato[i][j][k] == 0){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
