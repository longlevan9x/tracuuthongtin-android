package vn.com.dtsgroup.look_up_information_android.Init;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*******************************
 *                             *
 * Created by: VinhLD 20180510 *
 *                             *
 *******************************/

public class VLDxxxModule {

    public static boolean isEmail(String string) {
        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern regex = Pattern.compile(emailPattern);
        Matcher matcher = regex.matcher(string);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static String XoaKhoangTrang(String string) {
        return string.trim().replaceAll("\\s+", " ");
    }

    public static String DanhTuRieng(String string) {
        string = XoaKhoangTrang(string);
        String[] list = string.split(" ");
        string = "";
        for (int i = 0; i < list.length; i++) {
            string += String.valueOf(list[i].charAt(0)).toUpperCase() + list[i].substring(1).toLowerCase() + " ";
        }
        return string;
    }

    public static String removeAccent(String s) {
        s = s.replaceAll("đ", "d");
        s = s.replaceAll("Đ", "D");
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").toLowerCase();
    }

    public static String ContentURL(String stringURL) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(stringURL);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream(), Charset.forName("UTF-8")));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static String VLDEncodeMD5(String key, Object object) {
        String string = String.valueOf(object);
        string += key;
        return EncodeMD5(string);
    }

    public static String EncodeMD5(Object object) {
        String string = String.valueOf(object);
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(string.getBytes());
            BigInteger bigInteger = new BigInteger(1, digest.digest());
            return bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String DateToString(Date date){
        return date.getYear() + "-" + date.getMonth() + "-" + date.getDay();
    }

    public static String DateTimeToString(Date date){
        return date.getYear() + "-" + date.getMonth() + "-" + date.getDay()
                + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
    }
}
