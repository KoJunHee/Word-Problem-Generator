package operations;


import information.Information;
import information.Item;
import information.Person;

import java.util.ArrayList;

public abstract class Operation {

    private ArrayList<Person> names;
    private ArrayList<Item> items;
    private ArrayList<Integer> values;

    public abstract String createWordProblem(Information info);
    public abstract Float checkAnswer();

}
