package training.android.example_05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText criteriaEdtT;
    private Button searchBtn;
    private Button backBtn;
    private Button forwardBtn;
    private Button refreshBtn;
    private Button cleanBtn;
    private WebView webV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        criteriaEdtT = (EditText) findViewById(R.id.criteria);
        searchBtn = (Button) findViewById(R.id.search);
        backBtn = (Button) findViewById(R.id.back);
        forwardBtn = (Button) findViewById(R.id.forward);
        refreshBtn = (Button) findViewById(R.id.refresh);
        cleanBtn = (Button) findViewById(R.id.clean);
        webV = (WebView) findViewById(R.id.web);

        webV.setWebViewClient(new ViewClient());
        webV.getSettings().setJavaScriptEnabled(true);
        webV.getSettings().setLoadsImagesAutomatically(true);
        webV.getSettings().setUseWideViewPort(true);


        searchBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);
        forwardBtn.setOnClickListener(this);
        refreshBtn.setOnClickListener(this);
        cleanBtn.setOnClickListener(this);


        webV.loadUrl("https://www.w3c.com");

    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.search:
                webV.loadUrl(String.format("https://www.%s.com", criteriaEdtT.getText().toString()));
                break;
            case R.id.back:
                if (webV.canGoBack()) webV.goBack();
                break;
            case R.id.forward:
                if (webV.canGoForward()) webV.goForward();
                break;
            case R.id.refresh:
                webV.reload();
                break;
            case R.id.clean:
                webV.clearHistory();
                break;
        }

    }
}