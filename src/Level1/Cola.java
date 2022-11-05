package Level1;

public class Cola {
    public int solution(int a, int b, int n) {
        int answer = (n / a) * b;
        int mod = n % a + answer;
        while(mod >= a){
            answer += (mod / a) * b;
            mod = mod % a + (mod / a) * b;
        }

        return answer;
    }
}
