package Beakjoon;

import java.util.Scanner;

public class B_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        String nNum = sc.next();

        int answer = 0;

        char[] charNums = nNum.toCharArray();

        for(char c: charNums){
            answer += c - '0';
        }
        System.out.println(answer);
    }
}
