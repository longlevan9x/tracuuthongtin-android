package vn.com.dtsgroup.look_up_information_android.Activities.Search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import vn.com.dtsgroup.look_up_information_android.Adapter.StudentAdapter;
import vn.com.dtsgroup.look_up_information_android.Class.Student;
import vn.com.dtsgroup.look_up_information_android.Init.DataManager;
import vn.com.dtsgroup.look_up_information_android.R;

/*******************************
 *                             *
 * Created by: VinhLD 20180510 *
 *                             *
 *******************************/

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private TextView txt_noti;
    private ListView lv_search;
    private ProgressBar progressBar;

    private void init() {
        txt_noti = findViewById(R.id.txt_search_noti);
        lv_search = findViewById(R.id.lv_search);
        lv_search.setVisibility(View.GONE);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getString(R.string.lookup));

        init();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_search, menu);
        MenuItem item = menu.findItem(R.id.itemSearch);
        ((SearchView) item.getActionView()).setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        txt_noti.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        ArrayList<StudentAdapter.VStudent> vstudents = (new DataManager(this)).Students(query);
        lv_search.setAdapter(new StudentAdapter(
                this,
                android.R.layout.simple_list_item_1,
                vstudents
        ));
        progressBar.setVisibility(View.GONE);
        lv_search.setVisibility(View.VISIBLE);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
