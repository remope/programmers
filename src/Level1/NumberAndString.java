package Level1;

import java.util.HashMap;

public class NumberAndString {
    public int solution(String s) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("zero", 0); map.put("one", 1); map.put("two", 2); map.put("three", 3); map.put("four", 4);
        map.put("five", 5); map.put("six", 6); map.put("seven", 7); map.put("eight", 8); map.put("nine", 9);
        String tempStr = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                answer = answer * 10 + Integer.parseInt(s.substring(i, i+1));
            }else{
                tempStr += s.substring(i, i+1);
                if(map.get(tempStr) != null){
                    answer = answer * 10 + map.get(tempStr);
                    tempStr = "";
                }
            }
        }
        return answer;
    }
}
