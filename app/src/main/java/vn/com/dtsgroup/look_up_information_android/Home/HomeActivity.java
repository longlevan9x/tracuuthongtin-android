package vn.com.dtsgroup.look_up_information_android.Home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import vn.com.dtsgroup.look_up_information_android.Adapter.ViewPagerAdapter;
import vn.com.dtsgroup.look_up_information_android.Fragment.InfoFragment;
import vn.com.dtsgroup.look_up_information_android.Fragment.MarkFragment;
import vn.com.dtsgroup.look_up_information_android.R;
import vn.com.dtsgroup.look_up_information_android.Init.Module;

/*******************************
 *                             *
 * Created by: VinhLD 20180509 *
 *                             *
 *******************************/

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;

    private void initToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.rgb(Module.PRIMARY_R, Module.PRIMARY_G, Module.PRIMARY_B));
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }

    private void initDrawer(){
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void initNavigationView(){
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initViewPager(){
        viewPager = findViewById(R.id.viewPagerHome);
        tabLayout = findViewById(R.id.tabLayoutHome);
        newViewPagerAdapter();
    }
    private void newViewPagerAdapter(){
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), HomeActivity.this);
    }

    private void clearViews(){
        viewPager.removeAllViews();
        tabLayout.removeAllTabs();
        newViewPagerAdapter();
    }
    private void createViews(){
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void createStudentInfomation(){
//        clearViews();
        newViewPagerAdapter();

        viewPagerAdapter.addFragmentPager(new InfoFragment(), "");

        createViews();
        tabLayout.setVisibility(View.GONE);
    }

    private void createStudentMark(){
//        clearViews();
        newViewPagerAdapter();
        viewPagerAdapter.addFragmentPager(new MarkFragment(), "");

        createViews();
        tabLayout.setVisibility(View.GONE);
    }

    private void init() {
        initToolbar();
        initDrawer();
        initNavigationView();
        initViewPager();
        createStudentInfomation();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.nav_info:
                createStudentInfomation();
                break;

            case R.id.nav_mark:
                createStudentMark();
                break;

            case R.id.nav_schedule:

                break;

            case R.id.nav_schedule_exam:

                break;

            case R.id.nav_logout:

                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
