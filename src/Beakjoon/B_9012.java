package Beakjoon;

import java.util.Scanner;
import java.util.Stack;

public class B_9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag = true;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            String paren = sc.next();
            flag = true;
            for(int j = 0; j < paren.length(); j++) {
                char c = paren.charAt(j);
                if(c == '('){
                    stack.push(c);
                }else if(c == ')'){
                    if(stack.isEmpty()){
                        flag = false;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty()){
                flag = false;
            }
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            stack.clear();
        }
    }
}
