package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class B_1918 {
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String prefix = br.readLine();
        convert(prefix);

        System.out.println(sb);
    }

    public static void convert(String prefix){
        Map<Character, Integer> priority = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        priority.put('*', 2); priority.put('/', 2);
        priority.put('+', 1); priority.put('-', 1);
        priority.put('(', 0);
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                sb.append(c);
            }else if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                while(stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }else {
                if(stack.isEmpty() || priority.get(c) > priority.get(stack.peek())){
                    stack.push(c);
                }else{
                    while(!stack.isEmpty() && priority.get(c) <= priority.get(stack.peek())){
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
    }
}
