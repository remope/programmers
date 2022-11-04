package Level1;

import java.util.Stack;

/**
 * 아직 풀지 못한 문제들이나 현재 풀고 있는 문제들의 코드들 작성
 * Solution 외 Java Class에는 풀이가 완료된 코드들 이동
 */
public class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int bread2, vegetable, meat, bread1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < ingredient.length; i++){
            stack.push(ingredient[i]);
            if(stack.size() > 4) {
                bread2 = stack.pop();
                vegetable = stack.pop();
                meat = stack.pop();
                bread1 = stack.pop();

                if (bread2 == 1 && vegetable == 3 && meat == 2 && bread1 == 1) {
                    answer++;
                } else {
                    stack.push(bread1);
                    stack.push(meat);
                    stack.push(vegetable);
                    stack.push(bread2);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
