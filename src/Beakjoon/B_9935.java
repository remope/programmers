package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();
        int len = target.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            stack.push(str.charAt(i));

            if(stack.size() >= len){
                boolean isContain = true;
                for(int j = 0; j < len; j++) {
                    if(stack.get(stack.size() - len + j) != target.charAt(j)) {
                        isContain = false;
                        break;
                    }
                }
                if(isContain) {
                    for(int j = 0; j < len; j++) {
                        stack.pop();
                    }
                }

            }
            
        }

        StringBuffer sb = new StringBuffer();
        for(Character c : stack) {
            sb.append(c);
        }
        System.out.println(sb.length()==0? "FRULA" : sb);
    }


    /*
    //메모리 초과
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();
        int len = target.length();
        while(str.contains(target)){
            int targetIdx = str.indexOf(target);
            String temp1 = str.substring(0, targetIdx);
            String temp2 = str.substring(targetIdx + len);
            str = str.substring(0, targetIdx) + str.substring(targetIdx + len);
        }

        str = str.length() == 0 ? "FRULA" : str;
        System.out.println(str);
    }
    */


}
