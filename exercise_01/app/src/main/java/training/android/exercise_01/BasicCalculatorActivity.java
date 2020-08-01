package training.android.exercise_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import training.android.exercise_01.operations.BasicMathOperations;

public class BasicCalculatorActivity extends Activity  implements View.OnClickListener {

    private EditText numberOneEditT;
    private EditText numberTwoEditT;
    private TextView resultTxtV;
    private TextView signOperationTxtV;
    private Button additionBtn;
    private Button subtractionBtn;
    private Button multiplicationBtn;
    private Button divisionBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calculator);
        initializeViews();
        setOnClickListeners();
    }

    @Override
    public void onClick(View view) {

        resultTxtV.setText("");

        String numberOneText = numberOneEditT.getText().toString();
        String numberTwoText = numberTwoEditT.getText().toString();

        if (numberOneText.trim().equals("") || numberTwoText.trim().equals("")) {
            Toast.makeText(this, "No empty values allowed!", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        int numberOne = Integer.parseInt(numberOneText);
        int numberTwo = Integer.parseInt(numberTwoText);
        BasicMathOperations mathOperation = new BasicMathOperations(numberOne, numberTwo);

        switch (view.getId()) {
            case R.id.addition:
                signOperationTxtV.setText("+");
                resultTxtV.setText(String.valueOf(mathOperation.addition()));
                break;
            case R.id.subtraction:
                signOperationTxtV.setText("-");
                resultTxtV.setText(String.valueOf(mathOperation.subtraction()));
                break;
            case R.id.multiplication:
                signOperationTxtV.setText("x");
                resultTxtV.setText(String.valueOf(mathOperation.multiplication()));
                break;
            case R.id.division:
                try {
                    signOperationTxtV.setText("/");
                    resultTxtV.setText(String.valueOf(mathOperation.division()));
                } catch (ArithmeticException ae) {
                    Toast.makeText(this, "No division allowed!", Toast.LENGTH_SHORT)
                            .show();
                }

                break;
        }
    }

    private void initializeViews() {
        numberOneEditT = (EditText) findViewById(R.id.numberOne);
        numberTwoEditT = (EditText) findViewById(R.id.numberTwo);
        signOperationTxtV = (TextView) findViewById(R.id.signOperation);
        resultTxtV = (TextView) findViewById(R.id.result);
        additionBtn = (Button) findViewById(R.id.addition);
        subtractionBtn = (Button) findViewById(R.id.subtraction);
        multiplicationBtn = (Button) findViewById(R.id.multiplication);
        divisionBtn = (Button) findViewById(R.id.division);
    }

    private void setOnClickListeners() {
        additionBtn.setOnClickListener(this);
        subtractionBtn.setOnClickListener(this);
        multiplicationBtn.setOnClickListener(this);
        divisionBtn.setOnClickListener(this);
    }
}
