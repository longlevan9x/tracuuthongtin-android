package vn.com.dtsgroup.look_up_information_android.Activities.Login;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import vn.com.dtsgroup.look_up_information_android.Activities.Home.HomeActivity;
import vn.com.dtsgroup.look_up_information_android.Activities.Search.SearchActivity;
import vn.com.dtsgroup.look_up_information_android.Class.Student;
import vn.com.dtsgroup.look_up_information_android.Init.DataManager;
import vn.com.dtsgroup.look_up_information_android.Init.Module;
import vn.com.dtsgroup.look_up_information_android.Init.VLDxxxModule;
import vn.com.dtsgroup.look_up_information_android.R;

/*******************************
 *                             *
 * Created by: VinhLD 20180508 *
 *                             *
 *******************************/

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    public static String TAG = "LOGINACTIVITY";

    private Button btn_login, btn_skip;
    private EditText edt_id;
    private TextView txt_noti;
    private ProgressBar pbLogin;

    private void init() {
        btn_skip = findViewById(R.id.btn_skip);
        btn_skip.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        btn_skip.setOnClickListener(this);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        edt_id = findViewById(R.id.edt_idStudent);
        edt_id.addTextChangedListener(this);
        txt_noti = findViewById(R.id.txt_login_noti);
        txt_noti.setVisibility(View.GONE);
        pbLogin = findViewById(R.id.pbLogin);
        pbLogin.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(R.string.login_name);

        init();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_login:
                login();
                break;


            case R.id.btn_skip:
                skip();
                break;
        }
    }

    private void login() {
        String idS = edt_id.getText().toString();
        if (idS.isEmpty()) {
            IDisEmpty();
        } else {
            loginEnforcement(idS);
        }
    }

    private void loginEnforcement(String idS) {
        pbLogin.setVisibility(View.VISIBLE);
        btn_login.setEnabled(false);
        btn_skip.setEnabled(false);
        final String code = idS;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new Login().execute(Module.STUDENTAPILINK + code);
            }
        });
    }

    private void setStyleButton(Button button, boolean enabled, int backgroundColor, int textColor) {
        button.setEnabled(enabled);
        button.setBackgroundColor(backgroundColor);
        button.setTextColor(textColor);
    }

    private void setStyleButton(Button button, boolean enabled, Drawable drawable, int textColor) {
        button.setEnabled(enabled);
        button.setBackground(drawable);
        button.setTextColor(textColor);
    }

    private void IDisEmpty() {
        txt_noti.setText("Mã sinh viên trống!");
        txt_noti.setVisibility(View.VISIBLE);
    }

    private void skip() {
        Intent intent = new Intent(LoginActivity.this, SearchActivity.class);
        intent.putExtra("getIntent", TAG);
        startActivity(intent);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        txt_noti.setVisibility(View.GONE);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    class Login extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... strings) {
            return VLDxxxModule.ContentURL(strings[0]);
        }

        @SuppressLint("NewApi")
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                String message = jsonObject.getString("message");
                if (message.equals("success")) {
                    JSONObject object = jsonObject.getJSONObject("result");
                    Student student = new Student(
                            object.getInt("id"), object.getString("code"), object.getString("name"),
                            object.getString("class"), object.getInt("id_department"),
                            object.getString("branch_group"), object.getString("branch"),
                            object.getString("status"), object.getString("day_admission"),
                            object.getString("school_year"), object.getInt("course"),
                            object.getString("education_level"), object.getString("gender"),
                            object.getString("type_education"), object.getInt("area"),
                            object.getString("average_cumulative"), object.getInt("total_term"),
                            object.getString("created_at"), object.getString("updated_at")
                    );

                    afterLogin(student);
                } else {
                    String result = jsonObject.getString("result");
                    apiFail(message, result);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                apiFail(e.getMessage());
            } finally {
                finallyLogin();
            }
        }

        private void afterLogin(Student student) {
            DataManager manager = new DataManager(LoginActivity.this);
            if (manager.insertOrUpdateStudent(student)) {
                Module.updateLoginState(getApplicationContext(), true, student.getCode());
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                finish();
            }
        }

        private void apiFail(String message, String result) {
            txt_noti.setText(message + ": " + result);
            txt_noti.setVisibility(View.VISIBLE);
        }

        private void apiFail(String message) {
            txt_noti.setText(message);
            txt_noti.setVisibility(View.VISIBLE);
        }

        @SuppressLint("NewApi")
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        private void finallyLogin() {
            pbLogin.setVisibility(View.GONE);
            btn_login.setEnabled(true);
            btn_skip.setEnabled(true);
        }
    }
}
