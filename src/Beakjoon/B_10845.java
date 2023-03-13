package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 직접 구현한 큐
public class B_10845 {
    static int front = 0;
    static int rear = 0;
    static int[] queue = new int[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(st.nextToken());


        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()){
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);

    }
    public static void push(int n){
        queue[rear] = n;
        rear++;
    }

    public static int pop(){
        if(front == rear){
            return -1;
        } else{
            int result = queue[front];
            front++;
            return result;
        }
    }

    public static int size(){
        return rear - front;
    }

    public static int empty(){
        if(front == rear){
            return 1;
        } else{
            return 0;
        }
    }

    public static int front(){
        if(front == rear){
            return -1;
        } else{
            return queue[front];
        }
    }

    public static int back(){
        if(front == rear){
            return -1;
        } else{
            return queue[rear - 1];
        }
    }
}
