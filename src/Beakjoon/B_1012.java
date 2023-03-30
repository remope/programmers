package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1012 {
    static int[][] ary;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int test = Integer.parseInt(st.nextToken());

        for(int i = 0; i < test; i++){
            st = new StringTokenizer(br.readLine(), " ");

            int maxCol = Integer.parseInt(st.nextToken());
            int maxRow = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int count = 0;

            ary = new int[maxRow][maxCol];
            for(int j = 0; j < num; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                ary[x][y] = 1;
            }
            for(int r = 0; r < maxRow; r++){
                for(int c = 0; c < maxCol; c++){
                    if(ary[r][c] == 1){
                        bfs(r, c, maxRow, maxCol);
                        count++;
                    }
                }
            }
            System.out.println(count);

        }

    }
    public static void bfs(int row, int col, int maxRow, int maxCol){
        Queue<Coordinate> queue = new LinkedList<>();
        ary[row][col] = 0;
        queue.add(new Coordinate(row, col));
        Coordinate[] move = new Coordinate[4];
        move[0] = new Coordinate(0, -1);
        move[1] = new Coordinate(1, 0);
        move[2] = new Coordinate(0, 1);
        move[3] = new Coordinate(-1, 0);
        while(!queue.isEmpty()){
            Coordinate before = queue.poll();
            for(int k = 0; k < 4; k++){
                int newX = before.x + move[k].x;
                int newY = before.y + move[k].y;
                if(newX >= 0 && newX < maxRow && newY >= 0 && newY < maxCol && ary[newX][newY] == 1){
                    ary[newX][newY] = 0;
                    queue.add(new Coordinate(newX, newY));
                }
            }
        }
    }
    public static class Coordinate{
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

