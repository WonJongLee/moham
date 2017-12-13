package wj.com.moham.common.util;

import java.util.Random;

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

    public static String getRandomStr(int length) {
        char[] characters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuffer sb = new StringBuffer();
        Random rn = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(characters[rn.nextInt(characters.length)]);
        }
        return sb.toString();
    }
}
