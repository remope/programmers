package Level1;

public class SmallerSubstring {
    public int solution(String t, String p) {
        int answer = 0;
        long smallerThan = Long.parseLong(p);
        int length = t.length() - p.length() + 1;
        for(int i = 0; i < length; i++){
            long num = Long.parseLong(t.substring(i, i + p.length()));
            if(num <= smallerThan){
                answer++;
            }
        }
        return answer;
    }
}
