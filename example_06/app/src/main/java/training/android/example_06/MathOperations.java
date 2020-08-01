package training.android.example_06;

public class MathOperations {
    private int num1;
    private int num2;

    public MathOperations(int n1, int n2) {
        num1 = n1;
        num2 = n2;
    }

    public double makeDivision() {

        return Double.valueOf(num1) / Double.valueOf(num2);
    }
}
