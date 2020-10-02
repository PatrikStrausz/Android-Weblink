package sk.itsovy.strausz.android.weblink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnWeblinkListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        WeblinksAdapter adapter = new WeblinksAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onWeblinkClick(Weblink weblink) {
        //Toast.makeText(this, weblink.getTitle() + " clicked" + " ("+weblink.getRating()+" stars)" ,Toast.LENGTH_SHORT ).show();

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(weblink.getUrl()));
        startActivity(intent);


    }

    @Override
    public void onWeblinkLongClick(Weblink weblink) {

        Intent intent = new Intent(this, WeblinkDetailActivity.class);
        intent.putExtra(WeblinkDetailActivity.WEBLINK_TAG,  weblink);
        startActivity(intent);
    }
}