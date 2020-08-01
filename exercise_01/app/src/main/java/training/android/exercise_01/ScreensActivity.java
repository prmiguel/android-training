package training.android.exercise_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class ScreensActivity extends Activity implements View.OnClickListener {

    private Button redBtn;
    private Button yellowBtn;
    private Button greenBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screens);

        redBtn = (Button) findViewById(R.id.redBtn);
        yellowBtn = (Button) findViewById(R.id.yellowBtn);
        greenBtn = (Button) findViewById(R.id.greenBtn);

        redBtn.setOnClickListener(this);
        yellowBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.redBtn:
                startActivity(getIntent(RedScreenActivity.class));
                break;
            case R.id.yellowBtn:
                startActivity(getIntent(YellowScreenActivity.class));
                break;
            case R.id.greenBtn:
                startActivity(getIntent(GreenScreenActivity.class));
                break;
        }
    }

    private Intent getIntent(Class<?> activityScreenColor) {
        return new Intent(this, activityScreenColor);
    }
}
