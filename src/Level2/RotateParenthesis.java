package Level2;

import java.util.Stack;

public class RotateParenthesis {
    public int solution(String s) {
        int answer = 0;
        String nStr = s;
        int length = s.length();
        for(int i = 0; i < length; i++){
            if(checkParenthesis(nStr)){
                answer++;
            }
            nStr = nStr.substring(1, length) + nStr.charAt(0);
        }
        return answer;
    }

    public boolean checkParenthesis(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            try{
                switch (s.charAt(i)) {
                    case '[':
                        stack.add('[');
                        break;
                    case ']':
                        if (stack.peek() != '[') {
                            return false;
                        }
                        stack.pop();
                        break;
                    case '{':
                        stack.add('{');
                        break;
                    case '}':
                        if (stack.peek() != '{') {
                            return false;
                        }
                        stack.pop();
                        break;
                    case '(':
                        stack.add('(');
                        break;
                    case ')':
                        if (stack.peek() != '(') {
                            return false;
                        }
                        stack.pop();
                        break;
                }
            }
            catch (Exception e){
                return false;
            }

        }
        return stack.isEmpty()? true:false;
    }
}
