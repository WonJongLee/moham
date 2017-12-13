package wj.com.moham.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;

import com.google.firebase.auth.FirebaseAuth;

import wj.com.moham.activity.LoginActivity;

/**
 * Created by admin on 2017. 12. 4..
 */

public class Util {
    /*
     * param : context
     * return : device width
     */
    public static int getDeviceWidth(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    /*
     * param : activity
     */
    public static void doSignOut(Activity act) {
        FirebaseAuth.getInstance().signOut();
        act.startActivity(new Intent(act, LoginActivity.class));
        act.finish();
    }

    public static String extractEmail(String email) {
        if (StrUtil.isNull(email)) {
            return "";
        } else {
            return email.substring(0, email.indexOf("@"));
        }
    }
}
