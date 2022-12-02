package Level2;

import java.util.Arrays;

public class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int index = 0;
        Arrays.sort(people);
        for(int i = people.length - 1; i >= index; i--){
            if(people[i] + people[index] <= limit){
                index++;
                answer++;
            }else{
                answer++;
            }
        }
        return answer;
    }
}
