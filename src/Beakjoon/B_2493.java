package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<TowerVal> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            if(stack.isEmpty()){
                sb.append("0").append(' ');
                stack.push(new TowerVal(height, i));
            }else{
                while(true){
                    if(stack.isEmpty()){
                        sb.append("0").append(' ');
                        stack.push(new TowerVal(height, i));
                        break;
                    }
                    TowerVal peek = stack.peek();
                    if(peek.height > height){
                        sb.append(peek.num).append(" ");
                        stack.push(new TowerVal(height, i));
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }



        }
        System.out.println(sb);
    }

    public static class TowerVal{
        int height;
        int num;

        public TowerVal(int height, int num) {
            this.height = height;
            this.num = num;
        }
    }
    /*
    //첫 풀이, 메모리 초과
    public static Stack<Integer> result = new Stack<>();
    public static Stack<TowerVal> temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<TowerVal> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            stack.add(new TowerVal(Integer.parseInt(st.nextToken()), i + 1));
        }

        for (int i = 0; i < n; i++) {
            get(stack.pop(), stack);
        }
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; i++) {
            sb.append(result.pop()).append(' ');
        }
        System.out.println(sb);

    }
    public static void get(TowerVal a, Stack<TowerVal> tower){
        temp = new Stack<>();
        temp.addAll(tower);
        while(!temp.isEmpty()){
            TowerVal pop = temp.pop();
            if(a.height < pop.height){
                result.push(pop.num);
                return;
            }
        }
        result.push(0);
    }
    public static class TowerVal{
        int height;
        int num;

        public TowerVal(int height, int num) {
            this.height = height;
            this.num = num;
        }
    }
    */
}
