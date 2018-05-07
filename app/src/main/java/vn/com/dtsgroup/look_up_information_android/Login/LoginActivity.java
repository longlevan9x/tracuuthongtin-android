package vn.com.dtsgroup.look_up_information_android.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vn.com.dtsgroup.look_up_information_android.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(R.string.login_name);
    }
}
