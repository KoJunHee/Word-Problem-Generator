package information;

import java.util.ArrayList;
import java.util.Random;

public class Information {

    public ArrayList<String> typeOfProblems;
    public Integer numOfProblems;
    public Integer minRange;
    public Integer maxRange;
    public ArrayList<Person> nameAndSex;
    public ArrayList<Item> items;

    //사용자로부터 문제지 생성을 위한 정보들을 입력받는다
    public void getInformation() {
        InputManager input = new InputManager();
        input.printWelcomeMessage();
        typeOfProblems = input.getOperationTypes();
        numOfProblems = input.getNumberOfProblems();
        minRange = input.getMinRange();
        maxRange = input.getMaxRange();
        nameAndSex = input.getNameAndSex();
        items = input.getItemsOfInterest();
    }

    //이름, 성 렌덤 선택
    public Person generateRandNameAndSex() {
        Random rand = new Random();
        int n = rand.nextInt(nameAndSex.size()) + 0;
        return nameAndSex.get(n);
    }

    //아이템 렌덤 선택
    public Item generateRandItem() {
        Random rand = new Random();
        int n = rand.nextInt(items.size()) + 0;
        return items.get(n);
    }

    ////피연산자 렌덤 선택
    public Integer generateRandNum() {
        Random rand = new Random();
        Integer n = rand.nextInt(maxRange) + minRange;
        return n;
    }
}
