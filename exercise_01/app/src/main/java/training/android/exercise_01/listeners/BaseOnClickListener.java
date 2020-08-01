package training.android.exercise_01.listeners;

import android.content.Intent;
import android.view.View;

import training.android.exercise_01.MainActivity;

public class BaseOnClickListener implements View.OnClickListener {

    private MainActivity mainActivity;
    private Class<?> activity;

    public BaseOnClickListener(MainActivity mainActivity, Class<?> activity) {
        this.mainActivity = mainActivity;
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        mainActivity.startActivity(new Intent(mainActivity, activity));
    }
}
