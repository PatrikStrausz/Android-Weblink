package sk.itsovy.strausz.android.weblink;

import androidx.appcompat.app.AppCompatActivity;

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


        editText = findViewById(R.id.weblinkEditText);

        textView = findViewById(R.id.weblinkTextView);

        Intent intent = getIntent();

        weblink = (Weblink) intent.getSerializableExtra(WEBLINK_TAG);

        assert weblink != null;
        editText.setText(weblink.getTitle());


    }

    public void save(View view) {
        String text = editText.getText().toString();
        weblink.setTitle(text);
        finish();

    }
}