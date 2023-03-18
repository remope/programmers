package Beakjoon;

import java.util.Scanner;
import java.util.Stack;

public class B_4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        while(true){
            s = sc.nextLine();

            if(s.equals(".")){
                break;
            }
            System.out.println(answer(s));
        }
    }

    public static String answer(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '(' || c == '['){
                stack.push(c);
            } else if(c == ')'){
                if(stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                }else{
                    stack.pop();
                }
            } else if(c == ']'){
                if(stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            return "yes";
        }else{
            return "no";
        }
    }
}
