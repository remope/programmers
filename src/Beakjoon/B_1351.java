package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_1351 {
    public static long n;
    public static int p, q;
    public static HashMap<Long, Long> map = new HashMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        System.out.println(dp(n));

    }

    public static long dp(long n){
        if(n == 0){
            return 1;
        }
        if(map.containsKey(n)) {
            return map.get(n);
        }

        long a = (long) Math.floor(n/p);
        long b = (long) Math.floor(n/q);

        map.put(n, dp(a) + dp(b));
        return map.get(n);
    }
}
