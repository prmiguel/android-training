package training.android.example_04;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private EditText nameEdtT;
    private Button saveButton;
    private ListView namesLtV;

    private ArrayAdapter adapter;

    List<String> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdtT = (EditText) findViewById(R.id.name);
        saveButton = (Button) findViewById(R.id.save);
        namesLtV = (ListView) findViewById(R.id.listNames);

        saveButton.setOnClickListener(this);
        namesLtV.setOnItemClickListener(this);
        namesLtV.setOnItemLongClickListener(this);

        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, names);
        namesLtV.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        names.add(nameEdtT.getText().toString());

        adapter.notifyDataSetChanged();
        nameEdtT.setText("");
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, String.format("Hello %s", namesLtV.getItemAtPosition(i)), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, String.format("Bye %s", namesLtV.getItemAtPosition(i)), Toast.LENGTH_SHORT).show();
        return true;
    }
}