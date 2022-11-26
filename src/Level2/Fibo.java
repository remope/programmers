package Level2;

public class Fibo {
    public int solution(int n) {
        int answer = 0;
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        int first = 1;
        int second = 0;
        for(int i = 2; i <= n; i++){
            answer = first + second;
            second = first;
            first = answer;
        }
        return answer % 1234567;
    }

    public int fibo(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        return fibo(n - 2) + fibo(n - 1);
    }
}
