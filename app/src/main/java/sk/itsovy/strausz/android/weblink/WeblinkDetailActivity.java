package sk.itsovy.strausz.android.weblink;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WeblinkDetailActivity extends AppCompatActivity {

    public static final String WEBLINK_TAG = "weblink";
    private EditText editText;
    private TextView textView;
    private Weblink weblink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weblink_detail);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        if(intent.hasExtra(WEBLINK_TAG)) {
            editText = findViewById(R.id.weblinkEditText);
            textView = findViewById(R.id.weblinkTextView);
        } else{
            textView.findViewById(R.id.weblinkTextView);
            textView.setText("Add");
        }


        weblink = (Weblink) intent.getSerializableExtra(WEBLINK_TAG);

        assert weblink != null;
        editText.setText(weblink.getTitle());


    }

    public void save(View view) {
        String text = editText.getText().toString();
        weblink.setTitle(text);
        Intent intent = new Intent();
        intent.putExtra(WEBLINK_TAG,weblink);
        setResult(RESULT_OK, intent);
        finish();

    }
}