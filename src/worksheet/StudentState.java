package worksheet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class StudentState implements State {

    private Integer currentScore = 0;
    ArrayList<Problem> problems;

    public StudentState(ArrayList<Problem> problems) {
        this.problems = problems;
    }

    public void doAction(Context context) {
        System.out.println("\n다음 문제들을 풀어주세요.");
        context.setState(this);
        administerTest();
        outputScore();
    }

    private void administerTest() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        // 문제들 섞기
        Collections.shuffle(problems);

        System.out.println("\n---------------------------------- 문제 ----------------------------------");

        for (int i=0; i<problems.size(); i++) {
            Problem p = problems.get(i);
            System.out.println("\n" + (i+1) + ". " + p.getWordProblem());
            try {
                input = br.readLine();
                input = input.replace(" ", "");
                Float answer = Float.parseFloat(input);
                if (answer.equals(p.getAnswer())) {
                    System.out.println("Correct!");
                    currentScore+=1;
                }
                else System.out.println("Incorrect!");
            }
            catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    private void outputScore() {
        System.out.println("\n---------------------------------- 최종 결과----------------------------------");
        System.out.println(problems.size()+ "문제 중에 " + currentScore + "문제 맞추셨습니다.");
    }

    public String toString(){
        return "Student State";
    }

    public Float getScore() {
        return (float)currentScore/problems.size()*100;
    }

}
