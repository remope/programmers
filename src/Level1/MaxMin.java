package Level1;

public class MaxMin {
    public int[] solution(int n, int m) {
        int max = Math.max(n,m);
        int min = Math.min(n,m);
        while(min != 0){
            int remain = max % min;
            max = min;
            min = remain;
        }

        int gcd = n * m / max;

        int[] answer = {max, gcd};
        return answer;
    }
}
