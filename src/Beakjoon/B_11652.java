package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B_11652 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        long result = 0;

        for(long x: map.keySet()){
            if(map.get(x) > max) {
                max = map.get(x);
                result = x;
            } else if(map.get(x) == max) {
                result = Math.min(result, x);
            }
        }

        System.out.println(result);

    }
}
