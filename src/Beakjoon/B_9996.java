package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class B_9996 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), "*");
        String left = st.nextToken();
        String right = st.nextToken();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if(left.length() + right.length() > input.length()){
                sb.append("NE").append('\n');
                continue;
            }
            String l = input.substring(0, left.length());
            String r = input.substring(input.length() - right.length(), input.length());

            if(l.equals(left) && r.equals(right)){
                sb.append("DA").append('\n');
            }else{
                sb.append("NE").append('\n');
            }
        }
        System.out.println(sb);
    }
}
