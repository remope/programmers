package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_2504 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        boolean flag = true;
        int answer = 0;
        int cnt = 1;
        int length = s.length();
        for(int i = 0; i < length; i++){
            char cur = s.charAt(i);
            if(cur == '('){
                stack.push(cur);
                cnt *= 2;
            }else if(cur == '['){
                stack.push(cur);
                cnt *= 3;
            }else{
                if(cur == ')') {
                    if(stack.isEmpty() || stack.peek() != '(') {
                        flag = false;
                        break;
                    }
                    if(s.charAt(i - 1) =='(') {
                        answer += cnt;
                    }
                    stack.pop();
                    cnt /= 2;
                }else if(cur == ']') {
                    if(stack.isEmpty() || stack.peek() != '[') {
                        flag = false;
                        break;
                    }
                    if(s.charAt(i-1) == '[') {
                        answer += cnt;
                    }
                    stack.pop();
                    cnt /= 3;
                }
                else {
                    flag = false;
                    break;
                }
            }
        }
        if(!flag || !stack.isEmpty()) {
            answer = 0;
        }
        System.out.println(answer);
    }
}
