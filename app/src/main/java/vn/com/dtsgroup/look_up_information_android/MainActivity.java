package vn.com.dtsgroup.look_up_information_android;

/*******************************
 *                             *
 * Created by: VinhLD 20180508 *
 *                             *
 *******************************/

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import vn.com.dtsgroup.look_up_information_android.Login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startLogin();
    }

    private void startLogin(){
        (new CountDownTimer(1500,1500){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        }).start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }
}
