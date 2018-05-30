package information;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class InputManager {

    BufferedReader br;

    public InputManager() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    // Welcome message
    public void printWelcomeMessage() {
        System.out.println("문제지를 생성합니다.\n");
    }

    // 연산 타입 입력
    public ArrayList<String> getOperationTypes() {
        ArrayList<String> typeOfProblems = new ArrayList<String>();
        System.out.println("연산 타입(+, -, *, /)을 ,로 구분하여 입력하세요: \n" +
                "ex) +, *, /");
        try {
            String input = br.readLine();
            input = input.replace(" ", "");
            String[] inputList = input.split(",");
            typeOfProblems = new ArrayList<String>(Arrays.asList(inputList));
        }
        catch (IOException e) {
            System.err.println(e);
        }
        return typeOfProblems;
    }

    //생성할 문제 개수
    public Integer getNumberOfProblems() {
        Integer numOfProblems=0;
        System.out.println("\n몇 문제를 생성하시겠습니까?");
        try {
            String input = br.readLine();
            input = input.replace(" ", "");
            numOfProblems = Integer.parseInt(input);
        } catch (IOException e) {
            System.err.println(e);
        }
        return numOfProblems;
    }

    //피연산자의 최소값
    public Integer getMinRange() {
        Integer minRange = 0;
        System.out.println("\n피연산자의 최소값은?");
        try {
            String input = br.readLine();
            input = input.replace(" ", "");
            minRange = Integer.parseInt(input);
        }
        catch (IOException e) {
            System.err.println(e);
        }
        return minRange;
    }

    //피연산자의 최대값
    public Integer getMaxRange() {
        Integer maxRange = 0;
        System.out.println("\n피연산자의 최대값은?");
        try {
            String input = br.readLine();
            input = input.replace(" ", "");
            maxRange = Integer.parseInt(input);
        }
        catch (IOException e) {
            System.err.println(e);
        }
        return maxRange;
    }

    //이름과 성
    public ArrayList<Person> getNameAndSex() {
        ArrayList<Person> names = new ArrayList<Person>();
        System.out.println("\n이름과 성별들을 ,로 구분하여 입력하세요: \n" +
                "ex) JunHee-male, Mina-female");
        try {
            String input = br.readLine();
            input = input.replace(" ", "");
            String[] namesList = input.split(",");
            for (String pair : namesList) {
                String[] splitPair = pair.split("-");
                names.add(new Person(splitPair[0], splitPair[1]));
            }
        }
        catch (IOException e) {
            System.err.println(e);
        }
        return names;
    }

    //관심있어하는 물건
    public ArrayList<Item> getItemsOfInterest() {
        ArrayList<Item> items = new ArrayList<Item>();
        System.out.println("\n아이템들을 ,로 구분하여 입력하세요: \n" +
                "ex) paper, banana, notebook");

        try {
            String input = br.readLine();
            input = input.replace(" ", "");
            String[] itemsList = input.split(",");
            for (String item : itemsList)
                items.add(new Item(item));
        }
        catch (IOException e) {
            System.err.println(e);
        }
        return items;
    }
}
