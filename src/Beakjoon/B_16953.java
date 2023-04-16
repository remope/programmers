package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[] {n, 0});
        boolean flag = false;
        long count = 0;
        while(!queue.isEmpty()){
            long[] poll = queue.poll();
            long num = poll[0];
            count = poll[1];
            if(num == m){
                flag = true;
                count++;
                break;
            }else{
                if(num * 2 <= m){
                    queue.add(new long[] {num * 2, count + 1});
                }
                if(num * 10 + 1 <= m){
                    queue.add(new long[] {num * 10 + 1, count + 1});
                }
            }
        }
        if(flag)
            System.out.println(count);
        else
            System.out.println(-1);
    }
}
