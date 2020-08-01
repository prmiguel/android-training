package training.android.exercise_01.operations;

public class BasicMathOperations {

    private int numberOne;
    private int numberTwo;

    public BasicMathOperations(int numberOne, int numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    public int addition() {
        return numberOne + numberTwo;
    }

    public int subtraction() {
        return numberOne - numberTwo;
    }

    public int multiplication() {
        return numberOne * numberTwo;
    }

    public int division() {
        try {
            return numberOne / numberTwo;
        } catch (ArithmeticException ae) {
            throw new ArithmeticException(
                    String.format("No division allowed: %d / %d = ?", numberOne, numberTwo)
            );
        }
    }
}
