package Level1;

public class Harshard {
    public boolean solution(int x) {
        boolean answer = true;
        int digit = 0;
        int temp = x;
        while(temp > 0){
            digit += temp % 10;
            temp /= 10;
        }
        return x % digit == 0;
    }
}
