package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1978 {
    public static void main(String[] args) throws IOException {
        B_1978 obj = new B_1978();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int count = 0;
        for(int i = 0; i < n; i++){
            int check = Integer.parseInt(st.nextToken());
            if(obj.isPrime(check)){
                count++;
            }
        }

        System.out.println(count);
    }

    boolean isPrime(int n){
        int a = (int) Math.sqrt(n);
        if(n == 1) return false;
        for(int i = 2; i <= a; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
