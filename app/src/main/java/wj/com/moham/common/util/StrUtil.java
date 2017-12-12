package wj.com.moham.common.util;

/**
 * Created by admin on 2017. 12. 4..
 */

public class StrUtil {
    public static boolean isNull(String str) {
        return (str == null || "".equalsIgnoreCase(str.toString())) ? true : false;
    }

    public static boolean isNull(CharSequence str) {
        return (str == null || "".equalsIgnoreCase(str.toString())) ? true : false;
    }
}
