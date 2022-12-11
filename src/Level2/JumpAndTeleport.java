package Level2;

public class JumpAndTeleport {
/*
    //시간복잡도 O(n) -> 시간 초과 bottom - top
    public int solution(int n) {
        int[] ary = new int[n+1];
        if(n == 1 || n == 2) return 1;
        ary[1] = 1;
        ary[2] = 1;
        for(int i = 3; i <= n; i++){
            if(i % 2 == 0){
                ary[i] = Math.min(ary[i / 2], ary[i-1] + 1);
            }else{
                ary[i] = Math.min(ary[i - 1] + 1, ary[i / 2] + 1);
            }
        }
        return ary[n];
    }
*/
    public int solution(int n){
        int index = n;
        int ans = 0;
        while(index > 0){
            if(index % 2 == 0){
                index /= 2;
            }else{
                index -= 1;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        JumpAndTeleport jat = new JumpAndTeleport();
        System.out.println(jat.solution(5000));
    }
}
