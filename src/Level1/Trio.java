package Level1;

public class Trio {
    public int solution(int[] number) {
        int answer = 0;
        int length = number.length;
        for(int i = 0; i < length - 2; i++){
            for(int j = i + 1; j < length - 1; j++){
                int duo = number[i] + number[j];
                for(int k = j + 1; k < length; k++){
                    if(duo + number[k] == 0) answer++;
                }
            }
        }
        return answer;
    }
}
