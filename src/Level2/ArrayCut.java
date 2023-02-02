package Level2;

public class ArrayCut {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        for (int i = 0; i < answer.length; i++) {
            int y = (int)(left / n);
            int x = (int)(left++ % n);
            answer[i] = Math.max(y + 1, x + 1);
        }

        return answer;
    }

/*
    //시간 초과 코드
    public int[] solution(int n, long left, long right) {

        int[] answer = new int[(int) (right - left + 1)];
        int[][] ary = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                ary[j][i] = i + 1;
            }
            for(int j = 0; j < i; j++){
                ary[i][j] = i + 1;
            }
        }

        int[] oneDim = new int[n * n];
        for(int i = 0; i < n;  i++){
            for(int j = 0; j < n; j++){
                oneDim[i * n + j] = ary[i][j];
            }
        }

        int count = 0;
        for(int i = (int) left; i < (int) right + 1; i++){
            answer[count++] = oneDim[i];
        }
        return answer;
    }
*/
}
