package Level1;

public class InsufficientAmountCalc {
    public long solution(int price, int money, int count) {
        long answer = 0;
        int sumPrice = price;
        for(int i = 0; i < count; i++){
            answer += price;
            price += sumPrice;
        }
        return answer - money > 0 ? answer - money : 0;
    }
}
