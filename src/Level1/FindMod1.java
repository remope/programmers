package Level1;

public class FindMod1 {
    public int solution(int n) {
        int answer = 2;
        while(true){
            if(n % answer == 1) break;
            else answer++;
        }
        return answer;
    }
}
