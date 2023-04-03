package Beakjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11729 {
    public static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());

        sb.append((int) (Math.pow(2, n) - 1)).append("\n");
        hanoi(n, 1, 2, 3);
        System.out.println(sb);
    }

    public static void hanoi(int n, int start, int temp, int end){
        if(n == 1){
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }
        hanoi(n-1, start, end, temp);

        sb.append(start).append(" ").append(end).append("\n");

        hanoi(n - 1, temp, start, end);
    }
}
