package vn.com.dtsgroup.look_up_information_android.Activities.Start;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.google.firebase.iid.FirebaseInstanceId;

import vn.com.dtsgroup.look_up_information_android.Activities.Login.LoginActivity;
import vn.com.dtsgroup.look_up_information_android.Init.Module;

/*******************************
 *                             *
 * Created by: VinhLD 20180509 *
 *                             *
 *******************************/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startLogin();

//        Log.e("HIHI", FirebaseInstanceId.getInstance().getToken().toString());

//        if(Module.isNetworkAvailable(MainActivity.this)){
//            Log.e(MainActivity.class.getName().toString(), "Connected");
//        }
//        else{
//            Log.e(MainActivity.class.getName().toString(), "Not Connected");
//        }
    }

    private void startLogin(){
        (new CountDownTimer(1000,1000){

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
