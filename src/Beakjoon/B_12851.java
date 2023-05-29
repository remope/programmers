package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_12851 {
    public static int n, k;
    public static int[] time = new int[100001];
    public static int minTime = Integer.MAX_VALUE;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            System.out.println((n-k) + "\n1");
            return;
        }


        bfs();

        StringBuffer sb = new StringBuffer();
        sb.append(minTime).append('\n').append(count);

        System.out.println(sb);
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        time[n] = 1;
        q.add(n);

        while(!q.isEmpty()){
            Integer poll = q.poll();

            if(minTime < time[poll]){
                return;
            }
            for (int i = 0; i < 3; i++) {
                int next = 0;

                if(i == 0){
                    next = poll + 1;
                }else if(i == 1){
                    next = poll - 1;
                }else if(i == 2){
                    next = poll * 2;
                }

                if(next < 0 || next > 100000){
                    continue;
                }
                if(next == k){
                    count++;
                    minTime = time[poll];
                }

                if(time[next] == 0 || time[next] == time[poll] + 1){
                    q.add(next);
                    time[next] = time[poll] + 1;
                }
            }
        }
    }
}
