package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int testCases = Integer.parseInt(st.nextToken());

        for(int i = 0; i < testCases; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int mod = a % 10;
            for(int j = 0; j < b - 1; j++){
                mod = (a * mod) % 10;
            }
            if(mod == 0){
                mod = 10;
            }
            System.out.println(mod);
        }

    }
}
