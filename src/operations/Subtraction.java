package operations;

import information.Information;
import information.Item;
import information.Person;
import templates.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Subtraction extends Operation {

    private ArrayList<Person> names;
    private ArrayList<Item> items;
    private ArrayList<Integer> values;
    public Float answer;

    public Subtraction () {
        names = new ArrayList<Person>();
        items = new ArrayList<Item>();
        values = new ArrayList<Integer>();
    }

    //문제지 생성
    public String createWordProblem(Information info) {
        pickRandomInfo(info);

        //템플릿
        Template templates = new SubTemplate();
        ArrayList<String> opList = templates.getTemplate();
        String wordProblem = opList.get(0);

        //템플릿에 사용자로부터 입력받은 정보 넣기
        wordProblem = wordProblem.replace("#person1", names.get(0).name);
        wordProblem = wordProblem.replace("#person2", names.get(1).name);
        String pronoun = names.get(0).gender.toLowerCase().equals("male") ? "He" : "She";
        wordProblem = wordProblem.replace("#gender1", pronoun);
        wordProblem = wordProblem.replace("#item", items.get(0).item +"s");
        wordProblem = wordProblem.replace("#number1", Integer.toString(values.get(values.size()-1))); // get the max value
        wordProblem = wordProblem.replace("#number2", Integer.toString(values.get(0))); // get the min value

        return wordProblem;
    }

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

        //템플릴셍 넣기
        names.add(person1); names.add(person2);
        items.add(item);
        values.add(number1); values.add(number2);

        //정렬
        Collections.sort(values);
    }

    //정답 계산
    public Float checkAnswer() {
        Float result = (float)values.get(values.size()-1);
        for (int i=0; i<values.size()-1; i++)
            result -= values.get(i);
        DecimalFormat form = new DecimalFormat("0.00");
        answer = Float.parseFloat(form.format(result));
        return answer;
    }

}
