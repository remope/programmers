package Level0;

public class Num7 {
    public int solution(int[] array) {
        int answer = 0;
        for(int i: array){
            String str = Integer.toString(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '7') {
                    answer++;
                }
            }
        }
        return answer;
    }
}
