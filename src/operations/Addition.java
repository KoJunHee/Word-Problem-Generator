package operations;

import information.Information;
import information.Item;
import information.Person;
import templates.*;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Addition extends Operation {

    private ArrayList<Person> names;
    private ArrayList<Item> items;
    private ArrayList<Integer> values;
    public Float answer;

    public Addition () {
        names = new ArrayList<Person>();
        items = new ArrayList<Item>();
        values = new ArrayList<Integer>();
    }

    //문제지 생성
    public String createWordProblem(Information info) {
        pickRandomInfo(info);

        //템플릿
        Template templates = new AddTemplate();
        ArrayList<String> opList = templates.getTemplate();
        String wordProblem = opList.get(0);

        //템플릿에 사용자로부터 입력받은 정보 넣기
        wordProblem = wordProblem.replace("#person1", names.get(0).name);
        wordProblem = wordProblem.replace("#person2", names.get(1).name);
        wordProblem = wordProblem.replace("#item", items.get(0).item +"s");
        wordProblem = wordProblem.replace("#number1", Integer.toString(values.get(0)));
        wordProblem = wordProblem.replace("#number2", Integer.toString(values.get(1)));

        return wordProblem;
    }

    // 렌덤 정보 가져오기
    private void pickRandomInfo(Information info) {

        // 첫번째 사람
        Person person1 = info.generateRandNameAndSex();

        // 두번째 사람 (첫번째 사람과 다른 사람)
        Person person2 = person1;
        while (person2.name.equals(person1.name)) {
            Person tempPerson = info.generateRandNameAndSex();
            if (!tempPerson.name.equals(person1.name))
                person2 = tempPerson;
        }

        Item item = info.generateRandItem();
        Integer number1 = info.generateRandNum();
        Integer number2 = info.generateRandNum();

        // 템플릿에 넣기
        names.add(person1);
        names.add(person2);
        items.add(item);
        values.add(number1);
        values.add(number2);
    }

    //정답 계산
    public Float checkAnswer() {
        Float result = 0.00f;
        for (Integer i : values)
            result += i;
        DecimalFormat form = new DecimalFormat("0.00");
        answer = Float.parseFloat(form.format(result));
        return answer;
    }

}
