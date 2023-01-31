package Level2;

public class NLCM {
    public int solution(int[] arr) {
        int answer = 0;

        if(arr.length == 1){
            return arr[0];
        }

        int gcd = gcd(arr[0], arr[1]);
        answer = (arr[0] * arr[1]) / gcd;

        for(int i = 2; i < arr.length; i++) {
            gcd = gcd(answer, arr[i]);
            answer = (answer * arr[i]) / gcd;
        }

        return answer;
    }

    public int gcd(int a, int b) {
        int r = a % b;
        if(r == 0) return b;
        else return gcd(b, r);
    }
}
