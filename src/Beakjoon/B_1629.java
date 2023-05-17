package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//자료형의 범위를 잘 생각하고 풀기...
public class B_1629 {
    public static long a, b, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(recPow(a, b));

    }

    public static long recPow(long a, long b){
        if(b == 1){
            return a % c;
        }else{
            long x = recPow(a, b/2);
            if(b % 2 == 0){
                return (x * x) % c;
            }else{
                return ((x * x) % c * a) % c;
            }
        }
    }


}
