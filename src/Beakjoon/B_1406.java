package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }
        
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char command = st.nextToken().charAt(0);
            if (command == 'L') {
                if(!left.isEmpty()){
                    right.push(left.pop());
                }
            } else if (command == 'D') {
                if(!right.isEmpty()){
                    left.push(right.pop());
                }
            } else if (command == 'B') {
                if(!left.isEmpty()){
                    left.pop();
                }
            } else if (command == 'P') {
                char addChar = st.nextToken().charAt(0);
                left.push(addChar);
            }

        }
        StringBuffer sb = new StringBuffer();
        while(!left.isEmpty()){
            right.push(left.pop());
        }
        while(!right.isEmpty()){
            sb.append(right.pop());
        }
        System.out.println(sb);

        /*
        //시간초과
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char command = st.nextToken().charAt(0);
            if(command == 'L'){
                if(cursor != 0){
                    cursor -= 1;
                }
            }else if(command == 'D'){
                if(cursor < str.length()){
                    cursor++;
                }
            }else if(command == 'B'){
                if(cursor != 0){
                    str = str.substring(0, cursor - 1) + str.substring(cursor);
                    cursor--;
                }
            }else if(command == 'P'){
                char addChar = st.nextToken().charAt(0);
                str = str.substring(0, cursor) + addChar + str.substring(cursor);
                if(cursor < str.length()){
                    cursor++;
                }
            }
        }
*/
    }
}
