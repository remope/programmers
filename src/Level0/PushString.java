package Level0;

public class PushString {
    public int solution(String A, String B) {
        String mult = B + B;

        int answer = mult.indexOf(A);
        return answer;
    }
}
