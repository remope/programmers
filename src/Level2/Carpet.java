package Level2;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown + yellow;
        int row = 0, col = 0;
        for(int i = 3; i <= total/3; i++){
            if(total % i == 0){
                row = total / i;
                col = i;
                if((row + col) * 2 - 4 == brown){
                    break;
                }
            }
        }
        return new int[] {row, col};
    }

    public static void main(String[] args) {
        Carpet car = new Carpet();
        int[] ary = car.solution(24,24);
        System.out.println(ary[0] + " " + ary[1]);
    }
}
