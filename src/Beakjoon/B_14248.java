package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_14248 {
    public static int n;
    public static int[] check, map;
    public static int[] dir = {-1, 1};
    public static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n];
        check = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int start = Integer.parseInt(br.readLine());
        System.out.println(bfs(start - 1));

    }

    public static int bfs(int start){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        check[start] = 1;

        while(!queue.isEmpty()){
            int node = queue.poll();
            int depth = map[node];
            for(int d : dir){
                int direction = (d * depth) + node;
                if(direction >= 0 && direction < n && check[direction] == 0){
                    check[direction] = 1;
                    queue.add(direction);
                    count++;
                }
            }
        }
        return count;
    }
}
