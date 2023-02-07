package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int people = 0;
        int out = 0;
        int in = 0;
        for(int i = 0; i < 4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            out = Integer.parseInt(st.nextToken());
            in = Integer.parseInt(st.nextToken());
            people = people + in - out;
            max = max > people ? max : people;
        }
        System.out.println(max);
    }
}
