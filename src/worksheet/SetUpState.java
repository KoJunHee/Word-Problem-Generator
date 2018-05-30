package worksheet;


import information.Information;

import java.util.ArrayList;

public class SetUpState implements State {

    ArrayList<Problem> problems;

    public void doAction(Context context) {
        context.setState(this);
        createProblems();
    }

    //문제 생성
    private void createProblems() {
        problems = new ArrayList<Problem>();

        // 사용자에게 문제지 정보 입력받는다
        Information information = new Information();
        information.getInformation();

        // 타입에 따라 문제 몇개 만들지
        int numProblemsEach = information.numOfProblems/information.typeOfProblems.size();
        int numProblemsRemaining = information.numOfProblems - (numProblemsEach * information.typeOfProblems.size());

        // 문제 객체 생성
        for (String operation : information.typeOfProblems)
            for (int i=0; i<numProblemsEach; i++)
                problems.add(new Problem(information, operation));

        for (int i=0; i<numProblemsRemaining; i++)
            problems.add(new Problem(information, information.typeOfProblems.get(i)));

        // 문제에 따라 문제지 생성
        for (Problem p : problems)
            p.generateProblem();
    }

    public ArrayList<Problem> getProblems() {
        return problems;
    }

    public String toString(){
        return "Setup State";
    }

}
