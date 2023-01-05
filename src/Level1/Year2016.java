package Level1;

import java.util.HashMap;
import java.util.Map;

public class Year2016 {
    public String solution(int a, int b) {
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        /*
        Map<Integer, String> days = new HashMap<>();
        days.put(1, "FRI"); days.put(2, "SAT"); days.put(3, "SUN"); days.put(4, "MON");
        days.put(5, "TUE"); days.put(6, "WED"); days.put(0, "THU");
        */
        String[] days = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" };
        int totalDays = 0;
        for(int i = 0; i < a - 1; i++){
            totalDays += month[i];
        }
        totalDays += b;
        totalDays %= 7;

        return days[totalDays];
    }
}
