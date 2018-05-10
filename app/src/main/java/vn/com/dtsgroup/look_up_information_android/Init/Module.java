package vn.com.dtsgroup.look_up_information_android.Init;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Base64;

/*******************************
 *                             *
 * Created by: VinhLD 20180509 *
 *                             *
 *******************************/

public class Module {
    public static int PRIMARY_R = 26;
    public static int PRIMARY_G = 101;
    public static int PRIMARY_B = 171;

    public static String EncodeBase64(String string) {
        return Base64.encodeToString(string.getBytes(), 1).trim();
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
