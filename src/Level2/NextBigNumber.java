package Level2;

public class NextBigNumber {
    public int solution(int n) {
        int answer = 0;
        int cur = numOne(n);
        int next = 0;
        while(true) {
            next = numOne(++n);
            if(cur == next) break;
        }
        answer = n;
        return answer;
    }

    public int numOne(int n){
        int oneNum = 1;
        while(n > 1) {
            if(n % 2 == 1) {
                oneNum++;
            }
            n /= 2;
        }
        return oneNum;
    }
}
