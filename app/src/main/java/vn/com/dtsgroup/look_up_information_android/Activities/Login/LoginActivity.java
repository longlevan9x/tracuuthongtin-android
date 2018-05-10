package vn.com.dtsgroup.look_up_information_android.Activities.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vn.com.dtsgroup.look_up_information_android.Activities.Home.HomeActivity;
import vn.com.dtsgroup.look_up_information_android.R;

/*******************************
 *                             *
 * Created by: VinhLD 20180508 *
 *                             *
 *******************************/

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(R.string.login_name);

        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        finish();
    }
}
