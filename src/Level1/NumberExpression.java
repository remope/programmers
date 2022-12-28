package Level1;

public class NumberExpression {
    public int solution(int n) {
        int answer = 0;
        int temp = 0;
        for(int i = 1; i <= n; i++){
            temp = i;
            for(int j = i + 1; j <= n; j++){
                temp += j;
                if(temp >= n){
                    break;
                }
            }
            if(temp == n){
                answer++;
            }
        }
        return answer;
    }
}
