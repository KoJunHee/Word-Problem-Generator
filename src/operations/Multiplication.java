package operations;

import information.Information;
import information.Item;
import information.Person;
import templates.*;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Multiplication extends Operation {

    private ArrayList<Person> names;
    private ArrayList<Item> items;
    private ArrayList<Integer> values;
    public Float answer;

    public Multiplication () {
        names = new ArrayList<Person>();
        items = new ArrayList<Item>();
        values = new ArrayList<Integer>();
    }

    //문제지 생성
    public String createWordProblem(Information info) {
        pickRandomInfo(info);

        //템플릿
        Template templates = new MultTemplate();
        ArrayList<String> opList = templates.getTemplate();
        String wordProblem = opList.get(0);

        //템플릿에 사용자로부터 입력받은 정보 넣기
        wordProblem = wordProblem.replace("#person1", names.get(0).name);
        wordProblem = wordProblem.replace("#item", items.get(0).item +"s");
        wordProblem = wordProblem.replace("#number1", Integer.toString(values.get(0)));
        wordProblem = wordProblem.replace("#number2", Integer.toString(values.get(1)));

        return wordProblem;
    }

    private void pickRandomInfo(Information info) {

        Person person1 = info.generateRandNameAndSex();
        Item item = info.generateRandItem();
        Integer number1 = info.generateRandNum();
        Integer number2 = info.generateRandNum();

        // 템플릿에 넣기
        names.add(person1);
        items.add(item);
        values.add(number1);
        values.add(number2);
    }

    //정답 계산
    public Float checkAnswer() {
        Float result = 1.00f;
        for (Integer i : values)
            result *= i;
        DecimalFormat form = new DecimalFormat("0.00");
        answer = Float.parseFloat(form.format(result));
        return answer;
    }

}
