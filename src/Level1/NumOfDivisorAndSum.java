package Level1;

public class NumOfDivisorAndSum {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            Double sqrt = Math.sqrt(i);
            if(sqrt == sqrt.intValue()){
                answer -= i;
            }else{
                answer += i;
            }
        }
        return answer;
    }
}
