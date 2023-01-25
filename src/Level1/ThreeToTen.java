package Level1;

import java.util.ArrayList;
import java.util.List;

public class ThreeToTen {
    public int solution(int n) {
        int answer = 0;
        int mod = n;

        List<Integer> ternary = new ArrayList<>();

        while(mod != 0){
            ternary.add(mod % 3);
            mod /= 3;
        }

        int count = ternary.size() - 1;
        for(int i: ternary){
            answer += (int) (i * Math.pow(3, count--));
        }


        return answer;
    }
}
