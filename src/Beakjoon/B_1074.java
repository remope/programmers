package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1074 {
    public static int res = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        result((int)Math.pow(2, n), r, c);

        System.out.println(res);
    }

    public static void result(int size, int r, int c){
        if(size == 0){
            return;
        }

        if(r < size / 2 && c < size / 2){
            result(size / 2, r, c);
        }else if(r < size / 2 && c >= size / 2){
            res += size * size / 4;
            result(size / 2, r, c - size / 2);
        }else if(r >= size / 2 && c < size / 2){
            res += (size * size / 4) * 2;
            result(size / 2, r - size / 2, c);
        }else{
            res += (size * size / 4) * 3;
            result(size / 2, r - size / 2, c - size / 2);
        }


    }
}
