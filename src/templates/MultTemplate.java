package templates;

import java.util.ArrayList;

public class MultTemplate extends Template {

    public MultTemplate() {
        sentences = new ArrayList<String>();
        sentences.add("#person1 has #number1 groups of #number2 #item. " +
                "How many #item does #person1 have altogether?");
    }

    public ArrayList<String> getTemplate() {
        return sentences;
    }

}
