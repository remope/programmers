package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7576 {
    static int[][] tomato;
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        tomato = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j] == 1){
                    queue.add(new int[] {i, j});
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int[] coord = queue.poll();
            int x = coord[0];
            int y = coord[1];

            for(int i = 0; i < 4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX < 0 || newX >= n || newY < 0 || newY >= m){
                    continue;
                }
                if(tomato[newX][newY] == 0){
                    tomato[newX][newY] = tomato[x][y] + 1;
                    queue.add(new int[] {newX, newY});
                }
            }
        }

        if(isZero()){
            return -1;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(tomato[i][j] > max){
                    max = tomato[i][j];
                }
            }
        }
        return max - 1;
    }

    public static boolean isZero(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(tomato[i][j] == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
