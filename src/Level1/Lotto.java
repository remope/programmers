package Level1;

public class Lotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        int num = 0;
        int zeroNum = 0;
        for(int lotto: lottos){
            if(lotto == 0){
                zeroNum++;
                continue;
            }
            for(int win_num: win_nums){
                if(win_num == lotto){
                    num++;
                    break;
                }
            }
        }
        return new int[]{7-Math.max(num+zeroNum, 1), 7-Math.max(num,1)};
    }
}
