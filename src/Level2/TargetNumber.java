package Level2;

public class TargetNumber {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,0,target);
        return answer;
    }
    public void dfs(int[] numbers, int depth, int target){
        if(depth == numbers.length){
            if(target == 0){
                answer++;
            }
        } else{
            dfs(numbers, depth + 1, target + numbers[depth]);
            dfs(numbers, depth + 1, target - numbers[depth]);
        }
    }
}
