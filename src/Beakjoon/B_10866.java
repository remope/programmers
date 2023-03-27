package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B_10866 {
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            switch(s){
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    Integer popFront = deque.pollFirst();
                    if(popFront != null){
                        System.out.println(popFront);
                    }else{
                        System.out.println(-1);
                    }
                    break;
                case "pop_back":
                    Integer popBack = deque.pollLast();
                    if(popBack != null){
                        System.out.println(popBack);
                    }else{
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if(deque.isEmpty()){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case "front":
                    Integer front = deque.peekFirst();
                    if(front != null){
                        System.out.println(front);
                    }else {
                        System.out.println(-1);
                    }
                    break;
                case "back":
                    Integer back = deque.peekLast();
                    if(back != null){
                        System.out.println(back);
                    }else {
                        System.out.println(-1);
                    }
                    break;
            }
        }

    }
}
