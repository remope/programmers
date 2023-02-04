package Beakjoon;

import java.util.Scanner;

public class B_2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = 0;
        int end = 0;
        int answer = 1;
        int sum = 0;
        while(end < n){
            if(sum == n){
                answer++;
                end++;
                sum += end;
            }else if(sum < n){
                end++;
                sum+=end;
            }else if(sum > n){
                sum -= start;
                start++;
            }
        }
        System.out.println(answer);
    }
}
