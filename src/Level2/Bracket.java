package Level2;

import java.util.Stack;

public class Bracket {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
