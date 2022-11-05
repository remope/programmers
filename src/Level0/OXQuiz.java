package Level0;

public class OXQuiz {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i = 0; i < quiz.length; i++){
            String[] mathExp = quiz[i].split(" ");
            int left1 = Integer.parseInt(mathExp[0]), left2 = Integer.parseInt(mathExp[2]);
            int right = Integer.parseInt(mathExp[4]);
            int result = 0;
            switch(mathExp[1]){
                case "+":
                    result = left1 + left2;
                    break;
                case "-":
                    result = left1 - left2;
                    break;
            }
            if(result == right) answer[i] = "O";
            else answer[i] = "X";
        }
        return answer;
    }
}
