package operations;

public class OperationFactory {

    public Operation createOperation(String type) {
        Operation problem = new Addition();
        if (type.equals("+")) problem = new Addition();
        else if (type.equals("-")) problem = new Subtraction();
        else if (type.equals("*")) problem = new Multiplication();
        else if (type.equals("/")) problem = new Division();

        return problem;
    }

}
