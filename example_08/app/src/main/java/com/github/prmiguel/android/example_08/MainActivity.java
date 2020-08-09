package com.github.prmiguel.android.example_08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.manu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_menu1:
                Toast.makeText(this, "menu 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_menu2:
                Toast.makeText(this, "menu 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_menu3:
                finish();
                break;
            case R.id.action_menu4_1:
                Toast.makeText(this, "menu 4_1", Toast.LENGTH_SHORT).show();
                break;
            default:
                return false;
        }
        return super.onOptionsItemSelected(menuItem);
    }

}