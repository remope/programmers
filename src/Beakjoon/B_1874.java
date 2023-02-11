package Beakjoon;

import java.util.Scanner;
import java.util.Stack;

public class B_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ary = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            ary[i] = sc.nextInt();
        }
        StringBuffer bf = new StringBuffer();

        int idx = 1;
        boolean result = true;
        for(int i = 0; i < ary.length; i++){
            int aryNum = ary[i];
            if(aryNum >= idx){
                while(aryNum >= idx){
                    stack.push(idx++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }
            else{
                int num = stack.pop();
                if(num > aryNum){
                    System.out.println("NO");
                    result = false;
                    break;
                }else{
                    bf.append("-\n");
                }
            }
        }
        if(result){
            System.out.println(bf.toString());
        }

    }
}
