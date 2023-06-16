package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B_2346 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<int[]> deq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] ary = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        StringBuffer sb = new StringBuffer();
        sb.append(1).append(' ');

        int input = ary[0];

        for (int i = 1; i < n; i++) {
            deq.add(new int[] {(i + 1), ary[i]});
        }

        while(!deq.isEmpty()){
            if(input > 0){
                for (int i = 1; i < input; i++){
                    deq.add(deq.poll());
                }
                int[] next = deq.poll();
                input = next[1];
                sb.append(next[0]).append(' ');
            }
            else {
                for(int i=1; i <- input; i++) {
                    deq.addFirst(deq.pollLast());
                }

                int[] next = deq.pollLast();
                input = next[1];
                sb.append(next[0] + " ");
            }
        }

        System.out.println(sb);

    }
}
