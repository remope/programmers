package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] pack = new int[m];
        int[] singles = new int[m];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            pack[i] = Integer.parseInt(st.nextToken());
            singles[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pack);
        Arrays.sort(singles);

        int price = 0;

        int set = n / 6;
        int single = n % 6;

        if(pack[0] > singles[0] * 6){
            price += singles[0] * 6 * set;
        }else{
            price += pack[0] * set;
        }

        if(pack[0] > singles[0] * single){
            price += singles[0] * single;
        }else{
            price += pack[0];
        }

        System.out.println(price);


    }
}
