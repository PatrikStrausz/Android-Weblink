package sk.itsovy.strausz.android.weblink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WeblinkDetailActivity extends AppCompatActivity {

    public static final String WEBLINK_TAG = "weblink";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weblink_detail);

        EditText editText = findViewById(R.id.weblinkEditText);
        TextView textView = findViewById(R.id.weblinkTextView);

        Intent intent = getIntent();
        Weblink weblink =(Weblink) intent.getSerializableExtra(WEBLINK_TAG);

        editText.setText(weblink.getTitle());

    }

    public void save(View view) {
        finish();
    }
}