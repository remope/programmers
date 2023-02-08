package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int count = 0;
        int save = 0;
        for(int i = 1; i <= num; i++){
            if(num % i == 0){
                count++;
                if(count == n){
                    save = i;
                    break;
                }
            }
        }

        System.out.println(save);
    }
}
