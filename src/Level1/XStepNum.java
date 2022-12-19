package Level1;

public class XStepNum {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i = 0; i < n; i++){
//            answer[i] = x * (i + 1);  //오버플로우 발생, int 자료형을 long 자료형으로 형변환 시킴.
            answer[i] = ((long)x * (long)(i + 1));
        }
        return answer;
    }
}
