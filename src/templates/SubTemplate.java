package templates;

import java.util.ArrayList;

public class SubTemplate extends Template {

    public SubTemplate() {
        sentences = new ArrayList<String>();
        sentences.add("#person1 has #number1 #item. #gender1 gives #number2 #item to " +
                "#person2. How many #item does #person1 have left?");
    }

    public ArrayList<String> getTemplate() {
        return sentences;
    }

}
