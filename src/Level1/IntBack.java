package Level1;

public class IntBack {
    public int[] solution(long n) {
        String str = Long.toString(n);
        int length = str.length();
        int[] answer = new int[length];
        for(int i = length-1; i >= 0; i--){
            answer[length - i - 1] = str.charAt(i) - '0';
        }
        return answer;
    }
}
