package vn.com.dtsgroup.look_up_information_android.Init;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.util.Base64;

/*******************************
 *                             *
 * Created by: VinhLD 20180509 *
 *                             *
 *******************************/

public class Module {

    public static String DOMAINNAME = "https://tracuuthongtin.000webhostapp.com/tracuuthongtin-php/public/";
    public static String APILINK = DOMAINNAME + "api/";
    public static String APILINKV1 = APILINK + "v1/";
    public static String STUDENTAPILINK = APILINKV1 + "student/";

    public static int PRIMARY_R = 26;
    public static int PRIMARY_G = 101;
    public static int PRIMARY_B = 171;

    public static int HEX_EE = 238;

    public static String EncodeBase64(String string) {
        return Base64.encodeToString(string.getBytes(), 1).trim();
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    public static String AuthorText(String link, String text){
        return "<a href='" + link + "'>" + text + "</a>";
    }

    public static void updateLoginState(Context context, boolean state, String code){
        SharedPreferences sharedPreferences = context.getSharedPreferences("login", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("state", state);
        editor.putString("code", code);
        editor.commit();
    }

    public static boolean loginState(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("login", context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("state", false);
    }

    public static String IDStudent(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("login", context.MODE_PRIVATE);
        return sharedPreferences.getString("code", "14102100054");
    }

}
