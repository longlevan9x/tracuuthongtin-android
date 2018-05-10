package vn.com.dtsgroup.look_up_information_android.Activities.Home;

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
import android.widget.LinearLayout;

import vn.com.dtsgroup.look_up_information_android.Adapter.ViewPagerAdapter;
import vn.com.dtsgroup.look_up_information_android.Fragment.ScheduleExamFragment;
import vn.com.dtsgroup.look_up_information_android.Fragment.ScheduleFragment;
import vn.com.dtsgroup.look_up_information_android.R;
import vn.com.dtsgroup.look_up_information_android.Init.Module;

/*******************************
 *                             *
 * Created by: VinhLD 20180509 *
 *                             *
 *******************************/

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static String INFOMATIONTITLE = "Thông tin";
    public static String MARKTITLE = "Bảng điểm";
    public static String SCHEDULETITLE = "Lịch học";
    public static String SCHEDULEEXAMTITLE = "Lịch thi";

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;

    private ViewPager viewPagerSchedule, viewPagerScheduleExam;
    private TabLayout tabLayoutSchedule, tabLayoutScheduleExam;
    private ViewPagerAdapter adapterSchedule, adapterScheduleExam;

    private LinearLayout infomationLayout, markLayout, scheduleLayout, scheduleExamLayout;

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

    private void initSchedule(){
        viewPagerSchedule = findViewById(R.id.viewPagerSchedule);
        tabLayoutSchedule = findViewById(R.id.tabLayoutSchedule);
        adapterSchedule = new ViewPagerAdapter(getSupportFragmentManager(), HomeActivity.this);

        adapterSchedule.addFragmentPager(new ScheduleFragment(), "Thứ Hai");
        adapterSchedule.addFragmentPager(new ScheduleFragment(), "Thứ Hai");
        adapterSchedule.addFragmentPager(new ScheduleFragment(), "Thứ Hai");
        adapterSchedule.addFragmentPager(new ScheduleFragment(), "Thứ Hai");
        adapterSchedule.addFragmentPager(new ScheduleFragment(), "Thứ Hai");
        adapterSchedule.addFragmentPager(new ScheduleFragment(), "Thứ Hai");
        adapterSchedule.addFragmentPager(new ScheduleFragment(), "Thứ Hai");

        viewPagerSchedule.setAdapter(adapterSchedule);
        tabLayoutSchedule.setupWithViewPager(viewPagerSchedule);

//        tabLayoutSchedule.setSelectedTabIndicatorColor(Color.rgb(255,255,255));
//        tabLayoutSchedule.setSelectedTabIndicatorHeight(5);
    }

    private void initScheduleExam(){
        viewPagerScheduleExam = findViewById(R.id.viewPagerScheduleExam);
        tabLayoutScheduleExam = findViewById(R.id.tabLayoutScheduleExam);
        adapterScheduleExam = new ViewPagerAdapter(getSupportFragmentManager(), HomeActivity.this);

        adapterScheduleExam.addFragmentPager(new ScheduleExamFragment(), "Thứ Ba");
        adapterScheduleExam.addFragmentPager(new ScheduleExamFragment(), "Thứ Ba");
        adapterScheduleExam.addFragmentPager(new ScheduleExamFragment(), "Thứ Ba");
        adapterScheduleExam.addFragmentPager(new ScheduleExamFragment(), "Thứ Ba");
        adapterScheduleExam.addFragmentPager(new ScheduleExamFragment(), "Thứ Ba");
        adapterScheduleExam.addFragmentPager(new ScheduleExamFragment(), "Thứ Ba");
        adapterScheduleExam.addFragmentPager(new ScheduleExamFragment(), "Thứ Ba");

        viewPagerScheduleExam.setAdapter(adapterScheduleExam);
        tabLayoutScheduleExam.setupWithViewPager(viewPagerScheduleExam);



    }

    private void initLayouts(){
        infomationLayout = findViewById(R.id.infomationLayout);
        markLayout = findViewById(R.id.markLayout);
        scheduleLayout = findViewById(R.id.scheduleLayout);
        scheduleExamLayout = findViewById(R.id.scheduleExamLayout);
    }
    private void hideAllLayouts(){
        infomationLayout.setVisibility(View.GONE);
        markLayout.setVisibility(View.GONE);
        scheduleLayout.setVisibility(View.GONE);
        scheduleExamLayout.setVisibility(View.GONE);
    }
    private void showInfomation(){
        hideAllLayouts();
        infomationLayout.setVisibility(View.VISIBLE);
        setTitle(INFOMATIONTITLE);
    }
    private void showMark(){
        hideAllLayouts();
        markLayout.setVisibility(View.VISIBLE);
        setTitle(MARKTITLE);
    }
    private void showSchedule(){
        hideAllLayouts();
        scheduleLayout.setVisibility(View.VISIBLE);
        setTitle(SCHEDULETITLE);
    }
    private void showScheduleExam(){
        hideAllLayouts();
        scheduleExamLayout.setVisibility(View.VISIBLE);
        setTitle(SCHEDULEEXAMTITLE);
    }

    private void init() {
        initToolbar();
        initDrawer();
        initNavigationView();
        initLayouts();
        initSchedule();
        initScheduleExam();

        showInfomation();
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
                if(infomationLayout.getVisibility() == View.GONE){
                    showInfomation();
                }
                break;

            case R.id.nav_mark:
                if(markLayout.getVisibility() == View.GONE){
                    showMark();
                }
                break;

            case R.id.nav_schedule:
                if(scheduleLayout.getVisibility() == View.GONE){
                    showSchedule();
                }
                break;

            case R.id.nav_schedule_exam:
                if(scheduleExamLayout.getVisibility() == View.GONE){
                    showScheduleExam();
                }
                break;

            case R.id.nav_logout:

                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
