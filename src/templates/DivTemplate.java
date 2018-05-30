package templates;

import java.util.ArrayList;

public class DivTemplate extends Template {

    public DivTemplate() {
        sentences = new ArrayList<String>();
        sentences.add("#person1 has #number1 #item. #gender1 wants to divide them evenly " +
                "among #number2 friends. How many #item does each friend get?");
    }

    public ArrayList<String> getTemplate() {
        return sentences;
    }

}
