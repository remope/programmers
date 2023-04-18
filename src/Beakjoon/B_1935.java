package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_1935 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        double[] values = new double[n];

        String cal = br.readLine();

        for (int i = 0; i < n; i++) {
            values[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < cal.length(); i++){
            char c = cal.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                stack.push(values[c - 'A']);
            }else{
                double right = stack.pop();
                double left = stack.pop();
                switch(c){
                    case '+':
                        stack.push(left + right);
                        break;
                    case '-':
                        stack.push(left - right);
                        break;
                    case '*':
                        stack.push(left * right);
                        break;
                    case '/':
                        stack.push(left / right);
                        break;
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
