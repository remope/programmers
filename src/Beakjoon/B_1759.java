package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B_1759 {
    public static int L;
    public static int C;
    public static String[] chars;
    public static String password = "";
    public static int consonantCount = 0;   // 자음
    public static HashSet<String> consonant = new HashSet<>();
    public static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = br.readLine().split(" ");
        Arrays.sort(chars);

        consonant.add("a"); consonant.add("e"); consonant.add("i");
        consonant.add("o"); consonant.add("u");

        makePassword(0, 0);

        System.out.println(sb);

    }
    // 최소 한개의 모음과 두개의 자음
    public static void makePassword(int start, int depth) {
        if(depth == L) {
            if(consonantCount >= 1 && (depth - consonantCount) >= 2) {
                sb.append(password).append("\n");
            }
            return;
        }
        for(int i = start; i < chars.length; i++) {
            password += chars[i];
            if(consonant.contains(chars[i])) {
                consonantCount++;
            }
            makePassword(i + 1, depth + 1);
            password = password.substring(0, password.length() - 1);
            if(consonant.contains(chars[i])) {
                consonantCount--;
            }
        }
    }
}
