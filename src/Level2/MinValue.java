package Level2;

import java.util.Arrays;

public class MinValue {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int bIndex = B.length - 1;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < A.length; i++){
            answer += A[i]*B[bIndex - i];
        }
        return answer;
    }
}
