package Beakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        char[] chars = s.toCharArray();

        Arrays.sort(chars);

        StringBuilder answer = new StringBuilder(new String(chars));

        System.out.println(answer.reverse());

    }
}
