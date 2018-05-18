package vn.com.dtsgroup.look_up_information_android.Activities.Home;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import vn.com.dtsgroup.look_up_information_android.Activities.Login.LoginActivity;
import vn.com.dtsgroup.look_up_information_android.Activities.Search.SearchActivity;
import vn.com.dtsgroup.look_up_information_android.Adapter.ViewPagerAdapter;
import vn.com.dtsgroup.look_up_information_android.Class.Area;
import vn.com.dtsgroup.look_up_information_android.Class.Student;
import vn.com.dtsgroup.look_up_information_android.Fragment.ScheduleExamFragment;
import vn.com.dtsgroup.look_up_information_android.Fragment.ScheduleFragment;
import vn.com.dtsgroup.look_up_information_android.Init.DataManager;
import vn.com.dtsgroup.look_up_information_android.Init.VLDxxxModule;
import vn.com.dtsgroup.look_up_information_android.R;
import vn.com.dtsgroup.look_up_information_android.Init.Module;

/*******************************
 *                             *
 * Created by: VinhLD 20180509 *
 *                             *
 *******************************/

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, SearchView.OnQueryTextListener {

    public static String TAG = "HOMEACTIVITY";

    public static String INFOMATIONTITLE = "Thông tin";
    public static String MARKTITLE = "Bảng điểm";
    public static String SCHEDULETITLE = "Lịch học";
    public static String SCHEDULEEXAMTITLE = "Lịch thi";
    public static String ABOUTTITLE = "About";
    public static String DEBTTITLE = "Công nợ";

    private Student student;
    private DataManager dataManager;

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private CircleImageView img_student;
    private TextView txt_fullname, txt_code, txt_link_author, txt_link_author1;

    private ViewPager viewPagerSchedule, viewPagerScheduleExam;
    private TabLayout tabLayoutSchedule, tabLayoutScheduleExam;
    private ViewPagerAdapter adapterSchedule, adapterScheduleExam;
    private Dialog dialog_exit, dialog_logout;
    private MenuItem item_search;

    private LinearLayout infomationLayout, markLayout, scheduleLayout, scheduleExamLayout, aboutLayout, debtLayout;

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.rgb(Module.PRIMARY_R, Module.PRIMARY_G, Module.PRIMARY_B));
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }

    private void initDrawer() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void initNavigationView() {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        img_student = navigationView.getHeaderView(0).findViewById(R.id.img_student);
        txt_fullname = navigationView.getHeaderView(0).findViewById(R.id.txt_fullname_header);
        txt_code = navigationView.getHeaderView(0).findViewById(R.id.txt_IDStudent);

        String code = Module.IDStudent(this);
        dataManager = new DataManager(this);
        student = dataManager.getStudentbyCODE(code);

        Picasso.with(this).load(Module.IMAGESTUDENT + code)
                .into(img_student);
        txt_fullname.setText(student.getName());
        txt_code.setText(code);
    }

    private void initSchedule() {
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
    }

    private void initScheduleExam() {
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

    private void initInfomation() {
        String code = student.getCode();
        Picasso.with(this).load(Module.IMAGESTUDENT + code)
                .into((ImageView) findViewById(R.id.img_info_student));
        ((TextView) findViewById(R.id.txt_info_code)).setText(code);
        ((TextView) findViewById(R.id.txt_info_state)).setText(" " + student.getStatus());

        String info = "Ngày vào trường: " + student.getDay_admission() + "\n\n"
                + "Cơ sở: " + dataManager.AreaName(student.getArea()) + "\n\n"
                + "Niên khóa: " + student.getSchool_year() + "\n\n"
                + "Bậc đào tạo: " + student.getEducation_level() + "\n\n"
                + "Loại hình đào tạo: " + student.getType_education() + "\n\n"
                + "Khoa: " + dataManager.FacultyName(student.getId_department()) + "\n\n"
                + "Ngành: " + student.getBranch_group() + "\n\n"
                + "Chuyên ngành: " + student.getBranch() + "\n\n"
                + "Lớp: " + student.get_class();

        String info1 = "Giới tính: " + student.getGender() + "\n\n"
                + "Khóa: " + student.getCourse() + "\n\n"
                + "Tổng tín chỉ: " + student.getTotal_term() + "\n\n"
                + "Điểm tích lũy: " + student.getAverage_cumulative();

        ((TextView) findViewById(R.id.txt_info)).setText(info1);
        ((TextView) findViewById(R.id.txt_info_1)).setText(info);
    }

    private void initAbout() {
        txt_link_author = findViewById(R.id.txt_link_author);
        txt_link_author.setText(Html.fromHtml(Module.AuthorText("http://tradiem.ml/", "Website http://tradiem.ml/")));
        txt_link_author.setMovementMethod(LinkMovementMethod.getInstance());

        txt_link_author1 = findViewById(R.id.txt_link_author1);
        txt_link_author1.setText(Html.fromHtml(Module.AuthorText("http://longvanit.club/", "Blog http://longvanit.club/")));
        txt_link_author1.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void initLayouts() {
        infomationLayout = findViewById(R.id.infomationLayout);
        markLayout = findViewById(R.id.markLayout);
        scheduleLayout = findViewById(R.id.scheduleLayout);
        scheduleExamLayout = findViewById(R.id.scheduleExamLayout);
        aboutLayout = findViewById(R.id.aboutLayout);
        debtLayout = findViewById(R.id.debtLayout);
        initDialog();
    }

    private void initDialog() {
        initDialogExit();
        initDialogLogout();
    }

    private void initDialogExit() {
        dialog_exit = new Dialog(this);
        dialog_exit.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_exit.setContentView(R.layout.dialog_exit);
        ((Button) dialog_exit.findViewById(R.id.btn_dialog_exit_ok)).setOnClickListener(this);
        ((Button) dialog_exit.findViewById(R.id.btn_dialog_exit_cancel)).setOnClickListener(this);
    }

    private void initDialogLogout() {
        dialog_logout = new Dialog(this);
        dialog_logout.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_logout.setContentView(R.layout.dialog_logout);
        ((Button) dialog_logout.findViewById(R.id.btn_dialog_logout_ok)).setOnClickListener(this);
        ((Button) dialog_logout.findViewById(R.id.btn_dialog_logout_cancel)).setOnClickListener(this);
    }

    private void hideAllLayouts() {
        infomationLayout.setVisibility(View.GONE);
        markLayout.setVisibility(View.GONE);
        scheduleLayout.setVisibility(View.GONE);
        scheduleExamLayout.setVisibility(View.GONE);
        aboutLayout.setVisibility(View.GONE);
        debtLayout.setVisibility(View.GONE);
    }

    private void showInfomation() {
        hideAllLayouts();
        infomationLayout.setVisibility(View.VISIBLE);
        setTitle(INFOMATIONTITLE + " - " + VLDxxxModule.ProperNoun(student.getName()));
    }

    private void showMark() {
        hideAllLayouts();
        markLayout.setVisibility(View.VISIBLE);
        setTitle(MARKTITLE);
    }

    private void showSchedule() {
        hideAllLayouts();
        scheduleLayout.setVisibility(View.VISIBLE);
        setTitle(SCHEDULETITLE);
    }

    private void showScheduleExam() {
        hideAllLayouts();
        scheduleExamLayout.setVisibility(View.VISIBLE);
        setTitle(SCHEDULEEXAMTITLE);
    }

    private void showAbout() {
        hideAllLayouts();
        aboutLayout.setVisibility(View.VISIBLE);
        setTitle(ABOUTTITLE);
    }

    private void showDebt() {
        hideAllLayouts();
        debtLayout.setVisibility(View.VISIBLE);
        setTitle(DEBTTITLE);
    }

    private void init() {
        initToolbar();
        initDrawer();
        initNavigationView();
        initLayouts();
        initSchedule();
        initScheduleExam();
        initAbout();
        initInfomation();

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
            dialog_exit.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_search, menu);
        item_search = menu.findItem(R.id.itemSearch);
        SearchView searchView = (SearchView) item_search.getActionView();
        searchView.setOnQueryTextListener(this);
        item_search.setVisible(false);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        boolean search = false;

        switch (id) {
            case R.id.nav_info:
                if (infomationLayout.getVisibility() == View.GONE) {
                    showInfomation();
                }
                break;

            case R.id.nav_mark:
                if (markLayout.getVisibility() == View.GONE) {
                    showMark();
                    search = true;
                }
                break;

            case R.id.nav_schedule:
                if (scheduleLayout.getVisibility() == View.GONE) {
                    showSchedule();
                }
                break;

            case R.id.nav_schedule_exam:
                if (scheduleExamLayout.getVisibility() == View.GONE) {
                    showScheduleExam();
                }
                break;

            case R.id.nav_debt:
                if (debtLayout.getVisibility() == View.GONE) {
                    showDebt();
                }
                break;

            case R.id.nav_search:
                Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
                intent.putExtra("getIntent", TAG);
                startActivity(intent);
                break;

            case R.id.nav_logout:
                dialog_logout.show();
                break;

            case R.id.nav_about:
                showAbout();
                break;
        }

        item_search.setVisible(search);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_dialog_exit_ok:
                finish();
                break;

            case R.id.btn_dialog_exit_cancel:
                dialog_exit.hide();
                break;

            case R.id.btn_dialog_logout_ok:
                logout();
                break;

            case R.id.btn_dialog_logout_cancel:
                dialog_logout.hide();
                break;
        }
    }

    private void logout() {
        Module.updateLoginState(this, false, "");
        startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        finish();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
