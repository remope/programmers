package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class B_5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            boolean errFlag = false;
            boolean isReverse = false;
            Deque<Integer> deq = new ArrayDeque<>();
            String command = br.readLine();
            int length = Integer.parseInt(br.readLine());

            String ary = br.readLine();
            ary = ary.substring(1, ary.length() - 1);
            StringTokenizer st = new StringTokenizer(br.readLine().replace("[", "").replace("]", ""), ",");
            for (int j = 0; j < length; j++) {
                deq.add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < command.length(); j++) {
                if(command.charAt(j) == 'D'){
                    Integer poll;
                    if(isReverse){
                        poll = deq.pollLast();
                    }else{
                        poll = deq.pollFirst();
                    }
                    if(poll == null){
                        sb.append("error\n");
                        errFlag = true;
                        break;
                    }

                }else if(command.charAt(j) == 'R'){
                    isReverse = !isReverse;
                }
            }
            if(!errFlag){
                sb.append('[');
                while(!deq.isEmpty()){
                    if(isReverse) sb.append(deq.pollLast());
                    else sb.append(deq.pollFirst());
                    if(!deq.isEmpty()) sb.append(',');
                }
                sb.append(']').append('\n');
            }


        }
        System.out.println(sb);

    }
}
