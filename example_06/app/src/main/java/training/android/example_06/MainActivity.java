package training.android.example_06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText number1;
    private EditText number2;
    private TextView result;
    private Button add, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);
        result = (TextView) findViewById(R.id.result);
        add = (Button) findViewById(R.id.addition);
        sub = (Button) findViewById(R.id.subtraction);
        mul = (Button) findViewById(R.id.multiplication);
        div = (Button) findViewById(R.id.division);

        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addition:
                result.setText(String.format("%d", Integer.parseInt(number1.getText().toString()) +
                        Integer.parseInt(number2.getText().toString())));
                break;
            case R.id.subtraction:
                result.setText("" + subtract());
                break;
            case R.id.multiplication:
                MultiplicationOperation multiplicationOp = new MultiplicationOperation();
                int multiplicationResult = multiplicationOp.make(Integer.parseInt(number1.getText().toString()),
                        Integer.parseInt(number2.getText().toString()));
                result.setText("" + multiplicationResult);
                break;
            case R.id.division:
                MathOperations divisionOperation = new MathOperations(Integer.parseInt(number1.getText().toString()),
                        Integer.parseInt(number2.getText().toString()));
                double divisionResult = divisionOperation.makeDivision();
                DecimalFormat df = new DecimalFormat("0.000");
                result.setText(df.format(divisionResult));
                break;
        }
    }

    private int subtract() {
        return Integer.parseInt(number1.getText().toString()) -
                Integer.parseInt(number2.getText().toString());
    }
}