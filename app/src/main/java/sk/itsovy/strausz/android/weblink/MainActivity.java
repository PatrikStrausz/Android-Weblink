package sk.itsovy.strausz.android.weblink;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements OnWeblinkListener{

    private static final int CODE = 69420;

    private WeblinksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new WeblinksAdapter(this);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeToDeleteCallback(adapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_add:
                   startDetailActivity(Weblink.createEmptyWeblink());
                    return  true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onWeblinkClick(Weblink weblink) {
      startDetailActivity(weblink);
    }

    private void startDetailActivity(Weblink weblink){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(weblink.getUrl()));
        startActivity(intent);
    }

    @Override
    public void onWeblinkLongClick(Weblink weblink) {

        Intent intent = new Intent(this, WeblinkDetailActivity.class);
        intent.putExtra(WeblinkDetailActivity.WEBLINK_TAG,  weblink);
        startActivityForResult(intent,CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE) {
            if (resultCode == RESULT_OK) {
               Weblink weblink = (Weblink) data.getSerializableExtra(WeblinkDetailActivity.WEBLINK_TAG);
               Toast.makeText(this, "new weblink "+weblink.getTitle(), Toast.LENGTH_SHORT).show();
               adapter.update(weblink);
            }
        }


    }
}