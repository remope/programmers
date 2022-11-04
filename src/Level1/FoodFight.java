package Level1;

public class FoodFight {
    public String solution(int[] food) {
        String answer = "";
        for(int i = 1; i < food.length; i++){
            for(int j = 0; j < food[i]/2; j++){
                answer += Integer.toString(i);
            }
        }
        StringBuffer sb = new StringBuffer(answer);
        answer += "0" + sb.reverse().toString();
        return answer;
    }
}
