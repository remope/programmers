package Beakjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B_1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] strAry = new String[n];

        for(int i = 0; i < n; i++){
            strAry[i] = sc.next();
        }

        Arrays.sort(strAry, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                else {
                    return s1.length() - s2.length();
                }
            }
        });

        StringBuilder sb = new StringBuilder();

        sb.append(strAry[0]).append("\n");
        for(int i = 1; i < n; i++){
            if(!strAry[i].equals(strAry[i-1])){
                sb.append(strAry[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
