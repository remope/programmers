package Level1;

import java.util.Stack;

public class HateSameNumber {
    public int[] solution(int []arr) {
        int index = 1;
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(stack.peek() != arr[i]){
                stack.add(arr[i]);
                index++;
            }
        }
        int[] answer = new int[index];
        for(int i = index - 1; i >= 0; i--){
            answer[i] = stack.pop();
        }
        return answer;
    }

    public static void main(String[] args) {
        HateSameNumber hs = new HateSameNumber();
        System.out.println(hs.solution(new int[] {1, 1, 3, 3, 0, 1, 1}));
    }
}
