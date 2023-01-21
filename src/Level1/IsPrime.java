package Level1;

public class IsPrime {
    public int solution(int n) {
        int answer = 0;
        for(int i = 2; i < n+1; i++){
            answer+= isPrime(i);
        }
        return answer;
    }
    public int isPrime(int n){
        if(n <= 1) return -1;
        double sqrt = Math.sqrt(n);
        for(int i = 2; i <= sqrt; i++){
            if(n % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}
