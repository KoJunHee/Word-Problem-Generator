package templates;

import java.util.ArrayList;

public class AddTemplate extends Template {

    public AddTemplate() {
        sentences = new ArrayList<String>();
        this.addTemplate();
    }

    public void addTemplate() {
        sentences.add("#person1 has #number1 #item. #person2 has #number2 #item. " +
                "How many #item do they have altogether?");
    }

    public ArrayList<String> getTemplate() {
        return sentences;
    }

}
