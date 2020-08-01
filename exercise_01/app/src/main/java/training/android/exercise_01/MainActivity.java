package training.android.exercise_01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import training.android.exercise_01.listeners.BaseOnClickListener;

public class MainActivity extends AppCompatActivity {

    private Button basicCalculatorBtn;
    private Button screenCalculatorBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        setOnClickListeners();
    }

    private void initializeViews() {
        basicCalculatorBtn = (Button) findViewById(R.id.bcalculatorBtn);
        screenCalculatorBtn = (Button) findViewById(R.id.screensBtn);
    }

    private void setOnClickListeners() {
        basicCalculatorBtn.setOnClickListener(
                new BaseOnClickListener(this, BasicCalculatorActivity.class)
        );

        screenCalculatorBtn.setOnClickListener(
                new BaseOnClickListener(this, ScreensActivity.class)
        );
    }
}