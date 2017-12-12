package wj.com.moham.common.util;

import android.content.Context;
import android.util.DisplayMetrics;

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
}
